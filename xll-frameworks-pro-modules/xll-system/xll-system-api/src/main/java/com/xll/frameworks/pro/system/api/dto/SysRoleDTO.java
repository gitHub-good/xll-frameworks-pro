package com.xll.frameworks.pro.system.api.dto;

import com.xll.frameworks.pro.common.core.DTO;
import lombok.Data;
/**
 * 功能描述: <br>
 * <P>
 * @Description 角色RPC数据传输
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/19 00:02
 */
@Data
public class SysRoleDTO implements DTO {
    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限
     */
    private String roleKey;

    /**
     * 角色排序
     */
    private Integer sort;
    /**
     * 数据范围
     */
    private String dataScope;
}
