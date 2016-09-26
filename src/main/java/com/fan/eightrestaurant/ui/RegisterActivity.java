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
 * 用户注册界面
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
  private EditText userPhone, userCode, userPassWord;
  private TextView sendCode;
  private Button register;
  private TimeCount time;
  private Handler handler = new Handler() {
    @Override public void handleMessage(Message msg) {
      super.handleMessage(msg);
      if (msg.what == 1) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
      }
    }
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    initView();
  }

  /**
   * 初始化控件
   */
  private void initView() {
    ((TextView) findViewById(R.id.title_middle)).setText("注册账号");
    findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
      }
    });

    userPhone = (EditText) findViewById(R.id.register_userphone);
    userCode = (EditText) findViewById(R.id.register_usercode);
    userCode.setInputType(InputType.TYPE_CLASS_NUMBER);
    userPassWord = (EditText) findViewById(R.id.register_userpassword);
    userPassWord.addTextChangedListener(new SearchWatherUtils(userPassWord));
    sendCode = (TextView) findViewById(R.id.register_verification_code);
    register = (Button) findViewById(R.id.register_button);
    sendCode.setOnClickListener(this);
    register.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.register_verification_code:
        if (userPhone.getText().toString().equals("")) {
          Toast.makeText(RegisterActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
        } else {
          time = new TimeCount(60000, 1000);
          OkHttpUtils.post()
              .url(PathUtils.postSendCodeUrl())
              .addParams("phone", userPhone.getText().toString().trim())
              .addParams("type", "register")
              .build()
              .execute(new StringCallback() {
                @Override public void onError(Call call, Exception e) {

                }

                @Override public void onResponse(String response) {
                  try {
                    JSONObject jsonObject = new JSONObject(response);
                    String string = jsonObject.getString("message");
                    if (string.equals("ok")) {
                      Toast.makeText(RegisterActivity.this, "信息发送成功", Toast.LENGTH_SHORT).show();
                    } else if (string.equals("sendError")) {
                      Toast.makeText(RegisterActivity.this, "信息发送失败", Toast.LENGTH_SHORT).show();
                    } else if (string.equals("repetition")) {
                      Toast.makeText(RegisterActivity.this, "手机号码已被注册", Toast.LENGTH_SHORT).show();
                    } else if (string.equals("error")) {
                      Toast.makeText(RegisterActivity.this, "手机号码格式错误", Toast.LENGTH_SHORT).show();
                    }
                  } catch (JSONException e) {
                    e.printStackTrace();
                  }
                }
              });
        }
        break;
      case R.id.register_button:
        if (userPhone.getText().toString().trim().length() < 6
            || userPhone.getText().toString().trim().length() > 16) {
          Toast.makeText(RegisterActivity.this, "密码为6-16位数字、字母组成", Toast.LENGTH_SHORT).show();
        } else {
          OkHttpUtils.post()
              .url(PathUtils.postUserRegisterUrl())
              .addParams("phone", userPhone.getText().toString().trim())
              .addParams("password", userPassWord.getText().toString().trim())
              .addParams("password1", userPassWord.getText().toString().trim())
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
                      Toast.makeText(RegisterActivity.this, "服务器出问题了", Toast.LENGTH_SHORT).show();
                    } else if (message.equals("inconformity")) {
                      Toast.makeText(RegisterActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    } else if (message.equals("error")) {
                      Toast.makeText(RegisterActivity.this, "注册信息保存失败", Toast.LENGTH_SHORT).show();
                    } else if (message.equals("errorCode")) {
                      Toast.makeText(RegisterActivity.this, "验证码填写错误", Toast.LENGTH_SHORT).show();
                    } else if (message.equals("ok")) {
                      Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                      handler.sendEmptyMessageDelayed(1, 3000);
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
      sendCode.setClickable(false);
      sendCode.setText("(" + millisUntilFinished / 1000 + ") 秒后重新发送");
    }

    @Override public void onFinish() {
      sendCode.setText("获取验证码");
      sendCode.setClickable(true);
    }
  }
}
