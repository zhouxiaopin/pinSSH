package com.gzticc.common.frame.service;

import com.gzticc.common.base.pojo.ComboTree;
import com.gzticc.common.base.service.IBaseMyBatisService;
import com.gzticc.common.frame.pojo.SysMenuCustom;
import com.gzticc.common.frame.pojo.SysMenuQueryVo;

import java.util.List;

/**
 * 系统菜单的业务逻辑接口
 * @author pin
 *
 */
public interface ISysMenuService extends IBaseMyBatisService<SysMenuCustom,SysMenuQueryVo> {
    List<ComboTree> getComboTrees(String levelCode);
}
