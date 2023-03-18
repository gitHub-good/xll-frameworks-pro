package com.xll.frameworks.pro.system.domain.model.role;

import com.xll.frameworks.pro.common.core.exception.DomainException;
import com.xll.frameworks.pro.system.domain.assembler.SysRoleDomainAssembler;
import com.xll.frameworks.pro.system.repository.SysRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 功能描述: <br>
 * <P>
 * @Description 角色业务
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 23:14
 */
@Slf4j
@Service
public class SysRoleService {
    @Autowired
    private SysRoleRepository sysRoleRepository;

    public void save(SysRoleDO sysRoleDO) throws DomainException {
        try{
            sysRoleRepository.save(SysRoleDomainAssembler.INSTANCE.doToPo(sysRoleDO));
        }catch (Exception e){
            log.error("sys role service method save exception", e);
            throw new DomainException("sys role service method save exception");
        }
    }
}
