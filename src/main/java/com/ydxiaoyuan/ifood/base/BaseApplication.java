package com.ydxiaoyuan.ifood.base;

import android.app.Application;

/**
 * Created by arilpan on 2016/9/18.
 */
public class BaseApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    //初始化全局异常信息捕获，捕获异常后写入本地文件
    CrashHandler crashHandler = CrashHandler.getInstance();
    crashHandler.init(getApplicationContext());
  }
}