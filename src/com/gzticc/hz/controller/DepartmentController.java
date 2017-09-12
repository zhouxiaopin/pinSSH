package com.gzticc.hz.controller;

import com.gzticc.common.base.pojo.DatagridResult;
import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;
import com.gzticc.hz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门信息控制器
 * Created by Administrator on 2017/9/11.
 */
@Controller
//比如：部门列表：/department/list.action
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DatagridResult<DepartmentCustom> list(DepartmentQueryVo departmentQueryVo) throws Exception{
        List<DepartmentCustom> departments = departmentService.queryDepartment(departmentQueryVo);
        DatagridResult<DepartmentCustom> datagridResult = new DatagridResult<>();
        datagridResult.setRows(departments);
        return datagridResult;

    }
}
