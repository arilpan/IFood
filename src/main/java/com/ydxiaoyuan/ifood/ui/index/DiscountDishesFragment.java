package com.ydxiaoyuan.ifood.ui.index;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.adapter.dish.DiscountDishAdapter;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPDishDiscount;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.zfeng.swiperefreshload.SwipeRefreshLoadLayout;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.*;

/**
 * 折扣菜
 * Redo in 2016/9/13
 * Created by aril_pan@qq.com on 16/8.
 */
public class DiscountDishesFragment extends BaseFragment

{
  String shop_id;

  public DiscountDishesFragment() {
  }

  public static DiscountDishesFragment newInstance(String shop_org_id) {

    Bundle args = new Bundle();
    args.putString("shop_id", shop_org_id);
    DiscountDishesFragment fragment = new DiscountDishesFragment();
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

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_dish_discount, container, false);
    initView(view);
    return view;
  }

  RecyclerView order_recyview;
  private DiscountDishAdapter mAdapter;
  private List<APPDishDiscount.ValueBean.DataBean> datas;
  private List<APPDishDiscount.ValueBean.DataBean> datasRight;
  private SwipeRefreshLoadLayout mRefreshLayout;

  @Override public void onDestroy() {
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }

  private void initView(View view) {
    EventBus.getDefault().register(this);

    //"超值折扣菜"
    ((TextView) view.findViewById(R.id.title_middle)).setText("超值折扣菜");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });
    final TextView tab1 = (TextView) view.findViewById(R.id.tab1);
    final TextView tab2 = (TextView) view.findViewById(R.id.tab2);

    tab1.setTextColor(Color.rgb(172, 66, 66));
    tab2.setTextColor(Color.rgb(66, 66, 66));

    tab1.setText(APIConfig.shop_one_name);
    tab2.setText(APIConfig.shop_two_name);
    tab1.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        EventBus.getDefault()
            .post(new NetworkEvent(RequestType.INDEX_DISH_DISCOUNT, APIConfig.shop_one_id));
        shop_id = APIConfig.shop_one_id;
        tab1.setTextColor(Color.rgb(172, 66, 66));
        tab2.setTextColor(Color.rgb(66, 66, 66));
      }
    });
    tab2.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        EventBus.getDefault()
            .post(new NetworkEvent(RequestType.INDEX_DISH_DISCOUNT, APIConfig.shop_two_id));
        shop_id = APIConfig.shop_two_id;
        tab2.setTextColor(Color.rgb(172, 66, 66));
        tab1.setTextColor(Color.rgb(66, 66, 66));
      }
    });
    mRefreshLayout = (SwipeRefreshLoadLayout) view.findViewById(R.id.refresh_layout_left);

    order_recyview = (RecyclerView) view.findViewById(R.id.dish_discount_recyview);
    order_recyview.setLayoutManager(
        new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
    mAdapter = new DiscountDishAdapter(getContext());
    datas = new ArrayList<APPDishDiscount.ValueBean.DataBean>();
    datasRight = new ArrayList<APPDishDiscount.ValueBean.DataBean>();

    order_recyview.setAdapter(mAdapter);
    //        basicParamInit();
    //        initData();
    //        initRecyclerView();
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

    EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_DISCOUNT, shop_id));
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {
    Log.e("arilpan", "HotDishFragment 你调用咩?");
    if (RequestType.INDEX_DISH_DISCOUNT == event.reqType) {
      Log.e("arilpan", "HotDishFragment equals url=" + event.url + event.id);
      setData(getData(event.url + event.id));
    } else {
      Log.e("arilpan", "HotDishFragment what happend?");
    }
  }

  public List<APPDishDiscount.ValueBean.DataBean> getData(String url) {
    ResponseBody body = null;
    try {
      url = getUrl(url);
      Log.e("arilpan", "url " + url);

      final JsonAdapter<APPDishDiscount> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPDishDiscount.class));
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(url).build();
      Response response = client.newCall(request).execute();
      body = response.body();

      APPDishDiscount datas_arry = COM_JSON_ADAPTER.fromJson(body.source());

      List<APPDishDiscount.ValueBean.DataBean> datas = datas_arry.getValue().getData();

      Log.e("arilpan", "数据长度" + datas.size());
      if (datas.size() != 10) {
        if (isShopOne()) {
          start -= 10;
        } else {
          startRight -= 10;
        }
      }
      return datas;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
    return null;
  }

  //List<APPDishDiscount.ValueBean.DataBean> types;
  HashMap<Integer, ArrayList<String>> discountDishesMap;//折扣数-折扣菜集合
  List<Integer> discountDishesMapKey;//折扣数集合

  public static List<APPDishDiscount.ValueBean.DataBean> removeDuplicate(
      List<APPDishDiscount.ValueBean.DataBean> list) {
    Set set = new LinkedHashSet<APPDishDiscount.ValueBean.DataBean>();
    set.addAll(list);
    list.clear();
    list.addAll(set);
    return list;
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
        EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_DISCOUNT, shop_id));

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
        EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_DISCOUNT, shop_id));
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

  public void setData(final List<APPDishDiscount.ValueBean.DataBean> items) {
    try {
      _mActivity.runOnUiThread(new Runnable() {
        @Override public void run() {

          //                    if (mDatas == null) {
          //                        Log.e("arilpan", "datas is null");
          //                    }
          //                    if (items == null) {
          //                        Log.e("arilpan", "items is null start   -= 10");
          //                        start -= 10;
          //                    } else {
          //                        mDatas.addAll(items);
          //                        removeDuplicate(mDatas);
          //                        mAdapter.setDatas(mDatas);
          //                    }

          if (items == null) {
            Log.e("arilpan", "返回为null");
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

  @Override public boolean onBackPressedSupport() {
    Log.e("arilpan", "on back press");
    return false;
  }

  class MyLayoutManager extends LinearLayoutManager {
    public MyLayoutManager(Context context) {
      super(context);
      // TODO Auto-generated constructor stub
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec,
        int heightSpec) {
      View view = recycler.getViewForPosition(0);
      if (view != null) {
        measureChild(view, widthSpec, heightSpec);
        int measuredWidth = View.MeasureSpec.getSize(widthSpec);
        int measuredHeight = view.getMeasuredHeight();
        setMeasuredDimension(measuredWidth, measuredHeight);
      }
    }
  }
}
