package com.ydxiaoyuan.ifood.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.fragment.ShopFragment;

/**
 * Created by YoKeyword on 16/6/3.
 */
public class MainLazyFragment extends BaseLazyMainFragment {

  public static MainLazyFragment newInstance() {

    Bundle args = new Bundle();

    MainLazyFragment fragment = new MainLazyFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_lazy_main, container, false);
    return view;
  }

  @Override protected void initLazyView(@Nullable Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      // ShopFragment是flow包里的
      loadRootFragment(R.id.fl_third_container, ShopFragment.newInstance(ShopFragment.shop_id));
    } else { // 这里可能会出现该Fragment没被初始化时,就被强杀导致的没有load子Fragment
      if (findChildFragment(ShopFragment.class) == null) {
        loadRootFragment(R.id.fl_third_container, ShopFragment.newInstance(ShopFragment.shop_id));
      }
    }
  }
}
