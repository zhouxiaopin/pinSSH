package com.gzticc.common.service.impl;

import com.gzticc.common.base.mapper.BaseMapper;
import com.gzticc.common.base.pojo.DatagridResult;
import com.gzticc.common.service.IBaseMyBatisService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/9/13.
 */
public class BaseMyBatisServiceImpl<T,V> implements IBaseMyBatisService<T,V> {
    @Autowired
    protected BaseMapper<T,V> baseMapper;

    @Override
    public int insert(T entityCustom) {
        return baseMapper.insert(entityCustom);
    }

    @Override
    public int update(T entityCustom) {
        return baseMapper.update(entityCustom);
    }

    @Override
    public int delete(T entityCustom) {
        return baseMapper.delete(entityCustom);
    }

    @Override
    public int deleteList(String[] pks) {
        return baseMapper.deleteList(pks);
    }

    @Override
    public T queryObj(V entityQueryVo) {
        return baseMapper.queryObj(entityQueryVo);
    }

    @Override
    public DatagridResult<T> queryObjs(V entityQueryVo) {
        DatagridResult<T> dr = new DatagridResult<>();
        dr.setTotal(baseMapper.queryCount(entityQueryVo));
        dr.setRows(baseMapper.queryPageList(entityQueryVo));
        return dr;
    }
}
