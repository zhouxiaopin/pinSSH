package com.gzticc.hz.mapper;

import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;

import java.util.List;
/**
 * 部门信息的mapper接口
 * @author pin
 *
 */
public interface DepartmentMapper {
	/*
	 * 查找部门
	 */
	public List<DepartmentCustom> queryDepartment(DepartmentQueryVo departmentQueryVo) throws Exception;

}
