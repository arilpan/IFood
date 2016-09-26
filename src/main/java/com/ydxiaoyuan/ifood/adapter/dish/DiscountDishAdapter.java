package com.ydxiaoyuan.ifood.adapter.dish;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPDishDiscount;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arilpan@qq.com on 16/8.
 */
public class DiscountDishAdapter
    extends RecyclerView.Adapter<DiscountDishAdapter.MyViewHolder> {
  private List<APPDishDiscount.ValueBean.DataBean> mItems = new ArrayList<>();
  private LayoutInflater mInflater;

  private OnItemClickListener mClickListener;

  public DiscountDishAdapter(Context context) {
    this.mInflater = LayoutInflater.from(context);
  }

  public void setDatas(List<APPDishDiscount.ValueBean.DataBean> items) {
    if (items == null) return;
    mItems.clear();
    mItems.addAll(items);
    notifyDataSetChanged();
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.fragment_discount_dish_item, parent, false);
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

  @Override public void onBindViewHolder(MyViewHolder newholder, int position) {
    if (mItems != null) {
      //APIALL.ValueBean.DataBean
      APPDishDiscount.ValueBean.DataBean item = mItems.get(position);
      Log.e("arilpan", "position:" + position +
          ", tostring:" + item.toString());

      APPDishDiscount.ValueBean.DataBean dish = mItems.get(position);

      int key = Integer.parseInt(dish.getDiscount_type());
      switch (key) {
        //                case 0:
        //                    holder.discount_item_type.setText("零折免费菜品");
        //                    break;
        case 1:
          newholder.discount_item_type.setText("一折菜品");
          break;
        case 2:
          newholder.discount_item_type.setText("二折菜品");
          break;
        case 3:
          newholder.discount_item_type.setText("三折菜品");
          break;
        case 4:
          newholder.discount_item_type.setText("四折菜品");
          break;
        case 5:
          newholder.discount_item_type.setText("五折菜品");
          break;
        case 6:
          newholder.discount_item_type.setText("六折菜品");
          break;
        case 7:
          newholder.discount_item_type.setText("七折菜品");
          break;
        case 8:
          newholder.discount_item_type.setText("八折菜品");
          break;
        case 9:
          newholder.discount_item_type.setText("九折菜品");
          break;
        case 10:
          newholder.discount_item_type.setText("十折菜品");
          break;
        default:
          newholder.discount_item_type.setText("未知折扣");
          break;
      }

      newholder.dish_name.setText(dish.getDishes_name());
      newholder.dish_price.setText("￥" + dish.getDishes_price());
      newholder.dish_old_price.setText(dish.getRack_rate());
      newholder.dish_desc.setText(dish.getDishes_description());
      Glide.with(mInflater.getContext()) //
          .load(APIConfig.BASE_IMG_URL + dish.getUpload_url()) //
          .error(R.drawable.preferential_list_item_zanwutupian).
          into(newholder.dish_icon);
    }
  }

  @Override public int getItemCount() {
    return mItems.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    TextView discount_item_type;
    RelativeLayout dish_rlayout;
    ImageView dish_icon;
    TextView dish_name;
    TextView dish_price;
    TextView dish_old_price;
    TextView dish_desc;

    public MyViewHolder(View view) {
      super(view);
      discount_item_type = (TextView) view.findViewById(R.id.discount_item_type);
      dish_rlayout = (RelativeLayout) view.findViewById(R.id.dish_rlayout);
      dish_icon = (ImageView) view.findViewById(R.id.dish_image);
      dish_name = (TextView) view.findViewById(R.id.dish_name);
      dish_price = (TextView) view.findViewById(R.id.dish_price);
      dish_old_price = (TextView) view.findViewById(R.id.dish_mall_price);
      dish_desc = (TextView) view.findViewById(R.id.dish_desc);
    }
  }

  public void setOnItemClickListener(OnItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }
}
