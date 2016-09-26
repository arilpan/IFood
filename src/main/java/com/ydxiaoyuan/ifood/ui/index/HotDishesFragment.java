package com.ydxiaoyuan.ifood.ui.index;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import com.ydxiaoyuan.ifood.MainActivity;
import com.ydxiaoyuan.ifood.R;
import com.ydxiaoyuan.ifood.adapter.dish.HotDishesAdapter;
import com.ydxiaoyuan.ifood.api.APIConfig;
import com.ydxiaoyuan.ifood.api.message.APPALL;
import com.ydxiaoyuan.ifood.base.BaseFragment;
import com.ydxiaoyuan.ifood.api.RequestType;
import com.ydxiaoyuan.ifood.event.NetworkEvent;
import com.ydxiaoyuan.ifood.event.StartBrotherEvent;
import com.ydxiaoyuan.ifood.event.TabSelectedEvent;
import com.ydxiaoyuan.ifood.listener.OnItemClickListener;
import com.zfeng.swiperefreshload.SwipeRefreshLoadLayout;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by aril_pan@qq.com on 16/8.
 */
public class HotDishesFragment extends BaseFragment {
    //        implements SwipeRefreshLayout.OnRefreshListener {
    int SECOND = 1;

    private boolean mInAtTop = true;
    private int mScrollTotal;
    private SwipeRefreshLoadLayout mRefreshLayout;
    private RecyclerView mRecy;
    private HotDishesAdapter mAdapter;
    String shop_id = APIConfig.shop_one_id;
    private static final String ARG_NUMBER = "shop_id";

    public static HotDishesFragment newInstance(String shop_id) {
        Bundle args = new Bundle();
        args.putString(ARG_NUMBER, shop_id);
        HotDishesFragment fragment = new HotDishesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            shop_id = args.getString(ARG_NUMBER);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dish_hot_switch_layout, container, false);
        initView(view);
        return view;
    }

    /****************************************************************/
    public void addTab(View view) {
        final TextView tab1 = (TextView) view.findViewById(R.id.tab1);
        final TextView tab2 = (TextView) view.findViewById(R.id.tab2);

        tab1.setTextColor(Color.rgb(172, 66, 66));
        tab2.setTextColor(Color.rgb(66, 66, 66));

        tab1.setText(APIConfig.shop_one_name);
        tab2.setText(APIConfig.shop_two_name);
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop_id = APIConfig.shop_one_id;
                EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_HOT,
                        shop_id));
                tab1.setTextColor(Color.rgb(172, 66, 66));
                tab2.setTextColor(Color.rgb(66, 66, 66));
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop_id = APIConfig.shop_two_id;
                EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_HOT,
                        shop_id));
                tab2.setTextColor(Color.rgb(172, 66, 66));
                tab1.setTextColor(Color.rgb(66, 66, 66));
            }
        });
    }

    /****************************************************************/
    private void initView(View view) {
        setTitle(view, "热门菜品");
        view.findViewById(R.id.title_ll_left).setOnClickListener(new View
                .OnClickListener() {
            @Override
            public void onClick(View v) {
                _mActivity.onBackPressed();
            }
        });

        EventBus.getDefault().register(this);
        addTab(view);

        datas = new ArrayList<>();
        datasRight = new ArrayList<>();

        mRecy = (RecyclerView) view.findViewById(R.id.switch_recv_left);
        mRefreshLayout = (SwipeRefreshLoadLayout) view.findViewById(R.id.refresh_layout_left);


//        mRefreshLayout.
        mAdapter = new HotDishesAdapter(_mActivity);
        mRecy.setHasFixedSize(true);
//        mRecy.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager
//                .VERTICAL));
        mRecy.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecy.setAdapter(mAdapter);

        //滑动事件
//        mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                mScrollTotal += dy;
//                if (mScrollTotal <= 0) {
//                    mInAtTop = true;
//                } else {
//                    mInAtTop = false;
//                }
//            }
//        });

        //点击事件
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder holder) {
//                if (DishDetailFragment.getInstance().isAdded()) {
//                    DishDetailFragment.getInstance().show(fm, tag);
//                } else {
//                }
                if (datas != null) {
                    String dish_id = datas.get(position).getDishes_id();
                    EventBus.getDefault().post(
                            new StartBrotherEvent(
                                    DishDetailFragment.newInstance(dish_id)));
                }

                // 通知MainActivity跳转
//                EventBus.getDefault().post(
//                        new StartBrotherEvent(DishDetailFragment.newInstance(1)));
            }
        });

//        // Init Datas
//        List<APPALL.ValueBean.DataBean> items = new ArrayList<>();
        mAdapter.setDatas(datas);

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLoadLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
        mRefreshLayout.setLoadMoreListener(new SwipeRefreshLoadLayout.LoadMoreListener() {
            @Override
            public void loadMore() {
                loadMoreData();
            }
        });
        EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_HOT,
                shop_id));
    }

    //    @Override
