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
import com.ydxiaoyuan.ifood.api.message.APPALL;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arilpan@qq.com on 16/8.
 */
public class HotDishesAdapter extends RecyclerView.Adapter<HotDishesAdapter.MyViewHolder> {
  private List<APPALL.ValueBean.DataBean> mItems = new ArrayList<>();
  private LayoutInflater mInflater;

  private OnItemClickListener mClickListener;

  public HotDishesAdapter(Context context) {
    this.mInflater = LayoutInflater.from(context);
  }

  public void setDatas(List<APPALL.ValueBean.DataBean> items) {
    if (items == null) return;
    mItems.clear();
    mItems.addAll(items);
    notifyDataSetChanged();
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.index_list_item, parent, false);
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
    if (mItems != null) {
      //APIALL.ValueBean.DataBean
      APPALL.ValueBean.DataBean item = mItems.get(position);
      Log.e("arilpan", "position:" + position +
          ", tostring:" + item.toString());
      holder.name.setText(item.getDishes_name());
      holder.desc.setText(item.getDishes_description());
      holder.price.setText("￥" + item.getDishes_price());

      holder.sold_num.setText("已售:" + item.getPurchase_count());
      holder.mall_price.setText(item.getRack_rate());
      Glide.with(mInflater.getContext()) //
          .load(APIConfig.BASE_IMG_URL + item.getUpload_url()) //
          .error(R.drawable.preferential_list_item_zanwutupian).
          into(holder.image);
    }
  }

  @Override public int getItemCount() {
    return mItems.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView price;
    private TextView desc;
    private TextView name;

    private TextView mall_price;
    private TextView sold_num;
    private ImageView image;

    public MyViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.dish_name);
      desc = (TextView) itemView.findViewById(R.id.dish_desc);
      price = (TextView) itemView.findViewById(R.id.dish_price);
      mall_price = (TextView) itemView.findViewById(R.id.dish_mall_price);
      sold_num = (TextView) itemView.findViewById(R.id.dish_sold_num);
      image = (ImageView) itemView.findViewById(R.id.dish_image);
    }
  }

  public void setOnItemClickListener(OnItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }
}
