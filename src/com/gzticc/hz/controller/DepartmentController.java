package com.gzticc.hz.controller;

import com.gzticc.common.base.controller.BaseController;
import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;
import com.gzticc.hz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 部门信息控制器
 * Created by Administrator on 2017/9/11.
 */
@Controller
//比如：部门列表：/department/list.action
@RequestMapping("/department")
public class DepartmentController extends BaseController<DepartmentCustom,DepartmentQueryVo>{
    @Autowired
    private IDepartmentService departmentService;

    @Override
    protected String getJsp() {
        return "/department";
    }

    @Override
    protected String getId(DepartmentCustom departmentCustom) {
        return departmentCustom.getDepartmentId().toString();
    }

    @Override
    protected void addOprt(DepartmentCustom departmentCustom) {
        departmentCustom.setCreateTime(new Date());
    }

    @Override
    protected void updateOprt(DepartmentCustom departmentCustom, DepartmentCustom param) {
        departmentCustom.setDepartmentNo(param.getDepartmentNo());
        departmentCustom.setDepartmentName(param.getDepartmentName());
        departmentCustom.setDepartmentPhone(param.getDepartmentPhone());
        departmentCustom.setStatus(param.getStatus());
    }
}
