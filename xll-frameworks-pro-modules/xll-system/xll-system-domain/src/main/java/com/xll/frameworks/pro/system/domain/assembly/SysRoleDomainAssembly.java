package com.xll.frameworks.pro.system.domain.assembly;

import com.xll.frameworks.pro.system.domain.model.role.SysRoleDO;
import com.xll.frameworks.pro.system.repository.po.SysRolePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysRoleDomainAssembly {
    SysRoleDomainAssembly INSTANCE = Mappers.getMapper(SysRoleDomainAssembly.class );
    SysRolePO doToPo(SysRoleDO sysRoleDO);
}
