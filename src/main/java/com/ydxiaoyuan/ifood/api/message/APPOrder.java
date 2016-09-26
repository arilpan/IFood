package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * 0未完成,1完成,2取消
 * Created by aril_pan@qq.com on 16-8-26.
 */
public class APPOrder {
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
   * value : [{"shop_name":"8号烤鸭店","have_meals_time":"2016年08月10日 05时00分",
   * "order_id":"90f67d5b-b3f5-46f9-92a1-80f90751acd8","sum_price":"120.00",
   * "orderDishesList":[{"id":"de2748c2-6acb-4cbf-967a-64efe8d8b836",
   * "order_id":"90f67d5b-b3f5-46f9-92a1-80f90751acd8","user_id":"test",
   * "dishes_id":"26304412-b8ee-46fb-8d85-314db259f3df","dishes_name":"豆腐脑","dishes_price":"16
   * .00","dishes_count":"3","dishes_description":"味道鲜美、独特、细软、好吃。",
   * "upload_url":"/GrogshopUpload/dishes/20160811094005894dfn.jpg","evaluation_status":"0"},
   * {"id":"0eeaa248-2868-4183-9c15-7ff93dc4ada2",
   * "order_id":"90f67d5b-b3f5-46f9-92a1-80f90751acd8","user_id":"test",
   * "dishes_id":"ecf606b7-1bf0-4c1b-b23b-308e34f6864f","dishes_name":"阳春面","dishes_price":"12
   * .00","dishes_count":"2","dishes_description":"味道鲜美。",
   * "upload_url":"/GrogshopUpload/dishes/20160811085712755ycm.jpg","evaluation_status":"0"},
   * {"id":"a6c1386f-552e-4f3e-a9cf-b07cabbffbe1",
   * "order_id":"90f67d5b-b3f5-46f9-92a1-80f90751acd8","user_id":"test",
   * "dishes_id":"854e984d-0f4a-48a8-97e4-ada368e04196","dishes_name":"西瓜汁","dishes_price":"48
   * .00","dishes_count":"1","dishes_description":"味道可口、独特。",
   * "upload_url":"/GrogshopUpload/dishes/20160811092712413xgz.jpg","evaluation_status":"0"}]}]
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
   * shop_name : 8号烤鸭店
   * have_meals_time : 2016年08月10日 05时00分
   * order_id : 90f67d5b-b3f5-46f9-92a1-80f90751acd8
   * sum_price : 120.00
   * orderDishesList : [{"id":"de2748c2-6acb-4cbf-967a-64efe8d8b836",
   * "order_id":"90f67d5b-b3f5-46f9-92a1-80f90751acd8","user_id":"test",
   * "dishes_id":"26304412-b8ee-46fb-8d85-314db259f3df","dishes_name":"豆腐脑","dishes_price":"16
   * .00","dishes_count":"3","dishes_description":"味道鲜美、独特、细软、好吃。",
   * "upload_url":"/GrogshopUpload/dishes/20160811094005894dfn.jpg","evaluation_status":"0"},
   * {"id":"0eeaa248-2868-4183-9c15-7ff93dc4ada2",
   * "order_id":"90f67d5b-b3f5-46f9-92a1-80f90751acd8","user_id":"test",
   * "dishes_id":"ecf606b7-1bf0-4c1b-b23b-308e34f6864f","dishes_name":"阳春面","dishes_price":"12
   * .00","dishes_count":"2","dishes_description":"味道鲜美。",
   * "upload_url":"/GrogshopUpload/dishes/20160811085712755ycm.jpg","evaluation_status":"0"},
   * {"id":"a6c1386f-552e-4f3e-a9cf-b07cabbffbe1","order_id":"90f67d5b-b3f5-46f9-92a1
   * -80f90751acd8","user_id":"test","dishes_id":"854e984d-0f4a-48a8-97e4-ada368e04196",
   * "dishes_name":"西瓜汁","dishes_price":"48.00","dishes_count":"1","dishes_description
   * ":"味道可口、独特。","upload_url":"/GrogshopUpload/dishes/20160811092712413xgz.jpg",
   * "evaluation_status":"0"}]
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
    private String shop_name;
    private String have_meals_time;
    private String order_id;
    private String sum_price;
    /**
     * id : de2748c2-6acb-4cbf-967a-64efe8d8b836
     * order_id : 90f67d5b-b3f5-46f9-92a1-80f90751acd8
     * user_id : test
     * dishes_id : 26304412-b8ee-46fb-8d85-314db259f3df
     * dishes_name : 豆腐脑
     * dishes_price : 16.00
     * dishes_count : 3
     * dishes_description : 味道鲜美、独特、细软、好吃。
     * upload_url : /GrogshopUpload/dishes/20160811094005894dfn.jpg
     * evaluation_status : 0
     */

    private List<OrderDishesListBean> orderDishesList;

    public String getShop_name() {
      return shop_name;
    }

    public void setShop_name(String shop_name) {
      this.shop_name = shop_name;
    }

    public String getHave_meals_time() {
      return have_meals_time;
    }

    public void setHave_meals_time(String have_meals_time) {
      this.have_meals_time = have_meals_time;
    }

    public String getOrder_id() {
      return order_id;
    }

    public void setOrder_id(String order_id) {
      this.order_id = order_id;
    }

    public String getSum_price() {
      return sum_price;
    }

    public void setSum_price(String sum_price) {
      this.sum_price = sum_price;
    }

    public List<OrderDishesListBean> getOrderDishesList() {
      return orderDishesList;
    }

    public void setOrderDishesList(List<OrderDishesListBean> orderDishesList) {
      this.orderDishesList = orderDishesList;
    }

    public static class OrderDishesListBean {
      private String id;
      private String order_id;
      private String user_id;
      private String dishes_id;
      private String dishes_name;
      private String dishes_price;
      private String dishes_count;
      private String dishes_description;
      private String upload_url;
      private String evaluation_status;

      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
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

      public String getDishes_count() {
        return dishes_count;
      }

      public void setDishes_count(String dishes_count) {
        this.dishes_count = dishes_count;
      }

      public String getDishes_description() {
        return dishes_description;
      }

      public void setDishes_description(String dishes_description) {
        this.dishes_description = dishes_description;
      }

      public String getUpload_url() {
        return upload_url;
      }

      public void setUpload_url(String upload_url) {
        this.upload_url = upload_url;
      }

      public String getEvaluation_status() {
        return evaluation_status;
      }

      public void setEvaluation_status(String evaluation_status) {
        this.evaluation_status = evaluation_status;
      }
    }
  }
}
