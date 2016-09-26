package com.fan.eightrestaurant.utils;

import com.fan.eightrestaurant.bean.LeaveMessage;
import com.fan.eightrestaurant.bean.Preferential;
import com.fan.eightrestaurant.bean.SendInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdkj on 2016/8/11.
 */
public class JSONUtils {
  //解析 查看所有常用留言解析
  public static List<LeaveMessage> getMessageJson(String jsonObj) {
    List<LeaveMessage> result = new ArrayList<>();
    try {
      JSONObject jsonObject = new JSONObject(jsonObj);
      JSONArray data = jsonObject.getJSONArray("value");
      for (int i = 0; i < data.length(); i++) {
        JSONObject datas = data.getJSONObject(i);
        LeaveMessage leaveMessage = new LeaveMessage();
        //取值
        leaveMessage.setM_id(datas.getString("m_id"));
        leaveMessage.setM_title(datas.getString("m_title"));
        leaveMessage.setM_content(datas.getString("m_content"));
        result.add(leaveMessage);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return result;
  }

  //解析 我的留言用户反馈解析
  public static List<SendInfo> getSendInfoJson(String jsonObj) {
    List<SendInfo> list = new ArrayList<>();
    try {
      JSONObject jsonObject = new JSONObject(jsonObj);
      JSONArray data = jsonObject.getJSONArray("value");
      for (int i = 0; i < data.length(); i++) {
        JSONObject datas = data.getJSONObject(i);
        SendInfo sendInfo = new SendInfo();
        //取值
        sendInfo.setHotel_id(datas.getString("hotel_id"));
        sendInfo.setBack_content(datas.getString("back_content"));
        sendInfo.setCreatetime(datas.getString("createtime"));
        sendInfo.setCreateuser_id(datas.getString("createuser_id"));
        sendInfo.setCreateuser(datas.getString("createuser"));
        sendInfo.setBack_state(datas.getInt("back_state"));
        list.add(sendInfo);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return list;
  }

  //解析 专属优惠页面的解析
  public static List<Preferential> getPreferentialJson(String jsonObj) {
    List<Preferential> result = new ArrayList<>();
    try {
      JSONObject jsonObject = new JSONObject(jsonObj);
      JSONArray value = jsonObject.getJSONArray("value");
      for (int i = 0; i < value.length(); i++) {
        Preferential preferential = new Preferential();
        JSONObject data = value.getJSONObject(i);
        preferential.setCard_rule(data.getString("card_rule"));
        preferential.setContent_validity(data.getString("content_validity"));
        preferential.setActivity_end_time(data.getString("activity_end_time"));
        preferential.setUpload_url(data.getString("upload_url"));
        preferential.setShop_id(data.getString("shop_id"));
        preferential.setDiscount_id(data.getString("discount_id"));
        result.add(preferential);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return result;
  }
}
