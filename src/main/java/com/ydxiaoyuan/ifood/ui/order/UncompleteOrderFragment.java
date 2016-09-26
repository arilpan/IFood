package com.ydxiaoyuan.ifood.ui.order;

import android.content.Context;
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

import com.avast.android.dialogs.fragment.SimpleDialogFragment;
import com.avast.android.dialogs.iface.ISimpleDialogListener;
import com.bumptech.glide.Glide;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPOrder;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.helper.KVHelper;
import com.ydxiaoyuan.ifood.helper.UrlHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 未完成订单
 * 最大支持99個不同菜品數量訂單
 * Created by aril_pan@qq.com on 16/8.
 */
public class UncompleteOrderFragment extends BaseFragment implements ISimpleDialogListener {
  int REQUEST_SIMPLE_DIALOG = 42;
  String order_id = "90f67d5b-b3f5-46f9-92a1-80f90751acd";
  Context c = getContext();

  @Override public void onPositiveButtonClicked(int requestCode) {

    if (requestCode == REQUEST_SIMPLE_DIALOG) {
      Log.e("arilpan", "UncompleteOrderFragment Positive button clicked");
      //            Toast.makeText(getContext(), "Positive button clicked", Toast.LENGTH_SHORT).show();
      EventBus.getDefault().post(new NetworkEvent(RequestType.ORDER_CANCEL, order_id));
    } else {
      Log.e("arilpan", "UncompleteOrderFragment Positive button clicked");
    }
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    c = context;
  }

  @Override public void onNegativeButtonClicked(int requestCode) {
    String tag = getTag();
    if (requestCode == REQUEST_SIMPLE_DIALOG) {
      Log.e("arilpan", "UncompleteOrderFragment Negative button clicked");
      //            Toast.makeText(c, "Negative button clicked", Toast.LENGTH_SHORT).show();
    } else {
      Log.e("arilpan", "UncompleteOrderFragment Negative button clicked");
    }
  }

  @Override public void onNeutralButtonClicked(int requestCode) {
    if (requestCode == REQUEST_SIMPLE_DIALOG) {
      Log.e("arilpan", "UncompleteOrderFragment Neutral button clicked");
      //            Toast.makeText(c, "Neutral button clicked", Toast.LENGTH_SHORT).show();
    } else {
      Log.e("arilpan", "UncompleteOrderFragment Neutral button clicked");
    }
  }

  public UncompleteOrderFragment() {
  }

  public static UncompleteOrderFragment newInstance() {
    Bundle args = new Bundle();
    UncompleteOrderFragment fragment = new UncompleteOrderFragment();
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
    setTitle(view, "未完成订单");
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
        .post(new NetworkEvent(RequestType.ORDER_LIST, String.valueOf(APIConfig.ORDER_UNCOMPLETE)));
  }

  @Override public boolean onBackPressedSupport() {
    // 这里实际项目中推荐使用 EventBus接耦
    //        ((TestOne) getParentFragment()).onBackToFirstFragment();
    Log.e("arilpan", "on back press");
    return false;
    //        return true;
  }

  /** ************************************************************************ */
  class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    List<APPOrder.ValueBean.OrderDishesListBean> itemDishes;

