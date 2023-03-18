package com.xll.frameworks.pro.system.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xll.frameworks.pro.system.repository.mapper.SysUserMapper;
import com.xll.frameworks.pro.system.repository.po.SysUserPO;
import org.springframework.stereotype.Repository;

/**
 * 功能描述: <br>
 * <P>
 * @Description 用户存储层
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 22:16
 */
@Repository
public class SysUserRepository extends ServiceImpl<SysUserMapper, SysUserPO> {

}
