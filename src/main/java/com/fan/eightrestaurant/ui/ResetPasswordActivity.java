package com.fan.eightrestaurant.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ydxiaoyuan.ifood.R;
import com.fan.eightrestaurant.utils.PathUtils;
import com.fan.eightrestaurant.utils.SearchWatherUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * 用户登录之后重置密码
 */

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {
  private EditText userPwd, usePassWord;
  private Button register_button;
  private SharedPreferences getInfo;
  private String userId, token, secretkey;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reset_pwd);
    initView();
  }

  /**
   * 初始化控件
   */
  private void initView() {

    ((TextView) findViewById(R.id.title_middle)).setText("重置密码");
    findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
      }
    });

    userPwd = (EditText) findViewById(R.id.activity_reset_pwd_userpassword);
    usePassWord = (EditText) findViewById(R.id.activity_reset_pwd_userpwd);
    register_button = (Button) findViewById(R.id.activity_reset_pwd_button);
    //设置输入框禁止输入空格
    userPwd.addTextChangedListener(new SearchWatherUtils(userPwd));
    usePassWord.addTextChangedListener(new SearchWatherUtils(usePassWord));
    //获取user_id
    getInfo = getSharedPreferences("saveSelfInfo", Context.MODE_PRIVATE);
    userId = getInfo.getString("user_id", userId);
    token = getInfo.getString("token", token);
    secretkey = getInfo.getString("secretkey", secretkey);

    register_button.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.activity_reset_pwd_button:
        if (userPwd.getText().toString().trim().length() < 6
            || userPwd.getText().toString().trim().length() > 16) {
          Toast.makeText(ResetPasswordActivity.this, "密码为6-16位数字、字母组成", Toast.LENGTH_SHORT).show();
        } else {
          OkHttpUtils.post()
              .url(PathUtils.postResetPasswordUrl())
              .addParams("id", userId).addParams("password",
              usePassWord.getText().toString().trim()) //原始密码
              .addParams("password1", userPwd.getText().toString().trim())//新密码
              .addParams("token", token)//新密码
              .addParams("secretkey", secretkey)//新密码
              .build().execute(new StringCallback() {
            @Override public void onError(Call call, Exception e) {

            }

            @Override public void onResponse(String response) {
              try {
                JSONObject jb = new JSONObject(response);
                String message = jb.getString("message");
                if (message.equals("TokenError")) {
                  AlertDialog.Builder builder = new AlertDialog.Builder(ResetPasswordActivity.this);
                  builder.setTitle("提示");
                  builder.setMessage("登录异常，请重新登录");
                  builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {
                      Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                      startActivity(intent);
                      finish();
                    }
                  });
                  builder.create().show();
                } else if (message.equals("pwdError")) {
                  Toast.makeText(ResetPasswordActivity.this, "原始密码错误", Toast.LENGTH_SHORT).show();
                } else if (message.equals("ok")) {
                  Toast.makeText(ResetPasswordActivity.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                } else if (message.equals("error")) {
                  Toast.makeText(ResetPasswordActivity.this, "密码修改成失败", Toast.LENGTH_SHORT).show();
                }
              } catch (JSONException e) {
                e.printStackTrace();
              }
            }
          });
        }
        break;
    }
  }
}
