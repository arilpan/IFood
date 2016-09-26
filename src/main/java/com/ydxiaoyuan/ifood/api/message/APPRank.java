package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-8-26.
 */
public class APPRank {
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
   * value : {"data":[{"dishes_id":"e7d02f7f-5085-436a-95ce-83446cf53577",
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
   * "del_flag":"0"},{"dishes_id":"ae73d4fe-6b27-45be-b2af-d655ead940f6",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"1",
   * "upload_url":"/GrogshopUpload/dishes/20160811092807241ymz.jpg","dishes_name":"玉米汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"很解渴，可口。",
   * "appointment_notice":"提前一小时预约。","purchase_count":3,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 09:28:10","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"5f28cb48-9cad-4ee1-97f9-a45e97262d26",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"2",
   * "upload_url":"/GrogshopUpload/dishes/20160811092923422zsz.JPG","dishes_name":"紫薯汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口、很解渴。",
   * "appointment_notice":"提前两小时预约。","purchase_count":2,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 09:29:24","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"854e984d-0f4a-48a8-97e4-ada368e04196",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/20160811092712413xgz.jpg","dishes_name":"西瓜汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口、独特。",
   * "appointment_notice":"提前两小时预约。","purchase_count":2,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 09:27:13","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"0c94f372-e72c-4e74-946b-d722a7ecc984",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/20160811112232131tbyk.jpg","dishes_name":"铁板鱼扣",
   * "dishes_price":"42.00","rack_rate":"42.00","dishes_description":"肉质鲜美、醇厚、独特。",
   * "appointment_notice":"提前一小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 11:22:33","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"35c525e4-5617-4102-81e8-ce27656fdb62",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"1",
   * "upload_url":"/GrogshopUpload/dishes/2016081111190395tbhxfs.jpg","dishes_name":"铁板海鲜粉丝 ",
   * "dishes_price":"32.00","rack_rate":"32.00","dishes_description":"味道就是好。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 11:19:06","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"4282c257-dcde-49e7-bbb6-24c512a9c67a",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/2016081115570353zj.jpg","dishes_name":"蒸饺",
   * "dishes_price":"22.00","rack_rate":"22.00","dishes_description":"味道鲜美。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 15:57:04","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"43522fc1-ccbd-474e-b813-ce7f0d37e831",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"冷菜类","label_type":"精品套餐","package_type":"2",
   * "upload_url":"/GrogshopUpload/dishes/201608110843022djpd.jpg","dishes_name":"剁椒皮蛋",
   * "dishes_price":"12.60","rack_rate":"14.00","dishes_description":"味道鲜美、可口。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"9","add_user":"测试管理员","add_time":"2016-08-04
   * 09:12:52","update_user":"测试管理员","update_time":"2016-08-11 08:43:04","del_user":null,
   * "del_flag":"0"},{"dishes_id":"523eba98-03df-4311-9b7e-da84264e289f",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"1",
   * "upload_url":"/GrogshopUpload/dishes/20160811110711407szym.jpg","dishes_name":"松子玉米",
   * "dishes_price":"18.00","rack_rate":"18.00","dishes_description":"纯天然玉米，好吃的没话想说。",
   * "appointment_notice":"需提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 11:07:12","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"}],
   * "pageSize":10,"recordsTotal":115,"recordsFiltered":115,"totalPages":12,"success":false,
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
   * data : [{"dishes_id":"e7d02f7f-5085-436a-95ce-83446cf53577",
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
   * "del_flag":"0"},{"dishes_id":"ae73d4fe-6b27-45be-b2af-d655ead940f6",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"1",
   * "upload_url":"/GrogshopUpload/dishes/20160811092807241ymz.jpg","dishes_name":"玉米汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"很解渴，可口。",
   * "appointment_notice":"提前一小时预约。","purchase_count":3,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 09:28:10","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"5f28cb48-9cad-4ee1-97f9-a45e97262d26",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"2",
   * "upload_url":"/GrogshopUpload/dishes/20160811092923422zsz.JPG","dishes_name":"紫薯汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口、很解渴。",
   * "appointment_notice":"提前两小时预约。","purchase_count":2,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 09:29:24","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"854e984d-0f4a-48a8-97e4-ada368e04196",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"果汁类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/20160811092712413xgz.jpg","dishes_name":"西瓜汁",
   * "dishes_price":"48.00","rack_rate":"48.00","dishes_description":"味道可口、独特。",
   * "appointment_notice":"提前两小时预约。","purchase_count":2,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 09:27:13","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"0c94f372-e72c-4e74-946b-d722a7ecc984",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/20160811112232131tbyk.jpg","dishes_name":"铁板鱼扣",
   * "dishes_price":"42.00","rack_rate":"42.00","dishes_description":"肉质鲜美、醇厚、独特。",
   * "appointment_notice":"提前一小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 11:22:33","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"35c525e4-5617-4102-81e8-ce27656fdb62",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"1",
   * "upload_url":"/GrogshopUpload/dishes/2016081111190395tbhxfs.jpg","dishes_name":"铁板海鲜粉丝 ",
   * "dishes_price":"32.00","rack_rate":"32.00","dishes_description":"味道就是好。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 11:19:06","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"4282c257-dcde-49e7-bbb6-24c512a9c67a",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"0",
   * "upload_url":"/GrogshopUpload/dishes/2016081115570353zj.jpg","dishes_name":"蒸饺",
   * "dishes_price":"22.00","rack_rate":"22.00","dishes_description":"味道鲜美。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 15:57:04","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"},
   * {"dishes_id":"43522fc1-ccbd-474e-b813-ce7f0d37e831",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"冷菜类","label_type":"精品套餐","package_type":"2",
   * "upload_url":"/GrogshopUpload/dishes/201608110843022djpd.jpg","dishes_name":"剁椒皮蛋",
   * "dishes_price":"12.60","rack_rate":"14.00","dishes_description":"味道鲜美、可口。",
   * "appointment_notice":"提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"9","add_user":"测试管理员","add_time":"2016-08-04
   * 09:12:52","update_user":"测试管理员","update_time":"2016-08-11 08:43:04","del_user":null,
   * "del_flag":"0"},{"dishes_id":"523eba98-03df-4311-9b7e-da84264e289f",
   * "store_id":"ba262eba-05da-4886-947c-5a557c954af5","store_name":"8号烤鸭店","user_id":null,
   * "dishes_type":"热菜类","label_type":"精品套餐","package_type":"1","upload_url":"/GrogshopUpload
   * /dishes/20160811110711407szym.jpg","dishes_name":"松子玉米","dishes_price":"18.00",
   * "rack_rate":"18.00","dishes_description":"纯天然玉米，好吃的没话想说。",
   * "appointment_notice":"需提前两小时预约。","purchase_count":1,"purchase_persons":null,
   * "dishes_select_status":null,"discount_type":"0","add_user":"测试管理员","add_time":"2016-08-11
   * 11:07:12","update_user":null,"update_time":null,"del_user":null,"del_flag":"0"}]
   * pageSize : 10
   * recordsTotal : 115
   * recordsFiltered : 115
   * totalPages : 12
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
     * dishes_id : e7d02f7f-5085-436a-95ce-83446cf53577
     * store_id : ba262eba-05da-4886-947c-5a557c954af5
     * store_name : 8号烤鸭店
     * user_id : null
     * dishes_type : 主食类
     * label_type : 热门推荐
     * package_type :
     * upload_url : /GrogshopUpload/dishes/20160811085410241mf.jpg
     * dishes_name : 米饭每位一元
     * dishes_price : 1.00
     * rack_rate : 1.00
     * dishes_description : 味道鲜美。
     * appointment_notice : 需提前两个小时预定。
     * purchase_count : 650
     * purchase_persons : 1
     * dishes_select_status : null
     * discount_type : 0
     * add_user : 测试管理员
     * add_time : 2016-07-26 17:04:46
     * update_user : 测试管理员
     * update_time : 2016-08-11 08:54:11
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
      @Override public boolean equals(Object obj) {
        APPRank.ValueBean.DataBean s = (APPRank.ValueBean.DataBean) obj;
        return dishes_id.equals(s.dishes_id) && dishes_name.equals(s.dishes_name);
      }

      @Override public int hashCode() {
        String in = dishes_id + dishes_name;
        return in.hashCode();
      }

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
