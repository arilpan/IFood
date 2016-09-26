package com.ydxiaoyuan.ifood.ui.news;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bingoogolapple.bgabanner.BGABanner;
import com.bumptech.glide.Glide;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.adapter.NewsListAdapter;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPNewsList;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;
import com.zfeng.swiperefreshload.SwipeRefreshLoadLayout;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aril_pan@qq.com on 16/8.
 */
public class NewsListFragment extends BaseFragment
    //        implements SwipeRefreshLayout
    //        .OnRefreshListener
{
  int SECOND = 1;

  private BGABanner news_banner;
  List<String> imgs;

  private boolean mInAtTop = true;
  private int mScrollTotal;
  private SwipeRefreshLoadLayout mRefreshLayout;
  private RecyclerView mRecy;
  private NewsListAdapter mAdapter;

  public static NewsListFragment newInstance() {
    Bundle args = new Bundle();
    NewsListFragment fragment = new NewsListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_dish_news, container, false);
    initView(view);
    return view;
  }

  /****************************************************************/

  /** ************************************************************ */
  private void initView(View view) {
    ((TextView) view.findViewById(R.id.title_middle)).setText("新闻资讯");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });
    EventBus.getDefault().register(this);

    datas = new ArrayList<>();

    news_banner = (BGABanner) view.findViewById(R.id.news_banner);
    news_banner.setAdapter(new BGABanner.Adapter() {
      @Override
      public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        Log.e("arilpan", "model to string " + model.toString());
        Glide.with(view.getContext())
            .load(APIConfig.BASE_IMG_URL + model.toString())
            .error(R.drawable.preferential_list_item_zanwutupian)
            .into((ImageView) view);
      }
    });

    mRecy = (RecyclerView) view.findViewById(R.id.news_recyview);
    mRefreshLayout = (SwipeRefreshLoadLayout) view.findViewById(R.id.refresh_layout);
    mAdapter = new NewsListAdapter(_mActivity);
    mRecy.setHasFixedSize(true);
    //        mRecy.setLayoutManager(new StaggeredGridLayoutManager(1,
    //                StaggeredGridLayoutManager
    //                        .VERTICAL));
    mRecy.setLayoutManager(new LinearLayoutManager(_mActivity));
    mRecy.setAdapter(mAdapter);

    //滑动事件
    mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        mScrollTotal += dy;
        if (mScrollTotal <= 0) {
          mInAtTop = true;
        } else {
          mInAtTop = false;
        }
      }
    });
    //点击事件
    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(int position, View view, RecyclerView.ViewHolder holder) {
        Log.e("arilpan", " NewsListAdapter onItemClick  ");
        // 通知MainActivity跳转至CycleFragment
        EventBus.getDefault()
            .post(new StartBrotherEvent(
                    DishNewsDetailFragment.newInstance(datas.get(position).getNews_id())));
      }
    });

    mRefreshLayout.setOnRefreshListener(new SwipeRefreshLoadLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        refreshContent();
      }
    });
    mRefreshLayout.setLoadMoreListener(new SwipeRefreshLoadLayout.LoadMoreListener() {
      @Override public void loadMore() {
        loadMoreData();
      }
    });
    EventBus.getDefault().post(new NetworkEvent(RequestType.NEWS_LIST));
  }

  int start = 0;
  int end = 10;
  boolean isLoadMore = false;
  boolean isRefresh = true;

  private void refreshContent() {
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        isLoadMore = false;
        isRefresh = true;
        EventBus.getDefault().post(new NetworkEvent(RequestType.NEWS_LIST));
        Log.e("arilpan", "调用 refreshContent  ");
        mRefreshLayout.setRefreshing(false);
      }
    }, 1000);
  }

  private void loadMoreData() {
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        isLoadMore = true;
        isRefresh = false;
        EventBus.getDefault().post(new NetworkEvent(RequestType.NEWS_LIST));
        Log.e("arilpan", "调用loadMoreData  ");
        mRefreshLayout.setLoadMore(false);
      }
    }, 1000);
  }

  private String getUrl(String url) {
    if (isRefresh) {
      return url.replace("###", String.valueOf(0)).
          replace("$$$", String.valueOf(10));
    } else if (isLoadMore) {
      start += 10;
      return url.replace("###", String.valueOf(start)).
          replace("$$$", String.valueOf(end));
    }
    return url.replace("###", String.valueOf(0)).
        replace("$$$", String.valueOf(10));
  }

  //    @Override
  //    public void onRefresh()
  //    {
  //        mRefreshLayout.postDelayed(new Runnable()
  //        {
  //            @Override
  //            public void run()
  //            {
  //                mRefreshLayout.setRefreshing(false);
  //            }
  //        }, 1500);
  //    }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {
    Log.e("arilpan", "NewsListFragment哥 你调用咩?");
    if (RequestType.NEWS_LIST == event.reqType) {

      setData(getData(event));
    }
  }

  public List<APPNewsList.ValueBean.ListBean.DataBean> getData(NetworkEvent event) {
    ResponseBody body = null;
    try {
      final JsonAdapter<APPNewsList> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPNewsList.class));
      OkHttpClient client = new OkHttpClient();
      String url = event.url;
      url = getUrl(url);
      Log.e("arilpan", "新闻列表url:" + event.url);
      Request request = new Request.Builder().url(url).build();
      Response response = client.newCall(request).execute();
      body = response.body();

      APPNewsList datas_arry = COM_JSON_ADAPTER.fromJson(body.source());
      body.close();
      imgs = new ArrayList<>();
      imgs.add(datas_arry.getValue().getUrl1());
      imgs.add(datas_arry.getValue().getUrl2());
      imgs.add(datas_arry.getValue().getUrl3());

      List<APPNewsList.ValueBean.ListBean.DataBean> newdatas =
          datas_arry.getValue().getList().getData();
      Log.e("arilpan", "size :" + newdatas.size());

      return newdatas;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
    return null;
  }

  List<APPNewsList.ValueBean.ListBean.DataBean> datas;

  public static List<APPNewsList.ValueBean.ListBean.DataBean> removeDuplicate(
      List<APPNewsList.ValueBean.ListBean.DataBean> list) {
    Set set = new LinkedHashSet<APPNewsList.ValueBean.ListBean.DataBean>();
    set.addAll(list);
    list.clear();
    list.addAll(set);
    return list;
  }

  public void setData(final List<APPNewsList.ValueBean.ListBean.DataBean> items) {
    try {
      _mActivity.runOnUiThread(new Runnable() {
        @Override public void run() {
          if (imgs != null) {
            news_banner.setData(imgs, null);
          }
          if (items != null) {

            datas.addAll(items);
            removeDuplicate(datas);
            mAdapter.setDatas(datas);
          } else {
            start -= 10;
          }
          //stuff that updates ui
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Reselected Tab
   */
  //    @Subscribe
  //    public void onTabSelectedEvent(TabSelectedEvent event)
  //    {
  //        if (event.position != SECOND)
  //            return;
  //        if (mInAtTop)
  //        {
  //            mRefreshLayout.setRefreshing(true);
  //            onRefresh();
  //        } else
  //        {
  //            scrollToTop();
  //        }
  //    }
  //
  //    @Subscribe
  //    public void start(StartBrotherEvent event)
  //    {
  //        start(event.targetFragment);
  //    }
  private void scrollToTop() {
    mRecy.smoothScrollToPosition(0);
  }

  @Override public boolean onBackPressedSupport() {
    // 默认flase，继续向上传递
    return super.onBackPressedSupport();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    mRecy.setAdapter(null);
    EventBus.getDefault().unregister(this);
  }
}
