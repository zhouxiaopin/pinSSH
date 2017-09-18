package com.gzticc.common.frame.controller;

import com.gzticc.common.base.controller.BaseController;
import com.gzticc.common.frame.pojo.SysMenuCustom;
import com.gzticc.common.frame.pojo.SysMenuQueryVo;
import com.gzticc.common.frame.service.ISysMenuService;
import com.gzticc.hz.pojo.DepartmentCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 系统菜单信息控制器
 * Created by Administrator on 2017/9/11.
 */
@Controller
//比如：列表：/sysMenu/list.action
@RequestMapping("/sysMenu")
public class SysMenuController extends BaseController<SysMenuCustom,SysMenuQueryVo>{
    @Autowired
    private ISysMenuService sysMenuService;

    @Override
    protected String getJsp() {
        return "";
    }

    @Override
    protected String getId(SysMenuCustom sysMenuCustom) {
        return sysMenuCustom.getSysMenuId().toString();
    }

    @Override
    protected void addOprt(SysMenuCustom sysMenuCustom) {

    }

    @Override
    protected void updateOprt(SysMenuCustom sysMenuCustom, SysMenuCustom param) {

    }


}
