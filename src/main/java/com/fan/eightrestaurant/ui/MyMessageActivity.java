package com.fan.eightrestaurant.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ydxiaoyuan.ifood.R;
import com.fan.eightrestaurant.adapter.PagerAdapter;
import com.fan.eightrestaurant.fragment.DuckFragment;
import com.fan.eightrestaurant.fragment.EightFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的留言本界面
 */
public class MyMessageActivity extends FragmentActivity implements View.OnClickListener {

  private TextView[] titles;
  private TextView[] views;
  private ViewPager viewPager;
  private LinearLayout layout1, layout2;
  private PagerAdapter adapter;
  private String userId, token, secretkey, imagePath;
  private SharedPreferences getInfo;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_message);

    ((TextView) findViewById(R.id.title_middle)).setText("我的留言");
    findViewById(R.id.title_ll_left).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
      }
    });

    getInfo = getSharedPreferences("saveSelfInfo", Context.MODE_PRIVATE);
    userId = getInfo.getString("user_id", userId);
    token = getInfo.getString("token", token);
    secretkey = getInfo.getString("secretkey", secretkey);
    imagePath = getInfo.getString("imagePath", imagePath);
    getUserId();
    getToken();
    getSecretkey();
    getImagePath();

    initTopTitle();
    initViewPager();
  }

  public String getUserId() {
    return userId;
  }

  public String getToken() {
    return token;
  }

  public String getSecretkey() {
    return secretkey;
  }

  public String getImagePath() {
    return imagePath;
  }

  /**
   * 标题的设置
   */
  private void initTopTitle() {
    layout1 = (LinearLayout) findViewById(R.id.activity_my_message_layout1);
    layout2 = (LinearLayout) findViewById(R.id.activity_my_message_layout2);
    views = new TextView[2];
    titles = new TextView[2];
    for (int i = 0; i < titles.length; i++) {
      //标题的设置
      titles[i] = (TextView) layout1.getChildAt(i);
      titles[i].setTag(i);//设置标签
      titles[i].setOnClickListener(this);//设置标题的点击事件
      titles[0].setTextColor(Color.rgb(255, 102, 102));
      //标题底下横线的设置
      views[i] = (TextView) layout2.getChildAt(i);
      views[0].setBackgroundColor(Color.rgb(255, 102, 102));
    }
  }

  /**
   * ViewPager的设置
   */
  private void initViewPager() {
    viewPager = (ViewPager) findViewById(R.id.activity_my_message_viewpager);
    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override public void onPageSelected(int position) {
        for (int i = 0; i < 2; i++) {
          titles[i].setTextColor(Color.rgb(51, 51, 51));
          views[i].setBackgroundColor(Color.rgb(242, 242, 242));
        }
        titles[position].setTextColor(Color.rgb(255, 102, 102));
        views[position].setBackgroundColor(Color.rgb(255, 102, 102));
      }

      @Override public void onPageScrollStateChanged(int state) {

      }
    });
    EightFragment eightFragment = new EightFragment();
    DuckFragment duckFragment = new DuckFragment();
    List<Fragment> list = new ArrayList<>();
    list.add(eightFragment);
    list.add(duckFragment);
    adapter = new PagerAdapter(getSupportFragmentManager(), list);
    viewPager.setAdapter(adapter);
  }

  @Override public void onClick(View v) {
    int index = (int) v.getTag();
    viewPager.setCurrentItem(index);
  }
}
