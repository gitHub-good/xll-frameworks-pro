package com.xll.frameworks.pro.system.api.dto;

import com.xll.frameworks.pro.common.core.DTO;
import lombok.Data;

@Data
public class SysUserDTO implements DTO {
    private Long id;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户账户
     */
    private String userAccount;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 帐号状态（0:停用 1:正常)
     */
    private Integer status;
    /**
     * 删除标志（0:存在 1:删除)
     */
    private Integer delFlag;
}
