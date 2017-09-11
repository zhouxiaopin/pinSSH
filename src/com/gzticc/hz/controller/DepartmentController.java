package com.gzticc.hz.controller;

import com.gzticc.common.base.pojo.Branch;
import com.gzticc.common.base.pojo.Result;
import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;
import com.gzticc.hz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    //后台获取订单列表
/*    @RequestMapping("/list")
    public String list(Model model, DepartmentQueryVo departmentQueryVo) throws Exception{
        List<DepartmentCustom> departments = departmentService.queryDepartment(departmentQueryVo);
        // 通过形参中的model将model数据传到页面
        // 相当于modelAndView.addObject方法
        model.addAttribute("departments", departments);
//        return "/department/list";
        return "index";
    }*/

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Result<Branch> list(@RequestBody(required = false) DepartmentQueryVo departmentQueryVo) throws Exception{
        List<DepartmentCustom> departments = departmentService.queryDepartment(departmentQueryVo);

        Result<Branch> response = new Result<>();
        response.setStatus("true");
        response.setMsg("成功");

        Branch<DepartmentCustom> branch = new Branch<>();
        branch.setIndexPage(1);
        branch.setCount(2);
        branch.setData(departments);

        response.setData(branch);

        return response;

    }
}
