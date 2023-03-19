package com.xll.frameworks.pro.system.interfaces.assembler;

import com.xll.frameworks.pro.system.api.dto.SysUserDTO;
import com.xll.frameworks.pro.system.domain.model.user.SysUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserApiAssembler {
    SysUserApiAssembler INSTANCE = Mappers.getMapper(SysUserApiAssembler.class );

    SysUserDO dtoToDo(SysUserDTO sysUserDTO);
}
