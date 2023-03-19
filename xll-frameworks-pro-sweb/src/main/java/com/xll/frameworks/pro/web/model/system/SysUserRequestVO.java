package com.xll.frameworks.pro.web.model.system;

import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysUserRequestVO {
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
    @NotBlank(message = "用户账户不能为空")
    @Size(max = 64, message = "用户账户长度不能超过30个字符")
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
