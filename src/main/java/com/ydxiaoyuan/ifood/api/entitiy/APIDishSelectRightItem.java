package com.ydxiaoyuan.ifood.api.entitiy;

/**
 * 选菜接口
 * Created by aril_pan@qq.com on 16-8-25.
 */
public class APIDishSelectRightItem {

  /**
   * tagID : 2
   * type : null
   * dishes_name : 清蒸江桂鱼
   * dishes_price : 64.00
   * dishes_id : b6145030-ae45-4848-8f50-0a8e67425623
   * upload_url : /GrogshopUpload/dishes/20160810160225733qzjgy.jpg
   * list : null
   */

  private String tagID;
  private Object type;
  private String dishes_name;
  private String dishes_price;
  private String dishes_id;
  private String upload_url;
  private Object list;

  public String getTagID() {
    return tagID;
  }

  public void setTagID(String tagID) {
    this.tagID = tagID;
  }

  public Object getType() {
    return type;
  }

  public void setType(Object type) {
    this.type = type;
  }

  public String getDishes_name() {
    return dishes_name;
  }

  public void setDishes_name(String dishes_name) {
    this.dishes_name = dishes_name;
  }

  public String getDishes_price() {
    return dishes_price;
  }

  public void setDishes_price(String dishes_price) {
    this.dishes_price = dishes_price;
  }

  public String getDishes_id() {
    return dishes_id;
  }

  public void setDishes_id(String dishes_id) {
    this.dishes_id = dishes_id;
  }

  public String getUpload_url() {
    return upload_url;
  }

  public void setUpload_url(String upload_url) {
    this.upload_url = upload_url;
  }

  public Object getList() {
    return list;
  }

  public void setList(Object list) {
    this.list = list;
  }
}
