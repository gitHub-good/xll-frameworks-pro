package com.xll.frameworks.pro.system.domain.assembler;

import com.xll.frameworks.pro.system.domain.model.user.SysUserDO;
import com.xll.frameworks.pro.system.repository.po.SysUserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserDomainAssembler {
    SysUserDomainAssembler INSTANCE = Mappers.getMapper(SysUserDomainAssembler.class );

    SysUserPO doToPo(SysUserDO sysUserDO);
}
