package com.xll.frameworks.pro.web.model.system;

import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysRoleRequestVO {
    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    @Size(min = 0, max = 30, message = "角色名称长度不能超过30个字符")
    private String roleName;

    /**
     * 角色权限
     */
    @NotBlank(message = "权限字符不能为空")
    @Size(min = 0, max = 100, message = "权限字符长度不能超过100个字符")
    private String roleKey;

    /**
     * 角色排序
     */
    @NotBlank(message = "显示顺序不能为空")
    private Integer sort;
    /**
     * 数据范围
     */
    private String dataScope;
}
