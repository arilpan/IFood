package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-8-25.
 */
public class APPALL {
  /**
   * success : true
   * message : null
   * messageList : [{"org_id":"ba262eba-05da-4886-947c-5a557c954af5","org_name":"8号烤鸭店",
   * "parent_org_id":null,"parent_org_name":null,
   * "icon":"/GrogshopUpload/shop/20160816103908628logo3_03.png","address":"南京市江宁区殷华街21号",
   * "description":"北京烤鸭店的烤鸭味道独特c","shop_work_time":"早7:00-晚23:00","phone":"18156987456",
   * "createtime":"2016-07-25 11:05:19","createuser":"admin",
   * "createuser_id":"059a286f-f743-421a-8fa6-5123c9367574","updatetime":"2016-08-24 08:46:14",
   * "updateuser":"烤鸭店长","delflag":null,"deluser":null},
   * {"org_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","org_name":"8号土菜馆","parent_org_id":null,
   * "parent_org_name":null,"icon":"/GrogshopUpload/shop/20160816111258440logo2_03.png",
   * "address":"南京市江宁区龙眠大道181号","description":"8号菜馆有很多好吃的哦！","shop_work_time":"早8:00-晚22:00",
   * "phone":"13569874564","createtime":"2016-07-25 11:05:05","createuser":"admin",
   * "createuser_id":"059a286f-f743-421a-8fa6-5123c9367574","updatetime":"2016-08-22 15:16:22",
   * "updateuser":"菜馆店长","delflag":null,"deluser":null}]
   * messageList1 : null
   * messageList2 : null
   * messageList3 : null
   * messageList4 : null
   * messageList5 : null
   * messageList6 : null
   * messageList7 : null
   * messageList8 : null
   * code : 0
   * value : {"data":[{"dishes_id":"9f2b66bc-2504-4826-beb7-42d1e9064586",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810152050674zjsghg.jpg","dishes_name":"蘸酱水果黄瓜",
   * "dishes_price":"8.40","rack_rate":"12.00","dishes_description":"纯天然黄瓜，蘸酱味道更美。",
   * "appointment_notice":"需要你提前一小时预约","purchase_count":771,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"7","add_user":"测试管理员","add_time":"2016-07-27
   * 13:50:22","update_user":"测试管理员","update_time":"2016-08-10 15:20:51","del_user":null,
   * "del_flag":"0"},{"dishes_id":"36dbde58-5ab5-41b5-915c-66048e63a5df233",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810150412692jxnr.jpg","dishes_name":"酱香牛肉",
   * "dishes_price":"22.80","rack_rate":"38.00","dishes_description":"余味缭绕，回味无穷，肉质鲜美。",
   * "appointment_notice":"提前两小时预定哦","purchase_count":664,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-07-27
   * 10:52:36","update_user":"测试管理员","update_time":"2016-08-10 15:04:13","del_user":null,
   * "del_flag":"0"},{"dishes_id":"e7d02f7f-5085-436a-95ce-83446cf53577",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"主食类","label_type":"热门推荐","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160811085410241mf.jpg","dishes_name":"米饭每位一元",
   * "dishes_price":"1.00","rack_rate":"1.00","dishes_description":"味道鲜美。",
   * "appointment_notice":"需提前两个小时预定。","purchase_count":650,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-07-26
   * 17:04:46","update_user":"测试管理员","update_time":"2016-08-11 08:54:11","del_user":null,
   * "del_flag":"0"},{"dishes_id":"b9591534-59d2-46f9-9fe3-589d87ebfe23",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160811085148144mdj.jpg","dishes_name":"毛豆角",
   * "dishes_price":"7.20","rack_rate":"8.00","dishes_description":"纯天然，味道鲜美。 ",
   * "appointment_notice":"提前两小时预定。","purchase_count":451,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"9","add_user":"测试管理员","add_time":"2016-07-26
   * 17:05:09","update_user":"测试管理员","update_time":"2016-08-11 08:51:49","del_user":null,
   * "del_flag":"0"},{"dishes_id":"d31df144-21d0-49dd-979d-3897c77ab7fa",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810152556388bblyt.jpg","dishes_name":"八宝老油条",
   * "dishes_price":"19.20","rack_rate":"24.00","dishes_description":"油条味道独特。",
   * "appointment_notice":"提前两小时预定哦","purchase_count":341,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"8","add_user":"测试管理员","add_time":"2016-07-26
   * 16:35:06","update_user":"测试管理员","update_time":"2016-08-10 15:25:57","del_user":null,
   * "del_flag":"0"},{"dishes_id":"23dbde58-5ab5-41b5-915c-66048e63a5df2324",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810145854103gyxqme.jpeg","dishes_name":"豉油雪炝木耳
   * ","dishes_price":"16.00","rack_rate":"16.00","dishes_description":"豉油雪炝木耳
   * ，味道鲜美，木耳纯天然，肉质细嫩。","appointment_notice":"提前两小时预定哦","purchase_count":265,
   * "purchase_persons":1,"dishes_select_status":null,"discount_type":"0","add_user":"测试管理员",
   * "add_time":"2015-07-26 16:34:03","update_user":"测试管理员","update_time":"2016-08-10
   * 14:58:55","del_user":null,"del_flag":"0"},
   * {"dishes_id":"118364ad-7c6f-4564-abb2-b82e906aa52b",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"热门推荐","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810165800420zzcjt.jpg","dishes_name":"正宗草鸡汤大份",
   * "dishes_price":"258.00","rack_rate":"258.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":3,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 16:58:01","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"ae73d4fe-6b27-45be-b2af-d655ead940f6",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"1",
   * "upload_url":"/GrogshopUpload/dishes/20160811092807241ymz.jpg","dishes_name":"玉米汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"很解渴，可口。",
   * "appointment_notice":"提前一小时预约。","purchase_count":3,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 09:28:10","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"0da59e09-3fb4-43e5-9fc1-041faba51a76",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"热门推荐","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810162956991tskxc.jpg","dishes_name":"特色空心菜",
   * "dishes_price":"14.00","rack_rate":"14.00","dishes_description":"纯天然，好吃得不得了。",
   * "appointment_notice":"提前两小时预约。","purchase_count":2,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 16:29:58","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"5f28cb48-9cad-4ee1-97f9-a45e97262d26",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"2",
   * "upload_url":"/GrogshopUpload/dishes/20160811092923422zsz.JPG","dishes_name":"紫薯汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口、很解渴。",
   * "appointment_notice":"提前两小时预约。","purchase_count":2,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 09:29:24","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"}],
   * "pageSize":10,"recordsTotal":198,"recordsFiltered":198,"totalPages":20,"success":false,
   * "message":null,"messageList":null,"messageList1":null,"messageList2":null,
   * "messageList3":null,"messageList4":null,"messageList5":null,"messageList6":null,
   * "messageList7":null,"messageList8":null,"code":0,"value":null,"value1":null,
   * "errcode":null,"errmsg":null,"datas":null}
   * value1 : null
   * errcode : null
   * errmsg : null
   * datas : null
   * pageNo : 0
   * pages : 0
   */

