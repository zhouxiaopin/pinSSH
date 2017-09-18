
package com.gzticc.hz.service.impl;


import com.gzticc.common.base.pojo.BaseResult;
import com.gzticc.common.base.service.impl.BaseMyBatisServiceImpl;
import com.gzticc.common.base.utils.BaseConstant;
import com.gzticc.common.base.utils.BaseUtils;
import com.gzticc.hz.mapper.DepartmentMapper;
import com.gzticc.hz.pojo.DepartmentCustom;
import com.gzticc.hz.pojo.DepartmentQueryVo;
import com.gzticc.hz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 部门信息的业务逻辑实现类
 * @author pin
 *
 */
public class DepartmentServiceImpl extends BaseMyBatisServiceImpl<DepartmentCustom,DepartmentQueryVo>
		implements IDepartmentService {
	
	//注入部门mapper
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	protected BaseResult insertBefore(BaseResult baseResult, DepartmentCustom departmentCustom) {
		DepartmentCustom dc = new DepartmentCustom();
		dc.setDepartmentNo(departmentCustom.getDepartmentNo());
		DepartmentQueryVo departmentQueryVo = new DepartmentQueryVo();
		departmentQueryVo.setDepartmentCustom(dc);
		List<DepartmentCustom> departmentCustomList = departmentMapper.queryObjs(departmentQueryVo);
		if(BaseUtils.colleHasData(departmentCustomList)) {
			baseResult.setCode(BaseConstant.FAIL_CODE);
			baseResult.setMsg("该部门编号以存在");
		}
		return baseResult;
	}
}
