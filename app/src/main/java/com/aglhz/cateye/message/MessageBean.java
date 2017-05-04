package com.aglhz.cateye.message;

/**
 * Author: LiuJia on 2017/5/4 0004 16:23.
 * Email: liujia95me@126.com
 */

public class MessageBean {

    public String location;
    public String type;
    public String time;
    public boolean read;


    public MessageBean(String location, String time, String type, boolean read) {
        this.location = location;
        this.time = time;
        this.type = type;
        this.read = read;
    }
}