//    public void onRefresh() {
//        EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_HOT,
//                "36dbde58-5ab5-41b5-915c-66048e63a5df"));
//        Log.e("arilpan", "HotDishesFragment onRefresh 调用？？？  ");
//        mRefreshLayout.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mRefreshLayout.setRefreshing(false);
//            }
//        }, 1500);
//    }


    int start = 0;
    int startRight = 0;
    int end = 10;
    boolean isLoadMore = false;
    boolean isRefresh = true;

    private void refreshContent() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isLoadMore = false;
                isRefresh = true;
                EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_HOT,
                        shop_id));
                Log.e("arilpan", "调用 refreshContent  ");
                mRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }

    private void loadMoreData() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isLoadMore = true;
                isRefresh = false;
                EventBus.getDefault().post(new NetworkEvent(RequestType.INDEX_DISH_HOT,
                        shop_id));
                Log.e("arilpan", "调用loadMoreData  ");
                mRefreshLayout.setLoadMore(false);
            }
        }, 1000);
    }

    private String getUrl(String url) {
        if (isRefresh) {
            return url.replace("###", String.valueOf(0)).
                    replace("$$$", String.valueOf(10));
        } else if (isLoadMore) {
            if (isShopOne()) {
                start += 10;
                return url.replace("###", String.valueOf(start)).
                        replace("$$$", String.valueOf(end));
            } else {
                startRight += 10;
                return url.replace("###", String.valueOf(startRight)).
                        replace("$$$", String.valueOf(end));
            }
        }
        return url.replace("###", String.valueOf(0)).
                replace("$$$", String.valueOf(10));
    }

    /**
     * Reselected Tab
     */
    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event) {
        if (event.position != SECOND)
            return;
        if (mInAtTop) {
            mRefreshLayout.setRefreshing(true);
//            onRefresh();
        } else {
            scrollToTop();
        }
    }


    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onNetWork(NetworkEvent event) {
        Log.e("arilpan", "HotDishFragment 你调用咩?");
        if (APIConfig.dish_hot_more_url.equals(event.url)) {
            Log.e("arilpan", "HotDishFragment equals url");
            setData(getData(event.url + event.id));
        } else {
            Log.e("arilpan", "nothing happend ");
        }
    }


    public List<APPALL.ValueBean.DataBean> getData(String url) {
        try {
            final JsonAdapter<APPALL>
                    COM_JSON_ADAPTER = MainActivity.MOSHI.adapter(
                    Types.newParameterizedType(APPALL.class));
            OkHttpClient client = new OkHttpClient();

            url = getUrl(url);

            Log.e("arilpan", "url 结果 :" + url);
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();

            APPALL datas_arry =
                    COM_JSON_ADAPTER.fromJson(body.source());
            body.close();
            List<APPALL.ValueBean.DataBean> newdatas = datas_arry.getValue().getData();
            Log.e("arilpan", "newdatas.size：" + newdatas.size());
            if (newdatas.size() != 10) {
                if (isShopOne()) {
                    start -= 10;
                } else {
                    startRight -= 10;
                }
            }
            return newdatas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    List<APPALL.ValueBean.DataBean> datas;
    List<APPALL.ValueBean.DataBean> datasRight;

    public static List<APPALL.ValueBean.DataBean> removeDuplicate(List<APPALL.ValueBean.DataBean> list) {
        Set set = new LinkedHashSet<APPALL.ValueBean.DataBean>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    private boolean isShopOne() {
        return shop_id.equals(APIConfig.shop_one_id);
    }

    public void setData(final List<APPALL.ValueBean.DataBean> items) {
        try {
            _mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (datas == null) {
                        Log.e("arilpan", "datas is null");
                    }
//                    if (items == null) {
//                        Log.e("arilpan", "items is null start   -= 10");
//                        if (start >= 10) {
//                            start -= 10;
//                        }
//                    } else {
//                        datas.addAll(items);
//                        removeDuplicate(datas);
//                        mAdapter.setDatas(datas);
//                    }
                    if (items == null) {
                        Log.e("arilpan", "返回为null");
                        if (isShopOne()) {
                            start -= 10;
                        } else {
                            startRight -= 10;
                        }
                        return;
                    }
                    if (shop_id.equals(APIConfig.shop_one_id)) {
                        datas.addAll(items);
                        removeDuplicate(datas);
                        mAdapter.setDatas(datas);
                    } else if (shop_id.equals(APIConfig.shop_two_id)) {
                        datasRight.addAll(items);
                        removeDuplicate(datasRight);
                        mAdapter.setDatas(datasRight);
                    }
                    //上拉
//                    if (isLoadMore) {
//
//                        mAdapter.setDatas(items);
//                    } else {
//
//                    }
//                    for (APPALL.ValueBean.DataBean avd : items) {
//                        if (datas.contains(items)) {
//
//                        }
//                        else
//                        {
//                            //对比否
//                        }
//                    }


                    //stuff that updates ui
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void scrollToTop() {
        mRecy.smoothScrollToPosition(0);
    }

    @Override
    public boolean onBackPressedSupport() {
        // 默认flase，继续向上传递
        return super.onBackPressedSupport();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRecy.setAdapter(null);
        EventBus.getDefault().unregister(this);
    }
}
