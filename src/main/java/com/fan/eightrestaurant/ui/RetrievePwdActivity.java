package com.fan.eightrestaurant.ui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
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
 * 用户忘记密码，找回密码界面
 */
public class RetrievePwdActivity extends AppCompatActivity implements View.OnClickListener {

  private EditText userName, userCode, userPwd;
  private TextView CodeNum;
  private Button register_button;
  private TimeCount time;
  private Handler handler = new Handler() {
    @Override public void handleMessage(Message msg) {
      super.handleMessage(msg);
      if (msg.what == 1) {
        Intent intent = new Intent(RetrievePwdActivity.this, LoginActivity.class);
        startActivity(intent);
      }
    }
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_retrieve_pwd);
    initView();
  }

  /**
   * 初始化控件
   */
  private void initView() {
    ((TextView) findViewById(R.id.title_middle)).setText("忘记密码");
    findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
      }
    });

    userName = (EditText) findViewById(R.id.retrieve_userphone);
    userCode = (EditText) findViewById(R.id.retrieve_usercode);
    userCode.setInputType(InputType.TYPE_CLASS_NUMBER);
    userPwd = (EditText) findViewById(R.id.retrieve_userpassword);
    userPwd.addTextChangedListener(new SearchWatherUtils(userPwd));
    CodeNum = (TextView) findViewById(R.id.retrieve_verification_code);
    register_button = (Button) findViewById(R.id.retrieve_button);
    time = new TimeCount(60000, 1000);
    CodeNum.setOnClickListener(this);
    register_button.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.retrieve_button:
        if (userPwd.getText().toString().trim().length() < 6
            || userPwd.getText().toString().trim().length() > 16) {
          Toast.makeText(RetrievePwdActivity.this, "密码为6-16位数字、字母组成", Toast.LENGTH_SHORT).show();
        } else {
          OkHttpUtils.post()
              .url(PathUtils.postUpdatePwdUrl())
              .addParams("phone", userName.getText().toString().trim())
              .addParams("password", userPwd.getText().toString().trim())
              .addParams("password1", userPwd.getText().toString().trim())
              .addParams("code", userCode.getText().toString().trim())
              .build()
              .execute(new StringCallback() {
                @Override public void onError(Call call, Exception e) {

                }

                @Override public void onResponse(String response) {
                  try {
                    JSONObject jb = new JSONObject(response);
                    String message = jb.getString("message");
                    if (message.equals("serversError")) {
                      Toast.makeText(RetrievePwdActivity.this, "服务器出问题了", Toast.LENGTH_SHORT)
                          .show();
                    } else if (message.equals("ok")) {
                      Toast.makeText(RetrievePwdActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                      handler.sendEmptyMessageDelayed(1, 3000);
                    }
                  } catch (JSONException e) {
                    e.printStackTrace();
                  }
                }
              });
        }
        break;
      case R.id.retrieve_verification_code:

        if (userName.getText().toString().trim().equals("")) {
          Toast.makeText(RetrievePwdActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
        } else {
          time.start();
          OkHttpUtils.post()
              .url(PathUtils.postSendCodeUrl())
              .addParams("phone", userName.getText().toString().trim())
              .addParams("type", "updatePwd")
              .build()
              .execute(new StringCallback() {
                @Override public void onError(Call call, Exception e) {

                }

                @Override public void onResponse(String response) {

                  try {
                    JSONObject jb = new JSONObject(response);
                    String message = jb.getString("message");
                    if (message.equals("sendError")) {
                      Toast.makeText(RetrievePwdActivity.this, "信息发送失败", Toast.LENGTH_SHORT).show();
                    } else if (message.equals("repetition")) {
                      Toast.makeText(RetrievePwdActivity.this, "手机号码已被注册", Toast.LENGTH_SHORT)
                          .show();
                    } else if (message.equals("error")) {
                      Toast.makeText(RetrievePwdActivity.this, "手机号码格式错误", Toast.LENGTH_SHORT)
                          .show();
                    } else if (message.equals("ok")) {
                      Toast.makeText(RetrievePwdActivity.this, "信息发送成功", Toast.LENGTH_SHORT).show();
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

  /**
   * 获取验证码倒计时重新发送
   */
  class TimeCount extends CountDownTimer {

    public TimeCount(long millisInFuture, long countDownInterval) {
      super(millisInFuture, countDownInterval);
    }

    @Override public void onTick(long millisUntilFinished) {
      CodeNum.setClickable(false);
      CodeNum.setText("(" + millisUntilFinished / 1000 + ") 秒后重新发送");
    }

    @Override public void onFinish() {
      CodeNum.setText("获取验证码");
      CodeNum.setClickable(true);
    }
  }
}
