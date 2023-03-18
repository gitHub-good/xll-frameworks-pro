package com.xll.frameworks.pro.system.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xll.frameworks.pro.common.core.PO;
import lombok.Data;
/**
 * 功能描述: <br>
 * <P>
 * @Description 角色信息
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 22:15
 */
@Data
@TableName("SysRole")
public class SysRolePO extends PO {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限key
     */
    private String roleKey;
    /**
     * 角色排序
     */
    private Integer sort;
    /**
     * 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）
     */
    private Integer dataScope;
    /**
     * 角色状态（0:停用 1:正常)
     */
    private Integer status;
    /**
     * 删除标志（0:存在 1:删除)
     */
    private Integer delFlag;
}
