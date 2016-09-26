package com.ydxiaoyuan.ifood.adapter.dish;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPNew;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 瀑布流效果
 * 新品尝鲜
 * Created by arilpan@qq.com on 16/8.
 */
public class NewDishesAdapter
    extends RecyclerView.Adapter<NewDishesAdapter.MyViewHolder> {
  public List<APPNew.ValueBean.DataBean> mItems = new ArrayList<>();
  private LayoutInflater mInflater;

  private OnItemClickListener mClickListener;

  public NewDishesAdapter(Context context) {
    this.mInflater = LayoutInflater.from(context);
  }

  public void setDatas(List<APPNew.ValueBean.DataBean> items) {
    mItems.clear();
    mItems.addAll(items);
    getRandomHeight(this.mItems);
    notifyDataSetChanged();
  }

  private List<Integer> heights;

  //得到随机item的高度
  private void getRandomHeight(List<APPNew.ValueBean.DataBean> lists) {
    heights = new ArrayList<>();
    for (int i = 0; i < lists.size(); i++) {
      //            heights.add((int)(600+Math.random()*400));
      int desc_length = (lists.get(i).getDishes_description().length()) / 11;
      int desc_length_add = (lists.get(i).getDishes_description().length()) % 11;
      if (desc_length_add != 0) {
        desc_length += 1;
      }
      int length = (int) (638 + desc_length * 40);
      Log.e("arilpan", ",单个长度：" + lists.get(i).getDishes_description().length() +
          ",每10个字是一行，共计：" + length);
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

    APPNew.ValueBean.DataBean item = mItems.get(position);
    holder.name.setText(item.getDishes_name());
    holder.desc.setText(item.getDishes_description());
    holder.price.setText("￥" + item.getDishes_price());

    Glide.with(mInflater.getContext())
        .load(APIConfig.BASE_IMG_URL + item.getUpload_url())
        .placeholder(R.drawable.preferential_list_item_zanwutupian)
        .into(holder.image);
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
