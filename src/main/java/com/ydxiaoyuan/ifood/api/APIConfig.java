package com.ydxiaoyuan.ifood.api;

/**
 * 服务器接口信息配置
 * Created by aril_pan@qq.com on 16-8-25.
 */
public class APIConfig {
  public static int select_mall = 0;
  public final static int ONE = 1;
  public final static int TWO = 2;
  public static String shop_one_id = "";
  public static String shop_two_id = "";

  /**
   * 对应下面的3种订单状态
   */
  public static int ORDER_CANCLE = 2;         //已取消订单
  public static int ORDER_COMPLETE = 1;       //已完成订单
  public static int ORDER_UNCOMPLETE = 0;     //未完成订单

  /**
   * *********************************************************************************************
   *
   * 用以下全局变量记录首页获取到的数据，对应下面“首页获取店铺信息和菜品信息”接口
   *
   * *********************************************************************************************
   */
  public static String user_id = "";
  public static String shop_one_name = "";
  public static String shop_two_name = "";
  public static String shop_one_addr = "";
  public static String shop_two_addr = "";
  public static String shop_one_work_time = "";
  public static String shop_two_work_time = "";
  public static String shop_one_icon = "";
  public static String shop_two_icon = "";
  public static String shop_one_phone = "";
  public static String shop_two_phone = "";

  /**
   * *********************************************************************************************
   *
   * 服务器端基本配置
   *
   * *********************************************************************************************
   */
  public static String dish_id = "23dbde58-5ab5-41b5-915c-66048e63a5df2324";
  public static String IP_PORT = "http://192.168.0.5:8080";
  //    public static String IP_PORT = "http://172.16.0.35:8080";
  public static String BASE_PROJECT_URL = IP_PORT + "/GrogshopSystem/app";
  public static String BASE_URL = IP_PORT + "/GrogshopSystem/app/appShop";
  public static String BASE_DISH_URL = IP_PORT + "/GrogshopSystem/app/appDishes";
  public static String BASE_NEWS_URL = IP_PORT + "/GrogshopSystem/app/News";
  public static String BASE_IMG_URL = IP_PORT;

  /**
   * *********************************************************************************************
   * 以下为具体API
   * 1. 首页信息
   * 2. 订单接口
   * 3. 其他接口
   * *********************************************************************************************
   */

  /**
   * *********************************************************************************************
   * 以下接口依次为：
   * 1. 首页获取店铺信息和菜品信息
   * 2. 获取店铺环境图片
   * 3. 菜品排行
   * 4. 热门--查看更多==>与排行一个接口
   * 5. 折扣菜品
   * 6. 新品尝鲜
   * 7. 餐厅详情
   * 8. 菜品详情
   * 9. 查看某个菜品的全部评论
   * *********************************************************************************************
   */
  public static String index_url =
      BASE_URL + "/shop_dishes_index.do?iDisplayStart=0&iDisplayLength=10";
  public static String index_shop_env_url = BASE_URL + "/shop_Picture_info.do?shop_id=";

  public static String dish_rank_url =
      BASE_URL + "/shop_dishes_info.do?iDisplayStart=###&iDisplayLength=$$$&org_id=";
  public static String dish_hot_more_url =
      BASE_URL + "/shop_dishes_info.do?iDisplayStart=###&iDisplayLength=$$$&org_id=";
  public static String dish_discount_url =
      BASE_URL + "/shop_discountDishes_info.do?iDisplayStart=###&iDisplayLength=$$$&org_id=";
  public static String dish_new_to_taste_url = BASE_URL
      + "/shop_dishes_info.do?label_type=新品尝鲜&iDisplayStart=###&iDisplayLength=$$$&org_id=";
  public static String shop_detail_url = BASE_URL + "/shop_info.do?org_id=";
  public static String dish_detail_url = BASE_DISH_URL + "/dishes_Detail.do?dishes_id=";
  public static String dish_list_comment_url =
      BASE_PROJECT_URL + "/appEvaluation/list_Evaluations.do?user_id=USERID&dishes_id=DISHID";

  /**
   * *********************************************************************************************
   * 以下为订单接口，接口依次为：
   * 1. 选菜左侧:标签类型列表和菜品类型列表
   * 2. 选菜右侧:根据左侧tagID来区分那个是对应父菜单,获取
   * 3. 选择包间
   * 4. 订单创建
   * 5. 订单删除
   * 6. 查看订单列表（有3中状态，对应上面的3种订单状态：订单取消，订单成功）
   * 7. 评论已完成订单中的某个菜品
   * *********************************************************************************************
   */
  public static String select_dish_left_url =
      BASE_URL + "/shop_dishesClassification_info.do?org_id=";
  public static String select_dish_right_url =
      BASE_URL + "/shop_ClassificatedDishes_info.do?org_id=";
  public static String dish_select_room_url = BASE_URL + "/shop_room_info.do?org_id=";
  public static String order_create = BASE_PROJECT_URL + "/appOrder/addAndroidOrder.do?";
  public static String order_delete = BASE_PROJECT_URL + "/appOrder/deleteOrders.do?order_id=";
  public static String order_list_url =
      BASE_PROJECT_URL + "/appOrder/list_Order.do?user_id=USERID&order_status=";
  public static String order_cancel_url = BASE_PROJECT_URL + "/appOrder/cancelOrders.do?order_id=";
  public static String dish_comment_url = BASE_PROJECT_URL
      + "/appEvaluation/saveAddEvaluations.do?user_id=USERID&dishes_id=DISHID&content=CONTENT";

  /**
   * *********************************************************************************************
   * 以下为补充接口，接口依次为：
   * 1. 查看充值优惠（注：后来另加功能，获取列表，然后获取html5网页，查看页面详情)
   * 2. 新闻列表
   * 3. 单个新闻详情（服务器端新闻未做分页）
   * *********************************************************************************************
   */
  public static String recharge_discount_new_url =
      BASE_URL + "/shop_RechargeDiscount_info.do?shop_id=";
  public static String news_list_url =
      BASE_NEWS_URL + "/appListNews.do?iDisplayStart=###&iDisplayLength=$$$";
  public static String news_detail_url = BASE_NEWS_URL + "/appShowNews.do?news_id=";
}