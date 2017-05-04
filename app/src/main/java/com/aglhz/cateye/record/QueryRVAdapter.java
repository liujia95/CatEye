package com.aglhz.cateye.record;

import android.support.v7.widget.RecyclerView;

import com.aglhz.cateye.R;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.itsite.abase.mvp.view.base.BaseRecyclerViewAdapter;

/**
 * Author: LiuJia on 2017/5/4 0004 18:46.
 * Email: liujia95me@126.com
 */

public class QueryRVAdapter extends BaseRecyclerViewAdapter<HourseBean, BaseViewHolder> {

    public QueryRVAdapter(List<HourseBean> data) {
        super(R.layout.item_query_device, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HourseBean item) {
        helper.setImageResource(R.id.iv_img_item_query_device, item.imgRes)
                .setText(R.id.tv_name_item_query_device, item.name);
    }
}
