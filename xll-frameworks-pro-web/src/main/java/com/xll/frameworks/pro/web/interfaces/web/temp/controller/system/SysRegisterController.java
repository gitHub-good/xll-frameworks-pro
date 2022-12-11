package com.xll.frameworks.pro.web.interfaces.web.temp.controller.system;

import com.xll.frameworks.pro.common.core.core.controller.BaseController;
import com.xll.frameworks.pro.common.core.core.domain.R;
import com.xll.frameworks.pro.common.core.core.domain.entity.RegisterBody;
import com.xll.frameworks.pro.common.core.utils.StringUtils;
import com.xll.frameworks.pro.system.infrastructure.web.service.SysRegisterService;
import com.xll.frameworks.pro.system.temp.cache.ConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 注册验证
 *
 * @author ruoyi
 */
@RestController
public class SysRegisterController extends BaseController {

    @Autowired
    private SysRegisterService registerService;

    @PostMapping("/register")
    public R register(@RequestBody RegisterBody user) {
        if (!ConfigUtils.getConfigBooleanValueByKey("sys.account.registerUser", Boolean.FALSE)) {
            return R.fail("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? R.success() : R.fail(msg);
    }
}
