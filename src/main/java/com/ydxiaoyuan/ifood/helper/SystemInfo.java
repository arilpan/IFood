package com.ydxiaoyuan.ifood.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by aril_pan@qq.com on 16-8-15.
 */
public class SystemInfo {
  /**
   * whether see the first load page
   */
  public static boolean isFirstLoad(Context context) {
    SharedPreferences sp = context.getSharedPreferences("app", 0);
    return sp.getBoolean("first_load", true);
  }

  /**
   * cancel first load state
   */
  public static void setFirstLoad(Context context) {
    SharedPreferences sp = context.getSharedPreferences("app", 0);
    sp.edit().putBoolean("first_load", false).commit();
  }
}
