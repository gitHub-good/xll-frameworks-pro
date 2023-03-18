package com.xll.frameworks.pro.web.assembler;

import com.xll.frameworks.pro.system.api.dto.SysRoleDTO;
import com.xll.frameworks.pro.web.model.system.SysRoleRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysRoleWebAssembler {
    SysRoleWebAssembler INSTANCE = Mappers.getMapper(SysRoleWebAssembler.class);

    SysRoleDTO voToDto(SysRoleRequestVO sysRoleRequestVO);
}
