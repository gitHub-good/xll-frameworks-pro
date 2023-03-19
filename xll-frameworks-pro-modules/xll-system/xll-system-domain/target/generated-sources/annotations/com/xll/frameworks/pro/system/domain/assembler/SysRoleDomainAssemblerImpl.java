package com.xll.frameworks.pro.system.domain.assembler;

import com.xll.frameworks.pro.system.domain.model.role.SysRoleDO;
import com.xll.frameworks.pro.system.repository.po.SysRolePO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-19T21:14:18+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class SysRoleDomainAssemblerImpl implements SysRoleDomainAssembler {

    @Override
    public SysRolePO doToPo(SysRoleDO sysRoleDO) {
        if ( sysRoleDO == null ) {
            return null;
        }

        SysRolePO sysRolePO = new SysRolePO();

        sysRolePO.setId( sysRoleDO.getId() );
        sysRolePO.setRoleName( sysRoleDO.getRoleName() );
        sysRolePO.setRoleKey( sysRoleDO.getRoleKey() );
        sysRolePO.setSort( sysRoleDO.getSort() );
        sysRolePO.setDataScope( sysRoleDO.getDataScope() );
        sysRolePO.setStatus( sysRoleDO.getStatus() );
        sysRolePO.setDelFlag( sysRoleDO.getDelFlag() );
        sysRolePO.setCreateBy( sysRoleDO.getCreateBy() );
        sysRolePO.setCreateTime( sysRoleDO.getCreateTime() );
        sysRolePO.setUpdateBy( sysRoleDO.getUpdateBy() );
        sysRolePO.setUpdateTime( sysRoleDO.getUpdateTime() );

        return sysRolePO;
    }
}
