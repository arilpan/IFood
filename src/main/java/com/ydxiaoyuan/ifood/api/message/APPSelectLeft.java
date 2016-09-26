package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-8-26.
 */
public class APPSelectLeft {
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
   * value : [{"tagID":"1","type":"热门推荐","dishes_name":null,"dishes_price":null,
   * "dishes_id":null,"upload_url":null,"list":null},{"tagID":"3","type":"新品尝鲜",
   * "dishes_name":null,"dishes_price":null,"dishes_id":null,"upload_url":null,"list":null},
   * {"tagID":"2","type":"精品套餐","dishes_name":null,"dishes_price":null,"dishes_id":null,
   * "upload_url":null,"list":null},{"tagID":"8","type":"热菜类","dishes_name":null,
   * "dishes_price":null,"dishes_id":null,"upload_url":null,"list":null},{"tagID":"11",
   * "type":"果汁类","dishes_name":null,"dishes_price":null,"dishes_id":null,"upload_url":null,
   * "list":null},{"tagID":"9","type":"冷菜类","dishes_name":null,"dishes_price":null,
   * "dishes_id":null,"upload_url":null,"list":null}]
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
   * tagID : 1
   * type : 热门推荐
   * dishes_name : null
   * dishes_price : null
   * dishes_id : null
   * upload_url : null
   * list : null
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
    private String tagID;
    private String type;
    private Object dishes_name;
    private Object dishes_price;
    private Object dishes_id;
    private Object upload_url;
    private Object list;

    public String getTagID() {
      return tagID;
    }

    public void setTagID(String tagID) {
      this.tagID = tagID;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public Object getDishes_name() {
      return dishes_name;
    }

    public void setDishes_name(Object dishes_name) {
      this.dishes_name = dishes_name;
    }

    public Object getDishes_price() {
      return dishes_price;
    }

    public void setDishes_price(Object dishes_price) {
      this.dishes_price = dishes_price;
    }

    public Object getDishes_id() {
      return dishes_id;
    }

    public void setDishes_id(Object dishes_id) {
      this.dishes_id = dishes_id;
    }

    public Object getUpload_url() {
      return upload_url;
    }

    public void setUpload_url(Object upload_url) {
      this.upload_url = upload_url;
    }

    public Object getList() {
      return list;
    }

    public void setList(Object list) {
      this.list = list;
    }
  }
}
