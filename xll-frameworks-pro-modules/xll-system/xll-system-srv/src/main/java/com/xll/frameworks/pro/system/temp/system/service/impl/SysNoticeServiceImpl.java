package com.xll.frameworks.pro.system.temp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xll.frameworks.pro.common.core.core.domain.BaseEntity;
import com.xll.frameworks.pro.common.core.core.page.PageDomain;
import com.xll.frameworks.pro.system.temp.common.core.service.BaseServiceImpl;
import com.xll.frameworks.pro.system.temp.system.domain.SysNotice;
import com.xll.frameworks.pro.system.temp.system.mapper.SysNoticeMapper;
import com.xll.frameworks.pro.system.temp.system.service.SysNoticeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 公告 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class SysNoticeServiceImpl extends BaseServiceImpl<SysNoticeMapper, SysNotice> implements SysNoticeService
{
    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告ID
     * @return 结果
     */
    @Override
    @Transactional(readOnly = false)
    public int deleteNoticeByIds(String[] noticeIds)
    {
        return mapper.deleteNoticeByIds(noticeIds, BaseEntity.DEL_FLAG_DELETE);
    }
    @Override
    public List<SysNotice> getNoticeListByUserId(String userId){
        return mapper.getNoticeListByUserId(userId, BaseEntity.DEL_FLAG_NORMAL);
    }
    @Override
    public PageInfo<SysNotice> findNoticeByUserPage(SysNotice sysNotice){
        PageDomain page = sysNotice.getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        return new PageInfo(mapper.findNoticeByUserList(sysNotice));
    }
}