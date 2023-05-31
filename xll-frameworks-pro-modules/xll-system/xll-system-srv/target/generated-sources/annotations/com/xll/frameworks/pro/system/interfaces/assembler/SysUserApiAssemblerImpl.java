package com.xll.frameworks.pro.system.interfaces.assembler;

import com.xll.frameworks.pro.system.api.dto.SysUserDTO;
import com.xll.frameworks.pro.system.domain.model.user.SysUserDO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-11T21:40:51+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class SysUserApiAssemblerImpl implements SysUserApiAssembler {

    @Override
    public SysUserDO dtoToDo(SysUserDTO sysUserDTO) {
        if ( sysUserDTO == null ) {
            return null;
        }

        SysUserDO sysUserDO = new SysUserDO();

        sysUserDO.setId( sysUserDTO.getId() );
        sysUserDO.setDeptId( sysUserDTO.getDeptId() );
        sysUserDO.setRoleId( sysUserDTO.getRoleId() );
        sysUserDO.setUserName( sysUserDTO.getUserName() );
        sysUserDO.setUserAccount( sysUserDTO.getUserAccount() );
        sysUserDO.setPassword( sysUserDTO.getPassword() );
        sysUserDO.setMobile( sysUserDTO.getMobile() );
        sysUserDO.setStatus( sysUserDTO.getStatus() );
        sysUserDO.setDelFlag( sysUserDTO.getDelFlag() );

        return sysUserDO;
    }
}
