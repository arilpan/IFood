package com.ydxiaoyuan.ifood.entity;

/**
 * Created by aril_pan@qq.com on 2016/8/3.
 */
public class Recharge {
  private int id;
  private String image;
  private int backgoundRes;
  private int mallRes;
  private String mall_name;
  private String card_name;
  private String desc;
  private String time;

  public Recharge(int id, String image, String mall_name, String card_name, String desc,
      String time) {
    this.id = id;
    this.image = image;
    this.mall_name = mall_name;
    this.card_name = card_name;
    this.desc = desc;
    this.time = time;
  }

  public Recharge(int id, int mallRes, String mall_name, String card_name, String desc,
      String time) {
    this.id = id;
    this.mallRes = mallRes;
    this.mall_name = mall_name;
    this.card_name = card_name;
    this.desc = desc;
    this.time = time;
  }

  public int getMallRes() {
    return mallRes;
  }

  public void setMallRes(int mallRes) {
    this.mallRes = mallRes;
  }

  public int getBackgoundRes() {
    return backgoundRes;
  }

  public void setBackgoundRes(int backgoundRes) {
    this.backgoundRes = backgoundRes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getMall_name() {
    return mall_name;
  }

  public void setMall_name(String mall_name) {
    this.mall_name = mall_name;
  }

  public String getCard_name() {
    return card_name;
  }

  public void setCard_name(String card_name) {
    this.card_name = card_name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }
}
