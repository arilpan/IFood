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
import android.widget.ListView;


import com.fan.eightrestaurant.adapter.LeaveMessageAdapter;
import com.fan.eightrestaurant.bean.LeaveMessage;
import com.fan.eightrestaurant.utils.JSONUtils;
import com.fan.eightrestaurant.utils.PathUtils;
import com.ydxiaoyuan.ifood.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Call;

/**
 * 留言——常见问题查询界面
 */
public class LeaveMessageActivity extends AppCompatActivity {

  private ListView listView;

  private LeaveMessageAdapter adapter;
  private Button myLeaveButton;
  private String token, secretkey;
  private SharedPreferences getInfo;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_leave_message);
    initView();
  }

  private void initView() {
    listView = (ListView) findViewById(R.id.activity_leave_message_listview);
    myLeaveButton = (Button) findViewById(R.id.activity_leave_message_myleavebutton);

    getInfo = getSharedPreferences("saveSelfInfo", Context.MODE_PRIVATE);
    token = getInfo.getString("token", token);
    secretkey = getInfo.getString("secretkey", secretkey);

    initData(PathUtils.getAppListMessageUrl());

    adapter = new LeaveMessageAdapter(getBaseContext());
    listView.setAdapter(adapter);
  }

  private void initData(String path) {
    OkHttpUtils.get()
        .addParams("secretkey", secretkey)
        .addParams("token", token)
        .url(path)
        .build()
        .execute(new StringCallback() {
          @Override public void onError(Call call, Exception e) {

          }

          @Override public void onResponse(String response) {
            try {
              JSONObject object = new JSONObject(response);
              String message = object.getString("message");
              if (message.equals("TokenError")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LeaveMessageActivity.this);
                builder.setTitle("提示");
                builder.setMessage("登录异常，请重新登录");
                builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                  @Override public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(LeaveMessageActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                  }
                });
                builder.create().show();
              }
            } catch (JSONException e) {
              e.printStackTrace();
            }
            List<LeaveMessage> result = JSONUtils.getMessageJson(response);

            adapter.setList(result);
            myLeaveButton.setOnClickListener(new View.OnClickListener() {
              @Override public void onClick(View v) {
                Intent intent = new Intent(LeaveMessageActivity.this, MyMessageActivity.class);
                startActivity(intent);
              }
            });
          }
        });
  }
}
