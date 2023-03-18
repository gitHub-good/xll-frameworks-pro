package com.xll.frameworks.pro.system.interfaces.assembler;

import com.xll.frameworks.pro.system.api.dto.SysRoleDTO;
import com.xll.frameworks.pro.system.domain.model.role.SysRoleDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysRoleApiAssembler {
    SysRoleApiAssembler INSTANCE = Mappers.getMapper(SysRoleApiAssembler.class );

    SysRoleDO dtoToDo(SysRoleDTO sysRoleDTO);
}
