package com.ydxiaoyuan.ifood.ui.place;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.avast.android.dialogs.fragment.ListDialogFragment;
import com.avast.android.dialogs.iface.IListDialogListener;
import com.avast.android.dialogs.iface.ISimpleDialogCancelListener;
import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPRoomInfo;
import com.ydxiaoyuan.ifood.entity.Dish;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.helper.GetParamConstructor;
import com.ydxiaoyuan.ifood.helper.KVHelper;
import com.ydxiaoyuan.ifood.helper.UrlHelper;
import com.ydxiaoyuan.ifood.ui.menu.DishList;
import me.yokeyword.fragmentation.SupportFragment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by aril_pan@qq.com on 16/8.
 */
public class SelectPlaceDetailFragment extends SupportFragment
    implements IListDialogListener, ISimpleDialogCancelListener {
  private static final String ARG_NUMBER = "shop_id";
  private String shop_id;

  public static SelectPlaceDetailFragment newInstance(String shop_id) {
    SelectPlaceDetailFragment fragment = new SelectPlaceDetailFragment();
    Bundle args = new Bundle();
    args.putString(ARG_NUMBER, shop_id);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    if (args != null) {
      shop_id = args.getString(ARG_NUMBER);
    }
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_pre_order, container, false);
    initView(view);
    return view;
  }

  //pre_order_list_small_rl
  // 用餐人数
  // 用餐时间
  // 包间
  // 选择菜品
  RelativeLayout orderPersonNumRl;
  RelativeLayout orderTimeRl;
  RelativeLayout orderRoomRl;
  RelativeLayout orderSelectDishRl;
  TextView select_room;
  TextView select_time;
  TextView select_person_num;
  TextView remarksTextView;
  Button order;

  /**
   * 提交订单
   */
  public void submitOrder() {
    //        String user_id = APIConfig.user_id;
    String user_id = KVHelper.getUserInfo(getContext(), "username", "");
    String have_meals_persons = select_person_num.getText().toString();
    String have_meals_time = select_time.getText().toString();
    String remarks = remarksTextView.getText().toString();
    //shop_id;
    String shop_name =
        ((shop_id == APIConfig.shop_one_id) ? APIConfig.shop_one_name : APIConfig.shop_two_name);
    String room = select_room.getText().toString();
    //arilpan:2016-9-18 去除括号及括号内的信息：知秋厅(2-20人)=>知秋厅
    Log.e("arilpan", "old room " + room);
    room = room.substring(0, room.indexOf("("));
    Log.e("arilpan", "new room " + room);
    room = room.substring(0, room.indexOf("（"));
    Log.e("arilpan", "new china char room " + room);
    double sum_price = DishList.getTotalPrice();

    if (TextUtils.isEmpty(room)) {
      Toast.makeText(getContext(), "选择用餐房间", Toast.LENGTH_SHORT).show();
      return;
    }
    if (TextUtils.isEmpty(have_meals_persons)) {
      Toast.makeText(getContext(), "选择用餐人数", Toast.LENGTH_SHORT).show();
      return;
    }
    if (TextUtils.isEmpty(have_meals_time)) {
      Toast.makeText(getContext(), "选择用餐时间", Toast.LENGTH_SHORT).show();
      return;
    }

    /**
     * 1.如果时间太近,不可
     * 2.如果那个参数没选,不可
     *
     */
    //1. str :上面8个参数toJson=>后来告诉我其实是普通get方式
    // ,7000字符容量还够用= =!!!多亏了谷歌内核

    GetParamConstructor getParamConstructor = new GetParamConstructor();
    getParamConstructor.add("user_id", user_id);
    getParamConstructor.add("have_meals_persons", have_meals_persons);
    getParamConstructor.add("have_meals_time", have_meals_time);
    getParamConstructor.add("remarks", remarks);
    getParamConstructor.add("shop_id", shop_id);
    getParamConstructor.add("shop_name", shop_name);
    getParamConstructor.add("room", room);
    getParamConstructor.add("sum_price", String.valueOf(sum_price));

    String parmas1 = getParamConstructor.getString();
    Log.e("arilpan", "第一部分参数" + parmas1);

    //第二部分
    JSONObject jsonObj = new JSONObject();
    try {
      jsonObj.put("str", getParamConstructor);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    Log.e("arilpan", "-------------" + jsonObj.toString());

    //2.jsonStr
    List<TempDish> dishes = new ArrayList<>();
    for (Dish dish : DishList.getlist()) {
      String dishes_name = dish.getName();
      String dishes_price = dish.getPrice();
      int dishes_count = dish.getNum();
      String dish_id = dish.getDish_id();
      String url = dish.getImgurl();
      dishes.add(new TempDish(dishes_name, dishes_price, dishes_count, url, dish_id));
    }
    jsonStr tds = new jsonStr(dishes);
    //                TempDish blackjackHand = new TempDish(
    //                        new TempDish('6', SPADES),
    //                        Arrays.asList(new Dish('4', CLUBS), new Dish('A', HEARTS)));
    Moshi moshi = new Moshi.Builder().build();
    JsonAdapter<jsonStr> jsonAdapter = moshi.adapter(jsonStr.class);
    String json = jsonAdapter.toJson(tds);
    Log.e("arilpan", "-------------" + json.toString());

    getParamConstructor.add("jsonStr", json.toString());
    String parmas2 = getParamConstructor.getString();
    Log.e("arilpan", "第二部分参数" + parmas2);
    Log.e("arilpan", "after:-------------" + parmas2.toString());
    String getData = parmas2.toString();

    EventBus.getDefault().post(new NetworkEvent(RequestType.ORDER_UPLOAD, getData));
  }

  private void initView(View view) {
    EventBus.getDefault().register(this);
    EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_SELECT_ROOM, shop_id));

    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });

    final LinearLayout shop_bg = (LinearLayout) view.findViewById(R.id.shop_background);
    //        SimpleTarget target = new SimpleTarget<Drawable>() {
    //            @Override
    //            public void onResourceReady(Drawable resource, GlideAnimation<? super Drawable> glideAnimation) {
    //                shop_bg.setBackgroundDrawable(resource);
    //            }
    //        };
    if (APIConfig.select_mall == APIConfig.ONE) {
      Log.e("arilpan", "APIConfig.BASE_IMG_URL+APIConfig.shop_one_icon:"
          + APIConfig.BASE_IMG_URL
          + APIConfig.shop_one_icon);
      Glide.with(SelectPlaceDetailFragment.this)
          .load(APIConfig.BASE_IMG_URL + APIConfig.shop_one_icon)
          .error(R.drawable.pre_order_title)
          .into(new SimpleTarget<GlideDrawable>() {
            @Override public void onResourceReady(GlideDrawable resource,
                GlideAnimation<? super GlideDrawable> glideAnimation) {
              shop_bg.setBackgroundDrawable(resource);
            }
          });
      ((TextView) view.findViewById(R.id.shop_name)).setText(APIConfig.shop_one_name);
      ((TextView) view.findViewById(R.id.shop_addr)).setText(APIConfig.shop_one_addr);
      ((TextView) view.findViewById(R.id.shop_work_time)).setText(APIConfig.shop_one_work_time);
      //todo:phone : tel action
      //            ((TextView)view.findViewById(R.id.shop_addr)).setText(APIConfig.shop_one_phone);
    } else if (APIConfig.select_mall == APIConfig.TWO) {
      Glide.with(SelectPlaceDetailFragment.this)
          .load(APIConfig.BASE_IMG_URL + APIConfig.shop_two_icon)
          .error(R.drawable.pre_order_title)
          .into(new SimpleTarget<GlideDrawable>() {
            @Override public void onResourceReady(GlideDrawable resource,
                GlideAnimation<? super GlideDrawable> glideAnimation) {
              shop_bg.setBackgroundDrawable(resource);
            }
          });
      ((TextView) view.findViewById(R.id.shop_name)).setText(APIConfig.shop_two_name);
      ((TextView) view.findViewById(R.id.shop_addr)).setText(APIConfig.shop_two_addr);
      ((TextView) view.findViewById(R.id.shop_work_time)).setText(APIConfig.shop_two_work_time);
      //            ((TextView)view.findViewById(R.id.shop_addr)).setText(APIConfig.shop_two_phone);
    }
    orderPersonNumRl = (RelativeLayout) view.findViewById(R.id.order_person_num);
    orderTimeRl = (RelativeLayout) view.findViewById(R.id.order_time);
    orderRoomRl = (RelativeLayout) view.findViewById(R.id.order_room);
    orderSelectDishRl = (RelativeLayout) view.findViewById(R.id.order_dishes);

    remarksTextView = (TextView) view.findViewById(R.id.remarks_text);
    select_room = (TextView) view.findViewById(R.id.select_room);
    select_person_num = (TextView) view.findViewById(R.id.select_num);
    select_time = (TextView) view.findViewById(R.id.select_time);

    order = (Button) view.findViewById(R.id.order);
    /**
     * check
     * <p>
     *     <li>shop_id</li>
     *     <li>dish num>1 dish </li>
     *     <li>time>2 hours</li>
     *     <li>person number\room number select </li>
     * </p>
     */
    order.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        submitOrder();
      }
    });

    orderSelectDishRl.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //调用选择菜品
        final EditText inputServer = new EditText(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("备注")
            .setIcon(android.R.drawable.ic_dialog_info)
            .setView(inputServer)
            .setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

          public void onClick(DialogInterface dialog, int which) {
            remarksTextView.setText(inputServer.getText().toString());
          }
        });
        builder.show();
      }
    });
    orderRoomRl.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //调用选择房间
        ListDialogFragment.createBuilder(getContext(), getFragmentManager())
            .setTitle("选择包间:")
            .setItems(new String[] {})
            .setTargetFragment(SelectPlaceDetailFragment.this, SELECT_ROOM)
            .show();
      }
    });
    orderPersonNumRl.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //调用填写人数
        //调用选择房间
        ListDialogFragment.createBuilder(getContext(), getFragmentManager())
            .setTitle("选择用餐人数:")
            .setItems(new String[] {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
                "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
                "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57",
                "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71",
                "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85",
                "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99",
                "100"
            })
            .setTargetFragment(SelectPlaceDetailFragment.this, SELECT_PERSON_NUM)
            .show();
      }
    });
    vMasker = (View) view.findViewById(R.id.vMasker);
    initTimeSelect();
    orderTimeRl.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //弹出时间选择器
        pvTime.show();
      }
    });
  }

  static class jsonStr {
    public final List<TempDish> dishes;

    jsonStr() {
      dishes = null;
    }

    jsonStr(List<TempDish> dishes) {
      this.dishes = dishes;
    }
  }

  @Override public void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }

  //time start

  TimePickerView pvTime;
  View vMasker;

  public void initTimeSelect() {
    //调用选择时间
    //时间选择器
    pvTime = new TimePickerView(getContext(), TimePickerView.Type.ALL);
    //控制时间范围
    Calendar calendar = Calendar.getInstance();
    pvTime.setRange(calendar.get(Calendar.YEAR), calendar.get(Calendar.YEAR) + 1);
    pvTime.setTime(new Date());
    pvTime.setCyclic(false);
    pvTime.setCancelable(true);
    //时间选择后回调
    pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

      @Override public void onTimeSelect(Date date) {
        //2016-09-08 16:38
        String time = getTime(date);
        //                time.replaceFirst("-", "年");
        //                time.replace("-", "月");
        //                time.replace(" ", "日");
        //                time.replace(":", "时");
        //                time = time + "分";
        Log.e("arilpan", "click time select" + getTime(date) + "-->" + time);
        select_time.setText(time);
      }
    });
  }

  public static String getTime(Date date) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");//年月日时分
    return format.format(date);
  }

  @Override public boolean onBackPressedSupport() {
    if (pvTime.isShowing()) {
      pvTime.dismiss();
      return true;
    }
    return super.onBackPressedSupport();
  }

  //    @Override
  //    public boolean onKeyDown(int keyCode, KeyEvent event)
  //    {
  //        if (keyCode == KeyEvent.KEYCODE_BACK)
  //        {
  //
  //            if (pvTime.isShowing())
  //            {
  //                pvTime.dismiss();
  //                return true;
  //            }
  //        }
  //        return super.onKeyDown(keyCode, event);
  //    }

  //time end

  private static final int SELECT_PERSON_NUM = 11;
  private static final int SELECT_TIME = 10;
  private static final int SELECT_ROOM = 9;

  @Override public void onListItemSelected(CharSequence value, int number, int requestCode) {
    if (requestCode == SELECT_ROOM) {
      select_room.setText(value);
    }
    if (requestCode == SELECT_PERSON_NUM) {
      select_person_num.setText(value);
    }
  }

  @Override public void onCancelled(int requestCode) {
    switch (requestCode) {
      case SELECT_TIME:
        //                Toast.makeText(getContext(), "Dialog cancelled", Toast.LENGTH_SHORT).show();
        break;
      case SELECT_ROOM:
      case SELECT_PERSON_NUM:
        //                Toast.makeText(getContext(), "Nothing selected", Toast.LENGTH_SHORT).show();
        break;
      //            case REQUEST_DATE_PICKER:
      //                Toast.makeText(c, "Date picker cancelled", Toast.LENGTH_SHORT).show();
      //                break;
      //            case REQUEST_TIME_PICKER:
      //                Toast.makeText(c, "Time picker cancelled", Toast.LENGTH_SHORT).show();
      //                break;
    }
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {

    if (RequestType.INDEX_DISH_SELECT_ROOM == event.reqType) {
      Log.e("arilpan", "ShopFragment 填充数据");
      setData(getData(event));
    } else if (RequestType.ORDER_UPLOAD == event.reqType) {
      uploadData(event.url + event.id);
    }
  }

  public void uploadData(String url) {
    ResponseBody body = null;
    try {
      url = UrlHelper.addToken(getContext(), url);
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(url).build();

      Response response = client.newCall(request).execute();
      body = response.body();
      String result = body.string();
      Log.e("arilpan", "url:" + url + ",result:" + result);
      JSONObject jsonObject = new JSONObject(result);
      String msg = jsonObject.getString("message");
      Log.e("arilpan", " create order res:" + msg + ",result:" + result);
      if ("TokenError".equals(msg)) {
        _mActivity.runOnUiThread(new Runnable() {
          @Override public void run() {
            Toast.makeText(getContext(), "无权创建订单，请检查登录状态", Toast.LENGTH_SHORT).show();
            Log.e("arilpan", " create order success");
          }
        });
      } else if ("true".equals(jsonObject.getString("success"))) {
        _mActivity.runOnUiThread(new Runnable() {
          @Override public void run() {
            Toast.makeText(getContext(), "订单创建成功", Toast.LENGTH_SHORT).show();
            Log.e("arilpan", " create order success");
            pop();
          }
        });
      } else {
        _mActivity.runOnUiThread(new Runnable() {
          @Override public void run() {
            Toast.makeText(getContext(), "订单创建失败", Toast.LENGTH_SHORT).show();
          }
        });
        Log.e("arilpan", " create order fail");
        //                EventBus.getDefault().post(
        //                        new NetworkEvent(RequestType.ORDER_LIST,
        //                                String.valueOf(APIConfig.ORDER_CANCLE))
        //                );

      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
  }

  public void setData(final List<APPRoomInfo.ValueBean> datas) {
    try {
      _mActivity.runOnUiThread(new Runnable() {
        @Override public void run() {
          //                    mAdapter.setDatas(items);
          //stuff that updates ui

          orderRoomRl.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
              if (datas == null) {
                Toast.makeText(getContext(), "还未获取到包间数据", Toast.LENGTH_SHORT).show();
                return;
              }
              //调用选择房间
              String[] rooms = new String[datas.size()];
              int id = 0;
              for (APPRoomInfo.ValueBean vb : datas) {
                //                                vb.getRoom_id();
                rooms[id++] = vb.getRoom();
              }
              ListDialogFragment.createBuilder(getContext(), getFragmentManager())
                  .setTitle("选择包间:")
                  .setItems(rooms)
                  .setTargetFragment(SelectPlaceDetailFragment.this, SELECT_ROOM)
                  .show();
            }
          });
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<APPRoomInfo.ValueBean> getData(NetworkEvent event) {
    ResponseBody body = null;
    try {
      final JsonAdapter<APPRoomInfo> COM_JSON_ADAPTER =
          MainActivity.MOSHI.adapter(Types.newParameterizedType(APPRoomInfo.class));
      OkHttpClient client = new OkHttpClient();

      Request request = new Request.Builder().url(event.url + event.id).build();

      Response response = client.newCall(request).execute();
      body = response.body();

      APPRoomInfo datas_arry = COM_JSON_ADAPTER.fromJson(body.source());
      Log.e("arilpan", "room num:" + datas_arry.getValue().size());
      return datas_arry.getValue();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      body.close();
    }
    return null;
  }
}
