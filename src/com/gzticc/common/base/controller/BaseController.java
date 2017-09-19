package com.gzticc.common.base.controller;

import com.gzticc.common.base.exception.SysException;
import com.gzticc.common.base.pojo.BaseResult;
import com.gzticc.common.base.pojo.DatagridResult;
import com.gzticc.common.base.service.IBaseMyBatisService;
import com.gzticc.common.base.utils.BaseConstant;
import com.gzticc.common.base.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/14.
 */
public abstract class BaseController<T,V> {
    @Autowired
    private IBaseMyBatisService<T,V> baseMyBatisService;

    protected abstract String getJsp();
    protected abstract String getId(T t);
    protected abstract void addOprt(T t);
    protected abstract void updateOprt(T t,T param);


    @RequestMapping(value = "/initAdd", method = RequestMethod.POST)
    public String initAdd(Model model){
        try {
            model.addAttribute("oprt","add");
            model.addAttribute("retMsg",BaseConstant.SUCCESS_MSG);
        }catch (Exception e){
            model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
        }
        return getJsp();
    }
    @RequestMapping(value = "/initUpdate", method = RequestMethod.POST)
    public String initUpdate(Model model, String id){
        model.addAttribute("oprt","update");
        try {
            init(model,id);
        }catch (Exception e){
            model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
        }
        return getJsp();
    }
    @RequestMapping(value = "/initQueryDetail", method = RequestMethod.POST)
    public String queryDetail(Model model, String id){
        model.addAttribute("oprt","queryDetail");
        try {
            init(model,id);
        }catch (Exception e){
            model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
        }
        return getJsp();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult add(Model model, T t){
        BaseResult baseResult = null;
        try {
            addOprt(t);
            baseResult = baseMyBatisService.insert(t);
        }catch (Exception e){
            if(null == baseResult) {
                baseResult = new BaseResult();
            }
            baseResult.setCode(BaseConstant.EXCEPTION_CODE);
            baseResult.setMsg(BaseConstant.EXCEPTION_MSG);
        }
        return baseResult;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult update(Model model, T t){
        BaseResult baseResult = null;
        try {
            T obj = getObj(getId(t));
            updateOprt(obj,t);
            baseResult = baseMyBatisService.update(obj);
        }catch (Exception e){
            if(null == baseResult) {
                baseResult = new BaseResult();
            }
            baseResult.setCode(BaseConstant.EXCEPTION_CODE);
            baseResult.setMsg(BaseConstant.EXCEPTION_MSG);
        }
        return baseResult;
    }




    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete(@RequestParam("ids[]") String[] ids){

        BaseResult baseResult = null;
        try {
            int len = ids.length;
            if(1 == len ) {
                T obj = getObj(ids[0]);
                baseResult = baseMyBatisService.delete(obj);
            }else{
                baseResult = baseMyBatisService.deleteList(ids);
            }
        }catch (Exception e){
            if(null == baseResult) {
                baseResult = new BaseResult();
            }
            baseResult.setCode(BaseConstant.EXCEPTION_CODE);
            baseResult.setMsg(BaseConstant.EXCEPTION_MSG);
        }
        return baseResult;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DatagridResult<T> list(V v) {
        DatagridResult<T> datagridResult;
        try {
            datagridResult = baseMyBatisService.queryObjs(v);
        }catch (Exception e){
            return new DatagridResult<>();
        }
        return datagridResult;
    }

    protected T getObj(String pk){
        T t = null;
        try {
            t = baseMyBatisService.queryObj(pk);
        }catch (Exception e){
            new SysException(e.getMessage());
        }
        return t;
    }

    private void init(Model model, String id){
        try {
            T t = getObj(id);
            if(null != t) {
                model.addAttribute("obj",t);
                model.addAttribute("jsonObj", GsonUtils.objToJsonStr(t));
                model.addAttribute("retMsg", BaseConstant.SUCCESS_MSG);
            }else{
                model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
            }
        }catch (Exception e){
            model.addAttribute("retMsg",BaseConstant.FAIL_MSG);
        }
    }
}
