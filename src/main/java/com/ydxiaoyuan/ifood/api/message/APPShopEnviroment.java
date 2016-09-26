package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-8-28.
 */
public class APPShopEnviroment {
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
   * value : [{"picture_id":"5cbd3ba0-ca38-477e-a4a1-8f35a733e075",
   * "shop_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","picture_name":"8号土菜馆外场轮播图",
   * "upload_url":"/GrogshopUpload/picture/201608221731593878hcgwc.jpg","add_time":"2016-08-22
   * 17:32:02","add_user":"菜馆店长","update_time":null,"update_user":null,"del_user":null,
   * "del_flag":"0"},{"picture_id":"5fa0cf90-0582-4f54-b638-5fad5274ebaf",
   * "shop_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","picture_name":"8号土菜馆内场轮播图",
   * "upload_url":"/GrogshopUpload/picture/201608221729464968hcgnc.jpg","add_time":"2016-08-22
   * 17:29:49","add_user":"菜馆店长","update_time":null,"update_user":null,"del_user":null,
   * "del_flag":"0"}]
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
   * picture_id : 5cbd3ba0-ca38-477e-a4a1-8f35a733e075
   * shop_id : 36dbde58-5ab5-41b5-915c-66048e63a5df
   * picture_name : 8号土菜馆外场轮播图
   * upload_url : /GrogshopUpload/picture/201608221731593878hcgwc.jpg
   * add_time : 2016-08-22 17:32:02
   * add_user : 菜馆店长
   * update_time : null
   * update_user : null
   * del_user : null
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
    private String picture_id;
    private String shop_id;
    private String picture_name;
    private String upload_url;
    private String add_time;
    private String add_user;
    private Object update_time;
    private Object update_user;
    private Object del_user;
    private String del_flag;

    public String getPicture_id() {
      return picture_id;
    }

    public void setPicture_id(String picture_id) {
      this.picture_id = picture_id;
    }

    public String getShop_id() {
      return shop_id;
    }

    public void setShop_id(String shop_id) {
      this.shop_id = shop_id;
    }

    public String getPicture_name() {
      return picture_name;
    }

    public void setPicture_name(String picture_name) {
      this.picture_name = picture_name;
    }

    public String getUpload_url() {
      return upload_url;
    }

    public void setUpload_url(String upload_url) {
      this.upload_url = upload_url;
    }

    public String getAdd_time() {
      return add_time;
    }

    public void setAdd_time(String add_time) {
      this.add_time = add_time;
    }

    public String getAdd_user() {
      return add_user;
    }

    public void setAdd_user(String add_user) {
      this.add_user = add_user;
    }

    public Object getUpdate_time() {
      return update_time;
    }

    public void setUpdate_time(Object update_time) {
      this.update_time = update_time;
    }

    public Object getUpdate_user() {
      return update_user;
    }

    public void setUpdate_user(Object update_user) {
      this.update_user = update_user;
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
}
