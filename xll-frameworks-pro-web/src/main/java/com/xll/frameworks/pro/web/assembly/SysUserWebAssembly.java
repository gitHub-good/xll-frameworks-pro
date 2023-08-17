package com.xll.frameworks.pro.web.assembly;

import com.xll.frameworks.pro.system.api.dto.SysUserDTO;
import com.xll.frameworks.pro.web.model.system.SysUserRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SysUserWebAssembly {
    SysUserWebAssembly INSTANCE = Mappers.getMapper(SysUserWebAssembly.class);
    SysUserDTO voToDto(SysUserRequestVO sysUserRequestVO);
}
