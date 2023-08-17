package com.xll.frameworks.pro.system.interfaces.assembler;

import com.xll.frameworks.pro.system.api.dto.SysRoleDTO;
import com.xll.frameworks.pro.system.domain.model.role.SysRoleDO;
import com.xll.frameworks.pro.system.interfaces.assembly.SysRoleApiAssembly;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-11T21:40:51+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class SysRoleApiAssemblyImpl implements SysRoleApiAssembly {

    @Override
    public SysRoleDO dtoToDo(SysRoleDTO sysRoleDTO) {
        if ( sysRoleDTO == null ) {
            return null;
        }

        SysRoleDO sysRoleDO = new SysRoleDO();

        sysRoleDO.setId( sysRoleDTO.getId() );
        sysRoleDO.setRoleName( sysRoleDTO.getRoleName() );
        sysRoleDO.setRoleKey( sysRoleDTO.getRoleKey() );
        sysRoleDO.setSort( sysRoleDTO.getSort() );
        if ( sysRoleDTO.getDataScope() != null ) {
            sysRoleDO.setDataScope( Integer.parseInt( sysRoleDTO.getDataScope() ) );
        }

        return sysRoleDO;
    }
}
