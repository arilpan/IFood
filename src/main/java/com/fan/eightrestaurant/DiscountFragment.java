package com.fan.eightrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.fan.eightrestaurant.adapter.PreferentialAdapter;
import com.fan.eightrestaurant.bean.Preferential;
import com.fan.eightrestaurant.ui.PreferentialDetailsActivity;
import com.fan.eightrestaurant.utils.JSONUtils;
import com.fan.eightrestaurant.utils.PathUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import java.util.List;
import okhttp3.Call;
import com.ydxiaoyuan.ifood.R;

/**
 * 专属优惠信息界面
 */
public class DiscountFragment extends AppCompatActivity {
  private ListView listView;
  private PreferentialAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_preferential);
    listView = (ListView) findViewById(R.id.activity_preferential_listview);
    initData(PathUtils.getPreferentialUrl());
    View listViewHeader = getLayoutInflater().inflate(R.layout.preferential_listview_head, null);
    listView.addHeaderView(listViewHeader);
    adapter = new PreferentialAdapter(getBaseContext());
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
            //todo:intent
            Intent intent = new Intent(DiscountFragment.this, PreferentialDetailsActivity.class);
            String discount_id = result.get((int) id).getDiscount_id();
            String shop_id = result.get((int) id).getShop_id();
            intent.putExtra("discount_id", discount_id);
            intent.putExtra("shop_id", shop_id);
            startActivity(intent);
          }
        });
      }
    });
  }
}
