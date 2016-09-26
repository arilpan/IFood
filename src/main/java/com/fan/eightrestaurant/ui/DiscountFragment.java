package com.fan.eightrestaurant.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.fan.eightrestaurant.adapter.PreferentialAdapter;
import com.fan.eightrestaurant.bean.Preferential;
import com.fan.eightrestaurant.utils.JSONUtils;
import com.fan.eightrestaurant.utils.PathUtils;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;

import java.util.List;

/**
 * 专属优惠信息界面
 */
public class DiscountFragment extends BaseFragment {
  private ListView listView;
  private PreferentialAdapter adapter;
  private View view;

  public DiscountFragment() {
  }

  public static DiscountFragment newInstance() {
    Bundle args = new Bundle();
    DiscountFragment fragment = new DiscountFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_preferential, container, false);
    initView(view);
    return view;
  }

  public void initView(View view) {
    ((TextView) view.findViewById(R.id.title_middle)).setText("优惠");
    view.findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        pop();
      }
    });
    ((ImageView) view.findViewById(R.id.btn_iv_back)).setVisibility(View.GONE);

    listView = (ListView) view.findViewById(R.id.activity_preferential_listview);
    initData(PathUtils.getPreferentialUrl());
    //todo:arilpan  new Bundle()
    view = LayoutInflater.from(getContext()).inflate(R.layout.activity_preferential_head, null);
    listView.addHeaderView(view);
    adapter = new PreferentialAdapter(getContext());
    listView.setAdapter(adapter);
  }

  /**
   * 获取网络数据
   */
  private void initData(String path) {
    OkHttpUtils.get().url(path).build().execute(new StringCallback() {
      @Override public void onError(Call call, Exception e) {
      }

      @Override public void onResponse(String response) {
        final List<Preferential> result = JSONUtils.getPreferentialJson(response);
        adapter.setList(result);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
              return;
            } else {
              Intent intent = new Intent(getActivity(), PreferentialDetailsActivity.class);
              String discount_id = result.get(position - 1).getDiscount_id();
              String shop_id = result.get(position - 1).getShop_id();
              intent.putExtra("discount_id", discount_id);
              intent.putExtra("shop_id", shop_id);
              startActivity(intent);
            }
            //todo:intent
          }
        });
      }
    });
  }
}
