package com.ydxiaoyuan.ifood.ui.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.adapter.CommentsAdapter;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.APIConfigFactory;
import com.ydxiaoyuan.ifood.api.message.APPComments;
import com.ydxiaoyuan.ifood.api.message.APPDishDetail;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.helper.KVHelper;
import com.ydxiaoyuan.ifood.helper.UrlHelper;
import com.ydxiaoyuan.ifood.ui.place.SelectPlaceFragment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * 接受菜品id,并且可以进入预约页面
 * Created by aril_pan@qq.com on 16/8.
 */
public class DishDetailFragment extends BaseFragment {
  public String dish_id;

  public DishDetailFragment() {
  }

  //    public static DishDetailFragment newInstance(int number)
  //    {
  //        DishDetailFragment fragment = new DishDetailFragment();
  //        Bundle args = new Bundle();
  //        args.putString("dish_id", number + "");
  //        fragment.setArguments(args);
  //        return fragment;
  //    }

  public static DishDetailFragment newInstance(String dish_id) {
    Bundle args = new Bundle();
    args.putString("dish_id", dish_id);
    DishDetailFragment fragment = new DishDetailFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onDestroy() {
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    if (args != null) {
      dish_id = args.getString("dish_id");
    }
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_dish_detail, container, false);
    initView(view);
    return view;
  }

  public void gotoSubscribe() {
    //todo:直接跳转到shopFragment,并且将dish_id对应的dish放入列表中
    EventBus.getDefault().post(
        //                new StartBrotherEvent(SelectPlaceFragment.newInstance(dish_id)));
        new StartBrotherEvent(SelectPlaceFragment.newInstance()));
  }

  RecyclerView comments;
  TextView dish_name;
  TextView dish_price;
  TextView dish_old_price;
  TextView dish_desc;
  TextView dish_pre_order_must_know;
  TextView dish_mall_name;
  TextView dish_mall_addr;
  TextView dish_mall_work_time;

  ImageView dish_img;
  CommentsAdapter commentsAdapter;

  private void initView(View view) {

    setTitle(view, "菜品详情");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });
    EventBus.getDefault().register(this);

    dish_img = (ImageView) view.findViewById(R.id.dish_img);
    dish_name = (TextView) view.findViewById(R.id.dish_name);
    dish_price = (TextView) view.findViewById(R.id.dish_price);
    dish_old_price = (TextView) view.findViewById(R.id.dish_old_price);
    dish_desc = (TextView) view.findViewById(R.id.dish_desc);
    dish_pre_order_must_know = (TextView) view.findViewById(R.id.dish_pre_order_must_know);
    dish_mall_name = (TextView) view.findViewById(R.id.dish_mall_name);
    dish_mall_addr = (TextView) view.findViewById(R.id.dish_mall_addr);
    dish_mall_work_time = (TextView) view.findViewById(R.id.dish_mall_work_time);

    comments = (RecyclerView) view.findViewById(R.id.comments);
    comments.setLayoutManager(
        new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
    commentsAdapter = new CommentsAdapter(getContext());
    comments.setAdapter(commentsAdapter);

    Button btn_subscribe = (Button) view.findViewById(R.id.btn_subscribe);

    btn_subscribe.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        gotoSubscribe();
      }
    });
    EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_DETAIL, dish_id));
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {
    Log.e("arilpan", "DishDetail 你调用咩?");
    if (RequestType.INDEX_DISH_DETAIL == event.reqType) {
      Log.e("arilpan", "DishDetail equals url=" + event.url + event.id);
      setData(getData(event.url + event.id), getComments());
    } else {
      Log.e("arilpan", "DishDetail what happend?");
    }
  }

  public List<APPComments.ValueBean> getComments() {
    List<APPComments.ValueBean> result = null;
    ResponseBody body = null;
    try {
      String url = APIConfigFactory.createURL(RequestType.ORDER_LIST_COMMENT);
      String user_id = KVHelper.getUserInfo(getContext(), "username", "");
      url = url.replace("USERID", user_id);
      url = url.replace("DISHID", dish_id);
      url = UrlHelper.addToken(getContext(), url);
      final JsonAdapter<APPComments> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPComments.class));
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(url).build();
      Response response = client.newCall(request).execute();
      body = response.body();

      APPComments datas_arry = COM_JSON_ADAPTER.fromJson(body.source());
      result = datas_arry.getValue();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
    Log.e("arilpan", "result not null ,but return null?");
    if (result != null) {
      Log.e("arilpan", "result not null ");
      return result;
    }
    Log.e("arilpan", "result   null ");
    return null;
  }

  public APPDishDetail getData(String url) {
    try {
      //            Type type = Types.newParameterizedType(MockParameterized.class,
      //                    Object.class);
      //            JsonAdapter<MockParameterized<?>> jsonAdapter =
      // moshi.adapter(type);

      final JsonAdapter<APPDishDetail> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPDishDetail.class));
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(url).build();
      Response response = client.newCall(request).execute();
      ResponseBody body = response.body();

      APPDishDetail datas_arry = COM_JSON_ADAPTER.fromJson(body.source());
      body.close();
      //            APPDishDetail.ValueBean datas
      //                    = datas_arry.getValue();
      return datas_arry;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void setData(final APPDishDetail items, final List<APPComments.ValueBean> comments) {
    try {
      _mActivity.runOnUiThread(new Runnable() {
        @Override public void run() {
          if (items != null) {
            if (comments != null) {
              commentsAdapter.setDatas(comments);
            }

            APPDishDetail.ValueBean item = items.getValue();
            APPDishDetail.Value1Bean shop = items.getValue1();
            dish_name.setText(item.getDishes_name());
            dish_price.setText("￥" + item.getDishes_price());
            dish_old_price.setText("￥" + item.getRack_rate());
            dish_desc.setText(item.getDishes_description());
            dish_pre_order_must_know.setText(item.getAppointment_notice());
            dish_mall_name.setText(item.getStore_name());
            dish_mall_addr.setText(shop.getAddress());
            dish_mall_work_time.setText(shop.getShop_work_time());
            Glide.with(DishDetailFragment.this) //
                .load(APIConfig.BASE_IMG_URL + item.getUpload_url()) //
                .error(R.drawable.preferential_list_item_zanwutupian).
                into(dish_img);

            //dish_img
            //stuff that updates ui
          }
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
}
