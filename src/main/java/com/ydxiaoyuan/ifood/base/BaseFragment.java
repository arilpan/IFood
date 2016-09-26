package com.ydxiaoyuan.ifood.base;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ydxiaoyuan.ifood.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by YoKeyword on 16/2/3.
 */
public class BaseFragment extends SupportFragment {
  private static final String TAG = "Fragmentation";

  protected void setTitle(View view, String title) {
    ((TextView) view.findViewById(R.id.title_middle)).setText(title);
  }

  protected void initToolbarMenu(Toolbar toolbar) {
    toolbar.inflateMenu(R.menu.hierarchy);
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
          case R.id.action_hierarchy:
            _mActivity.showFragmentStackHierarchyView();
            _mActivity.logFragmentStackHierarchy(TAG);
            break;
        }
        return true;
      }
    });
  }
}
