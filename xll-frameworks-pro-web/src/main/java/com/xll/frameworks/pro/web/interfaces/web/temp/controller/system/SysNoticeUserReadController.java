package com.xll.frameworks.pro.web.interfaces.web.temp.controller.system;

import com.github.pagehelper.PageInfo;
import com.xll.frameworks.pro.common.core.annotation.Log;
import com.xll.frameworks.pro.common.core.core.controller.BaseController;
import com.xll.frameworks.pro.common.core.core.domain.R;
import com.xll.frameworks.pro.common.core.core.page.PageDomain;
import com.xll.frameworks.pro.common.core.enums.BusinessType;
import com.xll.frameworks.pro.system.temp.common.utils.poi.ExcelUtil;
import com.xll.frameworks.pro.system.temp.system.domain.SysNoticeUserRead;
import com.xll.frameworks.pro.system.temp.system.service.SysNoticeUserReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通知公告用户阅读Controller
 * @author aidex
 * @email aidex@qq.com
 * @date 2021-07-02
 */
@RestController
@RequestMapping("/system/sysNoticeUserRead")
public class SysNoticeUserReadController extends BaseController
{
    @Autowired
    private SysNoticeUserReadService sysNoticeUserReadService;

    /**
     * 查询通知公告用户阅读列表
     */
    @GetMapping("/list")
    public R<PageInfo> list(SysNoticeUserRead sysNoticeUserRead, HttpServletRequest request, HttpServletResponse response)
    {
        sysNoticeUserRead.setPage(new PageDomain(request, response));
        return R.data(sysNoticeUserReadService.findPage(sysNoticeUserRead));
    }

    /**
     * 获取通知公告用户阅读详细信息
     */
    @GetMapping(value = "/{id}")
    public R<SysNoticeUserRead> detail(@PathVariable("id") String id)
    {
        return R.data(sysNoticeUserReadService.get(id));
    }

    /**
     * 新增通知公告用户阅读
     */
    @Log(title = "通知公告用户阅读", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody @Validated  SysNoticeUserRead sysNoticeUserRead)
    {
        return R.status(sysNoticeUserReadService.save(sysNoticeUserRead));
    }

    /**
     * 修改通知公告用户阅读
     */
    @Log(title = "通知公告用户阅读", businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody @Validated SysNoticeUserRead sysNoticeUserRead)
    {
        return R.status(sysNoticeUserReadService.save(sysNoticeUserRead));

    }

    /**
     * 删除通知公告用户阅读
     */
    @Log(title = "通知公告用户阅读", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String[] ids)
    {
        return R.status(sysNoticeUserReadService.deleteSysNoticeUserReadByIds(ids));
    }


    /**
     * 导出通知公告用户阅读列表
     */
    @Log(title = "通知公告用户阅读", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public R export(SysNoticeUserRead sysNoticeUserRead)
    {
        List<SysNoticeUserRead> list = sysNoticeUserReadService.findList(sysNoticeUserRead);
        ExcelUtil<SysNoticeUserRead> util = new ExcelUtil<SysNoticeUserRead>(SysNoticeUserRead.class);
        return util.exportExcel(list, "sysNoticeUserRead");
    }

}
