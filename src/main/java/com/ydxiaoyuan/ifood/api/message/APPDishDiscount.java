package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-8-25.
 */
public class APPDishDiscount {
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
   * value : {"data":[{"dishes_id":"00659730-32a0-4322-8df7-60ba302c0681",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810162340634srzkpx.jpg","dishes_name":"蒜茸蒸开片虾",
   * "dishes_price":"40.80","rack_rate":"68.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-08-10
   * 16:23:44","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"14a4498d-6404-478c-bf97-a1bb9c0cdcc3",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810163111290tspcyp.jpg","dishes_name":"特色泡菜鱼片",
   * "dishes_price":"46.40","rack_rate":"58.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"8","add_user":"测试管理员","add_time":"2016-08-10
   * 16:31:13","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"25466133-4c2e-4002-9476-2d757e227394",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/20160810150254570jds.jpg","dishes_name":"鸡蛋酥",
   * "dishes_price":"11.00","rack_rate":"22.00","dishes_description":"鸡蛋酥很脆，很香，回味无穷。",
   * "appointment_notice":"抢手货，提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"5","add_user":"测试管理员","add_time":"2016-08-04
   * 09:06:34","update_user":"测试管理员","update_time":"2016-08-10 15:02:55","del_user":null,
   * "del_flag":"0"},{"dishes_id":"26e1de0d-773a-4260-b012-d854e6bb1609",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810162740570tscgy.jpg","dishes_name":"特色臭桂鱼",
   * "dishes_price":"64.00","rack_rate":"128.00","dishes_description":"味道鲜美。",
   * "appointment_notice":"提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"5","add_user":"测试管理员","add_time":"2016-08-10
   * 16:27:41","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"36dbde58-5ab5-41b5-915c-66048e63a5df233",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810150412692jxnr.jpg","dishes_name":"酱香牛肉",
   * "dishes_price":"22.80","rack_rate":"38.00","dishes_description":"余味缭绕，回味无穷，肉质鲜美。",
   * "appointment_notice":"提前两小时预定哦","purchase_count":664,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-07-27
   * 10:52:36","update_user":"测试管理员","update_time":"2016-08-10 15:04:13","del_user":null,
   * "del_flag":"0"},{"dishes_id":"3908a9cc-4867-4709-8a74-327b80d55524",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/2016081016284491tsfccdfb.jpg",
   * "dishes_name":"特色肥肠臭豆腐煲","dishes_price":"15.40","rack_rate":"22.00",
   * "dishes_description":"味道鲜美。","appointment_notice":"提前两小时预约。","purchase_count":0,
   * "purchase_persons":null,"dishes_select_status":null,"discount_type":"7",
   * "add_user":"测试管理员","add_time":"2016-08-10 16:28:45","update_user":null,"update_time":null,
   * "del_user":null,"del_flag":"0"},{"dishes_id":"3b3521b3-d01f-4fd5-95f9-3d95db306baf",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810165433846zjwpg.jpg","dishes_name":"珍菌煨排骨",
   * "dishes_price":"13.50","rack_rate":"27.00","dishes_description":"味道鲜美、有益健康。",
   * "appointment_notice":"提前三小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"5","add_user":"测试管理员","add_time":"2016-08-10
   * 16:54:35","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"42446dc9-7a94-449a-abd1-a1ac227688f0",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810150726424lnez.jpg","dishes_name":"老卤鹅杂",
   * "dishes_price":"34.80","rack_rate":"58.00","dishes_description":"肉质鲜嫩，卤味醇正。",
   * "appointment_notice":"提前两小时预约","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-08-03
   * 17:05:09","update_user":"测试管理员","update_time":"2016-08-10 15:07:27","del_user":null,
   * "del_flag":"0"},{"dishes_id":"47c6cb87-08c3-4ee6-9dae-b0416192518f",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810164755593yshx.jpg","dishes_name":"盐水河虾",
   * "dishes_price":"44.00","rack_rate":"88.00","dishes_description":"肉质鲜美，好吃。",
   * "appointment_notice":"提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"5","add_user":"测试管理员","add_time":"2016-08-10
   * 16:47:56","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"4b319838-9152-44b9-ab63-a0caefe56cec",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810163428932tsyshsdjy.jpg",
   * "dishes_name":"特色野生红烧大甲鱼 ","dishes_price":"208.60","rack_rate":"298.00",
   * "dishes_description":"肉质鲜美、细嫩。","appointment_notice":"提前两小时预约。","purchase_count":0,
   * "purchase_persons":null,"dishes_select_status":null,"discount_type":"7",
   * "add_user":"测试管理员","add_time":"2016-08-10 16:34:30","update_user":null,"update_time":null,
   * "del_user":null,"del_flag":"0"}],"pageSize":10,"recordsTotal":40,"recordsFiltered":40,
   * "totalPages":4,"success":false,"message":null,"messageList":null,"messageList1":null,
   * "messageList2":null,"messageList3":null,"messageList4":null,"messageList5":null,
   * "messageList6":null,"messageList7":null,"messageList8":null,"code":0,"value":null,
   * "value1":null,"errcode":null,"errmsg":null,"datas":null}
   * value1 : null
   * errcode : null
   * errmsg : null
   * datas : null
   * pageNo : 0
   * pages : 0
   */

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
  /**
   * data : [{"dishes_id":"00659730-32a0-4322-8df7-60ba302c0681",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810162340634srzkpx.jpg","dishes_name":"蒜茸蒸开片虾",
   * "dishes_price":"40.80","rack_rate":"68.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-08-10
   * 16:23:44","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"14a4498d-6404-478c-bf97-a1bb9c0cdcc3",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810163111290tspcyp.jpg","dishes_name":"特色泡菜鱼片",
   * "dishes_price":"46.40","rack_rate":"58.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"8","add_user":"测试管理员","add_time":"2016-08-10
   * 16:31:13","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"25466133-4c2e-4002-9476-2d757e227394",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/20160810150254570jds.jpg","dishes_name":"鸡蛋酥",
   * "dishes_price":"11.00","rack_rate":"22.00","dishes_description":"鸡蛋酥很脆，很香，回味无穷。",
   * "appointment_notice":"抢手货，提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"5","add_user":"测试管理员","add_time":"2016-08-04
   * 09:06:34","update_user":"测试管理员","update_time":"2016-08-10 15:02:55","del_user":null,
   * "del_flag":"0"},{"dishes_id":"26e1de0d-773a-4260-b012-d854e6bb1609",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810162740570tscgy.jpg","dishes_name":"特色臭桂鱼",
   * "dishes_price":"64.00","rack_rate":"128.00","dishes_description":"味道鲜美。",
   * "appointment_notice":"提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"5","add_user":"测试管理员","add_time":"2016-08-10
   * 16:27:41","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"36dbde58-5ab5-41b5-915c-66048e63a5df233",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810150412692jxnr.jpg","dishes_name":"酱香牛肉",
   * "dishes_price":"22.80","rack_rate":"38.00","dishes_description":"余味缭绕，回味无穷，肉质鲜美。",
   * "appointment_notice":"提前两小时预定哦","purchase_count":664,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-07-27
   * 10:52:36","update_user":"测试管理员","update_time":"2016-08-10 15:04:13","del_user":null,
   * "del_flag":"0"},{"dishes_id":"3908a9cc-4867-4709-8a74-327b80d55524",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/2016081016284491tsfccdfb.jpg",
   * "dishes_name":"特色肥肠臭豆腐煲","dishes_price":"15.40","rack_rate":"22.00",
   * "dishes_description":"味道鲜美。","appointment_notice":"提前两小时预约。","purchase_count":0,
   * "purchase_persons":null,"dishes_select_status":null,"discount_type":"7",
   * "add_user":"测试管理员","add_time":"2016-08-10 16:28:45","update_user":null,"update_time":null,
   * "del_user":null,"del_flag":"0"},{"dishes_id":"3b3521b3-d01f-4fd5-95f9-3d95db306baf",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810165433846zjwpg.jpg","dishes_name":"珍菌煨排骨",
   * "dishes_price":"13.50","rack_rate":"27.00","dishes_description":"味道鲜美、有益健康。",
   * "appointment_notice":"提前三小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"5","add_user":"测试管理员","add_time":"2016-08-10
   * 16:54:35","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"42446dc9-7a94-449a-abd1-a1ac227688f0",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"冷菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810150726424lnez.jpg","dishes_name":"老卤鹅杂",
   * "dishes_price":"34.80","rack_rate":"58.00","dishes_description":"肉质鲜嫩，卤味醇正。",
   * "appointment_notice":"提前两小时预约","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-08-03
   * 17:05:09","update_user":"测试管理员","update_time":"2016-08-10 15:07:27","del_user":null,
   * "del_flag":"0"},{"dishes_id":"47c6cb87-08c3-4ee6-9dae-b0416192518f",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810164755593yshx.jpg","dishes_name":"盐水河虾",
   * "dishes_price":"44.00","rack_rate":"88.00","dishes_description":"肉质鲜美，好吃。",
   * "appointment_notice":"提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"5","add_user":"测试管理员","add_time":"2016-08-10
   * 16:47:56","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"4b319838-9152-44b9-ab63-a0caefe56cec",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"","upload_url":"/GrogshopUpload
   * /dishes/20160810163428932tsyshsdjy.jpg","dishes_name":"特色野生红烧大甲鱼 ","dishes_price":"208
   * .60","rack_rate":"298.00","dishes_description":"肉质鲜美、细嫩。","appointment_notice":"提前两小时预约。",
   * "purchase_count":0,"purchase_persons":null,"dishes_select_status":null,"discount_type":"7
   * ","add_user":"测试管理员","add_time":"2016-08-10 16:34:30","update_user":null,"update_time
   * ":null,"del_user":null,"del_flag":"0"}]
   * pageSize : 10
   * recordsTotal : 40
   * recordsFiltered : 40
   * totalPages : 4
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
  private String datas;
  private Integer pageNo;
  private Integer pages;

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

  public String getDatas() {
    return datas;
  }

  public void setDatas(String datas) {
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
     * dishes_id : 00659730-32a0-4322-8df7-60ba302c0681
     * store_id : 36dbde58-5ab5-41b5-915c-66048e63a5df
     * store_name : 8号土菜馆
     * user_id : null
     * dishes_type : 热菜类
     * label_type : 新品尝鲜
     * package_type :
     * upload_url : /GrogshopUpload/dishes/20160810162340634srzkpx.jpg
     * dishes_name : 蒜茸蒸开片虾
     * dishes_price : 40.80
     * rack_rate : 68.00
     * dishes_description : 肉质鲜美、细嫩。
     * appointment_notice : 提前两小时预约。
     * purchase_count : 0
     * purchase_persons : null
     * dishes_select_status : null
     * discount_type : 6
     * add_user : 测试管理员
     * add_time : 2016-08-10 16:23:44
     * update_user : null
     * update_time : null
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
      private String purchase_persons;
      private String dishes_select_status;
      private String discount_type;
      private String add_user;
      private String add_time;
      private String update_user;
      private String update_time;
      private String del_user;
      private String del_flag;

      @Override public boolean equals(Object obj) {
        APPDishDiscount.ValueBean.DataBean s = (APPDishDiscount.ValueBean.DataBean) obj;
        return dishes_id.equals(s.dishes_id) && dishes_name.equals(s.dishes_name);
      }

      @Override public int hashCode() {
        String in = dishes_id + dishes_name;
        return in.hashCode();
      }

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

      public String getPurchase_persons() {
        return purchase_persons;
      }

      public void setPurchase_persons(String purchase_persons) {
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
}
