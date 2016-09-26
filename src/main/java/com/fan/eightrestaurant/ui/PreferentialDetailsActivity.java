package com.fan.eightrestaurant.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ydxiaoyuan.ifood.R;
import com.fan.eightrestaurant.utils.PathUtils;

/**
 * 优惠详情界面
 */
public class PreferentialDetailsActivity extends AppCompatActivity {
  private WebView webView;
  private WebSettings webSettings;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_preferential_details);
    ((TextView) findViewById(R.id.title_middle)).setText("优惠详情");
    findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
      }
    });

    webView = (WebView) findViewById(R.id.activity_preferential_details_webview);
    Intent intent = getIntent();
    String discount_id = intent.getStringExtra("discount_id");
    String shop_id = intent.getStringExtra("shop_id");
    String path =
        PathUtils.getPreferentialDtailsUrl() + "shop_id=" + shop_id + "&discount_id=" + discount_id;
    webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);  //设置支持js
    webView.loadUrl(path);  //加载需要展示的网页
    webView.setWebViewClient(new WebViewClient() {
      @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
    });
  }
}
