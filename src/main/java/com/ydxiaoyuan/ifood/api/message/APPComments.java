package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-9-9.
 */
public class APPComments {

  /**
   * success : true
   * message :
   * messageList : null
   * messageList1 : null
   * messageList2 : null
   * messageList3 : null
   * messageList4 : null
   * messageList5 : null
   * messageList6 : null
   * messageList7 : null
   * messageList8 : null
   * code : 0
   * value : [{"evaluation_id":"6052418b-2e42-465a-83b9-e2bd8497b48b",
   * "order_id":"2d553a93-ea7e-4e9a-95ed-d907abf5cfbb","user_id":"15826666277",
   * "dishes_id":"08d8a4b3-c063-4efa-95c5-b676c35d6e07","nickname":"木头人",
   * "user_icon":"/GrogshopUpload/appUserImg/201609061425413791473143139823.jpg","content":"",
   * "evaluation_time":"2016-09-09 10:11:09","del_flag":"0"},
   * {"evaluation_id":"945ff460-d94d-4b62-9586-736a09500fd0",
   * "order_id":"2d553a93-ea7e-4e9a-95ed-d907abf5cfbb","user_id":"15826666277",
   * "dishes_id":"08d8a4b3-c063-4efa-95c5-b676c35d6e07","nickname":"木头人",
   * "user_icon":"/GrogshopUpload/appUserImg/201609061425413791473143139823.jpg","content":"",
   * "evaluation_time":"2016-09-07 17:10:00","del_flag":"0"},
   * {"evaluation_id":"d002b186-8b96-4bd6-8078-ecd5574d4caf",
   * "order_id":"2d553a93-ea7e-4e9a-95ed-d907abf5cfbb","user_id":"15826666277",
   * "dishes_id":"08d8a4b3-c063-4efa-95c5-b676c35d6e07","nickname":"木头人",
   * "user_icon":"/GrogshopUpload/appUserImg/201609061425413791473143139823.jpg","content":"",
   * "evaluation_time":"2016-09-07 17:07:49","del_flag":"0"},
   * {"evaluation_id":"c76f60df-4f71-44f0-bf65-025e3acb2869",
   * "order_id":"2d553a93-ea7e-4e9a-95ed-d907abf5cfbb","user_id":"15826666277",
   * "dishes_id":"08d8a4b3-c063-4efa-95c5-b676c35d6e07","nickname":"木头人",
   * "user_icon":"/GrogshopUpload/appUserImg/201609061425413791473143139823.jpg","content":"",
   * "evaluation_time":"2016-09-07 17:07:37","del_flag":"0"},
   * {"evaluation_id":"16de28c0-3b67-473c-8095-d84705d6b412",
   * "order_id":"2d553a93-ea7e-4e9a-95ed-d907abf5cfbb","user_id":"15826666277",
   * "dishes_id":"08d8a4b3-c063-4efa-95c5-b676c35d6e07","nickname":"木头人",
   * "user_icon":"/GrogshopUpload/appUserImg/201609061425413791473143139823.jpg","content":"",
   * "evaluation_time":"2016-09-07 17:00:42","del_flag":"0"},
   * {"evaluation_id":"b9faed21-7723-4c7d-bc07-0c6a5011e223",
   * "order_id":"2d553a93-ea7e-4e9a-95ed-d907abf5cfbb","user_id":"15826666277",
   * "dishes_id":"08d8a4b3-c063-4efa-95c5-b676c35d6e07","nickname":"木头人",
   * "user_icon":"/GrogshopUpload/appUserImg/201609061425413791473143139823.jpg","content":"",
   * "evaluation_time":"2016-09-07 17:00:35","del_flag":"0"}]
   * value1 : null
   * errcode : null
   * errmsg : null
   * datas : null
   * pageNo : 0
   * pages : 0
   */

