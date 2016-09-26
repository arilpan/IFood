package com.fan.eightrestaurant;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by xdkj on 2016/7/12.
 */
public class MyApplication extends Application {
  private static MyApplication myApplication;

  public MyApplication() {
    myApplication = this;
  }

  @Override public void onCreate() {
    super.onCreate();
    OkHttpUtils.getInstance().debug("OkHttpUtils").setConnectTimeout(100000, TimeUnit.MILLISECONDS);
    Fresco.initialize(this);
  }

  public static MyApplication getInstnce() {
    return myApplication;
  }
}
