package com.xll.frameworks.pro.web.assembly;

import com.xll.frameworks.pro.system.api.dto.SysRoleDTO;
import com.xll.frameworks.pro.web.model.system.SysRoleRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysRoleWebAssembly {
    SysRoleWebAssembly INSTANCE = Mappers.getMapper(SysRoleWebAssembly.class);
    SysRoleDTO voToDto(SysRoleRequestVO sysRoleRequestVO);
}
