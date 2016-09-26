package com.ydxiaoyuan.ifood.adapter.dish;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.entity.Dish;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜品排行榜
 * Created by arilpan@qq.com on 16/8.
 */
public class RankDishesAdapter extends RecyclerView.Adapter<RankDishesAdapter.MyViewHolder> {
  private List<Dish> mItems = new ArrayList<>();
  private LayoutInflater mInflater;

  private OnItemClickListener mClickListener;

  public RankDishesAdapter(Context context) {
    this.mInflater = LayoutInflater.from(context);
  }

  public void setDatas(List<Dish> items) {
    mItems.clear();
    mItems.addAll(items);
    getRandomHeight(this.mItems);
    notifyDataSetChanged();
  }

  private List<Integer> heights;

  private void getRandomHeight(List<Dish> lists) {//得到随机item的高度
    heights = new ArrayList<>();
    for (int i = 0; i < lists.size(); i++) {
      //            heights.add((int)(600+Math.random()*400));
      int desc_length = (lists.get(i).getDesc().length()) / 10;
      int length = (int) (440 + desc_length * 10);
      Log.e("arilpan", ",单个长度：" + lists.get(i).getDesc().length() +
          ",每10个字是一行，工：" + length);
      heights.add(length);
    }
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = mInflater.inflate(R.layout.fragment_dish_switch_list_itme, parent, false);
    final MyViewHolder holder = new MyViewHolder(view);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        int position = holder.getAdapterPosition();
        if (mClickListener != null) {
          mClickListener.onItemClick(position, v, holder);
        }
      }
    });
    return holder;
  }

  @Override public void onBindViewHolder(MyViewHolder holder, int position) {
    ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();//得到item的LayoutParams布局参数
    params.height = heights.get(position);//把随机的高度赋予itemView布局

    holder.itemView.setLayoutParams(params);//把params设置给itemView布局

    Dish item = mItems.get(position);
    holder.name.setText(item.getName());
    holder.desc.setText(item.getDesc());
    holder.price.setText(item.getPrice());

    holder.image.setImageResource(R.drawable.index_dishes_image_default);
  }

  @Override public int getItemCount() {
    return mItems.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView price;
    private TextView desc;
    private TextView name;
    private ImageView image;

    public MyViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.switch_dish_name);
      desc = (TextView) itemView.findViewById(R.id.switch_dish_desc);
      price = (TextView) itemView.findViewById(R.id.switch_dish_price);

      image = (ImageView) itemView.findViewById(R.id.switch_dish_image);
    }
  }

  public void setOnItemClickListener(OnItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }
}
