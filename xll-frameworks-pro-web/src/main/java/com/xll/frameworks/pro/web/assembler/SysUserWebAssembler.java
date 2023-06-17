package com.xll.frameworks.pro.web.assembler;

import com.xll.frameworks.pro.system.api.dto.SysUserDTO;
import com.xll.frameworks.pro.web.model.system.SysUserRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SysUserWebAssembler {
    SysUserWebAssembler INSTANCE = Mappers.getMapper(SysUserWebAssembler.class);
    SysUserDTO voToDto(SysUserRequestVO sysUserRequestVO);
}
