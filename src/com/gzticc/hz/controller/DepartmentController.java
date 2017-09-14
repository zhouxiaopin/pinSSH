package com.gzticc.hz.controller;

import com.gzticc.common.exception.SysException;
import com.gzticc.common.pojo.BaseResult;
import com.gzticc.common.pojo.DatagridResult;
import com.gzticc.common.utils.BaseConstant;
import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;
import com.gzticc.hz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/initAdd", method = RequestMethod.POST)
    public String initAdd(Model model){
        model.addAttribute("oprt","add");
        return "/department";
    }
    @RequestMapping(value = "/initUpdate", method = RequestMethod.POST)
    public String initUpdate(Model model, String id){
        model.addAttribute("oprt","update");
        try {
            init(model,id);
        }catch (Exception e){
            model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
        }
        return "/department";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model, String id){
        /*model.addAttribute("oprt","update");
        try {

        }catch (Exception e){
            model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
        }*/
        return "/department";
    }
    @RequestMapping(value = "/queryDesc", method = RequestMethod.POST)
    public String queryDesc(Model model, String id){
        model.addAttribute("oprt","queryDesc");
        try {
            init(model,id);
        }catch (Exception e){
            model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
        }
        return "/department";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult add(Model model, DepartmentCustom departmentCustom){
        BaseResult baseResult = new BaseResult();
        try {
            baseResult = departmentService.insert(departmentCustom);
        }catch (Exception e){
            baseResult.setCode(BaseConstant.EXCEPTION_CODE);
            baseResult.setMsg(BaseConstant.EXCEPTION__MSG);
        }
        return baseResult;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DatagridResult<DepartmentCustom> list(DepartmentQueryVo departmentQueryVo) throws Exception{
        DatagridResult<DepartmentCustom> datagridResult;
        try {
            datagridResult = departmentService.queryObjs(departmentQueryVo);
        }catch (Exception e){
            return new DatagridResult<>();
        }
        return datagridResult;
    }

    private DepartmentCustom getObj(String pk){
        DepartmentCustom departmentCustom = null;
        try {
            departmentCustom = departmentService.queryObj(pk);
        }catch (Exception e){
            new SysException(e.getMessage());
        }
        return departmentCustom;
    }

    private void init(Model model, String id){
        try {
            DepartmentCustom departmentCustom = getObj(id);
            if(null != departmentCustom) {
                model.addAttribute("obj","departmentCustom");
                model.addAttribute("retMsg",BaseConstant.SUCCESS_MSG);
            }else{
                model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
            }
        }catch (Exception e){
            model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
        }
    }
}
