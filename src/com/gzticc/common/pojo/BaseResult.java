package com.gzticc.common.pojo;

import com.gzticc.common.utils.BaseConstant;

/**
 * Created by Administrator on 2017/9/12.
 */
public class BaseResult {
    private boolean status;
    private int code = BaseConstant.SUCCESS_CODE;
    private String msg = BaseConstant.SUCCESS_MSG;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return BaseConstant.SUCCESS_CODE <= code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
