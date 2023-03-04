package com.xll.frameworks.pro.web.interfaces.web.temp.controller.system;

import com.xll.frameworks.pro.common.core.annotation.Log;
import com.xll.frameworks.pro.common.core.config.AiDexConfig;
import com.xll.frameworks.pro.common.core.core.controller.BaseController;
import com.xll.frameworks.pro.common.core.core.domain.AjaxResult;
import com.xll.frameworks.pro.common.core.core.domain.R;
import com.xll.frameworks.pro.common.core.core.domain.entity.SysUser;
import com.xll.frameworks.pro.common.core.core.domain.model.LoginUser;
import com.xll.frameworks.pro.common.core.enums.BusinessType;
import com.xll.frameworks.pro.common.core.utils.SecurityUtils;
import com.xll.frameworks.pro.common.core.utils.file.FileUploadUtils;
import com.xll.frameworks.pro.common.core.utils.file.MimeTypeUtils;
import com.xll.frameworks.pro.system.infrastructure.web.service.TokenService;
import com.xll.frameworks.pro.system.temp.cache.UserUtils;
import com.xll.frameworks.pro.system.temp.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 个人信息 业务处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController
{
    @Autowired
    private ISysUserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 个人信息
     */
    @GetMapping
    public R<Map<String,Object>> profile()
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Map<String,Object> resultMap = new HashMap<String,Object>(3);
        resultMap.put("user",user);
        resultMap.put("roleGroup", userService.selectUserRoleGroup(loginUser.getUsername()));
        resultMap.put("postGroup", userService.selectUserPostGroup(loginUser.getUsername()));

        return R.data(resultMap);
    }

    /**
     * 修改用户
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R updateProfile(@RequestBody SysUser user)
    {
        //校验手机号
        userService.checkPhoneUnique(user);
        //校验邮箱
        userService.checkEmailUnique(user);
        //获取当前登录用户
        LoginUser loginUser = getLoginUser();
        SysUser sysUser = loginUser.getUser();
        //更新用户信息
        SysUser oldUser = userService.get(user.getId());
        user.setVersion(oldUser.getVersion());
        user.setUserName(sysUser.getUserName());
        user.setPassword(null);
        user.setAvatar(null);
        user.setDeptId(null);
        if (userService.updateUserProfile(user))
        {
            // 更新缓存用户信息
            sysUser.setNickName(user.getNickName());
            sysUser.setPhonenumber(user.getPhonenumber());
            sysUser.setEmail(user.getEmail());
            sysUser.setSex(user.getSex());
            sysUser.setVersion(user.getVersion());
            tokenService.setLoginUser(loginUser);
            //清除redis缓存信息
            UserUtils.clearCache(sysUser);
            return R.success();
        }
        return R.fail("修改个人信息异常，请联系管理员");
    }

    /**
     * 重置密码
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PutMapping("/updatePwd")
    public AjaxResult updatePwd(String oldPassword, String newPassword)
    {
        LoginUser loginUser = getLoginUser();
        String userName = loginUser.getUsername();
        String password = loginUser.getPassword();
        if (!SecurityUtils.matchesPassword(oldPassword, password))
        {
            return AjaxResult.error("修改密码失败，旧密码错误");
        }
        if (SecurityUtils.matchesPassword(newPassword, password))
        {
            return AjaxResult.error("新密码不能与旧密码相同");
        }
        if (userService.resetUserPwd(userName, SecurityUtils.encryptPassword(newPassword)) > 0)
        {
            // 更新缓存用户密码
            loginUser.getUser().setPassword(SecurityUtils.encryptPassword(newPassword));
            tokenService.setLoginUser(loginUser);
            return AjaxResult.success();
        }
        return AjaxResult.error("修改密码异常，请联系管理员");
    }

    /**
     * 头像上传
     */
    @Log(title = "用户头像", businessType = BusinessType.UPDATE)
    @PostMapping("/avatar")
    public AjaxResult avatar(@RequestParam("avatarfile") MultipartFile file) throws Exception
    {
        if (!file.isEmpty())
        {
            LoginUser loginUser = getLoginUser();
            String avatar = FileUploadUtils.upload(AiDexConfig.getAvatarPath(), file, MimeTypeUtils.IMAGE_EXTENSION);
            if (userService.updateUserAvatar(loginUser.getUsername(), avatar))
            {
                AjaxResult ajax = AjaxResult.success();
                ajax.put("imgUrl", avatar);
                // 更新缓存用户头像
                loginUser.getUser().setAvatar(avatar);
                tokenService.setLoginUser(loginUser);
                return ajax;
            }
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
}