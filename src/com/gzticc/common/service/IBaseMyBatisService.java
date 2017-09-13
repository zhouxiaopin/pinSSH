package com.gzticc.common.service;

import com.gzticc.common.base.pojo.DatagridResult;

/**
 * Created by Administrator on 2017/9/13.
 */
public interface IBaseMyBatisService<T,V> {
    //添加单个对象
    public int insert(T entityCustom);

    //修改单个对象
    public int update(T entityCustom);

    //删除单个对象
    public int delete(T entityCustom);

    //通过主键（数组）批量删除数据
    public int deleteList(String [] pks);

    //查询单个对象
    public T queryObj(V entityQueryVo);

    //分页查询数据列表
    public DatagridResult<T> queryObjs(V entityQueryVo);

}
