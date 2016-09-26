package com.fan.eightrestaurant.bean;

import com.google.gson.Gson;

/**
 * Created by xdkj on 2016/8/11.
 */
public class LeaveMessage {

  /**
   * m_id : 41e4e088-8e6f-4ce4-b6d5-b1d48dc9d33a
   * m_title : 有宵夜提供么？
   * m_content : 暂时不提供宵夜服务。
   * m_type : 1
   * m_state : null
   * hotel_id : null
   * hotel_name : null
   * createtime : 2016-07-28 11:04:01
   * createuser_id : null
   * createuser : null
   * updatetime : null
   * updateuser : null
   * deluser : null
   * delflag : null
   */

  private String m_id;
  private String m_title;
  private String m_content;
  private String m_type;
  private Object m_state;
  private Object hotel_id;
  private Object hotel_name;
  private String createtime;
  private Object createuser_id;
  private Object createuser;
  private Object updatetime;
  private Object updateuser;
  private Object deluser;
  private Object delflag;

  public static LeaveMessage objectFromData(String str) {

    return new Gson().fromJson(str, LeaveMessage.class);
  }

  public String getM_id() {
    return m_id;
  }

  public String setM_id(String m_id) {
    this.m_id = m_id;
    return m_id;
  }

  public String getM_title() {
    return m_title;
  }

  public void setM_title(String m_title) {
    this.m_title = m_title;
  }

  public String getM_content() {
    return m_content;
  }

  public void setM_content(String m_content) {
    this.m_content = m_content;
  }

  public String getM_type() {
    return m_type;
  }

  public void setM_type(String m_type) {
    this.m_type = m_type;
  }

  public Object getM_state() {
    return m_state;
  }

  public void setM_state(Object m_state) {
    this.m_state = m_state;
  }

  public Object getHotel_id() {
    return hotel_id;
  }

  public void setHotel_id(Object hotel_id) {
    this.hotel_id = hotel_id;
  }

  public Object getHotel_name() {
    return hotel_name;
  }

  public void setHotel_name(Object hotel_name) {
    this.hotel_name = hotel_name;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public Object getCreateuser_id() {
    return createuser_id;
  }

  public void setCreateuser_id(Object createuser_id) {
    this.createuser_id = createuser_id;
  }

  public Object getCreateuser() {
    return createuser;
  }

  public void setCreateuser(Object createuser) {
    this.createuser = createuser;
  }

  public Object getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(Object updatetime) {
    this.updatetime = updatetime;
  }

  public Object getUpdateuser() {
    return updateuser;
  }

  public void setUpdateuser(Object updateuser) {
    this.updateuser = updateuser;
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
}
