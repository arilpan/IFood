package com.fan.eightrestaurant.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fan.eightrestaurant.utils.CreateUserDialogUtils;
import com.fan.eightrestaurant.utils.PathUtils;
import com.fan.eightrestaurant.utils.UpLoadUtils;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

/**
 * 用户上传头像，修改昵称
 */
public class UpLoadActivity extends AppCompatActivity implements View.OnClickListener {

  private SimpleDraweeView simpleDraweeView;
  private CreateUserDialogUtils createUserDialog;
  private TextView showBirthday, showRealname, showEmail, showNiceName;
  private RelativeLayout UpLoadImage, sendBirthday, upLoadRealname, upLoadEmail, upLoadNickName;
  private String regEx = null;//日期格式的表达式
  private String regEm = null;//邮箱格式的表达式

  /**
   * 选择本地照片
   */
  protected static final int CHOOSE_PICTURE = 0;
  /**
   * 拍照
   */
  protected static final int TAKE_PICTURE = 1;
  /**
   * 裁剪图片
   */
  private static final int CROP_SMALL_PICTURE = 2;
  protected static Uri tempUri;
  private SharedPreferences getInfo;
  private String user_id, nickname, imagePath, token, secretkey, realname, birthday, email;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_up_load);
    initView();
  }

  /**
   * 初始化控件
   */
  private void initView() {
    ((TextView) findViewById(R.id.title_middle)).setText("编辑资料");
    findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //SettingFragmentEditProfile.this.
        finish();
      }
    });

    simpleDraweeView = (SimpleDraweeView) findViewById(R.id.activity_up_load_show_headimage);
    upLoadNickName = (RelativeLayout) findViewById(R.id.activity_up_load_name);
    UpLoadImage = (RelativeLayout) findViewById(R.id.activity_up_load_show_image);
    sendBirthday = (RelativeLayout) findViewById(R.id.activity_up_load_birthday);
    upLoadRealname = (RelativeLayout) findViewById(R.id.activity_up_load_realname);
    upLoadEmail = (RelativeLayout) findViewById(R.id.activity_up_load_email);
    showBirthday = (TextView) findViewById(R.id.activity_up_load_show_birthday);
    showRealname = (TextView) findViewById(R.id.activity_up_load_show_realname);
    showEmail = (TextView) findViewById(R.id.activity_up_load_show_email);
    showNiceName = (TextView) findViewById(R.id.activity_up_load_show_name);
    getUserInfo();
    UpLoadImage.setOnClickListener(this);
    upLoadNickName.setOnClickListener(this);
    upLoadEmail.setOnClickListener(this);
    upLoadRealname.setOnClickListener(this);
    sendBirthday.setOnClickListener(this);
  }

  /**
   * 获取用户信息
   */
  private void getUserInfo() {
    getInfo = getSharedPreferences("saveSelfInfo", Context.MODE_PRIVATE);
    user_id = getInfo.getString("user_id", user_id);
    nickname = getInfo.getString("nickname", nickname);
    imagePath = getInfo.getString("imagePath", imagePath);
    token = getInfo.getString("token", token);
    secretkey = getInfo.getString("secretkey", secretkey);
    realname = getInfo.getString("realname", realname);
    birthday = getInfo.getString("birthday", birthday);
    email = getInfo.getString("email", email);
    showNiceName.setText(nickname);
    simpleDraweeView.setImageURI(imagePath);
    showRealname.setText(realname);
    showEmail.setText(email);
    showBirthday.setText(birthday);
  }

  /**
   * 更新用户信息
   */
  private void updateUserInfo(String updateNickName, String updateRealName, String updateBirthday,
      String upateEmail, String updateImagePath) {
    SharedPreferences.Editor editorSelfInfo = getInfo.edit();
    editorSelfInfo.putString("nickname", updateNickName);
    editorSelfInfo.putString("realname", updateRealName);
    editorSelfInfo.putString("birthday", updateBirthday);
    editorSelfInfo.putString("email", upateEmail);
    editorSelfInfo.putString("imagePath", updateImagePath);
    editorSelfInfo.commit();
  }

  /**
   * 控件的点击事件
   */
  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.activity_up_load_show_image:
        showChoosePicDialog();
        break;
      case R.id.activity_up_load_name:
        createUserDialog =
            new CreateUserDialogUtils(this, R.style.loading_dialog, onClickListener, "请输入昵称");
        createUserDialog.show();
        break;
      case R.id.activity_up_load_realname:
        createUserDialog =
            new CreateUserDialogUtils(this, R.style.loading_dialog, onClickListener, "请输入真实姓名");
        createUserDialog.show();
        break;
      case R.id.activity_up_load_birthday:
        createUserDialog =
            new CreateUserDialogUtils(this, R.style.loading_dialog, onClickListener, "请输入生日");
        createUserDialog.show();
        break;
      case R.id.activity_up_load_email:
        createUserDialog =
            new CreateUserDialogUtils(this, R.style.loading_dialog, onClickListener, "请输入邮箱");
        createUserDialog.show();
        break;
    }
  }

  /**
   * 用户信息的修改
   */
  public View.OnClickListener onClickListener = new View.OnClickListener() {
    @Override public void onClick(View v) {
      switch (v.getId()) {
        case R.id.create_user_dialog_savebtn:  //用户修改昵称
          final String name = createUserDialog.editText.getText().toString().trim();
          if (name.equals("")) {
            Toast.makeText(UpLoadActivity.this, "昵称不能为空", Toast.LENGTH_SHORT).show();
          } else {
            OkHttpUtils.post()
                .url(PathUtils.postUpdateInformationUrl())
                .addParams("id", user_id)
                .addParams("nickname", name)
                .addParams("secretkey", secretkey)
                .addParams("token", token)
                .build()
                .execute(new StringCallback() {
                  @Override public void onError(Call call, Exception e) {
                  }

                  @Override public void onResponse(String response) {
                    try {
                      JSONObject jsonObject = new JSONObject(response);
                      String string = jsonObject.getString("message");
                      if (string.equals("TokenError")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(UpLoadActivity.this);
                        builder.setTitle("提示");
                        builder.setMessage("登录异常，请重新登录");
                        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                          @Override public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(UpLoadActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                          }
                        });
                        builder.create().show();
                      } else if (string.equals("ok")) {
                        nickname = name;
                        updateUserInfo(nickname, realname, birthday, email, imagePath);
                        showNiceName.setText(nickname);
                        Toast.makeText(UpLoadActivity.this, "信息保存成功", Toast.LENGTH_SHORT).show();
                      } else if (string.equals("error")) {
                        Toast.makeText(UpLoadActivity.this, "信息保存失败", Toast.LENGTH_SHORT).show();
                      }
                    } catch (JSONException e) {
                      e.printStackTrace();
                    }
                  }
                });
          }
          createUserDialog.dismiss();
          break;
        case R.id.create_user_dialog_saverealname: //用户修改真实姓名
          final String realName = createUserDialog.editText.getText().toString().trim();
          if (realName.equals("")) {
            Toast.makeText(UpLoadActivity.this, "姓名不能为空", Toast.LENGTH_SHORT).show();
          } else {
            OkHttpUtils.post()
                .url(PathUtils.postUpdateInformationUrl())
                .addParams("id", user_id)
                .addParams("realname", realName)
                .addParams("secretkey", secretkey)
                .addParams("token", token)
                .build()
                .execute(new StringCallback() {
                  @Override public void onError(Call call, Exception e) {
                  }

                  @Override public void onResponse(String response) {
                    try {
                      JSONObject jsonObject = new JSONObject(response);
                      String string = jsonObject.getString("message");
                      if (string.equals("TokenError")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(UpLoadActivity.this);
                        builder.setTitle("提示");
                        builder.setMessage("登录异常，请重新登录");
                        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                          @Override public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(UpLoadActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                          }
                        });
                        builder.create().show();
                      } else if (string.equals("ok")) {
                        realname = realName;
                        updateUserInfo(nickname, realname, birthday, email, imagePath);
                        showRealname.setText(realname);
                        Toast.makeText(UpLoadActivity.this, "信息保存成功", Toast.LENGTH_SHORT).show();
                      } else if (string.equals("error")) {
                        Toast.makeText(UpLoadActivity.this, "信息保存失败", Toast.LENGTH_SHORT).show();
                      }
                    } catch (JSONException e) {
                      e.printStackTrace();
                    }
                  }
                });
          }
          createUserDialog.dismiss();
          break;
        case R.id.create_user_dialog_savebrithday:   //用户修改生日
          final String brithday = createUserDialog.editText.getText().toString().trim();
          String string = brithday.substring(0, 4);
          int year = Integer.parseInt(string);
          //正则表达式限制生日的格式为yyyy-MM-dd
          if (year % 4 == 0 || (year % 4 == 0 && year % 100 == 0)) {
            regEx =
                "(^[1-2][0-9][0-9][0-9][-](([0][1,3,5,7,8])|([1][0,2]))[-](([0][0-9])|([1-2][0-9])|([3][0-1]))$)|(^[1-2][0-9][0-9][0-9][-](([0][4,6,9])|([1][1]))[-](([0][0-9])|([1-2][0-9])|([3][0]))$)|(^[1-2][0-9][0-9][0-9][-](([0][2]))[-](([0][1-9])|([1-2][0-9]))$)";
          } else {
            regEx =
                "(^[1-2][0-9][0-9][0-9][-](([0][1,3,5,7,8])|([1][0,2]))[-](([0][0-9])|([1-2][0-9])|([3][0-1]))$)|(^[1-2][0-9][0-9][0-9][-](([0][4,6,9])|([1][1]))[-](([0][0-9])|([1-2][0-9])|([3][0]))$)|(^[1-2][0-9][0-9][0-9][-](([0][2]))[-](([0][1-9])|([1][0-9])|([2][0-8]))$)";
          }
          if (brithday.equals("")) {
            Toast.makeText(UpLoadActivity.this, "生日不能为空", Toast.LENGTH_SHORT).show();
          } else if (brithday.matches(regEx)) {
            OkHttpUtils.post()
                .url(PathUtils.postUpdateInformationUrl())
                .addParams("id", user_id)
                .addParams("birthday", brithday)
                .addParams("secretkey", secretkey)
                .addParams("token", token)
                .build()
                .execute(new StringCallback() {
                  @Override public void onError(Call call, Exception e) {
                  }

                  @Override public void onResponse(String response) {
                    try {
                      JSONObject jsonObject = new JSONObject(response);
                      String string = jsonObject.getString("message");
                      if (string.equals("TokenError")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(UpLoadActivity.this);
                        builder.setTitle("提示");
                        builder.setMessage("登录异常，请重新登录");
                        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                          @Override public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(UpLoadActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                          }
                        });
                        builder.create().show();
                      } else if (string.equals("ok")) {
                        updateUserInfo(nickname, realname, brithday, email, imagePath);
                        showBirthday.setText(brithday);
                        Toast.makeText(UpLoadActivity.this, "信息保存成功", Toast.LENGTH_SHORT).show();
                      } else if (string.equals("error")) {
                        Toast.makeText(UpLoadActivity.this, "信息保存失败", Toast.LENGTH_SHORT).show();
                      }
                    } catch (JSONException e) {
                      e.printStackTrace();
                    }
                  }
                });
          } else {
            Toast.makeText(UpLoadActivity.this, "请输入正确的生日格式", Toast.LENGTH_SHORT).show();
          }
          createUserDialog.dismiss();
          break;
        case R.id.create_user_dialog_saveemail:  //用户修改邮箱
          final String email = createUserDialog.editText.getText().toString().trim();
          regEm =
              "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
          if (email.equals("")) {
            Toast.makeText(UpLoadActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
          } else if (email.matches(regEm)) {
            OkHttpUtils.post()
                .url(PathUtils.postUpdateInformationUrl())
                .addParams("id", user_id)
                .addParams("email", email)
                .addParams("secretkey", secretkey)
                .addParams("token", token)
                .build()
                .execute(new StringCallback() {
                  @Override public void onError(Call call, Exception e) {
                  }

                  @Override public void onResponse(String response) {
                    try {
                      JSONObject jsonObject = new JSONObject(response);
                      String string = jsonObject.getString("message");
                      if (string.equals("TokenError")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(UpLoadActivity.this);
                        builder.setTitle("提示");
                        builder.setMessage("登录异常，请重新登录");
                        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                          @Override public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(UpLoadActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                          }
                        });
                        builder.create().show();
                      } else if (string.equals("ok")) {
                        updateUserInfo(nickname, realname, birthday, email, imagePath);
                        showEmail.setText(email);
                        Toast.makeText(UpLoadActivity.this, "信息保存成功", Toast.LENGTH_SHORT).show();
                      } else if (string.equals("error")) {
                        Toast.makeText(UpLoadActivity.this, "信息保存失败", Toast.LENGTH_SHORT).show();
                      }
                    } catch (JSONException e) {
                      e.printStackTrace();
                    }
                  }
                });
          } else {
            Toast.makeText(UpLoadActivity.this, "请输入正确的邮箱格式", Toast.LENGTH_SHORT).show();
          }
          createUserDialog.dismiss();
          break;
      }
    }
  };

  /**
   * 显示修改头像的对话框
   */
  private void showChoosePicDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("设置头像");
    String[] items = { "选择本地照片", "拍照" };
    builder.setNegativeButton("取消", null);
    builder.setItems(items, new DialogInterface.OnClickListener() {

      @Override public void onClick(DialogInterface dialog, int which) {
        switch (which) {
          case CHOOSE_PICTURE: // 选择本地照片
            Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
            openAlbumIntent.setType("image/*");
            startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
            break;
          case TAKE_PICTURE: // 拍照
            Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            tempUri =
                Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "image.jpg"));
            // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
            openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
            startActivityForResult(openCameraIntent, TAKE_PICTURE);
            break;
        }
      }
    });
    builder.create().show();
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK) { // 如果返回码是可以用的
      switch (requestCode) {
        case TAKE_PICTURE:
          startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
          break;
        case CHOOSE_PICTURE:
          startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
          break;
        case CROP_SMALL_PICTURE:
          if (data != null) {
            setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
          }
          break;
      }
    }
  }

  /**
   * 裁剪图片
   */
  private void startPhotoZoom(Uri uri) {
    if (uri == null) {
      Toast.makeText(UpLoadActivity.this, "该图片的地址不存在", Toast.LENGTH_SHORT).show();
    }
    Intent intent = new Intent("com.android.camera.action.CROP");
    intent.setDataAndType(uri, "image/*");
    // 设置裁剪
    intent.putExtra("crop", "true");
    // aspectX aspectY 是宽与高的比例
    intent.putExtra("aspectX", 1);
    intent.putExtra("aspectY", 1);
    // outputX outputY 是裁剪图片宽与高
    intent.putExtra("outputX", 100);
    intent.putExtra("outputY", 100);
    intent.putExtra("return-data", true);
    startActivityForResult(intent, CROP_SMALL_PICTURE);
  }

  /**
   * 保存裁减之后的图片数据
   */
  private void setImageToView(Intent data) {
    Bundle extras = data.getExtras();
    if (extras != null) {
      Bitmap photo = extras.getParcelable("data");
      photo = UpLoadUtils.toRoundBitmap(photo, tempUri); // 这个时候的图片已经被处理成圆形的了
      uploadPic(photo);
    }
  }

  /**
   * 上传图片
   */
  private void uploadPic(Bitmap photo) {
    final String imageUrl =
        UpLoadUtils.savePhoto(photo, Environment.getExternalStorageDirectory().getAbsolutePath(),
            String.valueOf(System.currentTimeMillis()));
    File file = new File(imageUrl);
    if (imageUrl != null) {
      OkHttpUtils.post()
          .url(PathUtils.postImageUploadUrl())
          .addParams("id", user_id)
          .addFile("file", file.getName(), file)
          .addParams("secretkey", secretkey)
          .addParams("token", token)
          .build()
          .execute(new StringCallback() {
            @Override public void onError(Call call, Exception e) {
              Log.e("AAA", "网络数据下载失败");
            }

            @Override public void onResponse(String response) {
              try {
                JSONObject jb = new JSONObject(response);
                String message = jb.getString("message");
                imagePath = APIConfig.IP_PORT + jb.getString("value");
                updateUserInfo(nickname, realname, birthday, email, imagePath);
                if (message.equals("TokenError")) {
                  AlertDialog.Builder builder = new AlertDialog.Builder(UpLoadActivity.this);
                  builder.setTitle("提示");
                  builder.setMessage("登录异常，请重新登录");
                  builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {
                      Intent intent = new Intent(UpLoadActivity.this, LoginActivity.class);
                      startActivity(intent);
                      finish();
                    }
                  });
                  builder.create().show();
                }
                if (message.equals("uploadError")) {
                  Toast.makeText(UpLoadActivity.this, "头像上传失败", Toast.LENGTH_SHORT).show();
                } else if (message.equals("ok")) {
                  simpleDraweeView.setImageURI(imagePath);
                  Toast.makeText(UpLoadActivity.this, "头像修改成功", Toast.LENGTH_SHORT).show();
                } else if (message.equals("empty")) {
                  Toast.makeText(UpLoadActivity.this, "图片地址不存在", Toast.LENGTH_SHORT).show();
                } else if (message.equals("severError")) {
                  Toast.makeText(UpLoadActivity.this, "服务器出错", Toast.LENGTH_SHORT).show();
                }
              } catch (JSONException e) {
              }
            }
          });
    }
  }
}
