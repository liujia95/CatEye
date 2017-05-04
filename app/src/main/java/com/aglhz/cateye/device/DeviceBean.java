package com.aglhz.cateye.device;

/**
 * Author: LiuJia on 2017/5/4 0004 14:11.
 * Email: liujia95me@126.com
 */

public class DeviceBean {

    public String location;
    public int bgRes;
    public boolean onLine;

    public DeviceBean(String location, int bgRes, boolean onLine) {
        this.location = location;
        this.bgRes = bgRes;
        this.onLine = onLine;
    }
}
