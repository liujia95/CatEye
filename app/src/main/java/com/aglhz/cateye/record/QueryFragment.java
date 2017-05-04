package com.aglhz.cateye.record;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aglhz.cateye.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.itsite.abase.mvp.view.base.BaseFragment;

/**
 * Author: LiuJia on 2017/5/4 0004 18:45.
 * Email: liujia95me@126.com
 */

public class QueryFragment extends BaseFragment {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView_fragment_query)
    RecyclerView recyclerview;
    Unbinder unbinder;
    @BindView(R.id.toolbar_menu)
    TextView toolbarMenu;

    public static QueryFragment newInstance() {
        return new QueryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
        initData();
        initListener();
    }

    private void initToolbar() {
        initStateBar(toolbar);
        toolbarTitle.setText("记录查询");
        toolbarMenu.setText("查询");
    }

    private void initData() {
        recyclerview.setLayoutManager(new LinearLayoutManager(_mActivity));
        List<HourseBean> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new HourseBean("海伦堡1单元401", R.mipmap.ic_launcher, false));
        }
        QueryRVAdapter adapter = new QueryRVAdapter(data);
        View view = LayoutInflater.from(_mActivity).inflate(R.layout.item_query_header, null, false);
        adapter.addHeaderView(view);
        recyclerview.setAdapter(adapter);
    }

    private void initListener() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.toolbar_menu)
    public void onViewClicked() {
        _mActivity.start(RecordFragment.newInstance());
    }
}
