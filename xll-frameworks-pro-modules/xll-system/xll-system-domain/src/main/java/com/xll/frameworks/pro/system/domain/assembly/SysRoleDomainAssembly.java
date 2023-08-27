package com.xll.frameworks.pro.system.domain.assembly;

import com.xll.frameworks.pro.system.domain.model.role.SysRoleDO;
import com.xll.frameworks.pro.system.repository.po.SysRolePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 功能描述: <br>
 * <p>
 *  <角色model转换>
 * </p>
 * @author xuliangliang
 * @since 2023/7/29 23:38
 * @version 1.0.0
 */
@Mapper
public interface SysRoleDomainAssembly {
    SysRoleDomainAssembly INSTANCE = Mappers.getMapper(SysRoleDomainAssembly.class );
    SysRolePO doToPo(SysRoleDO sysRoleDO);
}
