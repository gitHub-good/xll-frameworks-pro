package com.xll.frameworks.pro.system.domain.model.user;

import com.xll.frameworks.pro.common.core.DO;
import com.xll.frameworks.pro.system.repository.po.SysUserPO;
import lombok.Data;

/**
 * 功能描述: <br>
 * <P>
 * @Description 用户领域对象
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 23:04
 */
@Data
public class SysUserDO implements DO {
    private SysUserPO sysUserPO;
}
