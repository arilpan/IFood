package com.fan.eightrestaurant.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.fan.eightrestaurant.utils.PathUtils;
import com.fan.eightrestaurant.utils.SearchWatherUtils;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.helper.KVHelper;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

/**
 * 用户登录界面
 */
public class LoginActivity extends Activity implements View.OnClickListener {
  private EditText userPhone, userPassword;
  private TextView login_forgetpwd, login_registered;
  private Button login;
  private SharedPreferences saveSelfInfo;
  private String token = "";
  private String secretkey = "";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    try {
      //如果已经登录,直接到mainActvity
      if (!TextUtils.isEmpty(KVHelper.getUserInfo(getApplicationContext(), "user_id", ""))) {
        Intent intent2 = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent2);
        finish();
      }

      setContentView(R.layout.activity_login);
    } catch (Exception e) {
      JPushInterface.init(this);
      JPushInterface.setDebugMode(true);
      OkHttpUtils.getInstance()
          .debug("OkHttpUtils")
          .setConnectTimeout(100000, TimeUnit.MILLISECONDS);
      Fresco.initialize(this);
    }

    initView();
  }

  /**
   * 初始化控件
   */
  private void initView() {

    userPhone = (EditText) findViewById(R.id.login_userphone);
    userPassword = (EditText) findViewById(R.id.login_userpassword);
    userPassword.addTextChangedListener(new SearchWatherUtils(userPassword));
    login_forgetpwd = (TextView) findViewById(R.id.login_forgetpwd);
    login_registered = (TextView) findViewById(R.id.login_registered);
    login = (Button) findViewById(R.id.login_button);

    //        userPhone.setText("15826666277");
    //        userPassword.setText("111111");

    login.setOnClickListener(this);
    login_forgetpwd.setOnClickListener(this);
    login_registered.setOnClickListener(this);
  }

  @Override public void onClick(View v) {

    switch (v.getId()) {
      case R.id.login_button:
        //login.setText("登录中。。。");
        login.setEnabled(false);
        if (userPhone.getText().toString().trim().equals("")) {
          Toast.makeText(LoginActivity.this, "用户名为空", Toast.LENGTH_SHORT).show();
          login.setText("登\t\t\t录");
          login.setEnabled(true);
        } else if (userPassword.getText().toString().trim().equals("")) {
          Toast.makeText(LoginActivity.this, "密码为空", Toast.LENGTH_SHORT).show();
          login.setText("登\t\t\t录");
          login.setEnabled(true);
        } else if (userPassword.getText().toString().trim().length() < 6
            || userPassword.getText().toString().trim().length() > 16) {
          Toast.makeText(LoginActivity.this, "密码为6-16位字符组成,不包含空字符串", Toast.LENGTH_SHORT).show();
          login.setText("登\t\t\t录");
          login.setEnabled(true);
        } else {
          final String user_phone = userPhone.getText().toString().trim();
          OkHttpUtils.post()
              .url(PathUtils.postUserLoginUrl())
              .addParams("username", userPhone.getText().toString().trim())
              .addParams("password", userPassword.getText().toString().trim())
              .addParams("token", token)
              .addParams("secretkey", secretkey).addParams("use_device",
              JPushInterface.getRegistrationID(getApplicationContext()))
              //手机极光推送所需设备id号
              .build().execute(new StringCallback() {
            @Override public void onError(Call call, Exception e) {
              Toast.makeText(LoginActivity.this, "网络未连接请重试", Toast.LENGTH_SHORT).show();
              login.setText("登\t\t\t录");
              login.setEnabled(true);
            }

            @Override public void onResponse(String response) {
              try {
                JSONObject jb = new JSONObject(response);
                String message = jb.getString("message");
                if (message.equals("error")) {
                  Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                  login.setText("登\t\t\t录");
                  login.setEnabled(true);
                } else if (message.equals("nonentity")) {
                  Toast.makeText(LoginActivity.this, "该账号不存在,请先注册", Toast.LENGTH_SHORT).show();
                  login.setText("登\t\t\t录");
                  login.setEnabled(true);
                } else if (message.equals("ok")) {
                  JSONObject data = jb.getJSONObject("value");
                  String user_id = data.getString("uid");
                  String username = data.getString("createuser");
                  String imagePath = APIConfig.BASE_IMG_URL + data.getString("user_icon");
                  String nickname = data.getString("nickname");
                  token = data.getString("token");
                  secretkey = data.getString("secretkey");
                  String realname = data.getString("realname");
                  String birthday = data.getString("birthday");
                  String email = data.getString("email");
                  //                                            saveUserInfo(user_id, user_phone, imagePath, nickname,
                  //                                                    token, secretkey);
                  saveUserInfo(user_id, user_phone, imagePath, nickname, token, secretkey, realname,
                      birthday, email);
                  Intent intent2 =
                      new Intent(LoginActivity.this, MainActivity.class);
                  startActivity(intent2);
                  finish();
                  login.setText("登\t\t\t录");
                  login.setEnabled(true);
                }
              } catch (JSONException e) {
                e.printStackTrace();
              }
            }
          });
        }
        break;
      case R.id.login_forgetpwd:
        Intent intent = new Intent(LoginActivity.this, RetrievePwdActivity.class);
        startActivity(intent);
        break;
      case R.id.login_registered:
        Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent1);
        break;
    }
  }

  /**
   * 用户信息的存储
   */
  private void saveUserInfo(String user_id, String username, String imagePath, String nickname,
      String token, String secretkey, String realname, String birthday, String email) {
    saveSelfInfo = getSharedPreferences("saveSelfInfo", Context.MODE_PRIVATE);
    SharedPreferences.Editor editorSelfInfo = saveSelfInfo.edit();
    editorSelfInfo.putString("user_id", user_id);
    editorSelfInfo.putString("username", username);
    editorSelfInfo.putString("imagePath", imagePath);
    editorSelfInfo.putString("nickname", nickname);
    editorSelfInfo.putString("token", token);
    editorSelfInfo.putString("secretkey", secretkey);
    editorSelfInfo.putString("realname", realname);
    editorSelfInfo.putString("birthday", birthday);
    editorSelfInfo.putString("email", email);
    Log.e("arilpan",
        "user_id" + user_id + ",username" + username + ",path" + imagePath + "," + nickname);
    editorSelfInfo.commit();
  }
}
