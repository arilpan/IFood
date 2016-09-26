package com.ydxiaoyuan.ifood.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.ydxiaoyuan.ifood.R;
import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by YoKeyword on 16/2/7.
 */
public class BaseBackFragment extends SwipeBackFragment {
  private SwipeBackLayout mSwipeBackLayout;
  private static final String TAG = "Fragmentation";

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    onFragmentCreate();
  }

  private void onFragmentCreate() {
    mSwipeBackLayout = new SwipeBackLayout(_mActivity);
    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT);
    mSwipeBackLayout.setLayoutParams(params);
    mSwipeBackLayout.setBackgroundColor(Color.TRANSPARENT);
  }

  protected View attachToSwipeBack(View view) {
    mSwipeBackLayout.attachToFragment(this, view);
    return mSwipeBackLayout;
  }

  @Override public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    if (hidden && mSwipeBackLayout != null) {
      mSwipeBackLayout.hiddenFragment();
    }
  }

  @Override protected void initFragmentBackground(View view) {
    if (view instanceof SwipeBackLayout) {
      View childView = ((SwipeBackLayout) view).getChildAt(0);
      setBackground(childView);
    } else {
      setBackground(view);
    }
  }

  public SwipeBackLayout getSwipeBackLayout() {
    return mSwipeBackLayout;
  }

  public void setSwipeBackEnable(boolean enable) {
    mSwipeBackLayout.setEnableGesture(enable);
  }

  protected void initToolbarNav(Toolbar toolbar) {
    toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        _mActivity.onBackPressed();
      }
    });

    initToolbarMenu(toolbar);
  }

  protected void initToolbarMenu(Toolbar toolbar) {
    toolbar.inflateMenu(R.menu.hierarchy);
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
          case R.id.action_hierarchy:
            _mActivity.showFragmentStackHierarchyView();
            _mActivity.logFragmentStackHierarchy(TAG);
            break;
        }
        return true;
      }
    });
  }
}
