package com.xll.frameworks.pro.system.domain.assembler;

import com.xll.frameworks.pro.system.domain.model.role.SysRoleDO;
import com.xll.frameworks.pro.system.repository.po.SysRolePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysRoleDomainAssembler {
    SysRoleDomainAssembler INSTANCE = Mappers.getMapper(SysRoleDomainAssembler.class );

    SysRolePO doToPo(SysRoleDO sysRoleDO);
}
