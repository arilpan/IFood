package com.fan.eightrestaurant.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fan.eightrestaurant.bean.Preferential;
import com.fan.eightrestaurant.utils.PathUtils;
import com.ydxiaoyuan.ifood.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdkj on 2016/8/18.
 */
public class PreferentialAdapter extends BaseAdapter {
  private Context context;
  private List<Preferential> list = null;
  private SimpleDraweeView showImage;

  public PreferentialAdapter(Context context) {
    this.context = context;
    list = new ArrayList<>();
  }

  public void setList(List<Preferential> list) {
    this.list = list;
    notifyDataSetChanged();
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

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      viewHolder = new ViewHolder();
      convertView =
          LayoutInflater.from(context).inflate(R.layout.activity_preferential_list_item, null);
      viewHolder.title = (TextView) convertView.findViewById(R.id.activity_preferential_title);
      viewHolder.description =
          (TextView) convertView.findViewById(R.id.activity_preferential_description);
      viewHolder.endTime = (TextView) convertView.findViewById(R.id.activity_preferential_end_time);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }
    viewHolder.title.setText(list.get(position).getCard_rule());
    viewHolder.description.setText(list.get(position).getContent_validity());
    viewHolder.endTime.setText("\t" + list.get(position).getActivity_end_time() + "截止");
    //下载图片
    String path = PathUtils.path + list.get(position).getUpload_url();
    Uri uri = Uri.parse(path);
    showImage = (SimpleDraweeView) convertView.findViewById(R.id.activity_preferential_showimage);
    showImage.setImageURI(uri);
    return convertView;
  }

  class ViewHolder {
    TextView title, description, endTime;
  }
}
