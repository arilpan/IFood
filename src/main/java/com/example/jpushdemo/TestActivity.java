package com.example.jpushdemo;

import cn.jpush.android.api.JPushInterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;

public class TestActivity extends Activity {

  String news_id;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_dish_news_detail);

    Intent intent = getIntent();
    if (null != intent) {
      Bundle bundle = getIntent().getExtras();
      String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
      String content = bundle.getString(JPushInterface.EXTRA_ALERT);
      news_id = content;
      //            tv.setText("Title : " + title + "  " + "Content : " + content);
    }
    ((TextView) findViewById(R.id.title_middle)).setText("资讯详情");
    findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
        //                _mActivity.onBackPressed();
      }
    });
    WebView webview = (WebView) findViewById(R.id.webview);

    String url = APIConfig.news_detail_url + news_id;
    //此方法可以在webview中打开链接而不会跳转到外部浏览器
    webview.setWebViewClient(new WebViewClient());
    webview.loadUrl(url);

    //        TextView tv = new TextView(this);
    //        tv.setText("用户自定义打开的Activity");
    //        Intent intent = getIntent();
    //        if (null != intent) {
    //	        Bundle bundle = getIntent().getExtras();
    //	        String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
    //	        String content = bundle.getString(JPushInterface.EXTRA_ALERT);
    //	        tv.setText("Title : " + title + "  " + "Content : " + content);
    //        }
    //        addContentView(tv, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
  }
}
