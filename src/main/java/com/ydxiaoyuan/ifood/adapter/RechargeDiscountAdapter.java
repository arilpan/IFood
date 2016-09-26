package com.ydxiaoyuan.ifood.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPRechargeDiscount;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 充值优惠
 * Created by arilpan@qq.com on 16/8.
 */
public class RechargeDiscountAdapter
    extends RecyclerView.Adapter<RechargeDiscountAdapter.MyViewHolder> {
  private List<APPRechargeDiscount.ValueBean> mItems = new ArrayList<>();
  private LayoutInflater mInflater;

  private OnItemClickListener mClickListener;

  public RechargeDiscountAdapter(Context context) {
    this.mInflater = LayoutInflater.from(context);
  }

  public void setDatas(List<APPRechargeDiscount.ValueBean> items) {
    mItems.clear();
    mItems.addAll(items);
    notifyDataSetChanged();
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = mInflater.inflate(R.layout.fragment_discount_list_item, parent, false);
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

  @Override public void onBindViewHolder(final MyViewHolder holder, int position) {
    APPRechargeDiscount.ValueBean item = mItems.get(position);
    holder.item_mall_name.setText(item.getShop_name());
    holder.item_card_name.setText(item.getCard_name());
    holder.item_desc.setText(item.getCard_rule());
    holder.item_time.setText(item.getActivity_start_time() + "--" + item.getActivity_end_time());
    //        holder.soldNum.setText(item.getNum() + "人购买");
    Glide.with(mInflater.getContext()) //
        .load(APIConfig.BASE_IMG_URL + item.getShop_pic()) //
        .error(R.drawable.chongzhi_dianpu).into(holder.item_image);

    if (("黄金卡").equals(item.getCard_name())) {
      holder.item_bg.setBackgroundResource(R.drawable.chongzhi_jinkabj);
      //            Picasso.with(mInflater.getContext()) //
      //                    .load(R.drawable.chongzhi_jinkabj) //
      //                    .error(R.drawable.chongzhi_yinkabj)
      //                    .into();
    } else if (("丽人卡").equals(item.getCard_name())) {
      holder.item_bg.setBackgroundResource(R.drawable.chongzhi_lirenkabj);
      //            Picasso.with(mInflater.getContext()) //
      //                    .load(R.drawable.chongzhi_lirenkabj) //
      //                    .error(R.drawable.chongzhi_yinkabj)
      //                    .into(holder.item_bg);
    } else {
      holder.item_bg.setBackgroundResource(R.drawable.chongzhi_yinkabj);
      //            Picasso.with(mInflater.getContext()) //
      //                    .load(R.drawable.chongzhi_yinkabj) //
      //                    .error(R.drawable.chongzhi_yinkabj)
      //                    .into(holder.item_bg);
    }
  }

  @Override public int getItemCount() {
    return mItems.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView item_mall_name;
    private TextView item_card_name;
    private TextView item_desc;
    private TextView item_time;

    private ImageView item_image;
    private LinearLayout item_bg;

    public MyViewHolder(View itemView) {
      super(itemView);
      item_mall_name = (TextView) itemView.findViewById(R.id.item_mall_name);
      item_card_name = (TextView) itemView.findViewById(R.id.item_card_name);
      item_desc = (TextView) itemView.findViewById(R.id.item_desc);
      item_time = (TextView) itemView.findViewById(R.id.item_time);
      item_image = (ImageView) itemView.findViewById(R.id.item_image);
      item_bg = (LinearLayout) itemView.findViewById(R.id.item_bg);
    }
  }

  public void setOnItemClickListener(OnItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }
}