  private boolean success;
  private String message;
  private Object messageList;
  private Object messageList1;
  private Object messageList2;
  private Object messageList3;
  private Object messageList4;
  private Object messageList5;
  private Object messageList6;
  private Object messageList7;
  private Object messageList8;
  private int code;
  private Object value1;
  private Object errcode;
  private Object errmsg;
  private Object datas;
  private int pageNo;
  private int pages;
  /**
   * evaluation_id : 6052418b-2e42-465a-83b9-e2bd8497b48b
   * order_id : 2d553a93-ea7e-4e9a-95ed-d907abf5cfbb
   * user_id : 15826666277
   * dishes_id : 08d8a4b3-c063-4efa-95c5-b676c35d6e07
   * nickname : 木头人
   * user_icon : /GrogshopUpload/appUserImg/201609061425413791473143139823.jpg
   * content :
   * evaluation_time : 2016-09-09 10:11:09
   * del_flag : 0
   */

  private List<ValueBean> value;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getMessageList() {
    return messageList;
  }

  public void setMessageList(Object messageList) {
    this.messageList = messageList;
  }

  public Object getMessageList1() {
    return messageList1;
  }

  public void setMessageList1(Object messageList1) {
    this.messageList1 = messageList1;
  }

  public Object getMessageList2() {
    return messageList2;
  }

  public void setMessageList2(Object messageList2) {
    this.messageList2 = messageList2;
  }

  public Object getMessageList3() {
    return messageList3;
  }

  public void setMessageList3(Object messageList3) {
    this.messageList3 = messageList3;
  }

  public Object getMessageList4() {
    return messageList4;
  }

  public void setMessageList4(Object messageList4) {
    this.messageList4 = messageList4;
  }

  public Object getMessageList5() {
    return messageList5;
  }

  public void setMessageList5(Object messageList5) {
    this.messageList5 = messageList5;
  }

  public Object getMessageList6() {
    return messageList6;
  }

  public void setMessageList6(Object messageList6) {
    this.messageList6 = messageList6;
  }

  public Object getMessageList7() {
    return messageList7;
  }

  public void setMessageList7(Object messageList7) {
    this.messageList7 = messageList7;
  }

  public Object getMessageList8() {
    return messageList8;
  }

  public void setMessageList8(Object messageList8) {
    this.messageList8 = messageList8;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public Object getValue1() {
    return value1;
  }

  public void setValue1(Object value1) {
    this.value1 = value1;
  }

  public Object getErrcode() {
    return errcode;
  }

  public void setErrcode(Object errcode) {
    this.errcode = errcode;
  }

  public Object getErrmsg() {
    return errmsg;
  }

  public void setErrmsg(Object errmsg) {
    this.errmsg = errmsg;
  }

  public Object getDatas() {
    return datas;
  }

  public void setDatas(Object datas) {
    this.datas = datas;
  }

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public List<ValueBean> getValue() {
    return value;
  }

  public void setValue(List<ValueBean> value) {
    this.value = value;
  }

  public static class ValueBean {
    private String evaluation_id;
    private String order_id;
    private String user_id;
    private String dishes_id;
    private String nickname;
    private String user_icon;
    private String content;
    private String evaluation_time;
    private String del_flag;

    public String getEvaluation_id() {
      return evaluation_id;
    }

    public void setEvaluation_id(String evaluation_id) {
      this.evaluation_id = evaluation_id;
    }

    public String getOrder_id() {
      return order_id;
    }

    public void setOrder_id(String order_id) {
      this.order_id = order_id;
    }

    public String getUser_id() {
      return user_id;
    }

    public void setUser_id(String user_id) {
      this.user_id = user_id;
    }

    public String getDishes_id() {
      return dishes_id;
    }

    public void setDishes_id(String dishes_id) {
      this.dishes_id = dishes_id;
    }

    public String getNickname() {
      return nickname;
    }

    public void setNickname(String nickname) {
      this.nickname = nickname;
    }

    public String getUser_icon() {
      return user_icon;
    }

    public void setUser_icon(String user_icon) {
      this.user_icon = user_icon;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public String getEvaluation_time() {
      return evaluation_time;
    }

    public void setEvaluation_time(String evaluation_time) {
      this.evaluation_time = evaluation_time;
    }

    public String getDel_flag() {
      return del_flag;
    }

    public void setDel_flag(String del_flag) {
      this.del_flag = del_flag;
    }
  }
}

