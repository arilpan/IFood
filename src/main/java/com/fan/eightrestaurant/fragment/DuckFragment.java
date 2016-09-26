package com.fan.eightrestaurant.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.fan.eightrestaurant.adapter.SendInfoAdapter;
import com.fan.eightrestaurant.bean.SendInfo;
import com.fan.eightrestaurant.ui.LoginActivity;
import com.fan.eightrestaurant.ui.MyMessageActivity;
import com.fan.eightrestaurant.utils.JSONUtils;
import com.fan.eightrestaurant.utils.PathUtils;
import com.ydxiaoyuan.ifood.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;

/**
 * Created by xdkj on 2016/8/12.
 *
 * 北京烤鸭用户留言界面
 */
public class DuckFragment extends Fragment implements View.OnClickListener {

  private ListView listView;
  private List<SendInfo> list;
  private SendInfoAdapter adapter;
  private EditText editText;
  private Button sendInfoBtn;
  private ImageView nullImage;
  private LinearLayout root;
  private String userId, token, secretkey, imagePath;
  private String hotelId = "ba262eba-05da-4886-947c-5a557c954af5";

  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View ret = null;
    ret = inflater.inflate(R.layout.fragment_duck, null);
    listView = (ListView) ret.findViewById(R.id.fragment_duck_listview);
    editText = (EditText) ret.findViewById(R.id.fragment_duck_edittext);
    nullImage = (ImageView) ret.findViewById(R.id.fragment_duck_null_image);
    sendInfoBtn = (Button) ret.findViewById(R.id.fragment_duck_sendbtn);
    root = (LinearLayout) ret.findViewById(R.id.fragment_duck_root);
    controlKeyboardLayout(root, sendInfoBtn);
    sendInfoBtn.setOnClickListener(this);
    initData();
    list = new ArrayList<>();
    return ret;
  }

  /**
   * 阻止软键盘遮盖输入框
   */
  private void controlKeyboardLayout(final View root, final View scrollToView) {
    // 注册一个回调函数，当在一个视图树中全局布局发生改变或者视图树中的某个视图的可视状态发生改变时调用这个回调函数。
    root.getViewTreeObserver()
        .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
              @Override public void onGlobalLayout() {
                Rect rect = new Rect();
                // 获取root在窗体的可视区域
                root.getWindowVisibleDisplayFrame(rect);
                // 当前视图最外层的高度减去现在所看到的视图的最底部的y坐标
                int rootInvisibleHeight = root.getRootView().getHeight() - rect.bottom;
                // 若rootInvisibleHeight高度大于100，则说明当前视图上移了，说明软键盘弹出了
                if (rootInvisibleHeight > 100) {
                  //软键盘弹出来的时候
                  int[] location = new int[2];
                  // 获取scrollToView在窗体的坐标
                  scrollToView.getLocationInWindow(location);
                  // 计算root滚动高度，使scrollToView在可见区域的底部
                  int srollHeight = (location[1] + scrollToView.getHeight()) - rect.bottom;
                  if (srollHeight != 0) {
                    root.scrollTo(0, srollHeight);
                  }
                } else {
                  // 软键盘没有弹出来的时候
                  root.scrollTo(0, 0);
                }
              }
            });
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    userId = ((MyMessageActivity) activity).getUserId();
    token = ((MyMessageActivity) activity).getToken();
    secretkey = ((MyMessageActivity) activity).getSecretkey();
    imagePath = ((MyMessageActivity) activity).getImagePath();
  }

  private void initData() {
    OkHttpUtils.get()
        .url(PathUtils.getAppListBackMessageUrl())
        .addParams("user_id", userId)
        .addParams("hotel_id", hotelId)
        .addParams("secretkey", secretkey)
        .addParams("token", token)
        .build()
        .execute(new StringCallback() {
          @Override public void onError(Call call, Exception e) {
          }

          @Override public void onResponse(String response) {
            try {
              JSONObject jb = new JSONObject(response);
              String message = jb.getString("message");
              if (message.equals("TokenError")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("登录异常，请重新登录");
                builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                  @Override public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                  }
                });
                builder.create().show();
              }
            } catch (JSONException e) {
              e.printStackTrace();
            }
            List<SendInfo> list1 = JSONUtils.getSendInfoJson(response);
            list.addAll(list1);
            if (list.size() == 0) {
              nullImage.setVisibility(View.VISIBLE);
              listView.setVisibility(View.GONE);
            }
            adapter = new SendInfoAdapter(getContext(), list);
            adapter.setUrl(imagePath);
            listView.setAdapter(adapter);
            listView.setSelection(list.size() - 1);
          }
        });
  }

  @Override public void onClick(View v) {
    if (editText.getText().toString().trim().equals("")) {
      Toast.makeText(getActivity(), "发送的内容不能为空", Toast.LENGTH_SHORT).show();
    } else {
      OkHttpUtils.get()
          .url(PathUtils.getAppAddBackMessageUrl())
          .addParams("hotel_id", hotelId)
          .addParams("back_content", editText.getText().toString().trim())
          .addParams("createuser_id", userId)
          .addParams("secretkey", secretkey)
          .addParams("token", token)
          .build()
          .execute(new StringCallback() {
            @Override public void onError(Call call, Exception e) {

            }

            @Override public void onResponse(String response) {
              try {
                JSONObject jb = new JSONObject(response);
                String message = jb.getString("message");
                if (message.equals("TokenError")) {
                  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                  builder.setTitle("提示");
                  builder.setMessage("登录异常，请重新登录");
                  builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {
                      Intent intent = new Intent(getActivity(), LoginActivity.class);
                      startActivity(intent);
                    }
                  });
                  builder.create().show();
                } else if (message.equals("ok")) {
                  Toast.makeText(getActivity(), "发送成功，等待回复", Toast.LENGTH_SHORT).show();
                } else if (message.equals("error")) {
                  Toast.makeText(getActivity(), "发送失败，请重新发送", Toast.LENGTH_SHORT).show();
                }
              } catch (JSONException e) {
                e.printStackTrace();
              }
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              Date curDate = new Date(System.currentTimeMillis());
              String str = sdf.format(curDate);
              SendInfo sendInfo = new SendInfo();
              sendInfo.setBack_content(editText.getText().toString().trim());
              sendInfo.setCreatetime(str);
              sendInfo.setBack_state(0);
              list.add(sendInfo);
              if (list.size() != 0) {
                nullImage.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
              }
              adapter.notifyDataSetChanged();
              listView.setSelection(list.size() - 1);
              editText.setText("");
              controlKeyboardLayout(root, sendInfoBtn);
            }
          });
    }
  }
}
