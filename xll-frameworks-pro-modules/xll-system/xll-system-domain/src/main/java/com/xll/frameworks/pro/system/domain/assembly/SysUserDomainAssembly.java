package com.xll.frameworks.pro.system.domain.assembly;

import com.xll.frameworks.pro.system.domain.model.user.SysUserDO;
import com.xll.frameworks.pro.system.repository.po.SysUserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserDomainAssembly {
    SysUserDomainAssembly INSTANCE = Mappers.getMapper(SysUserDomainAssembly.class );

    SysUserPO doToPo(SysUserDO sysUserDO);
}