    @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext())
          .inflate(R.layout.fragment_order_uncomplete_order_item, parent, false));
      /**************************設置高度信息****1  2  2* =>都是5个单位，为何*************************************/

      ViewGroup.LayoutParams layoutParams = holder.order_item_recyview.getLayoutParams();
      layoutParams.height = 35;
      if (viewType > 0) {
        layoutParams.height = 35 + viewType * 230;
        Log.e("arilpan", " dishes size: " + viewType + ",height:" + layoutParams.height);
      }
      holder.order_item_recyview.setLayoutManager(
          new LinearLayoutManager(_mActivity.getApplicationContext(), LinearLayoutManager.VERTICAL,
              true));
      holder.order_item_recyview.setLayoutParams(layoutParams);
      //            holder.order_item_recyview.setLayoutManager(
      //                    new LinearLayoutManager(_mActivity.getApplicationContext()));
      /****************************************************************************/
      return holder;
    }

    private static final int REQUEST_SIMPLE_DIALOG = 42;
    Context c = getContext();
    //        getContext();

    public void cancelOrder(int pos) {
      Log.e("arilpan", "電價了位置+" + pos);
      order_id = datas.get(pos).getOrder_id();
      SimpleDialogFragment.createBuilder(getContext(), getFragmentManager())
          .setTitle(" 是否取消订单?")
          .setTargetFragment(UncompleteOrderFragment.this, REQUEST_SIMPLE_DIALOG)
          .setMessage("提示: 点击右侧\"取消\"取消订单.")
          .setPositiveButtonText("取消").setNegativeButtonText("不取消")
          //                    .setTag(String.valueOf(pos))
          .setNeutralButtonText("再想想?")
              //                    .setRequestCode(REQUEST_SIMPLE_DIALOG)
          .show();
    }

    @Override public void onBindViewHolder(MyViewHolder holder, int position) {
      //          holder.tv.setText(mDatas.get(position));
      holder.order_item_recyview.setMinimumHeight(35);
      APPOrder.ValueBean order = datas.get(position);

      holder.order_item_mall_name.setText(order.getShop_name());
      holder.order_item_order_time.setText(order.getHave_meals_time());
      holder.order_item_total_price.setText("￥" + order.getSum_price());

      final int pos = position;
      holder.order_item_cancel_button.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          cancelOrder(pos);
        }
      });

      holder.order_item_recyview.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
              MyItemViewHolder itemholder =
                  new MyItemViewHolder(LayoutInflater.from(parent.getContext()).
                      inflate(R.layout.fragment_order_cancel_list_item, parent, false));
              return itemholder;
            }

            @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
              MyItemViewHolder newholder = (MyItemViewHolder) holder;

              Log.e("arilpan", "该item data的大小" + itemDishes.size());
              if (position < itemDishes.size()) {
                APPOrder.ValueBean.OrderDishesListBean dish = itemDishes.get(position);
                newholder.dish_name.setText(dish.getDishes_name());
                newholder.dish_price.setText("￥" + dish.getDishes_price());
                newholder.dish_desc.setText(dish.getDishes_description());
                Glide.with(UncompleteOrderFragment.this)
                    .load(APIConfig.BASE_IMG_URL + dish.getUpload_url())
                    .placeholder(R.drawable.preferential_list_item_zanwutupian)
                    .into(newholder.dish_icon);
              } else {
                Log.e("arilpan", " will throw java.lang.IndexOutOfBoundsException");
              }

              Log.e("arilpan", "item onBindViewHolder position: " + position + " ," +
                  "size : " + itemDishes.size());
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

              public MyItemViewHolder(View view) {
                super(view);
                view.setMinimumHeight(35);

                dish_icon = (ImageView) view.findViewById(R.id.dish_icon);
                dish_name = (TextView) view.findViewById(R.id.dish_name);
                dish_price = (TextView) view.findViewById(R.id.dish_price);
                dish_desc = (TextView) view.findViewById(R.id.dish_desc);
              }
            }
          }

      );
    }

    @Override public int getItemViewType(int position) {
      APPOrder.ValueBean order = datas.get(position);

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
      Button order_item_cancel_button;

      public MyViewHolder(View view) {
        super(view);
        view.setMinimumHeight(35);
        order_item_recyview = (RecyclerView) view.findViewById(R.id.order_item_recyview);
        order_item_total_price = (TextView) view.findViewById(R.id.order_item_total_price);
        order_item_order_time = (TextView) view.findViewById(R.id.order_item_order_time);
        order_item_mall_name = (TextView) view.findViewById(R.id.order_item_mall_name);

        order_item_cancel_button = (Button) view.findViewById(R.id.order_item_cancle_button);
      }
    }
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {
    if (APIConfig.order_list_url.equals(event.url) && (String.valueOf(APIConfig.ORDER_UNCOMPLETE)
        .equals(event.id))) {
      Log.e("arilpan", "order equals?");
      setData(getData(event.url + event.id));
    } else if (APIConfig.order_cancel_url.equals(event.url)) {
      String res = getCancelOrderResult(event.url + event.id);
      try {
        JSONObject jsonObject = new JSONObject(res);
        boolean isSuccess = jsonObject.getBoolean("success");
        if (isSuccess) {
          _mActivity.runOnUiThread(new Runnable() {
            @Override public void run() {
              Toast.makeText(getContext(), "取消订单成功", Toast.LENGTH_SHORT).show();
              EventBus.getDefault()
                  .post(new NetworkEvent(RequestType.ORDER_LIST,
                      String.valueOf(APIConfig.ORDER_UNCOMPLETE)));
            }
          });

          return;
        }
      } catch (JSONException e) {
        e.printStackTrace();
      }
      _mActivity.runOnUiThread(new Runnable() {
        @Override public void run() {
          Toast.makeText(getContext(), "取消订单失败", Toast.LENGTH_SHORT).show();
          EventBus.getDefault()
              .post(new NetworkEvent(RequestType.ORDER_LIST,
                  String.valueOf(APIConfig.ORDER_UNCOMPLETE)));
        }
      });
    } else {
      Log.e("arilpan", "HotDishFragment what happend?");
    }
  }

  public String getCancelOrderResult(String url) {
    url = UrlHelper.addToken(getContext(), url);
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder().url(UrlHelper.addToken(getContext(), url)).build();
    Response response = null;
    try {
      response = client.newCall(request).execute();
      String result = response.body().string();
      Log.e("arilpan", url + "取消订单结果" + result);
      return result;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
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
        Log.e("arilpan", " --" + data.getOrder_id() + data.getShop_name() + data.getSum_price());
      }
      return datas;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
    return null;
  }

  List<APPOrder.ValueBean> datas;
}
