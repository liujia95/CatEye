package com.aglhz.cateye.device;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aglhz.cateye.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.itsite.abase.mvp.view.base.BaseFragment;

/**
 * Author: LiuJia on 2017/5/4 0004 16:05.
 * Email: liujia95me@126.com
 */

public class DeviceSettingsItemsFragment extends BaseFragment {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private DeviceRVAdapter adapter;
    Unbinder unbinder;

    public static DeviceSettingsItemsFragment newInstance() {
        return new DeviceSettingsItemsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device_settings_items, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
    }

    private void initToolbar() {
        initStateBar(toolbar);
        toolbarTitle.setText("设置");
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mActivity.onBackPressedSupport();
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ll_change_params_fragment_device_settings, R.id.ll_device_settings_fragment_device_settings, R.id.tv_delete_fragment_device_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_change_params_fragment_device_settings:
                start(UpdateParamsFragment.newInstance());
                break;
            case R.id.ll_device_settings_fragment_device_settings:
                start(DeviceSettingsFragment.newInstance());
                break;
            case R.id.tv_delete_fragment_device_settings:

                break;
        }
    }
}
