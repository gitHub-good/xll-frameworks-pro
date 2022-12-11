package com.xll.frameworks.pro.system.temp.system.service;

import com.xll.frameworks.pro.common.core.core.domain.entity.SysUser;
import com.xll.frameworks.pro.system.temp.common.core.service.BaseService;
import com.xll.frameworks.pro.system.temp.system.domain.SysPortalConfig;

import java.util.List;
import java.util.Map;

/**
 * 多栏目门户配置Service接口
 * @author aidex
 * @email aidex@qq.com
 * @date 2021-05-11
 */
public interface SysPortalConfigService extends BaseService<SysPortalConfig>
{
    /**
     * 批量删除多栏目门户配置
     * @param ids 需要删除的多栏目门户配置ID
     * @return
     */
    public int deleteSysPortalConfigByIds(String[] ids);

    /**
    * 获取最大编号
    * @param sysPortalConfig
    * @return
    */
    public int findMaxSort(SysPortalConfig sysPortalConfig);

    /**
    * 校验小页编码的唯一性
    * @param sysPortalConfig
    */
    public void checkCodeUnique(SysPortalConfig sysPortalConfig);

    public Map<String,Object> findUserConfigList(SysUser user);

    public SysPortalConfig insertOrUpdateSysPortalConfig(SysPortalConfig sysPortalConfig);

    public void updateDefaultPortalConfig(SysPortalConfig sysPortalConfig);

    public List<SysPortalConfig> getPortalTemplateList(SysUser user);
}
