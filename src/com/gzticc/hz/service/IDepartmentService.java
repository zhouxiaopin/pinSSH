package com.gzticc.hz.service;

import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;

import java.util.List;

/**
 * 商品模块的业务逻辑接口
 * @author pin
 *
 */
public interface IDepartmentService {
	/*
	 * 分页查找商品列表
	 */
	public List<DepartmentCustom> queryDepartment(DepartmentQueryVo departmentQueryVo) throws Exception;
}
