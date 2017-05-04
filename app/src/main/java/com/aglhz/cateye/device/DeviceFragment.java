package com.aglhz.cateye.device;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aglhz.cateye.R;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.itsite.abase.mvp.view.base.BaseFragment;

/**
 * Author: LiuJia on 2017/5/4 0004 11:34.
 * Email: liujia95me@126.com
 */

public class DeviceFragment extends BaseFragment {


    @BindView(R.id.recyclerView_fragment_device)
    RecyclerView recyclerview;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_menu)
    TextView toolbarMenu;

    private DeviceRVAdapter adapter;
    Unbinder unbinder;

    public static DeviceFragment newInstance() {
        return new DeviceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device, container, false);
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
        toolbarTitle.setText("设备管理");
        toolbarMenu.setText("添加设备");
    }

    private void initData() {
        recyclerview.setLayoutManager(new LinearLayoutManager(_mActivity));
        List<DeviceBean> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(new DeviceBean("现代花园1单元501", R.mipmap.ic_launcher, true));
            datas.add(new DeviceBean("海伦堡1单元501", R.mipmap.ic_launcher, false));
        }
        adapter = new DeviceRVAdapter(datas);
        recyclerview.setAdapter(adapter);
    }

    private void initListener() {
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.cv_item_device:
                        Toast.makeText(_mActivity, "click video" + position, Toast.LENGTH_SHORT).show();
                        _mActivity.start(MonitoringFragment.newInstance());
                        break;
                    case R.id.iv_key_item_device:
                        Toast.makeText(_mActivity, "click key" + position, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.iv_setup_item_device:
                        Toast.makeText(_mActivity, "click setup" + position, Toast.LENGTH_SHORT).show();
                        _mActivity.start(DeviceSettingsItemsFragment.newInstance());
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.toolbar_menu)
    public void onViewClicked() {
        _mActivity.start(DeviceAddFragment.newInstance());
    }
}
