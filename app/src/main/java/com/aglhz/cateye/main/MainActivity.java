package com.aglhz.cateye.main;

import android.os.Bundle;

import com.aglhz.cateye.R;
import com.aglhz.cateye.main.view.HomeFragment;

import cn.itsite.abase.mvp.view.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_main_activity, HomeFragment.newInstance());
        }
    }
}
