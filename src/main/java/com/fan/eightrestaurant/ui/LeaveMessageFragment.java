package com.fan.eightrestaurant.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.fan.eightrestaurant.adapter.LeaveMessageAdapter;
import com.fan.eightrestaurant.bean.LeaveMessage;
import com.fan.eightrestaurant.utils.JSONUtils;
import com.fan.eightrestaurant.utils.PathUtils;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 留言——常见问题查询界面
 */
public class LeaveMessageFragment extends BaseFragment {

  private ListView listView;
  private List<LeaveMessage> list;
  private LeaveMessageAdapter adapter;
  private Button myLeaveButton;
  private String token, secretkey;
  private SharedPreferences getInfo;

  public LeaveMessageFragment() {
  }

  public static LeaveMessageFragment newInstance() {

    Bundle args = new Bundle();

    LeaveMessageFragment fragment = new LeaveMessageFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_leave_message, container, false);
    initView(view);
    return view;
  }
  //    @Override
  //    protected void onCreate(Bundle savedInstanceState) {
  //        super.onCreate(savedInstanceState);
  //        setContentView(R.layout.activity_leave_message);
  //        initView();
  //    }

  private void initView(View view) {
    ((TextView) view.findViewById(R.id.title_middle)).setText("留言本");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        pop();
      }
    });
    ((ImageView) view.findViewById(R.id.btn_iv_back)).setVisibility(View.GONE);

    listView = (ListView) view.findViewById(R.id.activity_leave_message_listview);
    myLeaveButton = (Button) view.findViewById(R.id.activity_leave_message_myleavebutton);

    getInfo = getContext().getSharedPreferences("saveSelfInfo", Context.MODE_PRIVATE);
    token = getInfo.getString("token", token);
    secretkey = getInfo.getString("secretkey", secretkey);

    initData(PathUtils.getAppListMessageUrl());
    list = new ArrayList<>();
    adapter = new LeaveMessageAdapter(getContext());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("登录异常，请重新登录");
                builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                  @Override public void onClick(DialogInterface dialog, int which) {
                    //todo:change arilpan
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    _mActivity.finish();
                  }
                });
                builder.create().show();
              }
            } catch (JSONException e) {
              e.printStackTrace();
            }
            List<LeaveMessage> result = JSONUtils.getMessageJson(response);

            adapter.setList(result);
          }
        });
    myLeaveButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), MyMessageActivity.class);
        startActivity(intent);
        //todo:arilpan intergrate
        //                                EventBus.getDefault().post(new StartBrotherEvent
        // (LeaveMessageFragment.newInstance()));
      }
    });
  }
}
