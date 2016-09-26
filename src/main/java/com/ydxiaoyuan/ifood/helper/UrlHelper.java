package com.ydxiaoyuan.ifood.helper;

import android.content.Context;

/**
 * Created by aril_pan@qq.com on 16-9-6.
 */
public class UrlHelper {
  public static String addToken(Context context, String url) {
    String token = KVHelper.getUserInfo(context, "token", "");
    String secretkey = KVHelper.getUserInfo(context, "secretkey", "");
    return url + "&token=" + token + "&secretkey=" + secretkey;
  }
}
