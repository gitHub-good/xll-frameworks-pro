package com.xll.frameworks.pro.system.infrastructure.web.service;

import com.xll.frameworks.pro.common.core.core.domain.entity.SysUser;
import com.xll.frameworks.pro.system.temp.system.service.ISysRoleService;
import com.xll.frameworks.pro.system.temp.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户权限处理
 * 
 * @author ruoyi
 */
@Component
public class SysPermissionService
{
    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private SysMenuService menuService;

    /**
     * 获取角色数据权限
     * 
     * @param user 用户信息
     * @return 角色权限信息
     */
    public Set<String> getRolePermission(SysUser user)
    {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin())
        {
            roles.add("admin");
        }
        else
        {
            roles.addAll(roleService.selectRolePermissionByUserId(user.getId()));
        }
        return roles;
    }

    /**
     * 获取菜单数据权限
     * 
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(SysUser user)
    {
        user.getMenuPermissions(user);
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin())
        {
            perms.add("*:*:*");
        }
        else
        {
            perms.addAll(menuService.selectMenuPermsByUserId(user.getId()));
        }
        return perms;
    }
}
