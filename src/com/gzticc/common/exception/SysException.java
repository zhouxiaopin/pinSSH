package com.gzticc.common.exception;

/**
 * Created by Administrator on 2017/9/14.
 */
public class SysException  extends RuntimeException{
    //异常信息
    private String message;

    public SysException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