  private boolean success;
  private String message;
  private String messageList1;
  private String messageList2;
  private String messageList3;
  private String messageList4;
  private String messageList5;
  private String messageList6;
  private String messageList7;
  private String messageList8;
  private Integer code;
  /**
   * data : [{"dishes_id":"9f2b66bc-2504-4826-beb7-42d1e9064586",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810152050674zjsghg.jpg","dishes_name":"蘸酱水果黄瓜",
   * "dishes_price":"8.40","rack_rate":"12.00","dishes_description":"纯天然黄瓜，蘸酱味道更美。",
   * "appointment_notice":"需要你提前一小时预约","purchase_count":771,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"7","add_user":"测试管理员","add_time":"2016-07-27
   * 13:50:22","update_user":"测试管理员","update_time":"2016-08-10 15:20:51","del_user":null,
   * "del_flag":"0"},{"dishes_id":"36dbde58-5ab5-41b5-915c-66048e63a5df233",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810150412692jxnr.jpg","dishes_name":"酱香牛肉",
   * "dishes_price":"22.80","rack_rate":"38.00","dishes_description":"余味缭绕，回味无穷，肉质鲜美。",
   * "appointment_notice":"提前两小时预定哦","purchase_count":664,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-07-27
   * 10:52:36","update_user":"测试管理员","update_time":"2016-08-10 15:04:13","del_user":null,
   * "del_flag":"0"},{"dishes_id":"e7d02f7f-5085-436a-95ce-83446cf53577",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"主食类","label_type":"热门推荐","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160811085410241mf.jpg","dishes_name":"米饭每位一元",
   * "dishes_price":"1.00","rack_rate":"1.00","dishes_description":"味道鲜美。",
   * "appointment_notice":"需提前两个小时预定。","purchase_count":650,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-07-26
   * 17:04:46","update_user":"测试管理员","update_time":"2016-08-11 08:54:11","del_user":null,
   * "del_flag":"0"},{"dishes_id":"b9591534-59d2-46f9-9fe3-589d87ebfe23",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160811085148144mdj.jpg","dishes_name":"毛豆角",
   * "dishes_price":"7.20","rack_rate":"8.00","dishes_description":"纯天然，味道鲜美。 ",
   * "appointment_notice":"提前两小时预定。","purchase_count":451,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"9","add_user":"测试管理员","add_time":"2016-07-26
   * 17:05:09","update_user":"测试管理员","update_time":"2016-08-11 08:51:49","del_user":null,
   * "del_flag":"0"},{"dishes_id":"d31df144-21d0-49dd-979d-3897c77ab7fa",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810152556388bblyt.jpg","dishes_name":"八宝老油条",
   * "dishes_price":"19.20","rack_rate":"24.00","dishes_description":"油条味道独特。",
   * "appointment_notice":"提前两小时预定哦","purchase_count":341,"purchase_persons":1,
   * "dishes_select_status":null,"discount_type":"8","add_user":"测试管理员","add_time":"2016-07-26
   * 16:35:06","update_user":"测试管理员","update_time":"2016-08-10 15:25:57","del_user":null,
   * "del_flag":"0"},{"dishes_id":"23dbde58-5ab5-41b5-915c-66048e63a5df2324",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810145854103gyxqme.jpeg","dishes_name":"豉油雪炝木耳
   * ","dishes_price":"16.00","rack_rate":"16.00","dishes_description":"豉油雪炝木耳
   * ，味道鲜美，木耳纯天然，肉质细嫩。","appointment_notice":"提前两小时预定哦","purchase_count":265,
   * "purchase_persons":1,"dishes_select_status":null,"discount_type":"0","add_user":"测试管理员",
   * "add_time":"2015-07-26 16:34:03","update_user":"测试管理员","update_time":"2016-08-10
   * 14:58:55","del_user":null,"del_flag":"0"},
   * {"dishes_id":"118364ad-7c6f-4564-abb2-b82e906aa52b",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"热门推荐","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810165800420zzcjt.jpg","dishes_name":"正宗草鸡汤大份",
   * "dishes_price":"258.00","rack_rate":"258.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":3,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 16:58:01","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"ae73d4fe-6b27-45be-b2af-d655ead940f6",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"1",
   * "upload_url":"/GrogshopUpload/dishes/20160811092807241ymz.jpg","dishes_name":"玉米汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"很解渴，可口。",
   * "appointment_notice":"提前一小时预约。","purchase_count":3,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 09:28:10","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"0da59e09-3fb4-43e5-9fc1-041faba51a76",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"热门推荐","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810162956991tskxc.jpg","dishes_name":"特色空心菜",
   * "dishes_price":"14.00","rack_rate":"14.00","dishes_description":"纯天然，好吃得不得了。",
   * "appointment_notice":"提前两小时预约。","purchase_count":2,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 16:29:58","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"5f28cb48-9cad-4ee1-97f9-a45e97262d26",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"2","upload_url":"/GrogshopUpload
   * /dishes/20160811092923422zsz.JPG","dishes_name":"紫薯汁","dishes_price":"48.00","rack_rate
   * ":"48.00","dishes_description":"味道可口、很解渴。","appointment_notice":"提前两小时预约。",
   * "purchase_count":2,"purchase_persons":null,"dishes_select_status":null,"discount_type":"0
   * ","add_user":"测试管理员","add_time":"2016-08-11 09:29:24","update_user":null,"update_time
   * ":null,"del_user":null,"del_flag":"0"}]
   * pageSize : 10
   * recordsTotal : 198
   * recordsFiltered : 198
   * totalPages : 20
   * success : false
   * message : null
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
   * value : null
   * value1 : null
   * errcode : null
   * errmsg : null
   * datas : null
   */

