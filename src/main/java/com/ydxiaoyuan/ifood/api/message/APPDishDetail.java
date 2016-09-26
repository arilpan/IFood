package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-8-26.
 */
public class APPDishDetail {
  /**
   * success : true
   * message : null
   * messageList : []
   * messageList1 : null
   * messageList2 : null
   * messageList3 : null
   * messageList4 : null
   * messageList5 : null
   * messageList6 : null
   * messageList7 : null
   * messageList8 : null
   * code : 0
   * value : {"dishes_id":"23dbde58-5ab5-41b5-915c-66048e63a5df2324",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810145854103gyxqme.jpeg","dishes_name":"豉油雪炝木耳
   * ","dishes_price":"16.00","rack_rate":"16.00","dishes_description":"豉油雪炝木耳
   * ，味道鲜美，木耳纯天然，肉质细嫩。","appointment_notice":"提前两小时预定哦","purchase_count":265,
   * "purchase_persons":null,"dishes_select_status":null,"discount_type":"0",
   * "add_user":"测试管理员","add_time":"2015-07-26 16:34:03","update_user":"测试管理员",
   * "update_time":"2016-08-10 14:58:55","del_user":null,"del_flag":"0"}
   * value1 : {"org_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","org_name":"8号土菜馆",
   * "parent_org_id":null,"parent_org_name":null,
   * "icon":"/GrogshopUpload/shop/20160816111258440logo2_03.png","address":"南京市江宁区龙眠大道181号",
   * "description":"8号菜馆有很多好吃的哦！","shop_work_time":"早8:00-晚22:00","phone":"13569874564",
   * "createtime":"2016-07-25 11:05:05","createuser":"admin",
   * "createuser_id":"059a286f-f743-421a-8fa6-5123c9367574","updatetime":"2016-08-22 15:16:22",
   * "updateuser":"菜馆店长","delflag":"0","deluser":"admin"}
   * errcode : null
   * errmsg : null
   * datas : null
   * pageNo : 0
   * pages : 0
   */

  private boolean success;
  private Object message;
  private Object messageList1;
  private Object messageList2;
  private Object messageList3;
  private Object messageList4;
  private Object messageList5;
  private Object messageList6;
  private Object messageList7;
  private Object messageList8;
  private Integer code;
  /**
   * dishes_id : 23dbde58-5ab5-41b5-915c-66048e63a5df2324
   * store_id : 36dbde58-5ab5-41b5-915c-66048e63a5df
   * store_name : 8号土菜馆
   * user_id : null
   * dishes_type : 冷菜类
   * label_type : 新品尝鲜
   * package_type :
   * upload_url : /GrogshopUpload/dishes/20160810145854103gyxqme.jpeg
   * dishes_name : 豉油雪炝木耳
   * dishes_price : 16.00
   * rack_rate : 16.00
   * dishes_description : 豉油雪炝木耳 ，味道鲜美，木耳纯天然，肉质细嫩。
   * appointment_notice : 提前两小时预定哦
   * purchase_count : 265
   * purchase_persons : null
   * dishes_select_status : null
   * discount_type : 0
   * add_user : 测试管理员
   * add_time : 2015-07-26 16:34:03
   * update_user : 测试管理员
   * update_time : 2016-08-10 14:58:55
   * del_user : null
   * del_flag : 0
   */

  private ValueBean value;
  /**
   * org_id : 36dbde58-5ab5-41b5-915c-66048e63a5df
   * org_name : 8号土菜馆
   * parent_org_id : null
   * parent_org_name : null
   * icon : /GrogshopUpload/shop/20160816111258440logo2_03.png
   * address : 南京市江宁区龙眠大道181号
   * description : 8号菜馆有很多好吃的哦！
   * shop_work_time : 早8:00-晚22:00
   * phone : 13569874564
   * createtime : 2016-07-25 11:05:05
   * createuser : admin
   * createuser_id : 059a286f-f743-421a-8fa6-5123c9367574
   * updatetime : 2016-08-22 15:16:22
   * updateuser : 菜馆店长
   * delflag : 0
   * deluser : admin
   */

  private Value1Bean value1;
  private Object errcode;
  private Object errmsg;
  private Object datas;
  private Integer pageNo;
  private Integer pages;
  private List<Object> messageList;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Object getMessage() {
    return message;
  }

