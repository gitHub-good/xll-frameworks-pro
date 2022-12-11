package com.xll.frameworks.pro.system.temp.system.service;


import com.xll.frameworks.pro.system.temp.common.core.service.BaseService;
import com.xll.frameworks.pro.system.temp.system.domain.SysCommonUseMenu;

import java.util.List;

/**
 * 常用菜单配置Service接口
 * @author aidex
 * @email aidex@qq.com
 * @date 2021-04-22
 */
public interface SysCommonUseMenuService extends BaseService<SysCommonUseMenu>
{
    /**
     * 批量删除常用菜单配置
     * @param ids 需要删除的常用菜单配置ID
     * @return
     */
    public int deleteSysCommonUseMenuByIds(String[] ids);

    public void editSort(List<SysCommonUseMenu> sysCommonUseMenuList);
}
