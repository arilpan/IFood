package com.fan.eightrestaurant.utils;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import com.ydxiaoyuan.ifood.R;

/**
 * Created by xdkj on 2016/9/12.
 * 自定义弹出框
 */
public class CreateUserDialogUtils extends Dialog {

  public Activity context;
  private View.OnClickListener mClickListener;
  public EditText editText;
  public Button saveBtn, saverealname, savebrithday, saveemail;
  public String hint;

  public CreateUserDialogUtils(Activity context) {
    super(context);
    this.context = context;
  }

  public CreateUserDialogUtils(Activity context, int theme, View.OnClickListener clickListener,
      String hint) {
    super(context, theme);
    this.context = context;
    this.hint = hint;
    this.mClickListener = clickListener;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // 指定布局
    this.setContentView(R.layout.create_user_dialog);
    editText = (EditText) findViewById(R.id.create_user_dialog_edittext);
    editText.setHint(hint);
         /*
         * 获取圣诞框的窗口对象及参数对象以修改对话框的布局设置, 可以直接调用getWindow(),表示获得这个Activity的Window
         * 对象,这样这可以以同样的方式改变这个Activity的属性.
         */
    Window dialogWindow = this.getWindow();

    WindowManager m = context.getWindowManager();
    Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
    WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
    // p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
    p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
    dialogWindow.setAttributes(p);
    // 根据id在布局中找到控件对象
    saveBtn = (Button) findViewById(R.id.create_user_dialog_savebtn);
    saverealname = (Button) findViewById(R.id.create_user_dialog_saverealname);
    savebrithday = (Button) findViewById(R.id.create_user_dialog_savebrithday);
    saveemail = (Button) findViewById(R.id.create_user_dialog_saveemail);

    // 为按钮绑定点击事件监听器
    if (hint.equals("请输入昵称")) {
      saveBtn.setOnClickListener(mClickListener);
    } else if (hint.equals("请输入真实姓名")) {
      saveBtn.setVisibility(View.GONE);
      saverealname.setVisibility(View.VISIBLE);
      saverealname.setOnClickListener(mClickListener);
    } else if (hint.equals("请输入生日")) {
      saveBtn.setVisibility(View.GONE);
      savebrithday.setVisibility(View.VISIBLE);
      editText.setSingleLine();
      savebrithday.setOnClickListener(mClickListener);
    } else if (hint.equals("请输入邮箱")) {
      saveBtn.setVisibility(View.GONE);
      saveemail.setVisibility(View.VISIBLE);
      saveemail.setOnClickListener(mClickListener);
    }
    this.setCancelable(true);
  }
}
