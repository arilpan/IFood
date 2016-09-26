package com.ydxiaoyuan.ifood.entity;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-8-16.
 */
public class Order {
  private int id;
  private String shopId;
  private String shopName;
  private String totalPrice;
  private String pre_order_time;
  private List<Dish> dishes;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getShopId() {
    return shopId;
  }

  public void setShopId(String shopId) {
    this.shopId = shopId;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public String getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getPre_order_time() {
    return pre_order_time;
  }

  public void setPre_order_time(String pre_order_time) {
    this.pre_order_time = pre_order_time;
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public void setDishes(List<Dish> dishes) {
    this.dishes = dishes;
  }
}
