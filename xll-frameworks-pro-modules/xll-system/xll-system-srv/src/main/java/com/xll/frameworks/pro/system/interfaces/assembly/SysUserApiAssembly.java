package com.xll.frameworks.pro.system.interfaces.assembly;

import com.xll.frameworks.pro.system.api.dto.SysUserDTO;
import com.xll.frameworks.pro.system.domain.model.user.SysUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserApiAssembly {
    SysUserApiAssembly INSTANCE = Mappers.getMapper(SysUserApiAssembly.class );

    SysUserDO dtoToDo(SysUserDTO sysUserDTO);
}
