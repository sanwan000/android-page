package cn.yhq.page.ui;

import android.support.v4.widget.SwipeRefreshLayout;

import com.markmao.pulltorefresh.widget.XListView;

/**
 * Created by Yanghuiqiang on 2016/10/12.
 */

public class PullToRefreshSwipeLayoutListViewContext extends PullToRefreshListViewContext {
    SwipeRefreshLayout swipeRefreshLayout;

    public PullToRefreshSwipeLayoutListViewContext(SwipeRefreshLayout swipeRefreshLayout, XListView xListView) {
        super(xListView);
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
    }
    @Override
    public void setPullRefreshEnable(boolean enable) {
        super.setPullRefreshEnable(false);
    }

    @Override
    public boolean isPullRefreshEnable() {
        return false;
    }

    @Override
    public boolean isPullLoadMoreEnable() {
        return true;
    }

    @Override
    public void onRefreshComplete(boolean success) {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setOnRefreshListener(final OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onRefreshListener.onPullToRefresh();
            }
        });
    }
}
