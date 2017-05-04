package com.aglhz.cateye.device;

import com.aglhz.cateye.R;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.itsite.abase.mvp.view.base.BaseRecyclerViewAdapter;

/**
 * Author: LiuJia on 2017/5/4 0004 14:10.
 * Email: liujia95me@126.com
 */

public class DeviceRVAdapter extends BaseRecyclerViewAdapter<DeviceBean, BaseViewHolder> {

    public DeviceRVAdapter(List<DeviceBean> data) {
        super(R.layout.item_device, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceBean item) {
        helper.setText(R.id.tv_location_item_device, item.location)
                .setText(R.id.tv_online_item_device, item.onLine ? "设备在线" : "设备不在线")
                .addOnClickListener(R.id.iv_setup_item_device)
                .addOnClickListener(R.id.cv_item_device)
                .addOnClickListener(R.id.iv_key_item_device);
    }
}