  public void setMessage(Object message) {
    this.message = message;
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

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ValueBean getValue() {
    return value;
  }

  public void setValue(ValueBean value) {
    this.value = value;
  }

  public Value1Bean getValue1() {
    return value1;
  }

  public void setValue1(Value1Bean value1) {
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

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public List<Object> getMessageList() {
    return messageList;
  }

  public void setMessageList(List<Object> messageList) {
    this.messageList = messageList;
  }

  public static class ValueBean {
    private String dishes_id;
    private String store_id;
    private String store_name;
    private Object user_id;
    private String dishes_type;
    private String label_type;
    private String package_type;
    private String upload_url;
    private String dishes_name;
    private String dishes_price;
    private String rack_rate;
    private String dishes_description;
    private String appointment_notice;
    private Integer purchase_count;
    private Object purchase_persons;
    private Object dishes_select_status;
    private String discount_type;
    private String add_user;
    private String add_time;
    private String update_user;
    private String update_time;
    private Object del_user;
    private String del_flag;

    public String getDishes_id() {
      return dishes_id;
    }

    public void setDishes_id(String dishes_id) {
      this.dishes_id = dishes_id;
    }

    public String getStore_id() {
      return store_id;
    }

    public void setStore_id(String store_id) {
      this.store_id = store_id;
    }

    public String getStore_name() {
      return store_name;
    }

    public void setStore_name(String store_name) {
      this.store_name = store_name;
    }

    public Object getUser_id() {
      return user_id;
    }

    public void setUser_id(Object user_id) {
      this.user_id = user_id;
    }

    public String getDishes_type() {
      return dishes_type;
    }

    public void setDishes_type(String dishes_type) {
      this.dishes_type = dishes_type;
    }

    public String getLabel_type() {
      return label_type;
    }

    public void setLabel_type(String label_type) {
      this.label_type = label_type;
    }

    public String getPackage_type() {
      return package_type;
    }

    public void setPackage_type(String package_type) {
      this.package_type = package_type;
    }

    public String getUpload_url() {
      return upload_url;
    }

    public void setUpload_url(String upload_url) {
      this.upload_url = upload_url;
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

    public String getRack_rate() {
      return rack_rate;
    }

    public void setRack_rate(String rack_rate) {
      this.rack_rate = rack_rate;
    }

    public String getDishes_description() {
      return dishes_description;
    }

    public void setDishes_description(String dishes_description) {
      this.dishes_description = dishes_description;
    }

    public String getAppointment_notice() {
      return appointment_notice;
    }

    public void setAppointment_notice(String appointment_notice) {
      this.appointment_notice = appointment_notice;
    }

    public Integer getPurchase_count() {
      return purchase_count;
    }

    public void setPurchase_count(Integer purchase_count) {
      this.purchase_count = purchase_count;
    }

    public Object getPurchase_persons() {
      return purchase_persons;
    }

    public void setPurchase_persons(Object purchase_persons) {
      this.purchase_persons = purchase_persons;
    }

    public Object getDishes_select_status() {
      return dishes_select_status;
    }

    public void setDishes_select_status(Object dishes_select_status) {
      this.dishes_select_status = dishes_select_status;
    }

    public String getDiscount_type() {
      return discount_type;
    }

    public void setDiscount_type(String discount_type) {
      this.discount_type = discount_type;
    }

    public String getAdd_user() {
      return add_user;
    }

    public void setAdd_user(String add_user) {
      this.add_user = add_user;
    }

    public String getAdd_time() {
      return add_time;
    }

    public void setAdd_time(String add_time) {
      this.add_time = add_time;
    }

    public String getUpdate_user() {
      return update_user;
    }

    public void setUpdate_user(String update_user) {
      this.update_user = update_user;
    }

    public String getUpdate_time() {
      return update_time;
    }

    public void setUpdate_time(String update_time) {
      this.update_time = update_time;
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

  public static class Value1Bean {
    private String org_id;
    private String org_name;
    private Object parent_org_id;
    private Object parent_org_name;
    private String icon;
    private String address;
    private String description;
    private String shop_work_time;
    private String phone;
    private String createtime;
    private String createuser;
    private String createuser_id;
    private String updatetime;
    private String updateuser;
    private String delflag;
    private String deluser;

    public String getOrg_id() {
      return org_id;
    }

    public void setOrg_id(String org_id) {
      this.org_id = org_id;
    }

    public String getOrg_name() {
      return org_name;
    }

    public void setOrg_name(String org_name) {
      this.org_name = org_name;
    }

    public Object getParent_org_id() {
      return parent_org_id;
    }

    public void setParent_org_id(Object parent_org_id) {
      this.parent_org_id = parent_org_id;
    }

    public Object getParent_org_name() {
      return parent_org_name;
    }

    public void setParent_org_name(Object parent_org_name) {
      this.parent_org_name = parent_org_name;
    }

    public String getIcon() {
      return icon;
    }

    public void setIcon(String icon) {
      this.icon = icon;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getShop_work_time() {
      return shop_work_time;
    }

    public void setShop_work_time(String shop_work_time) {
      this.shop_work_time = shop_work_time;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
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

    public String getCreateuser_id() {
      return createuser_id;
    }

    public void setCreateuser_id(String createuser_id) {
      this.createuser_id = createuser_id;
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

    public String getDeluser() {
      return deluser;
    }

    public void setDeluser(String deluser) {
      this.deluser = deluser;
    }
  }
}
