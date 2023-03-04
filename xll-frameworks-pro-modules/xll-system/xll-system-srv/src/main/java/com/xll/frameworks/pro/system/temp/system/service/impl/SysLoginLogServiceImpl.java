package com.xll.frameworks.pro.system.temp.system.service.impl;

import com.xll.frameworks.pro.common.core.core.domain.BaseEntity;
import com.xll.frameworks.pro.common.core.utils.uuid.IdUtils;
import com.xll.frameworks.pro.system.temp.common.core.service.BaseServiceImpl;
import com.xll.frameworks.pro.system.temp.system.domain.SysLoginLog;
import com.xll.frameworks.pro.system.temp.system.mapper.SysLoginLogMapper;
import com.xll.frameworks.pro.system.temp.system.service.SysLoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统访问日志情况信息 服务层处理
 *
 * @author ruoyi
 */
@Service
public class SysLoginLogServiceImpl extends BaseServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService {
    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public int deleteLoginLogByIds(String[] infoIds) {
        return mapper.deleteLoginLogByIds(infoIds, BaseEntity.DEL_FLAG_DELETE);
    }

    /**
     * 清空系统登录日志
     */
    @Override
    @Transactional(readOnly = false)
    public void cleanLoginLog() {
        mapper.cleanLoginLog();
    }

    @Override
    @Transactional(readOnly = false)
    public boolean addLoginLog(SysLoginLog sysLoginLog) {
        sysLoginLog.setId(IdUtils.randomUUID());
        return mapper.addLoginLog(sysLoginLog) > 0 ? true : false;
    }

    /**
     * 根据日志保留时间清除历史日志
     * @param saveDay
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public int deleteLoginLogBySaveDay(String saveDay) {
        return mapper.deleteLoginLogBySaveDay(saveDay);
    }
}