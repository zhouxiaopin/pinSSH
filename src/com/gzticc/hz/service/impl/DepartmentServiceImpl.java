
package com.gzticc.hz.service.impl;


import com.gzticc.hz.mapper.DepartmentMapper;
import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;
import com.gzticc.hz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 商品模块的业务逻辑实现类
 * @author pin
 *
 */
public class DepartmentServiceImpl implements IDepartmentService {
	
	//注入部门mapper
	@Autowired
	private DepartmentMapper departmentMapper;


	@Override
	public List<DepartmentCustom> queryDepartment(DepartmentQueryVo departmentQueryVo) throws Exception {
		return departmentMapper.queryDepartment(departmentQueryVo);
	}
}
