package com.aglhz.cateye.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aglhz.cateye.R;
import com.aglhz.cateye.device.DeviceFragment;
import com.aglhz.cateye.message.MessageFragment;
import com.aglhz.cateye.mine.MineFragment;
import com.aglhz.cateye.record.QueryFragment;
import com.aglhz.cateye.record.RecordFragment;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import cn.itsite.abase.mvp.view.base.BaseFragment;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Author: LiuJia on 2017/5/4 0004 10:52.
 * Email: liujia95me@126.com
 */

public class HomeFragment extends BaseFragment {

    private AHBottomNavigation ahbn;
    private SupportFragment[] fragments = new SupportFragment[5];
    private int bottomNavigationPreposition;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ahbn = (AHBottomNavigation) view.findViewById(R.id.ahbn_home_fragment);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            fragments[0] = DeviceFragment.newInstance();
            fragments[1] = QueryFragment.newInstance();
            fragments[2] = MessageFragment.newInstance();
            fragments[3] = MineFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_container_home_fragment, 0, fragments[0], fragments[1], fragments[2], fragments[3]);
        } else {
            fragments[0] = findFragment(DeviceFragment.class);
            fragments[1] = findFragment(QueryFragment.class);
            fragments[2] = findFragment(MessageFragment.class);
            fragments[3] = findFragment(MineFragment.class);
        }
        initData();
        initListener();
    }

    private void initData() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.device, R.drawable.ic_navigationhome_black_78px, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.record, R.drawable.ic_navigationset_black_78px, R.color.white);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.message, R.drawable.ic_navigationnew_black_78px, R.color.white);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.mine, R.drawable.ic_navigationmy_black_78px, R.color.white);
        List<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item3);
        bottomNavigationItems.add(item4);
        ahbn.addItems(bottomNavigationItems);
        ahbn.setDefaultBackgroundColor(getResources().getColor(R.color.white));
        ahbn.setBehaviorTranslationEnabled(false);
        ahbn.setColored(true);
        ahbn.setForceTint(false);
        ahbn.setAccentColor(getResources().getColor(R.color.base_color));
        ahbn.setInactiveColor(getResources().getColor(R.color.black));
        ahbn.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        ahbn.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, final boolean wasSelected) {
                showHideFragment(fragments[position], fragments[bottomNavigationPreposition]);
                bottomNavigationPreposition = position;
                return true;
            }
        });
        ahbn.setCurrentItem(0);
    }

    private void initListener() {
    }

}
