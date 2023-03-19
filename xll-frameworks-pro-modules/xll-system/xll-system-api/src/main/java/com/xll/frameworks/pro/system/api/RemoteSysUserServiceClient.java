package com.xll.frameworks.pro.system.api;

import com.xll.frameworks.pro.common.core.R;
import com.xll.frameworks.pro.system.api.dto.SysUserDTO;

public interface RemoteSysUserServiceClient {
    R<Boolean> save(SysUserDTO sysUserDTO);
}
