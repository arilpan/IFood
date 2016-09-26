package com.ydxiaoyuan.ifood.ui.index;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPShopEnviroment;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by aril_pan@qq.com on 16-8-30.
 */
public class ShopEnviromentFragment extends BaseFragment {
  public String shop_id;
  BGABanner index_child_banner;

  public ShopEnviromentFragment() {
  }

  //    public static DishDetailFragment newInstance(int number)
  //    {
  //        DishDetailFragment fragment = new DishDetailFragment();
  //        Bundle args = new Bundle();
  //        args.putString("shop_id", number + "");
  //        fragment.setArguments(args);
  //        return fragment;
  //    }

  public static ShopEnviromentFragment newInstance(String shop_id) {
    Bundle args = new Bundle();
    args.putString("shop_id", shop_id);
    Log.e("arilpan", "get shop_id" + shop_id);
    ShopEnviromentFragment fragment = new ShopEnviromentFragment();
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
      shop_id = args.getString("shop_id");
    }
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_index_enviroment, container, false);
    initView(view);
    return view;
  }

  TextView tab1;
  TextView tab2;

  public void setTabColor(boolean isTab1Select) {
    if (isTab1Select) {
      tab1.setTextColor(Color.rgb(172, 66, 66));
      tab2.setTextColor(Color.rgb(66, 66, 66));
    } else {
      tab2.setTextColor(Color.rgb(172, 66, 66));
      tab1.setTextColor(Color.rgb(66, 66, 66));
    }
  }

  private void initView(View view) {
    EventBus.getDefault().register(this);
    ((TextView) view.findViewById(R.id.title_middle)).setText("门店环境");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });

    index_child_banner = (BGABanner) view.findViewById(R.id.index_child_banner);
    tab1 = (TextView) view.findViewById(R.id.tab1);
    tab2 = (TextView) view.findViewById(R.id.tab2);
    tab1.setText(APIConfig.shop_one_name);
    tab2.setText(APIConfig.shop_two_name);

    setTabColor(true);
    index_child_banner.setAdapter(new BGABanner.Adapter() {
      @Override
      public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        Log.e("arilpan", "model to string " + model.toString());
        Log.e("arilpan", "model ( string) " + (String) model);

        Glide.with(view.getContext())
            .load(APIConfig.BASE_IMG_URL + model.toString())
            .error(R.drawable.preferential_list_item_zanwutupian)
            .into((ImageView) view);
        //                                Glide.with(banner.getContext()).
        //                                        load(model).placeholder
        //                                        (R.drawable.holder).
        //                                        error(R.drawable.holder).
        //                                        dontAnimate().thumbnail(0.1f).
        //                                        into((ImageView) view);
      }
    });

    tab1.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        EventBus.getDefault()
            .post(new NetworkEvent(RequestType.INDEX_SHOP_ENV, APIConfig.shop_one_id));
        setTabColor(true);
      }
    });
    tab2.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        EventBus.getDefault()
            .post(new NetworkEvent(RequestType.INDEX_SHOP_ENV, APIConfig.shop_two_id));
        setTabColor(false);
      }
    });
    EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_SHOP_ENV, shop_id));
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {
    Log.e("arilpan", "DishDetail 你调用咩?");
    if (RequestType.INDEX_SHOP_ENV == event.reqType) {
      Log.e("arilpan", "DishDetail equals url=" + event.url + event.id);
      getData(event.url + event.id);
      setData();
    } else {
      Log.e("arilpan", "DishDetail what happend?");
    }
  }

  public void getData(String url) {
    ResponseBody body = null;
    imgs = new ArrayList<String>();
    tips = new ArrayList<String>();
    try {
      //            Type type = Types.newParameterizedType(MockParameterized.class,
      //                    Object.class);
      //            JsonAdapter<MockParameterized<?>> jsonAdapter =
      // moshi.adapter(type);

      final JsonAdapter<APPShopEnviroment> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPShopEnviroment.class));
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(url).build();
      Response response = client.newCall(request).execute();
      body = response.body();

      APPShopEnviroment datas = COM_JSON_ADAPTER.fromJson(body.source());
      List<APPShopEnviroment.ValueBean> values = datas.getValue();
      for (APPShopEnviroment.ValueBean vb : values) {
        String imgname = vb.getPicture_name();
        String imgurl = vb.getUpload_url();
        imgs.add(imgurl);
        tips.add(imgname);
      }
      //                    =>取得图像和名称
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
  }

  public void setData() {
    try {
      _mActivity.runOnUiThread(new Runnable() {
        @Override public void run() {
          //stuff that updates ui
          if (imgs != null & imgs.size() > 0) {
            for (String s : tips) {
              Log.e("arilpan", "名iz:" + s);
            }
            index_child_banner.setData(imgs, tips);
          }
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  List<String> imgs;
  List<String> tips;

  @Override public boolean onBackPressedSupport() {
    Log.e("arilpan", "on back press");
    return false;
  }
}
