package com.gzticc.common.base.service;

import com.gzticc.common.base.pojo.BaseResult;
import com.gzticc.common.base.pojo.DatagridResult;

/**
 * Created by Administrator on 2017/9/13.
 */
public interface IBaseMyBatisService<T,V> {
    //添加单个对象
    public BaseResult insert(T entityCustom);

    //修改单个对象
    public BaseResult update(T entityCustom);

    //删除单个对象
    public BaseResult delete(T entityCustom);

    //通过主键（数组）批量删除数据
    public BaseResult deleteList(String [] pks);

    //查询单个对象
    public T queryObj(String pk);

    //分页查询数据列表
    public DatagridResult<T> queryObjs(V entityQueryVo);

}
