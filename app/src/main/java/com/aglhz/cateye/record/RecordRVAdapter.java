package com.aglhz.cateye.record;

import com.aglhz.cateye.R;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.itsite.abase.mvp.view.base.BaseRecyclerViewAdapter;

/**
 * Author: LiuJia on 2017/5/4 0004 20:55.
 * Email: liujia95me@126.com
 */

public class RecordRVAdapter extends BaseRecyclerViewAdapter<RecordBean,BaseViewHolder> {

    public RecordRVAdapter(List<RecordBean> data) {
        super(R.layout.item_record, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecordBean item) {

    }
}
