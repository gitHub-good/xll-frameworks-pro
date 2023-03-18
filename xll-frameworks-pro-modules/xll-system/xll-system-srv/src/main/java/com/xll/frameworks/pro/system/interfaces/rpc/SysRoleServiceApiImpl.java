package com.xll.frameworks.pro.system.interfaces.rpc;

import com.xll.frameworks.pro.common.core.R;
import com.xll.frameworks.pro.common.core.exception.DomainException;
import com.xll.frameworks.pro.system.api.SysRoleServiceApi;
import com.xll.frameworks.pro.system.api.dto.SysRoleDTO;
import com.xll.frameworks.pro.system.domain.model.role.SysRoleService;
import com.xll.frameworks.pro.system.interfaces.assembler.SysRoleApiAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysRoleServiceApiImpl implements SysRoleServiceApi {
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public R<Boolean> save(SysRoleDTO sysRoleDTO) {
        try{
            sysRoleService.save(SysRoleApiAssembler.INSTANCE.dtoToDo(sysRoleDTO));
        }catch (DomainException e){
            return R.fail("存储异常");
        }
        return R.ok();
    }
}
