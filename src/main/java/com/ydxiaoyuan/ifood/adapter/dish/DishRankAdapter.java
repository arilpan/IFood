package com.ydxiaoyuan.ifood.adapter.dish;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPRank;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arilpan@qq.com on 16/8.
 */
public class DishRankAdapter extends RecyclerView.Adapter<DishRankAdapter.MyViewHolder> {
  private List<APPRank.ValueBean.DataBean> mItems = new ArrayList<>();
  private LayoutInflater mInflater;

  private OnItemClickListener mClickListener;

  public DishRankAdapter(Context context) {
    this.mInflater = LayoutInflater.from(context);
  }

  public void setDatas(List<APPRank.ValueBean.DataBean> items) {
    mItems.clear();
    mItems.addAll(items);
    notifyDataSetChanged();
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = mInflater.inflate(R.layout.fragment_rank_dishes_list_item, parent, false);
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
    APPRank.ValueBean.DataBean item = mItems.get(position);
    holder.name.setText(item.getDishes_name());
    holder.desc.setText(item.getDishes_description());
    holder.price.setText("￥" + item.getDishes_price());
    holder.soldNum.setText("  " + item.getPurchase_count() + "人购买");
    //        holder.soldNum.setText(item.getNum() + "人购买");
    Glide.with(mInflater.getContext()) //
        .load(APIConfig.BASE_IMG_URL + item.getUpload_url()) //
        .error(R.drawable.preferential_list_item_zanwutupian).into(holder.image);
  }

  @Override public int getItemCount() {
    return mItems.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView price;
    private TextView desc;
    private TextView name;
    private TextView soldNum;

    private ImageView image;

    public MyViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.fragment_food_list_item_foodname);
      desc = (TextView) itemView.findViewById(R.id.fragment_food_list_item_introduction);
      price = (TextView) itemView.findViewById(R.id.fragment_food_list_item_foodprice);
      soldNum = (TextView) itemView.findViewById(R.id.fragment_food_list_item_buynum);

      image = (ImageView) itemView.findViewById(R.id.fragment_food_list_item_showiamge);
    }
  }

  public void setOnItemClickListener(OnItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }
}
