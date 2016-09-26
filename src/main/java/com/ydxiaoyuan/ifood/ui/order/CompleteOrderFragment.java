package com.ydxiaoyuan.ifood.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fan.eightrestaurant.ui.LoginActivity;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPOrder;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.helper.KVHelper;
import com.ydxiaoyuan.ifood.helper.UrlHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 已完成订单
 * Created by aril_pan@qq.com on 16/8.
 */
public class CompleteOrderFragment extends BaseFragment {

  public CompleteOrderFragment() {
  }

  public static CompleteOrderFragment newInstance() {
    Bundle args = new Bundle();
    CompleteOrderFragment fragment = new CompleteOrderFragment();

    fragment.setArguments(args);

    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_order_cancel, container, false);
    initView(view);
    return view;
  }

  RecyclerView order_recyview;
  private HomeAdapter mAdapter;

  private void initView(View view) {
    setTitle(view, "已完成订单");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });

    EventBus.getDefault().register(this);
    datas = new ArrayList<>();
    order_recyview = (RecyclerView) view.findViewById(R.id.order_recyview);
    order_recyview.setLayoutManager(
        new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));

    order_recyview.setAdapter(mAdapter = new HomeAdapter());
    EventBus.getDefault()
        .post(new NetworkEvent(RequestType.ORDER_LIST, String.valueOf(APIConfig.ORDER_COMPLETE)));
  }

  @Override public boolean onBackPressedSupport() {
    Log.e("arilpan", "on back press");
    return false;
  }

  /** ************************************************************************ */
  class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    List<APPOrder.ValueBean.OrderDishesListBean> itemDishes;

    @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext())
          .inflate(R.layout.fragment_order_complete_order_item, parent, false));
      /****************************************************************************/
      ViewGroup.LayoutParams layoutParams = holder.order_item_recyview.getLayoutParams();
      layoutParams.height = 35;
      if (viewType > 0) {
        layoutParams.height = 35 + viewType * 230;
        Log.e("arilpan", " dishes size: " + viewType + ",height:" +
            layoutParams.height);
      }
      holder.order_item_recyview.setLayoutManager(
          new LinearLayoutManager(_mActivity.getApplicationContext(), LinearLayoutManager.VERTICAL,
              true));
      holder.order_item_recyview.setLayoutParams(layoutParams);
      /****************************************************************************/
      return holder;
    }

    @Override public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.order_item_recyview.setMinimumHeight(35);
      APPOrder.ValueBean order = datas.get(position);

      holder.order_item_mall_name.setText(order.getShop_name());
      holder.order_item_order_time.setText(order.getHave_meals_time());
      holder.order_item_total_price.setText("￥" + order.getSum_price());

      final String order_id = order.getOrder_id();
      holder.order_item_recyview.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
              MyItemViewHolder itemholder =
                  new MyItemViewHolder(LayoutInflater.from(parent.getContext()).
                      inflate(R.layout.fragment_order_complete_list_item, parent, false));
              return itemholder;
            }

            @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
              MyItemViewHolder newholder = (MyItemViewHolder) holder;

              String name = null;
              Log.e("arilpan", "该item data的大小" + itemDishes.size());
              if (position < itemDishes.size()) {
                final String child_order_id = order_id;

                final APPOrder.ValueBean.OrderDishesListBean dish = itemDishes.get(position);
                name = dish.getDishes_name();
                newholder.dish_name.setText(dish.getDishes_name());
                newholder.dish_price.setText("￥" + dish.getDishes_price());
                newholder.dish_desc.setText(dish.getDishes_description());
                newholder.dish_num.setText(dish.getDishes_count() + "份");

                Glide.with(CompleteOrderFragment.this)
                    .load(APIConfig.BASE_IMG_URL + dish.getUpload_url())
                    .placeholder(R.drawable.preferential_list_item_zanwutupian)
                    .into(newholder.dish_icon);

                //                                final int pos = position;
                final String dish_name = name;
                newholder.dish_comment.setOnClickListener(new View.OnClickListener() {
                  @Override public void onClick(View view) {
                    goToComment(child_order_id, dish_name, dish);
                  }
                });
              } else {
                Log.e("arilpan", " will throw java.lang.IndexOutOfBoundsException");
              }
              Log.e("arilpan", "item onBindViewHolder position: " + position + " ," +
                  "size : " + itemDishes.size());
            }

            public void goToComment(String order_id, final String name,
                APPOrder.ValueBean.OrderDishesListBean dish) {
              String dish_name;
              String dish_icon;
              String dish_desc;
              //跳轉到評價頁面
              Log.e("arilpan", "電價了評價位置 name :" + name);
              EventBus.getDefault()
                  .post(new StartBrotherEvent(
                          CommentFragment.newInstance(order_id, dish.getDishes_id(), name,
                              dish.getUpload_url(), dish.getDishes_description())));
            }

            @Override public int getItemViewType(int position) {
              return 100;
            }

            @Override public int getItemCount() {
              return itemDishes.size();
            }

            class MyItemViewHolder extends RecyclerView.ViewHolder {
              ImageView dish_icon;
              TextView dish_name;
              TextView dish_price;
              TextView dish_desc;
              TextView dish_num;

              Button dish_comment;

              public MyItemViewHolder(View view) {
                super(view);
                view.setMinimumHeight(35);
                dish_icon = (ImageView) view.findViewById(R.id.dish_icon);
                dish_name = (TextView) view.findViewById(R.id.dish_name);
                dish_price = (TextView) view.findViewById(R.id.dish_price);
                dish_desc = (TextView) view.findViewById(R.id.dish_desc);

                dish_num = (TextView) view.findViewById(R.id.dish_num);

                dish_comment = (Button) view.findViewById(R.id.dish_comment);
              }
            }
          });
    }

    @Override public int getItemViewType(int position) {
      APPOrder.ValueBean order = datas.get(position);
      //            Order order = mDatas.get(position);
      if (order != null) {
        itemDishes = new ArrayList<>();
        itemDishes = order.getOrderDishesList();
        if (itemDishes != null) {
          return itemDishes.size();
        }
      }
      return 0;
    }

    @Override public int getItemCount() {
      return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
      RecyclerView order_item_recyview;
      TextView order_item_total_price;
      TextView order_item_order_time;
      TextView order_item_mall_name;

      public MyViewHolder(View view) {
        super(view);
        view.setMinimumHeight(35);
        order_item_recyview = (RecyclerView) view.findViewById(R.id.order_item_recyview);
        order_item_total_price = (TextView) view.findViewById(R.id.order_item_total_price);
        order_item_order_time = (TextView) view.findViewById(R.id.order_item_order_time);
        order_item_mall_name = (TextView) view.findViewById(R.id.order_item_mall_name);
      }
    }
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {
    if (APIConfig.order_list_url.equals(event.url) && (String.valueOf(APIConfig.ORDER_COMPLETE)
        .equals(event.id))) {
      Log.e("arilpan", "order equals?");
      setData(getData(event.url + event.id));
    } else {
      Log.e("arilpan", "HotDishFragment what happend?");
    }
  }

  public void setData(List<APPOrder.ValueBean> datas) {
    _mActivity.runOnUiThread(new Runnable() {
      @Override public void run() {
        order_recyview.setAdapter(mAdapter = new HomeAdapter());
        //stuff that updates ui
      }
    });
  }

  public List<APPOrder.ValueBean> getData(String url) {
    //        String realUrl = url.replace("USERID", APIConfig.user_id);
    String userPhone = KVHelper.getUserInfo(getContext(), "username", "");
    String realUrl = url.replace("USERID", userPhone);

    realUrl = UrlHelper.addToken(getContext(), realUrl);
    Log.e("arilpan", "完成订单link:" + realUrl);
    ResponseBody body = null;

    try {
      final JsonAdapter<APPOrder> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPOrder.class));
      OkHttpClient client = new OkHttpClient();
      Request request =
          new Request.Builder().url((UrlHelper.addToken(getContext(), realUrl))).build();
      Response response = client.newCall(request).execute();
      body = response.body();

      APPOrder datas_arry = COM_JSON_ADAPTER.fromJson(body.source());
      datas = datas_arry.getValue();
      for (APPOrder.ValueBean data : datas) {
        Log.e("arilpan", " --" + data.getShop_name() + data.getSum_price());
      }
      return datas;
    } catch (Exception e) {
      e.printStackTrace();
      Log.e("arilpan", "login error");
      Toast.makeText(getContext(), "登录异常", Toast.LENGTH_SHORT).show();
      Intent intent = new Intent(getActivity(), LoginActivity.class);
      startActivity(intent);
      _mActivity.finish();
    } finally {
      body.close();
    }
    return null;
  }

  List<APPOrder.ValueBean> datas;
}
