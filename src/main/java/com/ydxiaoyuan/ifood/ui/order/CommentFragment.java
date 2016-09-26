package com.ydxiaoyuan.ifood.ui.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.helper.KVHelper;
import com.ydxiaoyuan.ifood.helper.UrlHelper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aril_pan@qq.com on 16/8.
 */
public class CommentFragment extends BaseFragment {
  TextView comment;
  Button comment_button;

  public CommentFragment() {
    // Required empty public constructor
  }

  public static CommentFragment newInstance(String order_id, String dish_id, String name,
      String url, String desc)
  //dish.getDishes_id(),    name, dish.getUpload_url(),dish.getDishes_description()
  {

    Bundle args = new Bundle();
    CommentFragment fragment = new CommentFragment();
    args.putString("dish_id", dish_id);
    args.putString("order_id", order_id);
    args.putString("dish_name", name);
    args.putString("dish_desc", desc);
    args.putString("dish_url", url);
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_comment, container, false);
    initView(view);
    return view;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    if (args != null) {
      dishes_id = args.getString("dish_id");
      user_id = KVHelper.getUserInfo(getContext(), "username", "");
      dish_name = args.getString("dish_name");
      url = args.getString("dish_url");
      dish_desc = args.getString("dish_desc");
      order_id = args.getString("order_id");
    }
  }

  private void initView(View view) {
    setTitle(view, "评价");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });

    EventBus.getDefault().register(this);
    comment = (TextView) view.findViewById(R.id.comment);
    comment_button = (Button) view.findViewById(R.id.comment_button);

    (((TextView) view.findViewById(R.id.dish_name))).setText(dish_name);
    (((TextView) view.findViewById(R.id.dish_desc))).setText(dish_desc);

    Glide.with(CommentFragment.this)
        .load(APIConfig.BASE_IMG_URL + url)
        .error(R.drawable.preferential_list_item_zanwutupian)
        .into(((ImageView) view.findViewById(R.id.dish_icon)));

    comment_button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        content = comment.getText().toString();
        //提交后退出
        EventBus.getDefault().post(new NetworkEvent(RequestType.ORDER_COMMENT));
      }
    });
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) public void onNetWork(NetworkEvent event) {
    Log.e("arilpan", "WaterFall 你调用咩?");
    if (RequestType.ORDER_COMMENT == event.reqType) {

      /**
       *
       public static String dish_comment_url = BASE_PROJECT_URL +
       "appEvaluation/saveAddEvaluations.do?user_id=USERID" +
       "&dishes_id=DISHID&content=CONTENT";
       */

      String url = event.url.replace("USERID", user_id)
          .replace("DISHID", dishes_id)
          .replace("CONTENT", content);
      url = UrlHelper.addToken(getContext(), url);
      url = url + "&order_id=" + order_id;
      Log.e("arilpan", " comment url=" + url);

      if (getData(url)) {
        setData();
      } else {

      }
    } else {
      Log.e("arilpan", "WaterFall what happend?");
    }
  }

  public boolean getData(String url) {
    try {
      //network
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(UrlHelper.addToken(getContext(), url)).build();
      Response response = client.newCall(request).execute();
      ResponseBody body = response.body();
      String res = body.string();

      //result parse
      JSONObject jsonObject = new JSONObject(res);
      boolean isSuccess = jsonObject.getBoolean("success");
      //            if (isSuccess)
      {
        _mActivity.runOnUiThread(new Thread() {
          @Override public void run() {
            Toast.makeText(getContext(), "评价成功", Toast.LENGTH_SHORT).show();
          }
        });

        return true;
      }
    } catch (JSONException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    _mActivity.runOnUiThread(new Thread() {
      @Override public void run() {
        Toast.makeText(getContext(), "评价失败", Toast.LENGTH_SHORT).show();
      }
    });
    return false;
  }

  public void setData() {
    _mActivity.runOnUiThread(new Runnable() {
      @Override public void run() {
        pop();
        //stuff that updates ui
      }
    });
  }

  @Override public boolean onBackPressedSupport() {
    // 这里实际项目中推荐使用 EventBus接耦
    //        ((TestOne) getParentFragment()).onBackToFirstFragment();
    Log.e("arilpan", "on back press");
    return false;
    //        return true;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }

  String dish_name;
  String dish_desc;
  String url;
  String order_id;

  String user_id;
  String dishes_id;
  String content;
}
