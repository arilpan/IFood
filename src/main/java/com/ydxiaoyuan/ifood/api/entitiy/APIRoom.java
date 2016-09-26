package com.ydxiaoyuan.ifood.api.entitiy;

/**
 * room_title（包间名称），room_prise（包间价格），room_people（可容纳人数），
 * room_purl（包间图片）， room_content（包间说明），room_state（包间状态）
 * Created by aril_pan@qq.com on 16-8-25.
 */
public class APIRoom {
  /**
   * <p>
   * room_id : 704bcffa-c85b-4cb0-850b-9365e072f454
   * room_title : 荷花厅
   * room_people : 12
   * room_purl : null
   * room_content : 这是一个实惠的包间，具体介绍请看链接。http://hehuatin.com
   * room_state : 0
   * createtime : 2016-08-10 16:28:15
   * createuser : 测试管理员
   * updatetime : 2016-08-18 10:40:41
   * updateuser : 总店长
   * delflag : 0
   * deluser : null
   * hotel_id : 36dbde58-5ab5-41b5-915c-66048e63a5df
   * hotel_title : 8号土菜馆
   */

  private String room_id;
  private String room_title;
  private String room_people;
  private Object room_purl;
  private String room_content;
  private String room_state;
  private String createtime;
  private String createuser;
  private String updatetime;
  private String updateuser;
  private String delflag;
  private Object deluser;
  private String hotel_id;
  private String hotel_title;

  public String getRoom_id() {
    return room_id;
  }

  public void setRoom_id(String room_id) {
    this.room_id = room_id;
  }

  public String getRoom_title() {
    return room_title;
  }

  public void setRoom_title(String room_title) {
    this.room_title = room_title;
  }

  public String getRoom_people() {
    return room_people;
  }

  public void setRoom_people(String room_people) {
    this.room_people = room_people;
  }

  public Object getRoom_purl() {
    return room_purl;
  }

  public void setRoom_purl(Object room_purl) {
    this.room_purl = room_purl;
  }

  public String getRoom_content() {
    return room_content;
  }

  public void setRoom_content(String room_content) {
    this.room_content = room_content;
  }

  public String getRoom_state() {
    return room_state;
  }

  public void setRoom_state(String room_state) {
    this.room_state = room_state;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public String getCreateuser() {
    return createuser;
  }

  public void setCreateuser(String createuser) {
    this.createuser = createuser;
  }

  public String getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
  }

  public String getUpdateuser() {
    return updateuser;
  }

  public void setUpdateuser(String updateuser) {
    this.updateuser = updateuser;
  }

  public String getDelflag() {
    return delflag;
  }

  public void setDelflag(String delflag) {
    this.delflag = delflag;
  }

  public Object getDeluser() {
    return deluser;
  }

  public void setDeluser(Object deluser) {
    this.deluser = deluser;
  }

  public String getHotel_id() {
    return hotel_id;
  }

  public void setHotel_id(String hotel_id) {
    this.hotel_id = hotel_id;
  }

  public String getHotel_title() {
    return hotel_title;
  }

  public void setHotel_title(String hotel_title) {
    this.hotel_title = hotel_title;
  }
}
