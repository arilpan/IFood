package com.ydxiaoyuan.ifood;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;
import com.squareup.moshi.Moshi;
import com.ydxiaoyuan.ifood.base.BaseLazyMainFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.Objects;

/**
 * 类知乎 复杂嵌套Demo tip: 多使用右上角的"查看栈视图"
 * Created by YoKeyword on 16/6/2.
 */
public class MainActivity extends SupportActivity
    implements BaseLazyMainFragment.OnBackToFirstListener {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //init jpush
    JPushInterface.init(this);
    JPushInterface.setDebugMode(true);

    setContentView(R.layout.activity_main);
    EventBus.getDefault().register(MainActivity.this);

    if (savedInstanceState == null) {
      loadRootFragment(R.id.fl_container, MainFragment.newInstance());
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(MainActivity.this);
  }

  @Override public void onBackPressedSupport() {
    // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
    super.onBackPressedSupport();
  }

  @Override public FragmentAnimator onCreateFragmentAnimator() {
    // 设置横向(和安卓4.x动画相同)
    return new DefaultHorizontalAnimator();
  }

  @Override public void onBackToFirstFragment() {
    super.onBackPressedSupport();
  }

  public static final Moshi MOSHI = new Moshi.Builder().build();

  public static String getNetWorkResult(String url) {
    Log.e("arilpan", "Main url : " + url);
    ResponseBody body = null;
    try {
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(url).build();
      Response response = null;
      response = client.newCall(request).execute();
      body = response.body();
      Log.e("arilpan", "Main getNetWorkResult : " + body.toString());
      final String bs = body.string();
      return bs;
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
    return null;
  }
}
