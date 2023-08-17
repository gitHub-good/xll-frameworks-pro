package com.xll.frameworks.pro.system.domain.model.user;

import com.xll.frameworks.pro.common.core.exception.DomainException;
import com.xll.frameworks.pro.system.domain.assembly.SysUserDomainAssembly;
import com.xll.frameworks.pro.system.repository.SysUserRepository;
import com.xll.frameworks.pro.system.repository.po.SysUserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述: <br>
 * <P>
 * @Description 用户业务处理
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 23:06
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    public void save(SysUserDO sysUserDO) throws DomainException {
        SysUserPO sysUserPO = SysUserDomainAssembly.INSTANCE.doToPo(sysUserDO);
        sysUserRepository.save(sysUserPO);
    }
}
