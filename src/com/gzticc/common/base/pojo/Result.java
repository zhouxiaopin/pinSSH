package com.gzticc.common.base.pojo;

/**
 * Created by user on 2017/5/29.
 */
public class Result<T> {

    /**
     * status : true
     * msg : 登录成功
     * data : {}
     */

    private String status;
    private String msg;
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
