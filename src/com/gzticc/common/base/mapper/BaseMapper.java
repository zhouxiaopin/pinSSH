package com.gzticc.common.base.mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
public interface BaseMapper<T,V> {

    //添加单个对象
    int insert(T entityCustom);

    //修改单个对象
    int update(T entityCustom);

    //删除单个对象
    int delete(T entityCustom);

    //通过主键（数组）批量删除数据
    int deleteList(String [] pks);

    //查询单个对象
    T queryObj(String pk);

    //分页查询数据列表
    List<T> queryObjs(V entityQueryVo);

    //分页查询，返回总记录数
    Long queryCount(V entityQueryVo);

}
