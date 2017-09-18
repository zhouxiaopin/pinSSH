package com.gzticc.common.base.utils;

import java.util.Collection;

/**
 * Created by Administrator on 2017/9/18.
 */
public class BaseUtils {
    public static boolean colleHasData(Collection<? extends Object> collection){
        if(null != collection && 1 <= collection.size()) {
            return true;
        }else{
            return false;
        }
    }
}
