package com.xll.frameworks.pro.system.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xll.frameworks.pro.system.repository.mapper.SysDeptMapper;
import com.xll.frameworks.pro.system.repository.po.SysDeptPO;
import org.springframework.stereotype.Repository;

/**
 * 功能描述: <br>
 * <P>
 * @Description 部门信息
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 22:20
 */
@Repository
public class SysDeptRepository extends ServiceImpl<SysDeptMapper, SysDeptPO> {
}
