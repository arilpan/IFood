package com.ydxiaoyuan.ifood.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPNewsList;
import com.ydxiaoyuan.ifood.base.BaseFragment;

/**
 * Created by aril_pan@qq.com on 16/8.
 */
public class DishNewsDetailFragment extends BaseFragment {
  //    public static int dish_id;
  //news_detail_url
  APPNewsList.ValueBean.ListBean.DataBean dishnew;
  String news_id;
  private TextView title;
  private TextView time;
  private TextView content;

  public DishNewsDetailFragment() {
  }

  public static DishNewsDetailFragment newInstance(String news_id) {

    Bundle args = new Bundle();
    args.putString("news_id", "" + news_id);

    DishNewsDetailFragment fragment = new DishNewsDetailFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //news_id
    Bundle args = getArguments();
    if (args != null) {
      news_id = args.getString("news_id");
    }
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_dish_news_detail, container, false);
    initView(view);
    return view;
  }

  private void initView(View view) {
    ((TextView) view.findViewById(R.id.title_middle)).setText("资讯详情");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });
    WebView webview = (WebView) view.findViewById(R.id.webview);

    String url = APIConfig.news_detail_url + news_id;
    //此方法可以在webview中打开链接而不会跳转到外部浏览器
    webview.setWebViewClient(new WebViewClient());
    webview.loadUrl(url);
  }

  @Override public boolean onBackPressedSupport() {
    Log.e("arilpan", "on back press");
    return false;
  }
}
