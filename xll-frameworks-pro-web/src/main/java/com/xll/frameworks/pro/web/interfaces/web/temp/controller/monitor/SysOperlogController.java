package com.xll.frameworks.pro.web.interfaces.web.temp.controller.monitor;

import com.github.pagehelper.PageInfo;
import com.xll.frameworks.pro.common.core.annotation.Log;
import com.xll.frameworks.pro.common.core.core.controller.BaseController;
import com.xll.frameworks.pro.common.core.core.domain.R;
import com.xll.frameworks.pro.common.core.core.page.PageDomain;
import com.xll.frameworks.pro.common.core.enums.BusinessType;
import com.xll.frameworks.pro.system.temp.common.utils.poi.ExcelUtil;
import com.xll.frameworks.pro.system.temp.system.domain.SysOperLog;
import com.xll.frameworks.pro.system.temp.system.service.SysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 操作日志记录
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/operlog")
public class SysOperlogController extends BaseController
{
    @Autowired
    private SysOperLogService operLogService;

    @PreAuthorize("@ss.hasPermi('monitor:operlog:list')")
    @GetMapping("/page")
    public R<PageInfo> list(SysOperLog operLog, HttpServletRequest request, HttpServletResponse response)
    {
        operLog.setPage(new PageDomain(request, response));
        return R.data(operLogService.findPage(operLog));
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:export')")
    @GetMapping("/export")
    public R export(SysOperLog operLog)
    {
        List<SysOperLog> list = operLogService.findList(operLog);
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        return util.exportExcel(list, "操作日志");
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/{operIds}")
    public R remove(@PathVariable String[] operIds)
    {
        return R.status(operLogService.deleteOperLogByIds(operIds));
    }

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/clean")
    public R clean()
    {
        operLogService.cleanOperLog();
        return R.status(true);
    }
}
