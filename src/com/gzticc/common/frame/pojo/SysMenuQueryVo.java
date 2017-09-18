package com.gzticc.common.frame.pojo;

import com.gzticc.common.base.pojo.DatagridPage;

/**
 * 系统菜单实体类的包装对象
 * Created by Administrator on 2017/9/18.
 */
public class SysMenuQueryVo extends DatagridPage{
    //为了系统 可扩展性，对原始生成的pojo进行扩展
    private SysMenuCustom sysMenuCustom;

    public void setSysMenuCustom(SysMenuCustom sysMenuCustom) {
        this.sysMenuCustom = sysMenuCustom;
    }

    public SysMenuCustom getSysMenuCustom() {
        return sysMenuCustom;
    }
}
