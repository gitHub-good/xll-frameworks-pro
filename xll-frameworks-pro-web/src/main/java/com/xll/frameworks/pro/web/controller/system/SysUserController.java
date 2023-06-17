package com.xll.frameworks.pro.web.controller.system;

import com.xll.frameworks.pro.common.core.AjaxResult;
import com.xll.frameworks.pro.common.core.R;
import com.xll.frameworks.pro.system.api.RemoteSysUserServiceClient;
import com.xll.frameworks.pro.web.assembler.SysUserWebAssembler;
import com.xll.frameworks.pro.web.model.system.SysUserRequestVO;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class SysUserController {

    @DubboReference(version = "${demo.service.version}")
    private RemoteSysUserServiceClient remoteSysUserServiceClient;

    @PostMapping("/save")
    public AjaxResult save(@Validated @RequestBody SysUserRequestVO sysUserRequestVO){
        R<Boolean> r = remoteSysUserServiceClient.save(SysUserWebAssembler.INSTANCE.voToDto(sysUserRequestVO));
        if(r.getCode() == R.SUCCESS){
            return AjaxResult.success();
        }
        return AjaxResult.error("异常");
    }

}
