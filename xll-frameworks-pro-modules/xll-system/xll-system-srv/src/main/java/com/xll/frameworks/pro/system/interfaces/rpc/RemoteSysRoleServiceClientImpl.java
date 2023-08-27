package com.xll.frameworks.pro.system.interfaces.rpc;

import com.xll.frameworks.pro.common.core.R;
import com.xll.frameworks.pro.common.core.exception.DomainException;
import com.xll.frameworks.pro.system.api.RemoteSysRoleServiceClient;
import com.xll.frameworks.pro.system.api.dto.SysRoleDTO;
import com.xll.frameworks.pro.system.domain.model.role.SysRoleService;
import com.xll.frameworks.pro.system.interfaces.assembler.SysRoleApiAssembler;
import jakarta.annotation.Resource;
import com.xll.frameworks.pro.system.interfaces.assembly.SysRoleApiAssembly;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 功能描述: <br>
 * <P>
 * @Description OpenFeign远程调用
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/19 16:43
 */
@DubboService(version = "${demo.service.version}")
@Service
public class RemoteSysRoleServiceClientImpl implements RemoteSysRoleServiceClient {

    @Resource
    private SysRoleService sysRoleService;

    @Override
    public R<Boolean> save(@RequestBody SysRoleDTO sysRoleDTO){
        try{
            sysRoleService.save(SysRoleApiAssembly.INSTANCE.dtoToDo(sysRoleDTO));
        }catch (DomainException e){
            return R.fail("存储异常");
        }
        return R.ok();
    }
}
