package com.jiyun.eventbus;

/**
 * Created by jinguo on 2017/7/24.
 */

public class LoginEevent {

    private String msg;


    public LoginEevent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
