package com.ydxiaoyuan.ifood.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fan.eightrestaurant.ui.UpLoadActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.helper.KVHelper;
import com.ydxiaoyuan.ifood.ui.mine.SettingFragment;
import com.ydxiaoyuan.ifood.ui.order.CancleOrderFragment;
import com.ydxiaoyuan.ifood.ui.order.CompleteOrderFragment;
import com.ydxiaoyuan.ifood.ui.order.UncompleteOrderFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by aril_pan@qq.com on 16/8.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
  public MineFragment() {
  }

  public static MineFragment newInstance() {
    Bundle args = new Bundle();
    MineFragment fragment = new MineFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onResume() {
    super.onResume();
    Log.e("arilpan", "mine fragment onresume");
    setView();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_mine, container, false);
    initView(view);
    return view;
  }

  RelativeLayout cancel_layout;
  RelativeLayout complete_layout;
  RelativeLayout uncomplete_layout;

  LinearLayout setting_layout;

  private void setView() {
    String user_name = KVHelper.getUserInfo(getContext(), "nickname", "用戶昵称");
    String user_head_img = KVHelper.getUserInfo(getContext(), "imagePath", "");
    if (!TextUtils.isEmpty(user_name)) {
      username.setText(user_name);
    } else if ("null".equals(user_name)) {
      username.setText("请设置昵称");
    }
    if (!TextUtils.isEmpty(user_head_img)) {
      Glide.with(MineFragment.this).load(user_head_img).into(userhead);
    }
  }

  private ImageView userhead;
  private TextView username;

  private void initView(View view) {
    cancel_layout = (RelativeLayout) view.findViewById(R.id.cancel_layout);

    complete_layout = (RelativeLayout) view.findViewById(R.id.complete_layout);
    uncomplete_layout = (RelativeLayout) view.findViewById(R.id.uncomplete_layout);
    setting_layout = (LinearLayout) view.findViewById(R.id.setting_layout);

    cancel_layout.setOnClickListener(this);
    complete_layout.setOnClickListener(this);
    uncomplete_layout.setOnClickListener(this);
    setting_layout.setOnClickListener(this);

    ((TextView) view.findViewById(R.id.title_middle)).setText("我的");
    ((ImageView) view.findViewById(R.id.btn_iv_back)).setVisibility(View.GONE);

    userhead = (ImageView) view.findViewById(R.id.userhead);
    username = (TextView) view.findViewById(R.id.username);

    userhead.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), UpLoadActivity.class);
        startActivity(intent);
      }
    });
    setView();
  }

  @Override public boolean onBackPressedSupport() {
    Log.e("arilpan", "on back press");
    return false;
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      //已取消的訂單
      case R.id.cancel_layout:
        EventBus.getDefault().post(new StartBrotherEvent(CancleOrderFragment.newInstance()));
        break;
      //已完成的訂單
      case R.id.complete_layout:
        EventBus.getDefault().post(new StartBrotherEvent(CompleteOrderFragment.newInstance()));
        break;
      //未完成的訂單
      case R.id.uncomplete_layout:
        EventBus.getDefault().post(new StartBrotherEvent(UncompleteOrderFragment.newInstance()));
        break;
      //設置
      case R.id.setting_layout:
        EventBus.getDefault().post(new StartBrotherEvent(SettingFragment.newInstance()));
        break;
    }
  }
}
