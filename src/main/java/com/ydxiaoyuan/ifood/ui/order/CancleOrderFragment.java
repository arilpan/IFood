package com.ydxiaoyuan.ifood.ui.order;

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
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.avast.android.dialogs.fragment.SimpleDialogFragment;
import com.avast.android.dialogs.iface.ISimpleDialogListener;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * don't delete notes
 * 取消订单
 * Created by aril_pan@qq.com on 16/8.
 */
public class CancleOrderFragment extends BaseFragment implements ISimpleDialogListener {
  int REQUEST_SIMPLE_DIALOG = 42;

  @Override public void onPositiveButtonClicked(int requestCode) {

    if (requestCode == REQUEST_SIMPLE_DIALOG) {
      Log.e("arilpan", "CancleOrderFragment Positive button clicked");
      EventBus.getDefault().post(new NetworkEvent(RequestType.ORDER_DELETE, order_id));
    } else {
      Log.e("arilpan", "CancleOrderFragment Positive button clicked");
    }
  }

  @Override public void onNegativeButtonClicked(int requestCode) {
    String tag = getTag();
    if (requestCode == REQUEST_SIMPLE_DIALOG) {
      Log.e("arilpan", "CancleOrderFragment Negative button clicked");
    } else {
      Log.e("arilpan", "CancleOrderFragment Negative button clicked");
    }
  }

  @Override public void onNeutralButtonClicked(int requestCode) {
    if (requestCode == REQUEST_SIMPLE_DIALOG) {
      Log.e("arilpan", "CancleOrderFragment Neutral button clicked");
    } else {
      Log.e("arilpan", "CancleOrderFragment Neutral button clicked");
    }
  }

  public CancleOrderFragment() {
  }

  public static CancleOrderFragment newInstance() {
    Bundle args = new Bundle();
    CancleOrderFragment fragment = new CancleOrderFragment();
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
    setTitle(view, "已取消订单");
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
        .post(new NetworkEvent(RequestType.ORDER_LIST, String.valueOf(APIConfig.ORDER_CANCLE)));

    //        basicParamInit();
    //        initData();
    //        initRecyclerView();
  }

  @Override public boolean onBackPressedSupport() {
    // 这里实际项目中推荐使用 EventBus接耦
    //        ((TestOne) getParentFragment()).onBackToFirstFragment();
    Log.e("arilpan", "on back press");
    return false;
    //        return true;
  }

  String order_id;

  /** ************************************************************************ */
  class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    List<APPOrder.ValueBean.OrderDishesListBean> itemDishes;

    public void deleteOrder(int pos) {
      order_id = datas.get(pos).getOrder_id();
      SimpleDialogFragment.createBuilder(getContext(), getFragmentManager())
          .setTitle(" 是否删除订单?")
          .setTargetFragment(CancleOrderFragment.this, REQUEST_SIMPLE_DIALOG)
          .setMessage("提示: 点击右侧\"删除\"删除订单.")
          .setPositiveButtonText("删除").setNegativeButtonText("不删除")
          //                    .setTag(String.valueOf(pos))
          .setNeutralButtonText("再想想?")
              //                    .setRequestCode(REQUEST_SIMPLE_DIALOG)
          .show();
    }

