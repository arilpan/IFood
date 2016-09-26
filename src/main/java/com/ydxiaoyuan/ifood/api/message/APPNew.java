package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-8-26.
 */
public class APPNew {
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
   * {"dishes_id":"1411081a-587f-4dcb-ae40-64869b7c207f",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"果汁类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810170514837zsz.JPG","dishes_name":"紫薯汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 17:05:15","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"14a4498d-6404-478c-bf97-a1bb9c0cdcc3",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810163111290tspcyp.jpg","dishes_name":"特色泡菜鱼片",
   * "dishes_price":"46.40","rack_rate":"58.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"8","add_user":"测试管理员","add_time":"2016-08-10
   * 16:31:13","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"49e2e295-551d-48a2-90da-6b67e30aa4f0",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"果汁类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810170428755ymz.jpg","dishes_name":"玉米汁 ",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口。",
   * "appointment_notice":"提前一小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 17:04:29","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"ae1cb9ca-c45c-4c05-b7b9-336c5d1dbfd9",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"果汁类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810170250523syz.jpg","dishes_name":"山药汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口、有益健康。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 17:02:52","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"00659730-32a0-4322-8df7-60ba302c0681",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810162340634srzkpx.jpg","dishes_name":"蒜茸蒸开片虾",
   * "dishes_price":"40.80","rack_rate":"68.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-08-10
   * 16:23:44","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"00ae4580-a070-49c8-8925-0b19d1a10e96",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/2016081015471388hsjhbx.jpg","dishes_name":"红烧江湖八鲜",
   * "dishes_price":"76.00","rack_rate":"76.00","dishes_description":"味道鲜美。",
   * "appointment_notice":"提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 15:47:14","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"}],
   * "pageSize":10,"recordsTotal":36,"recordsFiltered":36,"totalPages":4,"success":false,
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
  private Object messageList;
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
   * {"dishes_id":"1411081a-587f-4dcb-ae40-64869b7c207f",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"果汁类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810170514837zsz.JPG","dishes_name":"紫薯汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 17:05:15","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"14a4498d-6404-478c-bf97-a1bb9c0cdcc3",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810163111290tspcyp.jpg","dishes_name":"特色泡菜鱼片",
   * "dishes_price":"46.40","rack_rate":"58.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"8","add_user":"测试管理员","add_time":"2016-08-10
   * 16:31:13","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"49e2e295-551d-48a2-90da-6b67e30aa4f0",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"果汁类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810170428755ymz.jpg","dishes_name":"玉米汁 ",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口。",
   * "appointment_notice":"提前一小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 17:04:29","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"ae1cb9ca-c45c-4c05-b7b9-336c5d1dbfd9",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"果汁类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810170250523syz.jpg","dishes_name":"山药汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口、有益健康。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-10
   * 17:02:52","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"00659730-32a0-4322-8df7-60ba302c0681",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"",
   * "upload_url":"/GrogshopUpload/dishes/20160810162340634srzkpx.jpg","dishes_name":"蒜茸蒸开片虾",
   * "dishes_price":"40.80","rack_rate":"68.00","dishes_description":"肉质鲜美、细嫩。",
   * "appointment_notice":"提前两小时预约。","purchase_count":0,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"6","add_user":"测试管理员","add_time":"2016-08-10
   * 16:23:44","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"00ae4580-a070-49c8-8925-0b19d1a10e96",
   * "store_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","store_name":"8号土菜馆","user_id":null,
   * "dishes_type":"热菜类","label_type":"新品尝鲜","package_type":"","upload_url":"/GrogshopUpload
   * /dishes/2016081015471388hsjhbx.jpg","dishes_name":"红烧江湖八鲜","dishes_price":"76.00",
   * "rack_rate":"76.00","dishes_description":"味道鲜美。","appointment_notice":"提前两小时预约。",
   * "purchase_count":0,"purchase_persons":null,"dishes_select_status":null,"discount_type":"0
   * ","add_user":"测试管理员","add_time":"2016-08-10 15:47:14","update_user":null,
   * "update_time":null,"del_user":null,"del_flag":"0"}]
   * pageSize : 10
   * recordsTotal : 36
   * recordsFiltered : 36
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
  private Object value1;
  private Object errcode;
  private Object errmsg;
  private Object datas;
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
    private Object message;
    private Object messageList;
    private Object messageList1;
    private Object messageList2;
    private Object messageList3;
    private Object messageList4;
    private Object messageList5;
    private Object messageList6;
    private Object messageList7;
    private Object messageList8;
    private Integer code;
    private Object value;
    private Object value1;
    private Object errcode;
    private Object errmsg;
    private Object datas;
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

    public Object getMessage() {
      return message;
    }

    public void setMessage(Object message) {
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

    public Integer getCode() {
      return code;
    }

    public void setCode(Integer code) {
      this.code = code;
    }

    public Object getValue() {
      return value;
    }

    public void setValue(Object value) {
      this.value = value;
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
      private Integer purchase_persons;
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

      public Integer getPurchase_persons() {
        return purchase_persons;
      }

      public void setPurchase_persons(Integer purchase_persons) {
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
  }
}
