package com.gzticc.common.base.utils;

import com.google.gson.Gson;

/**
 * Created by user on 2017/9/14.
 */
public class GsonUtils {
    public static String objToJsonStr(Object o){
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}
