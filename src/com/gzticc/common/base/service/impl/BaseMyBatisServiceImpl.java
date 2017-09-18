package com.gzticc.common.base.service.impl;

import com.gzticc.common.base.mapper.BaseMapper;
import com.gzticc.common.base.pojo.BaseResult;
import com.gzticc.common.base.pojo.DatagridResult;
import com.gzticc.common.base.service.IBaseMyBatisService;
import com.gzticc.common.base.utils.BaseConstant;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/9/13.
 */
public class BaseMyBatisServiceImpl<T,V> implements IBaseMyBatisService<T,V> {
    @Autowired
    protected BaseMapper<T,V> baseMapper;

    protected BaseResult insertBefore(BaseResult baseResult,T t){
        return baseResult;
    }

    protected BaseResult updateBefore(BaseResult baseResult,T t){
        return baseResult;
    }

    @Override
    public BaseResult insert(T entityCustom){
        BaseResult baseResult = new BaseResult();
        try {
            baseResult = insertBefore(baseResult,entityCustom);
            if(!baseResult.isStatus()) {
                return baseResult;
            }
            int flag = baseMapper.insert(entityCustom);
            if(flag >= 1) {
                baseResult.setCode(BaseConstant.ADD_SUCCESS_CODE);
                baseResult.setMsg(BaseConstant.ADD_SUCCESS_MSG);

            }else{
                baseResult.setCode(BaseConstant.FAIL_CODE);
                baseResult.setMsg(BaseConstant.ADD_FAIL_MSG);
            }
        }catch (Exception e){
            baseResult.setCode(BaseConstant.EXCEPTION_CODE);
            baseResult.setMsg(BaseConstant.EXCEPTION_MSG);
        }

        return baseResult;
    }

    @Override
    public BaseResult update(T entityCustom){
        BaseResult baseResult = new BaseResult();
        try {
            baseResult = updateBefore(baseResult,entityCustom);
            if(!baseResult.isStatus()) {
                return baseResult;
            }
            int flag = baseMapper.update(entityCustom);
            if(flag >= 1) {
                baseResult.setCode(BaseConstant.MDF_SUCCESS_CODE);
                baseResult.setMsg(BaseConstant.MDF_SUCCESS_MSG);

            }else{
                baseResult.setCode(BaseConstant.FAIL_CODE);
                baseResult.setMsg(BaseConstant.MDF_FAIL_MSG);
            }
        }catch (Exception e){
            baseResult.setCode(BaseConstant.EXCEPTION_CODE);
            baseResult.setMsg(BaseConstant.EXCEPTION_MSG);
        }
        return baseResult;
    }

    @Override
    public BaseResult delete(T entityCustom){
        BaseResult baseResult = null;
        try {
            int flag = baseMapper.delete(entityCustom);
            baseResult = deleteAfter(flag);
        }catch (Exception e){
            if(null == baseResult) {
                baseResult = new BaseResult();
            }
            baseResult.setCode(BaseConstant.EXCEPTION_CODE);
            baseResult.setMsg(BaseConstant.EXCEPTION_MSG);
        }
        return baseResult;
    }

    @Override
    public BaseResult deleteList(String[] pks){
        BaseResult baseResult = null;
        try {
            int flag = baseMapper.deleteList(pks);
            baseResult = deleteAfter(flag);
        }catch (Exception e){
            if(null == baseResult) {
                baseResult = new BaseResult();
            }
            baseResult.setCode(BaseConstant.EXCEPTION_CODE);
            baseResult.setMsg(BaseConstant.EXCEPTION_MSG);
        }
        return baseResult;
    }

    @Override
    public T queryObj(String pk){
        return baseMapper.queryObj(pk);
    }

    @Override
    public DatagridResult<T> queryObjs(V entityQueryVo){
        DatagridResult<T> dr = new DatagridResult<>();
        dr.setTotal(baseMapper.queryCount(entityQueryVo));
        dr.setRows(baseMapper.queryObjs(entityQueryVo));
        return dr;
    }

    private BaseResult deleteAfter(int flag){
        BaseResult br = new BaseResult();
        if(flag >= 1) {
            br.setCode(BaseConstant.DEL_SUCCESS_CODE);
            br.setMsg(BaseConstant.DEL_SUCCESS_MSG);

        }else{
            br.setCode(BaseConstant.FAIL_CODE);
            br.setMsg(BaseConstant.DEL_FAIL_MSG);
        }
        return br;
    }
}
