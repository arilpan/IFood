package com.ydxiaoyuan.ifood.adapter;

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
import com.ydxiaoyuan.ifood.api.message.APPComments;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜品评论
 * Created by arilpan@qq.com on 16/8.
 */
public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {
  private LayoutInflater mInflater;
  private Context mContext;
  private List<APPComments.ValueBean> mItems = new ArrayList<>();
  private OnItemClickListener mClickListener;

  public CommentsAdapter(Context context) {
    mInflater = LayoutInflater.from(context);
    mContext = context;
  }

  public void setDatas(List<APPComments.ValueBean> items) {
    mItems.clear();
    mItems.addAll(items);
    notifyDataSetChanged();
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.fragment_dish_detail_comments_item, parent, false);
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
    //        if (!mBooleanArray.get(position)) {
    //            holder.viewLine.setVisibility(View.INVISIBLE);
    //            holder.itemView.setBackgroundResource(R.color.shop_bg_app);
    //            holder.name.setTextColor(Color.BLACK);
    //        } else {
    //            holder.viewLine.setVisibility(View.VISIBLE);
    //            holder.itemView.setBackgroundColor(Color.WHITE);
    //            holder.name.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
    //        }
    //        holder.name.setText(mItems.get(position));
    holder.name.setText(mItems.get(position).getNickname());
    holder.content.setText(mItems.get(position).getContent());
    holder.time.setText(mItems.get(position).getEvaluation_time());

    Glide.with(mInflater.getContext())
        .load(APIConfig.BASE_IMG_URL + mItems.get(position).getUser_icon())
        .error(R.drawable.wode_touxiang)
        .into(holder.icon);
  }

  @Override public int getItemCount() {
    return mItems.size();
  }
  //
  //    public void setItemChecked(int position) {
  //        mBooleanArray.put(position, true);
  //
  //        if (mLastCheckedPosition > -1) {
  //            mBooleanArray.put(mLastCheckedPosition, false);
  //            notifyItemChanged(mLastCheckedPosition);
  //        }
  //        notifyDataSetChanged();
  //
  //        mLastCheckedPosition = position;
  //    }

  class MyViewHolder extends RecyclerView.ViewHolder {
    View viewLine;
    ImageView icon;
    TextView name;
    TextView time;
    TextView content;

    public MyViewHolder(View itemView) {
      super(itemView);
      //            viewLine = itemView.findViewById(R.id.view_line);
      icon = (ImageView) itemView.findViewById(R.id.icon);
      name = (TextView) itemView.findViewById(R.id.name);
      time = (TextView) itemView.findViewById(R.id.time);
      content = (TextView) itemView.findViewById(R.id.content);
    }
  }

  public void setOnItemClickListener(OnItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }
}
