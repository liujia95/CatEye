package com.aglhz.cateye;

import android.app.Application;
import android.content.Context;

/**
 * Author: LiuJia on 2017/5/4 0004 16:41.
 * Email: liujia95me@126.com
 */

public class BaseApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
