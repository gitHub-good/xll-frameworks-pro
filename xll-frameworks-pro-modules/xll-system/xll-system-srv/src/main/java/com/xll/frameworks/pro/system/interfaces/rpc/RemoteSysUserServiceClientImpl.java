package com.xll.frameworks.pro.system.interfaces.rpc;

import com.xll.frameworks.pro.common.core.R;
import com.xll.frameworks.pro.system.api.RemoteSysUserServiceClient;
import com.xll.frameworks.pro.system.api.dto.SysUserDTO;
import com.xll.frameworks.pro.system.domain.model.user.SysUserService;
import com.xll.frameworks.pro.system.interfaces.assembler.SysUserApiAssembler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@DubboService(version = "${demo.service.version}")
@Slf4j
public class RemoteSysUserServiceClientImpl implements RemoteSysUserServiceClient {
    @Autowired
    private SysUserService sysUserService;
    @Override
    public R<Boolean> save(SysUserDTO sysUserDTO) {
        sysUserService.save(SysUserApiAssembler.INSTANCE.dtoToDo(sysUserDTO));
        return R.ok();
    }
}
