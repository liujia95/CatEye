package com.aglhz.cateye.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aglhz.cateye.R;
import com.aglhz.cateye.device.DeviceRVAdapter;
import com.aglhz.cateye.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.itsite.abase.mvp.view.base.BaseFragment;

/**
 * Author: LiuJia on 2017/5/4 0004 11:35.
 * Email: liujia95me@126.com
 */

public class MineFragment extends BaseFragment {

    @BindView(R.id.tv_title_fragment_mine)
    TextView tvTitle;
    private DeviceRVAdapter adapter;
    Unbinder unbinder;

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initStateBar(tvTitle);
        initData();
    }


    private void initData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.ll_change_password, R.id.ll_share, R.id.ll_repair, R.id.ll_into_shore, R.id.ll_about_me, R.id.ll_setout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_change_password:
                break;
            case R.id.ll_share:
                break;
            case R.id.ll_repair:
                _mActivity.start(RepairFragment.newInstance());
                break;
            case R.id.ll_into_shore:
                break;
            case R.id.ll_about_me:
                break;
            case R.id.ll_setout:
                Intent intent = new Intent(_mActivity, LoginActivity.class);
                _mActivity.startActivity(intent);
                break;
        }
    }
}
