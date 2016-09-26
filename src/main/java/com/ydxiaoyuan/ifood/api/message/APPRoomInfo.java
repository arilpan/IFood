package com.ydxiaoyuan.ifood.api.message;

import java.util.List;

/**
 * Created by aril_pan@qq.com on 16-9-2.
 */
public class APPRoomInfo {
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
   * value : [{"room_id":"04400a8e-9413-441c-bac8-d77b0caaf00b","room_title":"维尔切未对",
   * "room_people":"1223","room_purl":null,"room_content":"而我却日期而王菲的委屈地方q","room_state":"0",
   * "createtime":"2016-09-01 10:53:12","createuser":"测试管理","updatetime":null,
   * "updateuser":null,"delflag":"0","deluser":null,
   * "hotel_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","hotel_title":"8号土菜馆"},
   * {"room_id":"0628a185-8633-4cd3-b3a9-6bf071720463","room_title":"迎春厅","room_people":"20",
   * "room_purl":null,
   * "room_content
   * ":"好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间好的包间","room_state":"1","createtime":"2016-08-03
   * 08:38:05","createuser":"测试管理员","updatetime":"2016-08-18 09:24:07","updateuser":"测试管理员","delflag":"0","deluser":null,"hotel_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","hotel_title":"8号土菜馆"},{"room_id":"06747f2d-7ba5-4cb3-9ad8-dbfd9e1ea41a","room_title":"味儿武器二","room_people":"34","room_purl":null,"room_content":"味儿请问发斯蒂芬爱是啊","room_state":"0","createtime":"2016-09-01
   * 11:01:35","createuser":"测试管理员","updatetime":null,"updateuser":null,"delflag":"0","deluser":null,"hotel_id":"36dbde58-5ab5-41b5-915c-66048e63a5df","hotel_title":"8号土菜馆"}]
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
   * room_id : 04400a8e-9413-441c-bac8-d77b0caaf00b
   * room_title : 维尔切未对
   * room_people : 1223
   * room_purl : null
   * room_content : 而我却日期而王菲的委屈地方q
   * room_state : 0
   * createtime : 2016-09-01 10:53:12
   * createuser : 测试管理
   * updatetime : null
   * updateuser : null
   * delflag : 0
   * deluser : null
   * hotel_id : 36dbde58-5ab5-41b5-915c-66048e63a5df
   * hotel_title : 8号土菜馆
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
    private String room;
    private String order_success;
    private String order_fail;
    private String room_occupancy;
    private String extra_time;

    public String getRoom() {
      return room;
    }

    public void setRoom(String room) {
      this.room = room;
    }

    public String getOrder_success() {
      return order_success;
    }

    public void setOrder_success(String order_success) {
      this.order_success = order_success;
    }

    public String getOrder_fail() {
      return order_fail;
    }

    public void setOrder_fail(String order_fail) {
      this.order_fail = order_fail;
    }

    public String getRoom_occupancy() {
      return room_occupancy;
    }

    public void setRoom_occupancy(String room_occupancy) {
      this.room_occupancy = room_occupancy;
    }

    public String getExtra_time() {
      return extra_time;
    }

    public void setExtra_time(String extra_time) {
      this.extra_time = extra_time;
    }
    //        private String room_id;
    //        private String room_title;
    //        private String room_people;
    //        private Object room_purl;
    //        private String room_content;
    //        private String room_state;
    //        private String createtime;
    //        private String createuser;
    //        private Object updatetime;
    //        private Object updateuser;
    //        private String delflag;
    //        private Object deluser;
    //        private String hotel_id;
    //        private String hotel_title;
    //
    //        public String getRoom_id()
    //        {
    //            return room_id;
    //        }
    //
    //        public void setRoom_id(String room_id)
    //        {
    //            this.room_id = room_id;
    //        }
    //
    //        public String getRoom_title()
    //        {
    //            return room_title;
    //        }
    //
    //        public void setRoom_title(String room_title)
    //        {
    //            this.room_title = room_title;
    //        }
    //
    //        public String getRoom_people()
    //        {
    //            return room_people;
    //        }
    //
    //        public void setRoom_people(String room_people)
    //        {
    //            this.room_people = room_people;
    //        }
    //
    //        public Object getRoom_purl()
    //        {
    //            return room_purl;
    //        }
    //
    //        public void setRoom_purl(Object room_purl)
    //        {
    //            this.room_purl = room_purl;
    //        }
    //
    //        public String getRoom_content()
    //        {
    //            return room_content;
    //        }
    //
    //        public void setRoom_content(String room_content)
    //        {
    //            this.room_content = room_content;
    //        }
    //
    //        public String getRoom_state()
    //        {
    //            return room_state;
    //        }
    //
    //        public void setRoom_state(String room_state)
    //        {
    //            this.room_state = room_state;
    //        }
    //
    //        public String getCreatetime()
    //        {
    //            return createtime;
    //        }
    //
    //        public void setCreatetime(String createtime)
    //        {
    //            this.createtime = createtime;
    //        }
    //
    //        public String getCreateuser()
    //        {
    //            return createuser;
    //        }
    //
    //        public void setCreateuser(String createuser)
    //        {
    //            this.createuser = createuser;
    //        }
    //
    //        public Object getUpdatetime()
    //        {
    //            return updatetime;
    //        }
    //
    //        public void setUpdatetime(Object updatetime)
    //        {
    //            this.updatetime = updatetime;
    //        }
    //
    //        public Object getUpdateuser()
    //        {
    //            return updateuser;
    //        }
    //
    //        public void setUpdateuser(Object updateuser)
    //        {
    //            this.updateuser = updateuser;
    //        }
    //
    //        public String getDelflag()
    //        {
    //            return delflag;
    //        }
    //
    //        public void setDelflag(String delflag)
    //        {
    //            this.delflag = delflag;
    //        }
    //
    //        public Object getDeluser()
    //        {
    //            return deluser;
    //        }
    //
    //        public void setDeluser(Object deluser)
    //        {
    //            this.deluser = deluser;
    //        }
    //
    //        public String getHotel_id()
    //        {
    //            return hotel_id;
    //        }
    //
    //        public void setHotel_id(String hotel_id)
    //        {
    //            this.hotel_id = hotel_id;
    //        }
    //
    //        public String getHotel_title()
    //        {
    //            return hotel_title;
    //        }
    //
    //        public void setHotel_title(String hotel_title)
    //        {
    //            this.hotel_title = hotel_title;
    //        }
  }
}
