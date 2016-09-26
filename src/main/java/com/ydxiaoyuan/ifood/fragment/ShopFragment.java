package com.ydxiaoyuan.ifood.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfigFactory;
import com.ydxiaoyuan.ifood.api.message.APPSelectLeft;
import com.ydxiaoyuan.ifood.api.message.APPSelectRight;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.event.ShopEvent;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.ui.menu.DishList;
import com.ydxiaoyuan.ifood.ui.menu.DishListFragment;
import com.ydxiaoyuan.ifood.ui.menu.MenuListFragment;
import com.ydxiaoyuan.ifood.ui.menu.SelectFragment;
import com.ydxiaoyuan.ifood.ui.place.SelectPlaceDetailFragment;
import me.yokeyword.fragmentation.SupportFragment;
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
 * Created by YoKeyword on 16/2/4.
 * Modifed by arilpan on 16/8.
 */

public class ShopFragment extends BaseFragment {
  public static final String TAG = ShopFragment.class.getSimpleName();
  FrameLayout fl_child_list_content_container;
  public static String shop_id;
  private Button order_now_btn;
  public static TextView total_price;
  FragmentManager fManager;
  FragmentTransaction transaction;

  public static ShopFragment newInstance(String shop_id) {
    Bundle args = new Bundle();
    args.putString("shop_id", shop_id);
    ShopFragment fragment = new ShopFragment();
    fragment.setArguments(args);

    return fragment;
  }

  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    if (args != null) {
      shop_id = args.getString("shop_id");
    }
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_shop, container, false);
    enqueueAction(new Runnable() {
      @Override public void run() {

      }
    });

    initView(view, savedInstanceState);
    return view;
  }


  public static List<APPSelectLeft.ValueBean> listMenus;

  public void setTotalPriceView() {
    total_price.setText("￥" + DishList.getTotalPrice());
  }

  public void gotoSelectDetail() {
    EventBus.getDefault()
        .post(new StartBrotherEvent(SelectPlaceDetailFragment.newInstance(shop_id)));
  }

  private void initView(View view, Bundle savedInstanceState) {
    EventBus.getDefault().register(this);

    setTitle(view, "选菜");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });
    //        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
    fl_child_list_content_container =
        (FrameLayout) view.findViewById(R.id.fl_child_list_content_container);
    order_now_btn = (Button) view.findViewById(R.id.order_now_btn);
    order_now_btn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {

        gotoSelectDetail();
      }
    });

    fManager = getFragmentManager();
    transaction = fManager.beginTransaction();

    //        mToolbar.setTitle("选菜");

    //        initToolbarMenu(mToolbar);

    total_price = (TextView) view.findViewById(R.id.total_price);
    setTotalPriceView();
    //获取一次,保存在下left
    if (savedInstanceState == null) {
      EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_SELECT_LEFT, shop_id));
      //            ArrayList<String> listMenus = new ArrayList<>();
      //            listMenus.add("热门推荐");
      //            listMenus.add("新品尝鲜");
      //            listMenus.add("精品套餐");
      //            listMenus.add("分类选择");
      //            ArrayList<String> hidenMenu = new ArrayList<>();
      //            hidenMenu.add("煲类");
      //            hidenMenu.add("汤");
      //            hidenMenu.add("小菜");
      //            hidenMenu.add("酒水饮料");
      //            hidenMenu.add("盖浇饭类");
      //            hidenMenu.add("炒面类");
      //            hidenMenu.add("拉面类");
      //            hidenMenu.add("盖浇面类");
      //            hidenMenu.add("特色菜");
      //            hidenMenu.add("加料");
      //            hidenMenu.add("馄饨类");
      //            hidenMenu.add("其他");

      ((RelativeLayout) view.findViewById(R.id.menu_selected)).setOnClickListener(
          new View.OnClickListener() {
            @Override public void onClick(View v) {
              if (showDishList) {
                //栈-->子栈
                SupportFragment dishListFragment = findChildFragment(DishListFragment.class);
                if (dishListFragment != null) {
                  dishListFragment.pop();
                } else {
                  Log.e("arilpan", "hiden程序异常");
                }
                showDishList = false;
              } else {
                SupportFragment dishListFragment = findChildFragment(DishListFragment.class);
                if (dishListFragment == null) {
                  replaceLoadRootFragment(R.id.fl_child_list_content_container,
                      DishListFragment.newInstance("菜单列表栏目", "1"), true);
                  //                                switchDishListFragment(
                  //                                        DishListFragment.newInstance("菜单列表栏目", "1"));
                  Log.e("arilpan", "show new dishListFragment ");
                } else {
                  Log.e("arilpan", "show dishListFragment ");
                  transaction.show(dishListFragment);
                }
                //显示已经选择的菜品
                showDishList = true;
              }
              //新的菜单列表 浮动listview
            }
          });
    }
  }

  static boolean showDishList = false;

  @Override public boolean onBackPressedSupport() {
    // ContentFragment是ShopFragment的栈顶子Fragment,
    // 会先调用ContentFragment的onBackPressedSupport方法
    //        Toast.makeText(_mActivity, "onBackPressedSupport-->" +
    //                "返回false,交给上层处理!",
    //                Toast.LENGTH_SHORT).show();

    //        Toast.makeText(_mActivity, "返回!",
    //                Toast.LENGTH_SHORT).show();
    return false;
  }

  public void switchSelectFragment(SelectFragment fragment) {
    SupportFragment selectFragment = findChildFragment(SelectFragment.class);
    if (selectFragment != null) {
      selectFragment.replaceFragment(fragment, false);
    }
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {

    if (RequestType.INDEX_DISH_SELECT_LEFT == event.reqType) {
      Log.e("arilpan", "ShopFragment 填充数据");
      getRightData(event);
      setData(getData(event));
    }
  }

  public static List<APPSelectRight.ValueBean> rightDatas;

  public void getRightData(NetworkEvent event) {
    ResponseBody body = null;
    try {
      final JsonAdapter<APPSelectRight> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPSelectRight.class));
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(
          APIConfigFactory.createURL(RequestType.INDEX_DISH_SELECT_RIGHT) + event.id).build();
      Response response = client.newCall(request).execute();
      body = response.body();

      APPSelectRight datas_arry = COM_JSON_ADAPTER.fromJson(body.source());

      rightDatas = datas_arry.getValue();
      Log.e("arilpan", "dish num:" + rightDatas.size());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
      body = null;
    }
    //        return null;
  }

  public List<APPSelectLeft.ValueBean> getData(NetworkEvent event) {
    ResponseBody body = null;
    try {
      final JsonAdapter<APPSelectLeft> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPSelectLeft.class));
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(event.url + event.id).build();
      Response response = client.newCall(request).execute();
      body = response.body();

      APPSelectLeft datas_arry = COM_JSON_ADAPTER.fromJson(body.source());
      listMenus = datas_arry.getValue();
      return listMenus;
    } catch (Exception e) {

      e.printStackTrace();
    } finally {
      body.close();
      body = null;
    }
    return null;
  }

  public void setData(final List<APPSelectLeft.ValueBean> items) {
    try {
      _mActivity.runOnUiThread(new Runnable() {
        @Override public void run() {
          //                    mAdapter.setDatas(items);
          //stuff that updates ui

          ArrayList<String> hidenMenu = new ArrayList<>();
          MenuListFragment menuListFragment = MenuListFragment.newInstance(listMenus);
          //                            MenuListFragment.newInstance(listMenus, hidenMenu);
          loadRootFragment(R.id.fl_list_container, menuListFragment);
          replaceLoadRootFragment(R.id.fl_content_container, SelectFragment.newInstance(
                  (listMenus == null || listMenus.size() == 0) ? "1" : listMenus.get(0).getTagID(),
                  "热门推荐"), false);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Subscribe public void setPrice(ShopEvent event) {
    setTotalPriceView();
  }

  public void switchDishListFragment() {
    SupportFragment dishListFragment = findChildFragment(DishListFragment.class);
    if (dishListFragment != null) {
      dishListFragment.pop();
    } else {
      Log.e("arilpan", "dishListFragment == null 不需要弹出,直接覆盖即可");
    }
  }

  @Override public void onDestroyView() {
    EventBus.getDefault().unregister(this);
    DishList.getlist().clear();
    super.onDestroyView();
  }
}
