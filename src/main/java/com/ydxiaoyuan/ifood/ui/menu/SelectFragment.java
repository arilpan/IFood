package com.ydxiaoyuan.ifood.ui.menu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPSelectRight;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.entity.Dish;
import com.ydxiaoyuan.ifood.event.ShopEvent;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.fragment.ShopFragment;
import com.ydxiaoyuan.ifood.ui.index.DishDetailFragment;
import me.yokeyword.fragmentation.SupportFragment;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * 右侧选择菜品的GridView
 *
 * @Author arilpan
 * Created by aril_pan@qq.com on 16/8.
 */
public class SelectFragment extends BaseFragment {
  private static final String ARG_PARAM1 = "left_menu_id";
  private static final String ARG_PARAM2 = "classname";
  GridView select_grid;
  String classname;
  String menu_id;

  public SelectFragment() {
  }

  public static SelectFragment newInstance(String param1, String param2) {
    SelectFragment fragment = new SelectFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      menu_id = getArguments().getString(ARG_PARAM1);
      classname = getArguments().getString(ARG_PARAM2);
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_select, container, false);
    initView(view);
    return view;
  }

  private void initView(View view) {

    TextView tvClassname = (TextView) view.findViewById(R.id.class_name);
    tvClassname.setText(classname);

    select_grid = (GridView) view.findViewById(R.id.select_grid);
  }

  LinearLayout select_dish_layout;
  ArrayList<Dish> item;

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    //得到tag对应的id name price 信息
    String[] name = new String[100];
    String[] price = new String[100];
    String[] ids = new String[100];
    String[] imgs = new String[100];

    int ii = 0;
    if (ShopFragment.rightDatas != null) {
      for (APPSelectRight.ValueBean vb : ShopFragment.rightDatas) {
        if (vb.getTagID().equals(menu_id)) {
          name[ii] = vb.getDishes_name();
          price[ii] = vb.getDishes_price();
          ids[ii] = vb.getDishes_id();
          imgs[ii++] = vb.getUpload_url();
          Log.e("arilpan", "解析某瓶类菜:" + vb.getTagID() + "," + vb.getDishes_name());
        }
      }
    }

    String pre_order = "预约";
    item = new ArrayList<Dish>();
    for (int i = 0; i < ii; i++) {
      Dish dish = new Dish();
      dish.setDish_id(ids[i]);
      dish.setName(name[i]);

      //            dish.setMallprice();
      dish.setPrice(price[i]);
      dish.setPreOrder("预约");
      dish.setImgurl(imgs[i]);
      item.add(dish);
    }
      /*  SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), item,
                R.layout.fragment_select_dishes_grid_item, new String[]
                {"item_image", "item_left", "item_middle", "item_right"},
                new int[]{R.id.item_image, R.id.item_left, R.id.item_middle,
                        R.id.item_right}) {
        };*/
    DishGridAdapter dga =
        new DishGridAdapter(item, R.layout.fragment_select_dishes_grid_item, getContext());
    select_grid.setAdapter(dga);
    //        select_grid.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //                Log.e("arilpan", "选择菜品的item setOnClickListener+" + v.getId());
    //            }
    //        });
    select_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("arilpan",
            "选择菜品的item setOnItemClickListener +" + view.getId() + ",position " + position);
        //加入菜品信息到列表
        Dish dish = item.get(position);
        dish.setNum(dish.getNum() + 1);
        DishList.getlist().remove(dish);
        DishList.getlist().add(dish);
        EventBus.getDefault().post(new ShopEvent(ShopFragment.newInstance(ShopFragment.shop_id)));
        //               switchDishListFragment(DishListFragment.newInstance(null, null));
        ((ShopFragment) getParentFragment()).switchDishListFragment();
      }
    });
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override public void onDetach() {
    super.onDetach();
  }

  class DishGridAdapter extends BaseAdapter {
    private List<Dish> dishs;//ListView显示的数据

    private int resource;//显示列表项的Layout

    private LayoutInflater inflater;//界面生成器

    private Context context;

    class ViewHolder {
    }

    DishGridAdapter(List dishs, int resource, Context context) {
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

    @Override public View getView(final int position, View convertView, ViewGroup parent) {
      if (convertView == null) {
        convertView = inflater.inflate(resource, null);
      }

      ImageView dish_img = (ImageView) convertView.findViewById(R.id.item_image);
      TextView dish_name = (TextView) convertView.findViewById(R.id.item_left);
      TextView dish_desc = (TextView) convertView.findViewById(R.id.item_middle);
      TextView dish_order_btn = (TextView) convertView.findViewById(R.id.item_right);

      final Dish dish = dishs.get(position);
      dish_name.setText(dish.getName());
      dish_desc.setText(dish.getPrice());
      dish_order_btn.setText("预约");

      Glide.with(SelectFragment.this)
          .load(APIConfig.BASE_IMG_URL + dish.getImgurl())
          .placeholder(R.drawable.preferential_list_item_zanwutupian)
          .into(dish_img);
      //            Picasso.with(
      //                    inflater.getContext()) //
      //                    .load(APIConfig.BASE_IMG_URL + dish.getImgurl()) //
      //                    .error(R.drawable.index_dishes_image_default).
      //                    into(dish_img);

      dish_img.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          Log.e("arilpan", "选择菜品的item Adapter dish_img +" + view.getId());
          SupportFragment sf = findChildFragment(DishDetailFragment.class);
          if (sf != null) {
            sf.pop();

            Log.e("arilpan", "findChildFragment不空 已经pop");
          }
          sf = findFragment(DishDetailFragment.class);
          if (sf != null) {
            sf.pop();
            Log.e("arilpan", "findFragment 已经pop");
          }
          EventBus.getDefault().post(new StartBrotherEvent(DishDetailFragment.
                  newInstance(dish.getDish_id())));

          //                    start(DishDetailFragment.newInstance(1));
          //  Toast.makeText(context, good.getGoodProvider(),
          //  Toast.LENGTH_LONG).show();
        }
      });
      return convertView;
    }
  }
}
