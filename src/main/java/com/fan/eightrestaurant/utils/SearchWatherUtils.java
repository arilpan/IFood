package com.fan.eightrestaurant.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by xdkj on 2016/8/23.
 *
 * EditText设置不能输入空字符类
 */
public class SearchWatherUtils implements TextWatcher {
  /**
   * 监听改变的文本框
   */
  private EditText editText;
  /**
   * 输入字符串最大长度
   */
  private int mMaxLenth = 16;
  /**
   * 实际输入字符串的长度
   */
  private int cou = 0;
  /**
   * 实际输入字符串的最终长度
   */
  private int selectionEnd = 0;
  private Context context;

  public SearchWatherUtils(EditText editText) {
    this.editText = editText;
  }

  @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

  }

  @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
    cou = before + count;
    String editable = editText.getText().toString();
    String str = stringFilter(editable.toString());
    if (!editable.equals(str)) {
      editText.setText(str);
      //设置新的光标所在位置
      editText.setSelection(str.length());
    }
    cou = editText.length();
  }

  @Override public void afterTextChanged(Editable s) {
    if (cou > mMaxLenth) {//如果实际输入的字符串长度大于限制的最大长度
      selectionEnd = editText.getSelectionEnd();//获取字符串的最终长度并赋值给selectionEnd
      s.delete(mMaxLenth, selectionEnd);//将限定的最大长度以外的多余的字符串删去
    }
  }

  public static String stringFilter(String str) throws PatternSyntaxException {
    String regEx = " ";
    Pattern p = Pattern.compile(regEx);
    Matcher m = p.matcher(str);
    return m.replaceAll("").trim();
  }
}
