package com.aglhz.cateye.message;

import com.aglhz.cateye.BaseApplication;
import com.aglhz.cateye.R;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.itsite.abase.mvp.view.base.BaseActivity;
import cn.itsite.abase.mvp.view.base.BaseRecyclerViewAdapter;
import cn.itsite.abase.utils.StringUtils;

/**
 * Author: LiuJia on 2017/5/4 0004 16:23.
 * Email: liujia95me@126.com
 */

public class MessageRVAdapter extends BaseRecyclerViewAdapter<MessageBean, BaseViewHolder> {

    public MessageRVAdapter(List<MessageBean> data) {
        super(R.layout.item_message, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageBean item) {
        helper.setText(R.id.tv_time_item_message, item.time)
                .setText(R.id.tv_location_item_message, String.format(BaseApplication.mContext.getResources().getString(R.string.device_name), item.location))
                .setText(R.id.tv_type_item_message, String.format(BaseApplication.mContext.getResources().getString(R.string.alarm_type), item.type))
                .setImageResource(R.id.iv_status_item_message, item.read ? R.drawable.ic_newsread_black_120px : R.drawable.ic_news_brown_120px);
    }
}
