package com.xll.frameworks.pro.system.api;

import com.xll.frameworks.pro.common.core.R;
import com.xll.frameworks.pro.system.api.dto.SysRoleDTO;

public interface SysRoleServiceApi {

    R<Boolean> save(SysRoleDTO sysRoleDTO);
}
