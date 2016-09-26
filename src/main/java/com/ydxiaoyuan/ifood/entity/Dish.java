package com.ydxiaoyuan.ifood.entity;

/**
 * Created by arilpan@qq.com on 2016/8/8.
 */
public class Dish {
  private int id;
  private String dish_id;
  private String name;
  private int img;
  private String imgurl;
  private String desc;
  private String price;
  private String mallprice;
  private String preOrder;
  private int num;

  @Override public String toString() {
    String res = "id: "
        + getId()
        + " , num :"
        + getName()
        + " ,name "
        + getName()
        + ",mallPrice "
        + getMallprice()
        + " ,desc "
        + getDesc()
        + ",price "
        + getPrice();
    return res;
  }

  public Dish() {

  }

  public Dish(String name, String desc, String price) {
    this.name = name;
    this.desc = desc;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDish_id() {
    return dish_id;
  }

  public void setDish_id(String dish_id) {
    this.dish_id = dish_id;
  }

  public String getMallprice() {
    return mallprice;
  }

  public void setMallprice(String mallprice) {
    this.mallprice = mallprice;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getImg() {
    return img;
  }

  public void setImg(int img) {
    this.img = img;
  }

  public String getImgurl() {
    return imgurl;
  }

  public void setImgurl(String imgurl) {
    this.imgurl = imgurl;
  }

  public String getPreOrder() {
    return preOrder;
  }

  public void setPreOrder(String preOrder) {
    this.preOrder = preOrder;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
