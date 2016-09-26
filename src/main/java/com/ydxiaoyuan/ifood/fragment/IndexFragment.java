package com.ydxiaoyuan.ifood.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.jpush.android.api.JPushInterface;
import com.bumptech.glide.Glide;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.adapter.dish.HotDishesAdapter;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPALL;
import com.ydxiaoyuan.ifood.base.BaseLazyMainFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.helper.KVHelper;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;
import com.ydxiaoyuan.ifood.ui.index.*;
import com.ydxiaoyuan.ifood.ui.news.NewsListFragment;
import com.ydxiaoyuan.ifood.ui.place.SelectPlaceFragment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aril_pan@qq.com on 16/8.
 */
public class IndexFragment extends BaseLazyMainFragment {
  public IndexFragment() {
  }

  public static IndexFragment newInstance() {
    Bundle args = new Bundle();
    IndexFragment fragment = new IndexFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_mainpage, container, false);
    //        SupportFragment supportFragment;
    //        if (savedInstanceState == null) {
    //            supportFragment = IndexFragment.newInstance();
    //            Log.e("arilpan", "IndexFragment savedInstanceState == null ");
    //            view = inflater.inflate(R.layout.fragment_mainpage, container, false);
    //            Log.e("arilpan", "IndexFragment view  inflate");
    //        } else {
    //            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
    //            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()自行进行判断查找
    // (效率更高些),用下面的方法查找更方便些
    //            supportFragment = findFragment(IndexFragment.class);
    //            Log.e("arilpan", "MainFragment savedInstanceState != null ");
    //        }
    initView(view);
    return view;
  }

  private void addBtn(View view) {
    view.findViewById(R.id.pre_order_layout).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        EventBus.getDefault().post(new StartBrotherEvent(SelectPlaceFragment.newInstance()));
      }
    });
    view.findViewById(R.id.greate_package_layout).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        EventBus.getDefault()
            .post(new StartBrotherEvent(ShopEnviromentFragment.newInstance(APIConfig.shop_one_id)));
      }
    });
    view.findViewById(R.id.recharge_layout).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        EventBus.getDefault()
            .post(new StartBrotherEvent(DiscountFragment.newInstance(APIConfig.shop_one_id)));
      }
    });

    view.findViewById(R.id.dish_rank_rl).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        EventBus.getDefault()
            .post(new StartBrotherEvent(RankDishesFragment.newInstance(APIConfig.shop_one_id)));
      }
    });
    view.findViewById(R.id.discount_dish_rl).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        EventBus.getDefault()
            .post(new StartBrotherEvent(DiscountDishesFragment.newInstance(APIConfig.shop_one_id)));
      }
    });
    view.findViewById(R.id.recharge_rl).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        EventBus.getDefault()
            .post(new StartBrotherEvent(DiscountFragment.newInstance(APIConfig.shop_one_id)));
      }
    });
    view.findViewById(R.id.dayly_welfare_rl).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        EventBus.getDefault().post(new StartBrotherEvent(NewsListFragment.newInstance()));
      }
    });

    view.findViewById(R.id.more_hot_dish).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        EventBus.getDefault()
            .post(new StartBrotherEvent(HotDishesFragment.newInstance(APIConfig.shop_one_id)));
      }
    });
  }

  private void dishList() {
    mAdapter = new HotDishesAdapter(_mActivity);
    index_list.setHasFixedSize(true);
    index_list.setLayoutManager(
        new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
    index_list.setAdapter(mAdapter);
    Log.e("arilpan", "init index_list hot dishes");
    updateData();

    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(int position, View view, RecyclerView.ViewHolder holder) {
        if (datas != null) {
          String dish_id = datas.get(position).getDishes_id();
          EventBus.getDefault()
              .post(new StartBrotherEvent(DishDetailFragment.newInstance(dish_id)));
        }
      }
    });
  }

  private void updateData() {
  }

  BGABanner index_banner;

  ImageView jpush_set;

  private void initView(final View view) {
    EventBus.getDefault().register(this);

    jpush_set = (ImageView) view.findViewById(R.id.btn_title_right);
    jpush_set.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        if (!JPushInterface.isPushStopped(view.getContext())) {
          JPushInterface.stopPush(getContext());
          Toast.makeText(getContext(), "已停止接收推送", Toast.LENGTH_SHORT).show();
        } else {
          JPushInterface.init(getContext());
          JPushInterface.resumePush(getContext());
          Toast.makeText(getContext(), "已开启接收推送", Toast.LENGTH_SHORT).show();
        }
      }
    });
    index_list = (RecyclerView) view.findViewById(R.id.index_list);
    index_list.setFocusable(false);
    index_banner = (BGABanner) view.findViewById(R.id.index_banner);
    index_banner.setAdapter(new BGABanner.Adapter() {
      @Override
      public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        Log.e("arilpan", "model to string " + model.toString());
        Glide.with(view.getContext())
            .load(APIConfig.BASE_IMG_URL + model.toString())
            .error(R.drawable.index_banner_default)
            .into((ImageView) view);
      }
    });

    dishList();

    addBtn(view);

    //EventBus.getDefault().register(this);

    LinearLayout new_arrival_layout = (LinearLayout) view.findViewById(R.id.new_arrival_layout);
    new_arrival_layout.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //                start(DishesSwitchFragment.newInstance(),
        //                          SupportFragment.SINGLETOP);
        //                EventBus.getDefault().post(new StartBrotherEvent
        //                          (DishesSwitchFragment.newInstance()));
        //                ((MainActivity) getParentFragment()).startBrother
        //                        (new StartBrotherEvent(DishesSwitchFragment.newInstance()));
        EventBus.getDefault()
            .post(new StartBrotherEvent(NewDishesFragment.newInstance(APIConfig.shop_one_id)));
      }
    });

    List<APPALL.ValueBean.DataBean> items = new ArrayList<>();
    mAdapter.setDatas(items);

    EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_ALL));
  }

  @Override protected void initLazyView(@Nullable Bundle savedInstanceState) {
  }

  @Override public void onDestroyView() {
    EventBus.getDefault().unregister(this);
    super.onDestroyView();
  }

  @Override public boolean onBackPressedSupport() {
    // 这里实际项目中推荐使用 EventBus接耦
    //        ((TestOne) getParentFragment()).onBackToFirstFragment();
    Log.e("arilpan", "on back press");
    return false;
    //        return true;
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {

    if (RequestType.INDEX_ALL == event.reqType) {
      Log.e("arilpan", "Indexfragment 填充數據");
      setData(getData(event));
    }
  }

  public List<APPALL.ValueBean.DataBean> getData(NetworkEvent event) {
    ResponseBody body = null;
    try {
      final JsonAdapter<APPALL> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPALL.class));
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(event.url).build();
      Response response = client.newCall(request).execute();
      body = response.body();

      APPALL datas_arry = COM_JSON_ADAPTER.fromJson(body.source());

      datas = datas_arry.getValue().getData();
      for (APPALL.ValueBean.DataBean data : datas) {
        Log.e("arilpan", data.getDiscount_type() +
            ",code :" + data.getDishes_price());
      }
      if (APIConfig.shop_one_id.isEmpty()) {
        APIConfig.shop_one_id = datas_arry.getMessageList().get(0).getOrg_id();
        APIConfig.shop_two_id = datas_arry.getMessageList().get(1).getOrg_id();

        APIConfig.shop_one_name = datas_arry.getMessageList().get(0).getOrg_name();
        APIConfig.shop_two_name = datas_arry.getMessageList().get(1).getOrg_name();

        APIConfig.shop_one_work_time = datas_arry.getMessageList().get(0).getShop_work_time();
        APIConfig.shop_two_work_time = datas_arry.getMessageList().get(1).getShop_work_time();

        APIConfig.shop_one_addr = datas_arry.getMessageList().get(0).getAddress();
        APIConfig.shop_two_addr = datas_arry.getMessageList().get(1).getAddress();

        APIConfig.shop_one_icon = datas_arry.getMessageList().get(0).getIcon();
        APIConfig.shop_two_icon = datas_arry.getMessageList().get(1).getIcon();

        APIConfig.shop_one_phone = datas_arry.getMessageList().get(0).getPhone();
        APIConfig.shop_two_phone = datas_arry.getMessageList().get(1).getPhone();

        APIConfig.user_id = KVHelper.getUserInfo(getContext(), "user_id", "");
      }

      //            Collections.sort(contributors, new Comparator<APIDish>()
      //            {
      //                @Override
      //                public int compare(APIDish c1, APIDish c2)
      //                {
      //                    return c2.getDishes_id() - c1.getDishes_id();
      //                }
      //            });
      return datas;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
    return null;
  }

  List<APPALL.ValueBean.DataBean> datas;

  public void setData(final List<APPALL.ValueBean.DataBean> items) {
    try {
      _mActivity.runOnUiThread(new Runnable() {
        @Override public void run() {
          mAdapter.setDatas(items);
          //stuff that updates ui
          List<String> imgs = new ArrayList<String>();
          imgs.add(APIConfig.shop_one_icon);
          imgs.add(APIConfig.shop_two_icon);
          index_banner.setData(imgs, null);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private RecyclerView index_list;
  private HotDishesAdapter mAdapter;
}
