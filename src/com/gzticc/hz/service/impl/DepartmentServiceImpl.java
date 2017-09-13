
package com.gzticc.hz.service.impl;


import com.gzticc.common.service.impl.BaseMyBatisServiceImpl;
import com.gzticc.hz.mapper.DepartmentMapper;
import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;
import com.gzticc.hz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 商品模块的业务逻辑实现类
 * @author pin
 *
 */
public class DepartmentServiceImpl extends BaseMyBatisServiceImpl<DepartmentCustom,DepartmentQueryVo>
		implements IDepartmentService {
	
	//注入部门mapper
	@Autowired
	private DepartmentMapper departmentMapper;

}
