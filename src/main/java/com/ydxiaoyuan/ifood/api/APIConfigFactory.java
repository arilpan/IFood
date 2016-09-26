package com.ydxiaoyuan.ifood.api;

/**
 * 获取相应的服务器地址
 * Created by aril_pan@qq.com on 16-8-26.
 */
public class APIConfigFactory {
  public static String createURL(int reqType) {
    switch (reqType) {
      case RequestType.INDEX_ALL:
        return APIConfig.index_url;
      case RequestType.INDEX_DISH_SELECT_LEFT:
        return APIConfig.select_dish_left_url;
      case RequestType.INDEX_DISH_SELECT_RIGHT:
        return APIConfig.select_dish_right_url;
      case RequestType.INDEX_DISH_RANK:
        return APIConfig.dish_rank_url;
      case RequestType.INDEX_DISH_HOT:
        return APIConfig.dish_hot_more_url;
      case RequestType.INDEX_DISH_DISCOUNT:
        return APIConfig.dish_discount_url;
      case RequestType.INDEX_DISH_NEW:
        return APIConfig.dish_new_to_taste_url;
      case RequestType.INDEX_DISH_SELECT_ROOM:
        return APIConfig.dish_select_room_url;
      case RequestType.INDEX_DISH_DETAIL:
        return APIConfig.dish_detail_url;
      case RequestType.DISCOUNT_LIST:
        return APIConfig.recharge_discount_new_url;
      case RequestType.NEWS_LIST:
        return APIConfig.news_list_url;
      case RequestType.NEWS_DETAIL:
        return APIConfig.news_detail_url;
      case RequestType.ORDER_LIST:
        return APIConfig.order_list_url;
      case RequestType.ORDER_CANCEL:
        return APIConfig.order_cancel_url;
      case RequestType.ORDER_COMMENT:
        return APIConfig.dish_comment_url;
      case RequestType.INDEX_SHOP_ENV:
        return APIConfig.index_shop_env_url;
      case RequestType.DISCOUNT_CARD_LIST:
        return APIConfig.recharge_discount_new_url;
      case RequestType.ORDER_DELETE:
        return APIConfig.order_delete;
      case RequestType.ORDER_UPLOAD:
        return APIConfig.order_create;
      case RequestType.ORDER_LIST_COMMENT:
        return APIConfig.dish_list_comment_url;
      //            case RequestType.INDEX_ALL:
      //                return  APIConfig.shop_detail_url;
      //                break;
    }
    return null;
  }
}
