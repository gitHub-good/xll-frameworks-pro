package com.xll.frameworks.pro.web.controller.system;

import com.xll.frameworks.pro.common.core.AjaxResult;
import com.xll.frameworks.pro.common.core.R;
import com.xll.frameworks.pro.system.api.RemoteSysRoleServiceClient;
import com.xll.frameworks.pro.web.assembly.SysRoleWebAssembly;
import com.xll.frameworks.pro.web.model.system.SysRoleRequestVO;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
public class SysRoleController {
    @DubboReference(version = "${demo.service.version}")
    private RemoteSysRoleServiceClient remoteSysRoleServiceClient;
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysRoleRequestVO roleRequestVO) {
        R<Boolean> save = remoteSysRoleServiceClient.save(SysRoleWebAssembly.INSTANCE.voToDto(roleRequestVO));
        if(save.getCode() == R.SUCCESS){
            return AjaxResult.success();
        }else{
            return AjaxResult.error();
        }
    }
}
