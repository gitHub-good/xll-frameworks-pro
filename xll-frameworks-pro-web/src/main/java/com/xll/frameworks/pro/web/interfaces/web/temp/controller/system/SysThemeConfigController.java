package com.xll.frameworks.pro.web.interfaces.web.temp.controller.system;

import com.github.pagehelper.PageInfo;
import com.xll.frameworks.pro.common.core.annotation.Log;
import com.xll.frameworks.pro.common.core.core.controller.BaseController;
import com.xll.frameworks.pro.common.core.core.domain.R;
import com.xll.frameworks.pro.common.core.core.page.PageDomain;
import com.xll.frameworks.pro.common.core.enums.BusinessType;
import com.xll.frameworks.pro.system.temp.common.utils.poi.ExcelUtil;
import com.xll.frameworks.pro.system.temp.system.domain.SysThemeConfig;
import com.xll.frameworks.pro.system.temp.system.service.SysThemeConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户主题信息记录Controller
 * @author aidex
 * @email aidex@qq.com
 * @date 2021-04-29
 */
@RestController
@RequestMapping("/sysThemeConfig/sysThemeConfig")
public class SysThemeConfigController extends BaseController
{
    @Autowired
    private SysThemeConfigService sysThemeConfigService;

    /**
     * 查询用户主题信息记录列表
     */
    @PreAuthorize("@ss.hasPermi('sysThemeConfig:sysThemeConfig:list')")
    @GetMapping("/list")
    public R<PageInfo> list(SysThemeConfig sysThemeConfig, HttpServletRequest request, HttpServletResponse response)
    {
        sysThemeConfig.setPage(new PageDomain(request, response));
        return R.data(sysThemeConfigService.findPage(sysThemeConfig));
    }

    /**
     * 获取用户主题信息记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('sysThemeConfig:sysThemeConfig:query')")
    @GetMapping(value = "/{id}")
    public R<SysThemeConfig> detail(@PathVariable("id") String id)
    {
        return R.data(sysThemeConfigService.get(id));
    }

    /**
     * 新增用户主题信息记录
     */
    @PreAuthorize("@ss.hasPermi('sysThemeConfig:sysThemeConfig:add')")
    @Log(title = "用户主题信息记录", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody @Validated  SysThemeConfig sysThemeConfig)
    {
        return R.status(sysThemeConfigService.save(sysThemeConfig));
    }

    /**
     * 修改用户主题信息记录
     */
    @PreAuthorize("@ss.hasPermi('sysThemeConfig:sysThemeConfig:edit')")
    @Log(title = "用户主题信息记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody @Validated SysThemeConfig sysThemeConfig)
    {
        return R.status(sysThemeConfigService.save(sysThemeConfig));

    }

    /**
     * 删除用户主题信息记录
     */
    @PreAuthorize("@ss.hasPermi('sysThemeConfig:sysThemeConfig:remove')")
    @Log(title = "用户主题信息记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String[] ids)
    {
        return R.status(sysThemeConfigService.deleteSysThemeConfigByIds(ids));
    }

    /**
     * 获取最大编号
     */
    @PreAuthorize("@ss.hasPermi('sysThemeConfig:sysThemeConfig:query')")
    @GetMapping("/findMaxSort")
    public R findMaxSort()
    {
        return R.data(sysThemeConfigService.findMaxSort(new SysThemeConfig()));
    }

    /**
     * 导出用户主题信息记录列表
     */
    @PreAuthorize("@ss.hasPermi('sysThemeConfig:sysThemeConfig:export')")
    @Log(title = "用户主题信息记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public R export(SysThemeConfig sysThemeConfig)
    {
        List<SysThemeConfig> list = sysThemeConfigService.findList(sysThemeConfig);
        ExcelUtil<SysThemeConfig> util = new ExcelUtil<SysThemeConfig>(SysThemeConfig.class);
        return util.exportExcel(list, "sysThemeConfig");
    }

}
