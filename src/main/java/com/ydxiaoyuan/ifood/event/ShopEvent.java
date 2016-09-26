package com.ydxiaoyuan.ifood.event;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by arilpan@qq.com on 16/8/2.
 */
public class ShopEvent {
  public SupportFragment targetFragment;

  public ShopEvent() {
  }

  public ShopEvent(SupportFragment targetFragment) {
    this.targetFragment = targetFragment;
  }
}
