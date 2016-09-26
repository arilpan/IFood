package com.ydxiaoyuan.ifood.api;

/**
 * Created by aril_pan@qq.com on 16-8-23.
 */
public class RequestType {
  //user
  public final static int LOGIN = 1;
  public final static int REGISTE = 1;

  //order
  public final static int ORDER_CANCEL_LIST = 11;
  public final static int ORDER_COMPLETE_LIST = 12;
  public final static int ORDER_UNCOMPLETE_LIST = 13;
  public final static int ORDER_DETAIL = 14;

  //index-dish
  public final static int INDEX_ALL = 31;
  public final static int INDEX_SHOP_ENV = 311;
  public final static int INDEX_DISH_NEW = 32;
  public final static int INDEX_DISH_RANK = 33;
  public final static int INDEX_DISH_DISCOUNT = 34;
  public final static int INDEX_DISH_HOT = 35;
  public final static int INDEX_DISH_DETAIL = 36;
  public final static int INDEX_DISH_SELECT_LEFT = 37;
  public final static int INDEX_DISH_SELECT_RIGHT = 38;
  public final static int INDEX_DISH_SELECT_ROOM = 39;

  //news
  public final static int NEWS_LIST = 41;
  public final static int NEWS_DETAIL = 42;

  //discount
  public final static int DISCOUNT_CARD_LIST = 50;
  public final static int DISCOUNT_LIST = 51;
  public final static int DISCOUNT_DETAIL = 52;

  //action
  public final static int ORDER_LIST = 91;
  public final static int ORDER_CANCEL = 92;
  public final static int ORDER_COMMENT = 93;
  public final static int ORDER_DELETE = 94;
  public final static int ORDER_UPLOAD = 95;
  public final static int ORDER_LIST_COMMENT = 96;
}
