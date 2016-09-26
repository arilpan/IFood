package com.ydxiaoyuan.ifood.ui.mine;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.avast.android.dialogs.fragment.SimpleDialogFragment;
import com.avast.android.dialogs.iface.ISimpleDialogListener;
import com.fan.eightrestaurant.ui.LoginActivity;
import com.fan.eightrestaurant.ui.ResetPasswordActivity;
import com.fan.eightrestaurant.utils.PathUtils;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.helper.KVHelper;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import okhttp3.Call;

/**
 * todo : add button logical
 * Created by aril_pan@qq.com on 16/8.
 */
public class SettingFragment extends BaseFragment implements ISimpleDialogListener {
  int REQUEST_CLEAR_DATA = 100;

  public SettingFragment() {
  }

  public static SettingFragment newInstance() {

    Bundle args = new Bundle();
    SettingFragment fragment = new SettingFragment();
    fragment.setArguments(args);
    return fragment;
  }

  public void exit() {
    String token = KVHelper.getUserInfo(getContext(), "token", "");
    String secretkey = KVHelper.getUserInfo(getContext(), "secretkey", "");
    OkHttpUtils.post()
        .url(PathUtils.postLoginOutUrl())
        .addParams("token", token)
        .addParams("secretkey", secretkey)
        .build()
        .execute(new StringCallback() {
          @Override public void onError(Call call, Exception e) {
            Log.e("AAA", "网络数据下载失败 ");
          }

          @Override public void onResponse(String response) {
            Log.e("AAA", "网络数据下载成功 " + response);
            try {
              JSONObject jb = new JSONObject(response);
              String message = jb.getString("message");
              if (message.equals("TokenError")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("登录异常，请重新登录");
                builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                  @Override public void onClick(DialogInterface dialog, int which) {
                    KVHelper.clearUserInfo(getContext());
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                  }
                });
                builder.create().show();
              } else {
                if (message.equals("ok")) {

                } else if (message.equals("error")) {
                  Toast.makeText(getContext(), "用户注销登录失败", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                _mActivity.finish();
              }
            } catch (JSONException e) {
              e.printStackTrace();
            } finally {
              KVHelper.clearUserInfo(getContext());
            }
          }
        });
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_setting, container, false);
    initView(view);
    return view;
  }

  LinearLayout ll_update;
  LinearLayout ll_clear_data;
  LinearLayout ll_about;
  LinearLayout ll_repswd;

  private void initView(View view) {
    setTitle(view, "设置");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });

    ll_update = (LinearLayout) view.findViewById(R.id.ll_update);
    ll_clear_data = (LinearLayout) view.findViewById(R.id.ll_clear_data);
    ll_about = (LinearLayout) view.findViewById(R.id.ll_about);
    ll_repswd = (LinearLayout) view.findViewById(R.id.ll_repswd);
    ll_update.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        //todo:dialog
        SimpleDialogFragment.createBuilder(getContext(), getChildFragmentManager())
            .setMessage("暂无新版本")
            .show();
      }
    });
    view.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        exit();
      }
    });
    ll_clear_data.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        SimpleDialogFragment.createBuilder(getContext(), getChildFragmentManager())
            .setTargetFragment(SettingFragment.this, REQUEST_CLEAR_DATA)
            .setMessage("请问需要清除数据吗?")
            .setPositiveButtonText("清除")
            .setNegativeButtonText("取消")
            .show();
      }
    });
    ll_about.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        EventBus.getDefault().post(new StartBrotherEvent(AboutFragment.newInstance(0)));
      }
    });
    ll_repswd.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        //                EventBus.getDefault().post(new StartBrotherEvent(
        //                        DishDetailFragment.newInstance("")));
        Intent intent = new Intent();
        intent.setClass(getActivity(), ResetPasswordActivity.class);
        startActivity(intent);
      }
    });
  }

  @Override public boolean onBackPressedSupport() {
    // 这里实际项目中推荐使用 EventBus接耦
    //        ((TestOne) getParentFragment()).onBackToFirstFragment();
    Log.e("arilpan", "on back press");
    return false;
    //        return true;
  }

  @Override public void onNegativeButtonClicked(int requestCode) {
    Log.e("arilpan", "onNegativeButtonClicked code :" + REQUEST_CLEAR_DATA);
  }

  @Override public void onNeutralButtonClicked(int requestCode) {
    Log.e("arilpan", "on  NeutralButtonClicked code :" + REQUEST_CLEAR_DATA);
  }

  @Override public void onPositiveButtonClicked(int requestCode) {
    if (requestCode == REQUEST_CLEAR_DATA) {
      deleteCache(getContext());
      Toast.makeText(getContext(), "清除成功 ", Toast.LENGTH_SHORT).show();
    }
  }

  public static void deleteCache(Context context) {
    try {
      File dir = context.getCacheDir();
      if (dir != null && dir.isDirectory()) {
        deleteDir(dir);
      }
    } catch (Exception e) {
    }
  }

  public static boolean deleteDir(File dir) {
    if (dir != null && dir.isDirectory()) {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        boolean success = deleteDir(new File(dir, children[i]));
        if (!success) {
          return false;
        }
      }
    }
    return dir.delete();
  }
}
