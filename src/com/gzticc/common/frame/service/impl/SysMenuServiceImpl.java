
package com.gzticc.common.frame.service.impl;


import com.gzticc.common.base.service.impl.BaseMyBatisServiceImpl;
import com.gzticc.common.frame.mapper.SysMenuMapper;
import com.gzticc.common.frame.pojo.SysMenuCustom;
import com.gzticc.common.frame.pojo.SysMenuQueryVo;
import com.gzticc.common.frame.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 系统菜单信息的业务逻辑实现类
 * @author pin
 *
 */
public class SysMenuServiceImpl extends BaseMyBatisServiceImpl<SysMenuCustom,SysMenuQueryVo>
		implements ISysMenuService {
	
	//注入mapper
	@Autowired
	private SysMenuMapper sysMenuMapper;


}
