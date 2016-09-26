package com.ydxiaoyuan.ifood.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by aril_pan@qq.com on 16-8-25.
 */
public class KVHelper {
  public static String user_id;
  public static String shop_1;

  public static boolean clearUserInfo(Context context) {
    SharedPreferences sp = context.getSharedPreferences("saveSelfInfo", 0);
    return sp.edit().clear().commit();
  }

  public static String getUserInfo(Context context, String key, String defValue) {
    SharedPreferences sp = context.getSharedPreferences("saveSelfInfo", 0);
    return sp.getString(key, defValue);
  }

  public static boolean save(Context context, String key, String value) {
    SharedPreferences sp = context.getSharedPreferences("app", 0);
    return sp.edit().putString(key, value).commit();
  }

  public static String read(Context context, String key, String defValue) {
    SharedPreferences sp = context.getSharedPreferences("app", 0);
    return sp.getString(key, defValue);
  }
}
