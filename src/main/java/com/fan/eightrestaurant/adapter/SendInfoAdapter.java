package com.fan.eightrestaurant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ydxiaoyuan.ifood.R;
import com.fan.eightrestaurant.bean.SendInfo;
import java.util.List;

/**
 * Created by xdkj on 2016/8/12.
 */
public class SendInfoAdapter extends BaseAdapter {
  private Context context;
  private List<SendInfo> list;
  public final static int LEFT = 0;
  public final static int RIGHT = 1;
  private SimpleDraweeView showImage;
  private String url = null;

  public void setUrl(String url) {
    this.url = url;
  }

  public SendInfoAdapter(Context context, List<SendInfo> list) {
    this.context = context;
    this.list = list;
  }

  @Override public int getCount() {
    if (list != null) {
      return list.size();
    }
    return 0;
  }

  @Override public Object getItem(int position) {
    return list.get(position);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public int getItemViewType(int position) {
    if (list.get(position).getBack_state() == 1) {
      return LEFT;
    } else if (list.get(position).getBack_state() == 0) {
      return RIGHT;
    } else {
      return 0;
    }
  }

  @Override public int getViewTypeCount() {
    return 2;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      viewHolder = new ViewHolder();
      switch (getItemViewType(position)) {
        case LEFT:
          convertView =
              LayoutInflater.from(context).inflate(R.layout.fragment_listview_item_left, null);
          viewHolder.showTime = (TextView) convertView.findViewById(R.id.eight_list_item_fromtime);
          viewHolder.showContent =
              (TextView) convertView.findViewById(R.id.eight_list_item_fromtext);
          break;
        case RIGHT:
          convertView =
              LayoutInflater.from(context).inflate(R.layout.fragment_listview_item_right, null);
          viewHolder.showTime = (TextView) convertView.findViewById(R.id.eight_list_item_totime);
          viewHolder.showContent = (TextView) convertView.findViewById(R.id.eight_list_item_totext);
          //获取图片
          showImage = (SimpleDraweeView) convertView.findViewById(R.id.eight_list_item_showimage);
          showImage.setImageURI(url);
          break;
      }
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }
    viewHolder.showTime.setText(list.get(position).getCreatetime());
    viewHolder.showContent.setText(list.get(position).getBack_content());

    return convertView;
  }

  class ViewHolder {
    TextView showTime, showContent;
  }
}
