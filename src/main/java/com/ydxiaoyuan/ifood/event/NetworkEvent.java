package com.ydxiaoyuan.ifood.event;

import com.ydxiaoyuan.ifood.api.APIConfigFactory;

/**
 * Created by aril_pan@qq.com on 16-8-23.
 */
public class NetworkEvent {
  public String url;
  public int reqType;
  public String id;

  public NetworkEvent() {
  }

  public NetworkEvent(int reqType, String id) {
    this.id = id;
    this.reqType = reqType;
    this.url = APIConfigFactory.createURL(reqType);
  }

  public NetworkEvent(int reqType) {
    this(reqType, "");
  }
}
