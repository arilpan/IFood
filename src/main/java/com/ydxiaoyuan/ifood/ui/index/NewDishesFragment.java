package com.ydxiaoyuan.ifood.ui.index;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.adapter.dish.NewDishesAdapter;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPNew;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.event.TabSelectedEvent;
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
public class NewDishesFragment extends BaseFragment
    //        implements SwipeRefreshLayout
    //        .OnRefreshListener
{
  int SECOND = 1;
  String shop_id;

  private boolean mInAtTop = true;
  private int mScrollTotal;
  private SwipeRefreshLoadLayout mRefreshLayout;
  private RecyclerView mRecy;
  private NewDishesAdapter mAdapter;

  public static NewDishesFragment newInstance(String shop_org_id) {
    Log.e("arilpan", "1233");
    Bundle args = new Bundle();
    args.putString("shop_id", shop_org_id);
    NewDishesFragment fragment = new NewDishesFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    if (args != null) {
      shop_id = args.getString("shop_id");
    }
  }

  @Override public void onDestroy() {
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_dish_switch_layout, container, false);
    initView(view);
    return view;
  }

  /****************************************************************/

  /** ************************************************************ */
  private void initView(View view) {
    EventBus.getDefault().register(this);
    datas = new ArrayList<>();
    datasRight = new ArrayList<>();

    ((TextView) view.findViewById(R.id.title_middle)).setText("新品尝鲜");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });
    final TextView tab1 = (TextView) view.findViewById(R.id.tab1);
    tab1.setTextColor(Color.rgb(172, 66, 66));

    final TextView tab2 = (TextView) view.findViewById(R.id.tab2);
    tab2.setTextColor(Color.rgb(66, 66, 66));

    tab1.setText(APIConfig.shop_one_name);
    tab2.setText(APIConfig.shop_two_name);
    tab1.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        EventBus.getDefault()
            .post(new NetworkEvent(RequestType.INDEX_DISH_NEW, APIConfig.shop_one_id));
        shop_id = APIConfig.shop_one_id;
        tab1.setTextColor(Color.rgb(172, 66, 66));
        tab2.setTextColor(Color.rgb(66, 66, 66));
      }
    });
    tab2.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        EventBus.getDefault()
            .post(new NetworkEvent(RequestType.INDEX_DISH_NEW, APIConfig.shop_two_id));
        shop_id = APIConfig.shop_two_id;
        tab2.setTextColor(Color.rgb(172, 66, 66));
        tab1.setTextColor(Color.rgb(66, 66, 66));
      }
    });

    mRecy = (RecyclerView) view.findViewById(R.id.switch_recv_left);
    mRefreshLayout = (SwipeRefreshLoadLayout) view.findViewById(R.id.refresh_layout_left);
    //        mRefreshLayout.setOnRefreshListener(this);
    mAdapter = new NewDishesAdapter(_mActivity);
    mRecy.setHasFixedSize(true);
    mRecy.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    //        mRecy.setLayoutManager(new LinearLayoutManager(_mActivity));
    mRecy.setAdapter(mAdapter);

    //滑动事件
    //        mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
    //            @Override
    //            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    //                super.onScrolled(recyclerView, dx, dy);
    //                mScrollTotal += dy;
    //                if (mScrollTotal <= 0) {
    //                    mInAtTop = true;
    //                } else {
    //                    mInAtTop = false;
    //                }
    //            }
    //        });

    //点击事件
    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(int position, View view, RecyclerView.ViewHolder holder) {
        if (isShopOne()) {
          if (datas != null) {
            String dish_id = datas.get(position).getDishes_id();
            EventBus.getDefault()
                .post(new StartBrotherEvent(DishDetailFragment.newInstance(dish_id)));
          }
        } else {
          if (datasRight != null) {
            String dish_id = datasRight.get(position).getDishes_id();
            EventBus.getDefault()
                .post(new StartBrotherEvent(DishDetailFragment.newInstance(dish_id)));
          }
        }
        // 通知MainActivity跳转
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
    EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_NEW, shop_id));
  }

  private boolean isShopOne() {
    return shop_id.equals(APIConfig.shop_one_id);
  }

  int start = 0;
  int startRight = 0;
  int end = 10;
  boolean isLoadMore = false;
  boolean isRefresh = true;

  private void refreshContent() {
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        isLoadMore = false;
        isRefresh = true;
        EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_NEW, shop_id));
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
        EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_NEW, shop_id));
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
      if (isShopOne()) {
        start += 10;
        return url.replace("###", String.valueOf(start)).
            replace("$$$", String.valueOf(end));
      } else {
        startRight += 10;
        return url.replace("###", String.valueOf(startRight)).
            replace("$$$", String.valueOf(end));
      }
    }
    return url.replace("###", String.valueOf(0)).
        replace("$$$", String.valueOf(10));
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {
    Log.e("arilpan", "WaterFall 你调用咩?");
    if (RequestType.INDEX_DISH_NEW == event.reqType) {
      Log.e("arilpan", "WaterFall equals url=" + event.url + event.id);
      setData(getData(event.url + event.id));
    } else {
      Log.e("arilpan", "WaterFall what happend?");
    }
  }

  public List<APPNew.ValueBean.DataBean> getData(String url) {
    ResponseBody body = null;
    try {
      url = getUrl(url);
      Log.e("arilpan", "url " + url);
      final JsonAdapter<APPNew> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPNew.class));

      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(url).build();
      Response response = client.newCall(request).execute();
      body = response.body();

      APPNew datas_arry = COM_JSON_ADAPTER.fromJson(body.source());

      List<APPNew.ValueBean.DataBean> newdatas = datas_arry.getValue().getData();
      Log.e("arilpan", "数据长度" + newdatas.size());
      if (newdatas.size() != 10) {
        if (isShopOne()) {
          start -= 10;
        } else {
          startRight -= 10;
        }
      }
      return newdatas;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
    return null;
  }

  List<APPNew.ValueBean.DataBean> datas;
  List<APPNew.ValueBean.DataBean> datasRight;

  public static List<APPNew.ValueBean.DataBean> removeDuplicate(
      List<APPNew.ValueBean.DataBean> list) {
    Set set = new LinkedHashSet<APPNew.ValueBean.DataBean>();
    set.addAll(list);
    list.clear();
    list.addAll(set);
    return list;
  }

  public void setData(final List<APPNew.ValueBean.DataBean> items) {
    try {
      _mActivity.runOnUiThread(new Runnable() {
        @Override public void run() {
          if (items == null) {
            if (isShopOne()) {
              start -= 10;
            } else {
              startRight -= 10;
            }
            return;
          }
          if (shop_id.equals(APIConfig.shop_one_id)) {
            datas.addAll(items);
            removeDuplicate(datas);
            mAdapter.setDatas(datas);
          } else if (shop_id.equals(APIConfig.shop_two_id)) {
            datasRight.addAll(items);
            removeDuplicate(datasRight);
            mAdapter.setDatas(datasRight);
          }
          //stuff that updates ui
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //    @Override
  //    public void onRefresh()
  //    {
  //        EventBus.getDefault().post(new NetworkEvent(
  //                RequestType.INDEX_DISH_NEW,
  //                shop_id));
  //        mRefreshLayout.postDelayed(new Runnable()
  //        {
  //            @Override
  //            public void run()
  //            {
  //                mRefreshLayout.setRefreshing(false);
  //            }
  //        }, 1500);
  //    }

  /**
   * Reselected Tab
   */
  @Subscribe public void onTabSelectedEvent(TabSelectedEvent event) {
    Log.e("arilpan", "invock in water fall dish fragment ");
    if (event.position != SECOND) return;
    if (mInAtTop) {
      mRefreshLayout.setRefreshing(true);
      //            onRefresh();
    } else {
      scrollToTop();
    }
  }

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
  }
}
