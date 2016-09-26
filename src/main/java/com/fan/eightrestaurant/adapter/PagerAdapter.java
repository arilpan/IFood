package com.fan.eightrestaurant.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xdkj on 2016/8/12.
 */
public class PagerAdapter extends FragmentPagerAdapter {
  List<Fragment> list;

  public PagerAdapter(FragmentManager fm, List<Fragment> list) {
    super(fm);
    this.list = list;
  }

  @Override public Fragment getItem(int position) {
    return list.get(position);
  }

  @Override public int getCount() {
    if (list != null) {
      return list.size();
    }
    return 0;
  }
}
