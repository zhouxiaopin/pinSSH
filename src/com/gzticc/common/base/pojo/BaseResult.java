package com.gzticc.common.base.pojo;

import com.gzticc.common.base.utils.BaseConstant;

/**
 * Created by Administrator on 2017/9/12.
 */
public class BaseResult {
    private boolean status = Boolean.TRUE;
    private int code = BaseConstant.SUCCESS_CODE;
    private String msg = BaseConstant.SUCCESS_MSG;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
