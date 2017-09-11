package com.gzticc.hz.controller;

import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;
import com.gzticc.hz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    //后台获取订单列表
    @RequestMapping("/list")
    public String list(Model model, DepartmentQueryVo departmentQueryVo) throws Exception{
        List<DepartmentCustom> departments = departmentService.queryDepartment(departmentQueryVo);
        // 通过形参中的model将model数据传到页面
        // 相当于modelAndView.addObject方法
        model.addAttribute("departments", departments);
        return "/department/list";
    }
}
