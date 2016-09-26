package com.ydxiaoyuan.ifood.ui.menu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.entity.Dish;
import com.ydxiaoyuan.ifood.event.ShopEvent;
import com.ydxiaoyuan.ifood.fragment.ShopFragment;
import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * 下测查看已经选择的菜品信息
 * <p/>
 * Created by aril_pan@qq.com on 16/8.
 */
public class DishListFragment extends BaseFragment {
  private static final String ARG_PARAM1 = "select_dish";
  ListView select_grid;
  String classname;

  public DishListFragment() {
  }

  static DishListFragment fragment;

  public static DishListFragment newInstance(String param1, String param2) {
    DishListFragment fragment = new DishListFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      classname = getArguments().getString(ARG_PARAM1);
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_select_dishes, container, false);
    initView(view);
    return view;
  }

  private void initView(View view) {

    TextView tvClassname = (TextView) view.findViewById(R.id.class_name);
    tvClassname.setText(classname);
    TextView clear_dish = (TextView) view.findViewById(R.id.clear_dish);
    clear_dish.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        clearDish();
      }
    });

    select_grid = (ListView) view.findViewById(R.id.select_grid);
    select_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView nums = (TextView) adapterView.findViewById(R.id.item_middle);
        View v;
        int count = adapterView.getChildCount();
        v = adapterView.getChildAt(i);

        if (view.getId() == R.id.item_left) {
          Log.e("arilpan", "left item is clicked");
          nums.setText("0");
        } else if (view.getId() == R.id.item_right) {
          Log.e("arilpan", "right item is clicked");
          nums.setText("2");
        } else {
          Log.e("arilpan", "other item is clicked");
        }
      }
    });
  }

  public void clearDish() {
    for (Dish d : DishList.getlist()) {
      d.setNum(0);
    }
    if (items != null) {
      items.clear();
    }
    DishList.getlist().clear();

    EventBus.getDefault().post(new ShopEvent(ShopFragment.newInstance(ShopFragment.shop_id)));
    ((ShopFragment) getParentFragment()).switchDishListFragment();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    initGridView();
  }

  List<Dish> items;

  //TODO:item_left item_right
  public void initGridView() {
    items = DishList.getlist();
    ItemAddMinusAdapter iama =
        new ItemAddMinusAdapter(items, R.layout.fragment_select_dishes_list_item, getContext());
    select_grid.setAdapter(iama);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override public void onDetach() {
    super.onDetach();
  }

  class ItemAddMinusAdapter extends BaseAdapter {
    private List<Dish> dishs;//ListView显示的数据

    private int resource;//显示列表项的Layout

    private LayoutInflater inflater;//界面生成器

    private Context context;

    class ViewHolder {
    }

    ItemAddMinusAdapter(List dishs, int resource, Context context) {
      this.dishs = dishs;
      this.resource = resource;
      this.context = context.getApplicationContext();
      inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override public int getCount() {
      return dishs.size();
    }

    @Override public Object getItem(int position) {
      return position;
    }

    @Override public long getItemId(int position) {
      return position;
    }

    TextView item_middle;

    @Override public View getView(final int position, View convertView, ViewGroup parent) {
      if (convertView == null) {
        convertView = inflater.inflate(resource, null);
      }
      //            ImageView dish_img = (ImageView) convertView.findViewById(R.id.item_image);
      TextView dish_name = (TextView) convertView.findViewById(R.id.dish_name);
      TextView dish_price = (TextView) convertView.findViewById(R.id.dish_price);
      TextView item_left = (TextView) convertView.findViewById(R.id.item_left);
      item_middle = (TextView) convertView.findViewById(R.id.item_middle);
      TextView item_right = (TextView) convertView.findViewById(R.id.item_right);

      Dish dish = dishs.get(position);
      dish_name.setText(dish.getName());
      dish_price.setText("￥" + dish.getPrice());
      item_left.setText("+");

      try {
        if (item_middle == null) {
          Log.e("arilpan", "item_middle init fail");
        }
        if (dish.getNum() == 0) {
          Log.e("arilpan", "dish.setNum() fail");
          dish.setNum(1);
          Log.e("arilpan", "dish.setNum() set 1 ");
        }
        item_middle.setText(String.valueOf(dish.getNum()));
      } catch (Exception e) {
        e.printStackTrace();
      }

      item_right.setText("-");
      //                "item_image", "item_price", "item_left", "item_middle", "item_right"
      item_left.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          _mActivity.runOnUiThread(new Thread() {
            @Override public void run() {
              Log.e("arilpan", "菜品数量加1" + dishs.get(position).getDish_id() +
                  "," + dishs.get(position).getName());
              addItem(dishs.get(position));
            }
          });
        }
      });
      item_right.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {

          _mActivity.runOnUiThread(new Thread() {
            @Override public void run() {
              Log.e("arilpan", "菜品数量减1" + dishs.get(position).getDish_id() +
                  "," + dishs.get(position).getName());
              minusItem(dishs.get(position));
            }
          });
        }
      });

      return convertView;
    }

    public void addItem(Dish dish) {
      dish.setNum(dish.getNum() + 1);
      Log.e("arilpan", "菜品数量加1:" + dish.getNum());
      DishList.getlist().remove(dish);
      DishList.getlist().add(dish);
      item_middle.setText(String.valueOf(dish.getNum() + 1));
      //            ((ShopFragment) getParentFragment()).switchDishListFragment();
      EventBus.getDefault().post(new ShopEvent(ShopFragment.newInstance(ShopFragment.shop_id)));
      //            dishs.clear();
      //            dishs.addAll(DishList.getlist());
      notifyDataSetChanged();
    }

    public void minusItem(Dish dish) {
      int num = dish.getNum() - 1;
      Log.e("arilpan", "菜品数量-1:" + num);
      dish.setNum(dish.getNum() - 1);
      DishList.getlist().remove(dish);
      if (num > 0) {
        DishList.getlist().add(dish);
        item_middle.setText(String.valueOf(num));
      } else {

        //                ((ShopFragment) getParentFragment()).switchDishListFragment();
      }
      EventBus.getDefault().post(new ShopEvent(ShopFragment.newInstance(ShopFragment.shop_id)));

      //            dishs.clear();
      //            dishs.addAll(DishList.getlist());
      notifyDataSetChanged();
    }

    @Override public int getItemViewType(int position) {
      return super.getItemViewType(position);
    }
  }
}
