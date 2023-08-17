package com.xll.frameworks.pro.system.interfaces.assembly;

import com.xll.frameworks.pro.system.api.dto.SysRoleDTO;
import com.xll.frameworks.pro.system.domain.model.role.SysRoleDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysRoleApiAssembly {
    SysRoleApiAssembly INSTANCE = Mappers.getMapper(SysRoleApiAssembly.class );

    SysRoleDO dtoToDo(SysRoleDTO sysRoleDTO);
}