  private ValueBean value;
  private String value1;
  private String errcode;
  private String errmsg;
  private List<ValueBean> datas;
  private Integer pageNo;
  private Integer pages;
  /**
   * org_id : ba262eba-05da-4886-947c-5a557c954af5
   * org_name : 8号烤鸭店
   * parent_org_id : null
   * parent_org_name : null
   * icon : /GrogshopUpload/shop/20160816103908628logo3_03.png
   * address : 南京市江宁区殷华街21号
   * description : 北京烤鸭店的烤鸭味道独特c
   * shop_work_time : 早7:00-晚23:00
   * phone : 18156987456
   * createtime : 2016-07-25 11:05:19
   * createuser : admin
   * createuser_id : 059a286f-f743-421a-8fa6-5123c9367574
   * updatetime : 2016-08-24 08:46:14
   * updateuser : 烤鸭店长
   * delflag : null
   * deluser : null
   */

  private List<MessageListBean> messageList;

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

  public String getMessageList1() {
    return messageList1;
  }

  public void setMessageList1(String messageList1) {
    this.messageList1 = messageList1;
  }

  public String getMessageList2() {
    return messageList2;
  }

  public void setMessageList2(String messageList2) {
    this.messageList2 = messageList2;
  }

  public String getMessageList3() {
    return messageList3;
  }

