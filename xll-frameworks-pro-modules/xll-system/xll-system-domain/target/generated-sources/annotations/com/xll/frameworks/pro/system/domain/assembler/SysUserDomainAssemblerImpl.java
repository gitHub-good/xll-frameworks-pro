package com.xll.frameworks.pro.system.domain.assembler;

import com.xll.frameworks.pro.system.domain.model.user.SysUserDO;
import com.xll.frameworks.pro.system.repository.po.SysUserPO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-19T21:13:44+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class SysUserDomainAssemblerImpl implements SysUserDomainAssembler {

    @Override
    public SysUserPO doToPo(SysUserDO sysUserDO) {
        if ( sysUserDO == null ) {
            return null;
        }

        SysUserPO sysUserPO = new SysUserPO();

        sysUserPO.setId( sysUserDO.getId() );
        sysUserPO.setDeptId( sysUserDO.getDeptId() );
        sysUserPO.setRoleId( sysUserDO.getRoleId() );
        sysUserPO.setUserName( sysUserDO.getUserName() );
        sysUserPO.setUserAccount( sysUserDO.getUserAccount() );
        sysUserPO.setPassword( sysUserDO.getPassword() );
        sysUserPO.setMobile( sysUserDO.getMobile() );
        sysUserPO.setStatus( sysUserDO.getStatus() );
        sysUserPO.setDelFlag( sysUserDO.getDelFlag() );
        sysUserPO.setCreateBy( sysUserDO.getCreateBy() );
        sysUserPO.setCreateTime( sysUserDO.getCreateTime() );
        sysUserPO.setUpdateBy( sysUserDO.getUpdateBy() );
        sysUserPO.setUpdateTime( sysUserDO.getUpdateTime() );

        return sysUserPO;
    }
}
