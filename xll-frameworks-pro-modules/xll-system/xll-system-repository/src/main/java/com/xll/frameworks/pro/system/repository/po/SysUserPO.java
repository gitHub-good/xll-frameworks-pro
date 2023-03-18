package com.xll.frameworks.pro.system.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xll.frameworks.pro.common.core.PO;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述: <br>
 * <P>
 * @Description 用户信息
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 21:59
 */
@Data
@TableName("SysUser")
public class SysUserPO extends PO {
    @TableId(type = IdType.AUTO)
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