  public void setMessageList3(String messageList3) {
    this.messageList3 = messageList3;
  }

  public String getMessageList4() {
    return messageList4;
  }

  public void setMessageList4(String messageList4) {
    this.messageList4 = messageList4;
  }

  public String getMessageList5() {
    return messageList5;
  }

  public void setMessageList5(String messageList5) {
    this.messageList5 = messageList5;
  }

  public String getMessageList6() {
    return messageList6;
  }

  public void setMessageList6(String messageList6) {
    this.messageList6 = messageList6;
  }

  public String getMessageList7() {
    return messageList7;
  }

  public void setMessageList7(String messageList7) {
    this.messageList7 = messageList7;
  }

  public String getMessageList8() {
    return messageList8;
  }

  public void setMessageList8(String messageList8) {
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

  public String getValue1() {
    return value1;
  }

  public void setValue1(String value1) {
    this.value1 = value1;
  }

  public String getErrcode() {
    return errcode;
  }

  public void setErrcode(String errcode) {
    this.errcode = errcode;
  }

  public String getErrmsg() {
    return errmsg;
  }

  public void setErrmsg(String errmsg) {
    this.errmsg = errmsg;
  }

  public List<ValueBean> getDatas() {
    return datas;
  }

  public void setDatas(List<ValueBean> datas) {
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

  public List<MessageListBean> getMessageList() {
    return messageList;
  }

  public void setMessageList(List<MessageListBean> messageList) {
    this.messageList = messageList;
  }

  public static class ValueBean {
    private Integer pageSize;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private Integer totalPages;
    private boolean success;
    private String message;
    private String messageList;
    private String messageList1;
    private String messageList2;
    private String messageList3;
    private String messageList4;
    private String messageList5;
    private String messageList6;
    private String messageList7;
    private String messageList8;
    private Integer code;
    private String value;
    private String value1;
    private String errcode;
    private String errmsg;
    private String datas;
    /**
     * dishes_id : 9f2b66bc-2504-4826-beb7-42d1e9064586
     * store_id : 36dbde58-5ab5-41b5-915c-66048e63a5df
     * store_name : 8号土菜馆
     * user_id : null
     * dishes_type : 冷菜类
     * label_type : 新品尝鲜
     * package_type :
     * upload_url : /GrogshopUpload/dishes/20160810152050674zjsghg.jpg
     * dishes_name : 蘸酱水果黄瓜
     * dishes_price : 8.40
     * rack_rate : 12.00
     * dishes_description : 纯天然黄瓜，蘸酱味道更美。
     * appointment_notice : 需要你提前一小时预约
     * purchase_count : 771
     * purchase_persons : 1
     * dishes_select_status : null
     * discount_type : 7
     * add_user : 测试管理员
     * add_time : 2016-07-27 13:50:22
     * update_user : 测试管理员
     * update_time : 2016-08-10 15:20:51
     * del_user : null
     * del_flag : 0
     */

    private List<DataBean> data;

    public Integer getPageSize() {
      return pageSize;
    }

    public void setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
    }

    public Integer getRecordsTotal() {
      return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
      this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
      return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
      this.recordsFiltered = recordsFiltered;
    }

    public Integer getTotalPages() {
      return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
      this.totalPages = totalPages;
    }

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

    public String getMessageList() {
      return messageList;
    }

    public void setMessageList(String messageList) {
      this.messageList = messageList;
    }

    public String getMessageList1() {
      return messageList1;
    }

    public void setMessageList1(String messageList1) {
      this.messageList1 = messageList1;
    }

    public String getMessageList2() {
      return messageList2;
    }

    public void setMessageList2(String messageList2) {
      this.messageList2 = messageList2;
    }

    public String getMessageList3() {
      return messageList3;
    }

    public void setMessageList3(String messageList3) {
      this.messageList3 = messageList3;
    }

    public String getMessageList4() {
      return messageList4;
    }

    public void setMessageList4(String messageList4) {
      this.messageList4 = messageList4;
    }

    public String getMessageList5() {
      return messageList5;
    }

    public void setMessageList5(String messageList5) {
      this.messageList5 = messageList5;
    }

    public String getMessageList6() {
      return messageList6;
    }

    public void setMessageList6(String messageList6) {
      this.messageList6 = messageList6;
    }

    public String getMessageList7() {
      return messageList7;
    }

    public void setMessageList7(String messageList7) {
      this.messageList7 = messageList7;
    }

    public String getMessageList8() {
      return messageList8;
    }

    public void setMessageList8(String messageList8) {
      this.messageList8 = messageList8;
    }

    public Integer getCode() {
      return code;
    }

    public void setCode(Integer code) {
      this.code = code;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public String getValue1() {
      return value1;
    }

    public void setValue1(String value1) {
      this.value1 = value1;
    }

    public String getErrcode() {
      return errcode;
    }

    public void setErrcode(String errcode) {
      this.errcode = errcode;
    }

    public String getErrmsg() {
      return errmsg;
    }

    public void setErrmsg(String errmsg) {
      this.errmsg = errmsg;
    }

    public String getDatas() {
      return datas;
    }

    public void setDatas(String datas) {
      this.datas = datas;
    }

    public List<DataBean> getData() {
      return data;
    }

    public void setData(List<DataBean> data) {
      this.data = data;
    }

    public static class DataBean {
      @Override public boolean equals(Object obj) {
        DataBean s = (DataBean) obj;
        return dishes_id.equals(s.dishes_id) && dishes_name.equals(s.dishes_name);
      }

      @Override public int hashCode() {
        String in = dishes_id + dishes_name;
        return in.hashCode();
      }

      private String dishes_id;
      private String store_id;
      private String store_name;
      private String user_id;
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
      private Integer purchase_persons;
      private String dishes_select_status;
      private String discount_type;
      private String add_user;
      private String add_time;
      private String update_user;
      private String update_time;
      private String del_user;
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

      public String getUser_id() {
        return user_id;
      }

      public void setUser_id(String user_id) {
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

      public Integer getPurchase_persons() {
        return purchase_persons;
      }

      public void setPurchase_persons(Integer purchase_persons) {
        this.purchase_persons = purchase_persons;
      }

      public String getDishes_select_status() {
        return dishes_select_status;
      }

      public void setDishes_select_status(String dishes_select_status) {
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

      public String getDel_user() {
        return del_user;
      }

      public void setDel_user(String del_user) {
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

  public static class MessageListBean {
    private String org_id;
    private String org_name;
    private String parent_org_id;
    private String parent_org_name;
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

    public String getParent_org_id() {
      return parent_org_id;
    }

    public void setParent_org_id(String parent_org_id) {
      this.parent_org_id = parent_org_id;
    }

    public String getParent_org_name() {
      return parent_org_name;
    }

    public void setParent_org_name(String parent_org_name) {
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
