
package com.gzticc.common.frame.service.impl;


import com.gzticc.common.base.pojo.ComboTree;
import com.gzticc.common.base.service.impl.BaseMyBatisServiceImpl;
import com.gzticc.common.base.utils.BaseUtils;
import com.gzticc.common.frame.mapper.SysMenuMapper;
import com.gzticc.common.frame.pojo.SysMenuCustom;
import com.gzticc.common.frame.pojo.SysMenuQueryVo;
import com.gzticc.common.frame.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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


	@Override
	public List<ComboTree> getComboTrees(String levelCode) {
		List<ComboTree> comboTrees = new ArrayList<>();
		SysMenuCustom sysMenuCustom = new SysMenuCustom();
		sysMenuCustom.setLevelCode("1");

		SysMenuQueryVo sysMenuQueryVo = new SysMenuQueryVo();
		sysMenuQueryVo.setSysMenuCustom(sysMenuCustom);

		List<SysMenuCustom> sysMenuCustoms = sysMenuMapper.queryObjs(sysMenuQueryVo);

		if(BaseUtils.colleHasData(sysMenuCustoms)) {
			SysMenuCustom topMenu = sysMenuCustoms.get(0);
			ComboTree comboTree = new ComboTree();
			comboTree.setId(topMenu.getSysMenuNo());
			comboTree.setText(topMenu.getSysMenuName());
			comboTree.setChildren(getSubTree(topMenu.getSysMenuNo()));
			comboTrees.add(comboTree);
		}

		return comboTrees;
	}

	private List<ComboTree> getSubTree(String parentNo){
		List<ComboTree> comboTrees = new ArrayList<>();
		SysMenuCustom sysMenuCustom = new SysMenuCustom();
		sysMenuCustom.setParentNo(parentNo);

		SysMenuQueryVo sysMenuQueryVo = new SysMenuQueryVo();
		sysMenuQueryVo.setSysMenuCustom(sysMenuCustom);

		List<SysMenuCustom> sysMenuCustoms = sysMenuMapper.queryObjs(sysMenuQueryVo);
		if(BaseUtils.colleHasData(sysMenuCustoms)) {
			SysMenuCustom smc;
			ComboTree comboTree;
			for (int i=0, len = sysMenuCustoms.size(); i<len; i++){
				smc = sysMenuCustoms.get(i);
				comboTree = new ComboTree();
				comboTree.setId(smc.getSysMenuNo());
				comboTree.setText(smc.getSysMenuName());
				comboTree.setChildren(getSubTree(smc.getSysMenuNo()));
				comboTrees.add(comboTree);
			}
		}

		return comboTrees;
	}
}
