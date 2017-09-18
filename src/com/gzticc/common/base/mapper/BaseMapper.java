package com.gzticc.common.base.mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
public interface BaseMapper<T,V> {

    //添加单个对象
    public int insert(T entityCustom);

    //修改单个对象
    public int update(T entityCustom);

    //删除单个对象
    public int delete(T entityCustom);

    //通过主键（数组）批量删除数据
    public int deleteList(String [] pks);

    //查询单个对象
    public T queryObj(String pk);

    //分页查询数据列表
    public List<T> queryObjs(V entityQueryVo);

    //分页查询，返回总记录数
    public Long queryCount(V entityQueryVo);

}
