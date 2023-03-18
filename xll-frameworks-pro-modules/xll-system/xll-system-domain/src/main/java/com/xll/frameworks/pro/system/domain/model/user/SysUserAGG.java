package com.xll.frameworks.pro.system.domain.model.user;

import com.xll.frameworks.pro.system.domain.model.dept.SysDeptDO;
import com.xll.frameworks.pro.system.repository.po.SysRolePO;
import lombok.Data;

import java.util.List;

/**
 * 功能描述: <br>
 * <P>
 * @Description 用户聚合
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 23:05
 */
@Data
public class SysUserAGG {
    private SysUserDO sysUserDO;
    /**
     * 部门信息
     */
    private SysDeptDO sysDeptDO;
    /**
     * 角色信息集
     */
    private List<SysRolePO> roles;
}
