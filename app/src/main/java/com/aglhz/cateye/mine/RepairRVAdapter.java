package com.aglhz.cateye.mine;

import com.aglhz.cateye.R;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.itsite.abase.mvp.view.base.BaseRecyclerViewAdapter;

/**
 * Author: LiuJia on 2017/5/4 0004 21:10.
 * Email: liujia95me@126.com
 */

public class RepairRVAdapter extends BaseRecyclerViewAdapter<RepairBean, BaseViewHolder> {

    public RepairRVAdapter(List<RepairBean> data) {
        super(R.layout.item_repairs, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairBean item) {

    }
}
