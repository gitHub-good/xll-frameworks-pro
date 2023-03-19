package com.xll.frameworks.pro.system.api;

import com.xll.frameworks.pro.common.core.R;
import com.xll.frameworks.pro.system.api.dto.SysRoleDTO;

/**
 * 功能描述: <br>
 * <P>
 * @Description 角色API
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/19 14:34
 */
public interface RemoteSysRoleServiceClient {
    R<Boolean> save(SysRoleDTO sysRoleDTO);

}
