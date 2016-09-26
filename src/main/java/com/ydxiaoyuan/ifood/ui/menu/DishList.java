package com.ydxiaoyuan.ifood.ui.menu;

import android.util.Log;

import com.ydxiaoyuan.ifood.entity.Dish;
import com.ydxiaoyuan.ifood.helper.ArithHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择过的菜品的信息list
 * Created by arilpan on 2016/8/11.
 */
public class DishList {
  public static List<Dish> dishes;

  public static List<Dish> getlist() {
    if (dishes == null) {
      dishes = new ArrayList<>();
    }
    return dishes;
  }

  public static double getTotalPrice() {
    double total = 0l;
    dishes = getlist();
    for (Dish dish : dishes) {
      double temp = ArithHelper.mul(Double.parseDouble(String.valueOf(dish.getNum())),
          Double.parseDouble(dish.getPrice()));
      //            dish.getNum() *
      //                    Double.parseDouble(dish.getPrice();
      total = ArithHelper.add(total, temp);
      //            total = total + (dish.getNum() *
      //                    Double.parseDouble(dish.getPrice()));
    }
    Log.e("arilpan", "调用已选菜品计算总额方法:" + total);
    return total;
  }
}
