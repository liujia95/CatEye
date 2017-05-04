package com.aglhz.cateye.login;

import android.os.Bundle;

import com.aglhz.cateye.R;
import com.aglhz.cateye.main.view.HomeFragment;

import cn.itsite.abase.mvp.view.base.BaseActivity;
import cn.itsite.abase.mvp.view.base.BaseFragment;

/**
 * Author: LiuJia on 2017/5/4 0004 21:24.
 * Email: liujia95me@126.com
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_main_activity, LoginFragment.newInstance());
        }
    }
}
