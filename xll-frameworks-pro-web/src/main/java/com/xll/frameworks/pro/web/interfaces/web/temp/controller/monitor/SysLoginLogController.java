package com.xll.frameworks.pro.web.interfaces.web.temp.controller.monitor;

import com.github.pagehelper.PageInfo;
import com.xll.frameworks.pro.common.core.annotation.Log;
import com.xll.frameworks.pro.common.core.core.controller.BaseController;
import com.xll.frameworks.pro.common.core.core.domain.R;
import com.xll.frameworks.pro.common.core.core.page.PageDomain;
import com.xll.frameworks.pro.common.core.enums.BusinessType;
import com.xll.frameworks.pro.system.infrastructure.web.service.SysPasswordService;
import com.xll.frameworks.pro.system.temp.common.utils.poi.ExcelUtil;
import com.xll.frameworks.pro.system.temp.system.domain.SysLoginLog;
import com.xll.frameworks.pro.system.temp.system.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 系统访问记录
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/loginLog")
public class SysLoginLogController extends BaseController
{
    @Autowired
    private SysLoginLogService sysLoginLogService;

    @Autowired
    private SysPasswordService passwordService;

    @PreAuthorize("@ss.hasPermi('monitor:loginLog:list')")
    @GetMapping("/page")
    public R<PageInfo> list(SysLoginLog sysLoginLog, HttpServletRequest request, HttpServletResponse response)
    {
        sysLoginLog.setPage(new PageDomain(request, response));
        return R.data(sysLoginLogService.findPage(sysLoginLog));
    }

    @Log(title = "登录日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('monitor:loginLog:export')")
    @GetMapping("/export")
    public R export(SysLoginLog sysLoginLog)
    {
        List<SysLoginLog> list = sysLoginLogService.findList(sysLoginLog);
        ExcelUtil<SysLoginLog> util = new ExcelUtil<SysLoginLog>(SysLoginLog.class);
        return util.exportExcel(list, "登录日志");
    }

    @PreAuthorize("@ss.hasPermi('monitor:loginLog:remove')")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{infoIds}")
    public R remove(@PathVariable String[] infoIds)
    {
        return R.status(sysLoginLogService.deleteLoginLogByIds(infoIds));
    }

    @PreAuthorize("@ss.hasPermi('monitor:loginLog:remove')")
    @Log(title = "登录日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    public R clean()
    {
        sysLoginLogService.cleanLoginLog();
        return R.status(true);
    }

    @PreAuthorize("@ss.hasPermi('monitor:loginLog:unlock')")
    @Log(title = "账户解锁", businessType = BusinessType.OTHER)
    @GetMapping("/unlock/{userName}")
    public R unlock(@PathVariable("userName") String userName)
    {
        passwordService.clearLoginRecordCache(userName);
        return R.status(true);
    }
}
