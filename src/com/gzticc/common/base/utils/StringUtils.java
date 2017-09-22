package com.gzticc.common.base.utils;

/**
 * Created by Administrator on 2017/9/22.
 */
public class StringUtils {
    public static boolean isNull(String s){
        if(null == s || 0 >= s.length()) {
            return true;
        }
        return false;
    }
}
