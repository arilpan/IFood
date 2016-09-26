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
import com.ydxiaoyuan.ifood.api.message.APPNewsList;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻列表
 * Created by arilpan@qq.com on 16/8.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {
  private List<APPNewsList.ValueBean.ListBean.DataBean> mItems = new ArrayList<>();
  private LayoutInflater mInflater;

  private OnItemClickListener mClickListener;

  public NewsListAdapter(Context context) {
    this.mInflater = LayoutInflater.from(context);
  }

  public void setDatas(List<APPNewsList.ValueBean.ListBean.DataBean> items) {
    mItems.clear();
    mItems.addAll(items);
    notifyDataSetChanged();
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = mInflater.inflate(R.layout.fragment_dish_news_list_item, parent, false);
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
    APPNewsList.ValueBean.ListBean.DataBean item = mItems.get(position);
    holder.title.setText(item.getNews_title());
    holder.content.setText(item.getNews_content());

    //todo :load defalut img
    Glide.with(mInflater.getContext()) //
        .load(APIConfig.BASE_IMG_URL + item.getNews_url()) //
            //                .resizeDimen(R.dimen.notification_icon_width_height,
            //                        R.dimen.notification_icon_width_height) //
        .error(R.drawable.preferential_list_item_zanwutupian).into(holder.image);
    //                .into(holder.image, R.id.photo, NOTIFICATION_ID, notification);
  }

  @Override public int getItemCount() {
    return mItems.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView content;

    private ImageView image;

    public MyViewHolder(View itemView) {
      super(itemView);
      title = (TextView) itemView.findViewById(R.id.title);
      content = (TextView) itemView.findViewById(R.id.content);

      image = (ImageView) itemView.findViewById(R.id.image);
    }
  }

  public void setOnItemClickListener(OnItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }
}
