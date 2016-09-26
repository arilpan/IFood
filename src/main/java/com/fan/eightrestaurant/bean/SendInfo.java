package com.fan.eightrestaurant.bean;

import java.lang.reflect.Type;

/**
 * Created by xdkj on 2016/8/12.
 */
public class SendInfo {

  /**
   * back_id : 1
   * hotel_id : 36dbde58-5ab5-41b5-915c-66048e63a5df
   * user_id : 059a286f-f743-421a-8fa6-5123c9367574
   * back_content : 大点
   * createtime : 2016-07-25 11:05:05
   * createuser_id : 059a286f-f743-421a-8fa6-5123c9367574
   * createuser : 测试管理员
   * deluser : null
   * delflag : null
   * back_state : 1
   * m_state : null
   */

  private String back_id;
  private String hotel_id;
  private String user_id;
  private String back_content;
  private String createtime;
  private String createuser_id;
  private String createuser;
  private Object deluser;
  private Object delflag;
  private int back_state;
  private Object m_state;

  public String getBack_id() {
    return back_id;
  }

  public void setBack_id(String back_id) {
    this.back_id = back_id;
  }

  public String getHotel_id() {
    return hotel_id;
  }

  public void setHotel_id(String hotel_id) {
    this.hotel_id = hotel_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getBack_content() {
    return back_content;
  }

  public void setBack_content(String back_content) {
    this.back_content = back_content;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public String getCreateuser_id() {
    return createuser_id;
  }

  public void setCreateuser_id(String createuser_id) {
    this.createuser_id = createuser_id;
  }

  public String getCreateuser() {
    return createuser;
  }

  public void setCreateuser(String createuser) {
    this.createuser = createuser;
  }

  public Object getDeluser() {
    return deluser;
  }

  public void setDeluser(Object deluser) {
    this.deluser = deluser;
  }

  public Object getDelflag() {
    return delflag;
  }

  public void setDelflag(Object delflag) {
    this.delflag = delflag;
  }

  public int getBack_state() {
    return back_state;
  }

  public void setBack_state(int back_state) {
    this.back_state = back_state;
  }

  public Object getM_state() {
    return m_state;
  }

  public void setM_state(Object m_state) {
    this.m_state = m_state;
  }
}