    @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext())
          .inflate(R.layout.fragment_order_cancel_order_item, parent, false));
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

    @Override public void onBindViewHolder(MyViewHolder holder, int position) {
      //          holder.tv.setText(mDatas.get(position));
      holder.order_item_recyview.setMinimumHeight(35);

      APPOrder.ValueBean order = datas.get(position);
      holder.order_item_mall_name.setText(order.getShop_name());
      holder.order_item_order_time.setText(order.getHave_meals_time());
      holder.order_item_total_price.setText("￥" + order.getSum_price());

      final int pos = position;
      holder.order_item_delete_button.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          deleteOrder(pos);
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
                newholder.dish_num.setText(dish.getDishes_count() + "份");
                Glide.with(CancleOrderFragment.this)
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
              TextView dish_num;

              public MyItemViewHolder(View view) {
                super(view);
                view.setMinimumHeight(35);

                //                                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                //                                layoutParams.height = 35;
                //                                if (itemDishes != null)
                //                                {
                //                                    int size = itemDishes.size();
                //                                    Log.e("arilpan", " dishes size: " + size);
                //                                    if (size > 0)
                //                                    {
                //                                        layoutParams.height = 35 + size * 100;
                //                                    }
                //                                }
                //                                view.setLayoutParams(layoutParams);

                dish_icon = (ImageView) view.findViewById(R.id.dish_icon);
                dish_name = (TextView) view.findViewById(R.id.dish_name);
                dish_price = (TextView) view.findViewById(R.id.dish_price);
                dish_desc = (TextView) view.findViewById(R.id.dish_desc);
                dish_num = (TextView) view.findViewById(R.id.dish_num);
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
      Button order_item_delete_button;

      public MyViewHolder(View view) {
        super(view);
        view.setMinimumHeight(35);
        order_item_recyview = (RecyclerView) view.findViewById(R.id.order_item_recyview);
        order_item_total_price = (TextView) view.findViewById(R.id.order_item_total_price);
        order_item_order_time = (TextView) view.findViewById(R.id.order_item_order_time);
        order_item_mall_name = (TextView) view.findViewById(R.id.order_item_mall_name);
        order_item_delete_button = (Button) view.findViewById(R.id.order_item_delete_button);
      }
    }
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {
    if (APIConfig.order_list_url.equals(event.url) && (String.valueOf(APIConfig.ORDER_CANCLE)
        .equals(event.id))) {
      Log.e("arilpan", "order equals?");
      setData(getData(event.url + event.id));
    } else if (APIConfig.order_delete.equals(event.url)) {
      deleteData(event.url + event.id);
      Log.e("arilpan", "HotDishFragment what happend?");
    }
  }

  public void deleteData(String url) {
    ResponseBody body = null;
    try {
      String realUrl = UrlHelper.addToken(getContext(), url);
      Log.e("arilpan", "删除订单link:" + realUrl);
      OkHttpClient client = new OkHttpClient();

      FormBody fromBody = new FormBody.Builder().add("order_id", order_id).build();
      Request request = new Request.Builder().url(realUrl).post(fromBody).build();
      Response response = client.newCall(request).execute();
      body = response.body();
      String result = body.string();
      JSONObject jsonObject = new JSONObject(result);
      String msg = jsonObject.getString("message");
      if ("true".equals(msg)) {
        _mActivity.runOnUiThread(new Runnable() {
          @Override public void run() {
            Toast.makeText(getContext(), "删除成功 刷新数据", Toast.LENGTH_SHORT);
          }
        });
      } else {
        _mActivity.runOnUiThread(new Runnable() {
          @Override public void run() {
            Toast.makeText(getContext(), "删除失败 刷新数据", Toast.LENGTH_SHORT);
          }
        });
        Log.e("arilpan", " 刷新数据");
        EventBus.getDefault()
            .post(new NetworkEvent(RequestType.ORDER_LIST, String.valueOf(APIConfig.ORDER_CANCLE)));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
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
    ResponseBody body = null;
    //        String realUrl = url.replace("USERID", APIConfig.user_id);
    String userPhone = KVHelper.getUserInfo(getContext(), "username", "");
    String realUrl = url.replace("USERID", userPhone);

    try {
      realUrl = UrlHelper.addToken(getContext(), realUrl);
      Log.e("arilpan", "完成订单link:" + realUrl);

      realUrl = UrlHelper.addToken(getContext(), realUrl);
      final JsonAdapter<APPOrder> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPOrder.class));
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(realUrl).build();
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
    } finally {

      body.close();
    }
    return null;
  }

  List<APPOrder.ValueBean> datas;
}
