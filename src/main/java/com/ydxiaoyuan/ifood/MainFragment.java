package com.ydxiaoyuan.ifood;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fan.eightrestaurant.ui.LeaveMessageFragment;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.event.TabSelectedEvent;
import com.ydxiaoyuan.ifood.fragment.IndexFragment;
import com.ydxiaoyuan.ifood.fragment.MineFragment;
import com.ydxiaoyuan.ifood.view.BottomBar;
import com.ydxiaoyuan.ifood.view.BottomBarTab;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by arilpan@qq.com on 2016/8/4.
 */
public class MainFragment extends BaseFragment {
  public static final int FIRST = 0;
  public static final int SECOND = 1;
  public static final int THIRD = 2;
  public static final int FOURTH = 3;

  private SupportFragment[] mFragments = new SupportFragment[4];

  private BottomBar mBottomBar;

  public static MainFragment newInstance() {

    Bundle args = new Bundle();

    MainFragment fragment = new MainFragment();
    fragment.setArguments(args);
    return fragment;
  }

  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    if (savedInstanceState == null) {
      mFragments[FIRST] = IndexFragment.newInstance();
      mFragments[SECOND] = com.fan.eightrestaurant.ui.
          DiscountFragment.newInstance();
      //                    DiscountFragment.newInstance(APIConfig.shop_one_id);
      mFragments[THIRD] = LeaveMessageFragment.newInstance();
      mFragments[FOURTH] = MineFragment.newInstance();

      loadMultipleRootFragment(R.id.fl_container, FIRST, mFragments[FIRST], mFragments[SECOND],
          mFragments[THIRD], mFragments[FOURTH]);
      Log.e("arilpan", "MainFragment savedInstanceState == null ");
    } else {
      // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

      // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些)
      // ,用下面的方法查找更方便些
      mFragments[FIRST] = findFragment(IndexFragment.class);
      mFragments[SECOND] = findFragment(com.fan.eightrestaurant.ui.
          DiscountFragment.class);
      mFragments[THIRD] = findFragment(LeaveMessageFragment.class);
      mFragments[FOURTH] = findFragment(MineFragment.class);
      Log.e("arilpan", "MainFragment savedInstanceState != null ");
    }

    initView(view);
    return view;
  }

  @Override protected FragmentAnimator onCreateFragmentAnimator() {
    //        return super.onCreateFragmentAnimator();
    // 设置横向(和安卓4.x动画相同)
    return new DefaultHorizontalAnimator();
  }

  private void initView(View view) {
    EventBus.getDefault().register(this);
    mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

    mBottomBar.addItem(new BottomBarTab(_mActivity, R.drawable.ic_home_icon1, "首页"))
        .addItem(new BottomBarTab(_mActivity, R.drawable.ic_home_icon2, "优惠"))
        .addItem(new BottomBarTab(_mActivity, R.drawable.ic_home_icon3, "留言"))
        .addItem(new BottomBarTab(_mActivity, R.drawable.ic_home_icon4, "我的"));

    mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {

      @Override public void onTabSelected(int position, int prePosition) {
        Log.e("arilpan",
            "MainFragment onTabSelected position: " + position + ",prePosition:" + prePosition);
        showHideFragment(mFragments[position], mFragments[prePosition]);
      }

      @Override public void onTabUnselected(int position) {

      }

      @Override public void onTabReselected(int position) {
        //                EventBus.getDefault().post(new TabSelectedEvent(position));
        //                Log.e("arilpan", "MainFragment OnTabSelectedListener position: " + position);
        SupportFragment currentFragment = mFragments[position];
        if (currentFragment == null) {
          mFragments[FIRST] = IndexFragment.newInstance();
          mFragments[SECOND] = com.fan.eightrestaurant.ui.
              DiscountFragment.newInstance();
          //                    DiscountFragment.newInstance(APIConfig.shop_one_id);
          mFragments[THIRD] = LeaveMessageFragment.newInstance();
          mFragments[FOURTH] = MineFragment.newInstance();
        }

        int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();
        // 如果不在该类别Fragment的主页,则回到主页;
        if (count > 1) {
          if (currentFragment instanceof IndexFragment) {
            currentFragment.popToChild(IndexFragment.class, false);
          } else if (currentFragment instanceof LeaveMessageFragment) {
            currentFragment.popToChild(LeaveMessageFragment.class, false);
          } else if (currentFragment instanceof com.fan.eightrestaurant.ui.DiscountFragment) {
            currentFragment.popToChild(com.fan.eightrestaurant.ui.DiscountFragment.class, false);
          } else if (currentFragment instanceof MineFragment) {
            currentFragment.popToChild(MineFragment.class, false);
          }
          return;
        }
        // 这里推荐使用EventBus来实现 -> 解耦
        if (count == 1) {
          // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
          // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
          EventBus.getDefault().post(new TabSelectedEvent(position));
        }
      }
    });
  }

  @Override protected void onFragmentResult(int requestCode, int resultCode, Bundle data) {
    super.onFragmentResult(requestCode, resultCode, data);
    if (requestCode == REQ_MSG && resultCode == RESULT_OK) {

    }
  }

  private static final int REQ_MSG = 10;

  /**
   * start other BrotherFragment
   */
  @Subscribe public void startBrother(StartBrotherEvent event) {
    start(event.targetFragment);
  }

  @Override public void onDestroyView() {
    EventBus.getDefault().unregister(this);
    super.onDestroyView();
  }
}
