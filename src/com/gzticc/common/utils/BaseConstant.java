package com.gzticc.common.utils;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface BaseConstant {

    /**************返回的提示code****************/
    int SUCCESS_CODE = 0;
    int FAIL_CODE = -1;
    int FALL_NOT_AUTH = -2;
    int EXCEPTION_CODE = -3;
    int ADD_SUCCESS_CODE = 1;
    int DEL_SUCCESS_CODE = 2;
    int MDF_SUCCESS_CODE = 3;
    int QRY_SUCCESS_CODE = 4;
    int AUD_SUCCESS_CODE = 5;

    /**************返回的提示msg****************/
    String SUCCESS_MSG = "操作成功";
    String FAIL_MSG = "操作失败";

    String ADD_SUCCESS_MSG = "增加操作成功";
    String ADD_FAIL_MSG = "增加操作失败";

    String DEL_SUCCESS_MSG = "删除操作成功";
    String DEL_FAIL_MSG = "删除操作失败";

    String MDF_SUCCESS_MSG = "修改操作成功";
    String MDF_FAIL_MSG = "修改操作失败";

    String QRY_SUCCESS_MSG = "查询操作成功";
    String QRY_FAIL_MSG = "查询操作失败";

    String AUD_FAIL_MSG = "审核操作失败";
    String AUD_SUCCESS_MSG = "审核操作成功";

    String RECORD_EXISTS_YES_MSG = "记录已存在";
    String RECORD_EXISTS_NO_MSG = "记录不存在";

    String EXCEPTION__MSG = "系统繁忙,请稍后再试";

    /**************默认分页查询的条数****************/
    int DEFAULT_PAGE_COUNT = 10;



}