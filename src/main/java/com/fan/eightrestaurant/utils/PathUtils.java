package com.fan.eightrestaurant.utils;

import com.ydxiaoyuan.ifood.api.APIConfig;

/**
 * Created by xdkj on 2016/8/8.
 * 接口类
 */
public class PathUtils {
  public static String path = APIConfig.IP_PORT;

  /**
   * 用户注册、修改密码短信接口
   */
  public static String postSendCodeUrl() {
    return path + "/GrogshopSystem/app/sendCode.do";
  }

  /**
   * 用户注册保存接口
   */

  public static String postUserRegisterUrl() {
    return path + "/GrogshopSystem/app/userRegister.do";
  }

  /**
   * 用户登录接口
   */
  public static String postUserLoginUrl() {
    return path + "/GrogshopSystem/app/userLogin.do";
  }

  /**
   * 用户修改密码接口
   */
  public static String postUpdatePwdUrl() {
    return path + "/GrogshopSystem/app/updatePwd.do";
  }

  /**
   * 用户登录重置密码接口
   */
  public static String postResetPasswordUrl() {
    return path + "/GrogshopSystem/app/updataPassword.do";
  }

  /**
   * 用户个人资料修改保存接口
   */
  public static String postUpdateInformationUrl() {
    return path + "/GrogshopSystem/app/updateInformation.do";
  }

  /**
   * 用户上传头像接口
   */
  public static String postImageUploadUrl() {
    return path + "/GrogshopSystem/app/imageUpload.do";
  }

  /**
   * 留言——常见问题查询接口
   */
  public static String getAppListMessageUrl() {
    return path + "/GrogshopSystem/app/MessageBack/appListMessage.do";
  }

  /**
   * 客户问题查询  传user_id用户主键 hotel_id菜馆主键
   */
  public static String getAppListBackMessageUrl() {
    return path + "/GrogshopSystem/app/MessageBack/appListBackMessage.do";
  }

  /**
   * 客服回复问题或者提问问题，传back_content回复内容  createuser_id用户主键  createuser用户名称  hotel_id菜馆主键
   */
  public static String getAppAddBackMessageUrl() {
    return path + "/GrogshopSystem/app/MessageBack/appAddBackMessage.do";
  }

  /**
   * 专属优惠信息接口preferential
   */
  public static String getPreferentialUrl() {
    return path + "/GrogshopSystem/app/appShop/shop_RechargeDiscount_info.do?shop_id=&card_type=2";
  }

  /**
   * 专属优惠详情的接口
   */
  public static String getPreferentialDtailsUrl() {
    return path + "/GrogshopSystem/app/appShop/appShowDiscounts.do?";
  }

  /**
   * 用户注销登录接口
   */
  public static String postLoginOutUrl() {
    return path + "/GrogshopSystem/app/loginOut.do";
  }
}
