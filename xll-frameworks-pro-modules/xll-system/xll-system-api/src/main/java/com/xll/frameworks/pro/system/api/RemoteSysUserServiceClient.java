package com.xll.frameworks.pro.system.api;

import com.xll.frameworks.pro.common.core.R;
import com.xll.frameworks.pro.system.api.dto.SysUserDTO;

/**
 * 功能描述: <br>
 * <p>
 *  <用户管理>
 * </p>
 * @author xuliangliang
 * @since 2023/7/29 23:37
 * @version 1.0.0
 */
public interface RemoteSysUserServiceClient {
    R<Boolean> save(SysUserDTO sysUserDTO);
}
