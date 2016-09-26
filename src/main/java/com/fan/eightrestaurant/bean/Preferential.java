package com.fan.eightrestaurant.bean;

import com.google.gson.Gson;

/**
 * Created by xdkj on 2016/8/18.
 */
public class Preferential {
  /**
   * discount_id : 1387b352-db15-449e-9423-b28baee159f0
   * shop_id : 36dbde58-5ab5-41b5-915c-66048e63a5df
   * shop_name : 8号菜馆
   * shop_pic : /GrogshopUpload/shop/20160801150220656iPadProPor.png
   * card_name : 里约奥运会优惠
   * card_rule : 8号菜馆，助力里约奥运会，全场五折起。       //名称
   * activity_start_time : 2016-08-09
   * activity_end_time : 2016-08-24        //活动结束时间
   * content_validity : 里约奥运会大幕已拉开。奥运会在里约举办，8号菜馆各种优惠，快来参加。  //内容
   * card_content : <p style="font-family: Arial, sans-serif; margin: 0px 3px 15px; padding: 0px;
   * line-height: 25px; color: rgb(85, 85, 85); font-size: 14px; white-space: normal; text-indent:
   * 30px; background-color: rgb(255, 255, 255);">里约奥运会大幕已拉开。奥运会在里约举办，一定程度上带动了世界各地体育爱好者、旅游爱好者赴南美旅游的热情，给巴西里约乃至整个南美旅游市场带来大量客源。</p><p
   * style="text-align:center">\
   * <img src="http://:8080/GrogshopSystem/../ueditor/Img/20160812/1470962331727071098.jpg"
   * title="1470962331727071098.jpg" alt="lyay.jpg"/></p><p style="font-family: Arial, sans-serif;
   * margin: 0px 3px 15px; padding: 0px; line-height: 25px; color: rgb(85, 85, 85); font-size: 14px;
   * white-space: normal; text-indent: 30px; background-color: rgb(255, 255,
   * 255);">8号菜馆为客户提供低价菜品优惠，助力奥运会，带给你在国内享受奥运带来的乐趣。</p><p style="font-family: Arial, sans-serif;
   * margin: 0px 3px 15px; padding: 0px; line-height: 25px; color: rgb(85, 85, 85); font-size: 14px;
   * white-space: normal; text-indent: 30px; background-color: rgb(255, 255,
   * 255);">8号菜馆在此提醒游客，优惠活动期间，请你们尽量提前享受，奥运期间，客户众多，提前为了避免客流高峰期给你们带来的不便。</p><p style="font-family:
   * Arial, sans-serif; margin: 0px 3px 15px; padding: 0px; line-height: 25px; color: rgb(85, 85,
   * 85); font-size: 14px; white-space: normal; text-indent: 30px; background-color: rgb(255, 255,
   * 255);">让我们为奥运健儿加油助威！</p><p style="text-align:center"><img src="http://:8080/GrogshopSystem/../ueditor/Img/20160812/1470962375340013096.jpg"
   * title="1470962375340013096.jpg" alt="lynh.jpg"/></p><p><br/></p>
   * card_type : 2
   * upload_url : /GrogshopUpload/discount/20160810084935979lyoyh.jpg     //图片地址
   * add_user : 测试管理员
   * add_time : 2016-08-09 16:51:33
   * update_user : 余游
   * update_time : 2016-08-16 08:47:46
   * del_user : null
   * del_flag : 0
   */

  private String discount_id;
  private String shop_id;
  private String shop_name;
  private String shop_pic;
  private String card_name;
  private String card_rule;
  private String activity_start_time;
  private String activity_end_time;
  private String content_validity;
  private String card_content;
  private String card_type;
  private String upload_url;
  private String add_user;
  private String add_time;
  private String update_user;
  private String update_time;
  private Object del_user;
  private String del_flag;

  public static Preferential objectFromData(String str) {

    return new Gson().fromJson(str, Preferential.class);
  }

  public String getDiscount_id() {
    return discount_id;
  }

  public void setDiscount_id(String discount_id) {
    this.discount_id = discount_id;
  }

  public String getShop_id() {
    return shop_id;
  }

  public void setShop_id(String shop_id) {
    this.shop_id = shop_id;
  }

  public String getShop_name() {
    return shop_name;
  }

  public void setShop_name(String shop_name) {
    this.shop_name = shop_name;
  }

  public String getShop_pic() {
    return shop_pic;
  }

  public void setShop_pic(String shop_pic) {
    this.shop_pic = shop_pic;
  }

  public String getCard_name() {
    return card_name;
  }

  public void setCard_name(String card_name) {
    this.card_name = card_name;
  }

  public String getCard_rule() {
    return card_rule;
  }

  public void setCard_rule(String card_rule) {
    this.card_rule = card_rule;
  }

  public String getActivity_start_time() {
    return activity_start_time;
  }

  public void setActivity_start_time(String activity_start_time) {
    this.activity_start_time = activity_start_time;
  }

  public String getActivity_end_time() {
    return activity_end_time;
  }

  public void setActivity_end_time(String activity_end_time) {
    this.activity_end_time = activity_end_time;
  }

  public String getContent_validity() {
    return content_validity;
  }

  public void setContent_validity(String content_validity) {
    this.content_validity = content_validity;
  }

  public String getCard_content() {
    return card_content;
  }

  public void setCard_content(String card_content) {
    this.card_content = card_content;
  }

  public String getCard_type() {
    return card_type;
  }

  public void setCard_type(String card_type) {
    this.card_type = card_type;
  }

  public String getUpload_url() {
    return upload_url;
  }

  public void setUpload_url(String upload_url) {
    this.upload_url = upload_url;
  }

  public String getAdd_user() {
    return add_user;
  }

  public void setAdd_user(String add_user) {
    this.add_user = add_user;
  }

  public String getAdd_time() {
    return add_time;
  }

  public void setAdd_time(String add_time) {
    this.add_time = add_time;
  }

  public String getUpdate_user() {
    return update_user;
  }

  public void setUpdate_user(String update_user) {
    this.update_user = update_user;
  }

  public String getUpdate_time() {
    return update_time;
  }

  public void setUpdate_time(String update_time) {
    this.update_time = update_time;
  }

  public Object getDel_user() {
    return del_user;
  }

  public void setDel_user(Object del_user) {
    this.del_user = del_user;
  }

  public String getDel_flag() {
    return del_flag;
  }

  public void setDel_flag(String del_flag) {
    this.del_flag = del_flag;
  }
}
