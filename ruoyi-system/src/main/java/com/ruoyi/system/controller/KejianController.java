package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Kejian;
import com.ruoyi.system.service.IKejianService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课件管理Controller
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/system/kejian")
public class KejianController extends BaseController
{
    @Autowired
    private IKejianService kejianService;

    /**
     * 查询课件管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:kejian:list')")
    @GetMapping("/list")
    public TableDataInfo list(Kejian kejian)
    {
        startPage();
        List<Kejian> list = kejianService.selectKejianList(kejian);
        return getDataTable(list);
    }

    /**
     * 导出课件管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:kejian:export')")
    @Log(title = "课件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Kejian kejian)
    {
        List<Kejian> list = kejianService.selectKejianList(kejian);
        ExcelUtil<Kejian> util = new ExcelUtil<Kejian>(Kejian.class);
        util.exportExcel(response, list, "课件管理数据");
    }

    /**
     * 获取课件管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:kejian:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(kejianService.selectKejianById(id));
    }

    /**
     * 新增课件管理
     */
    @PreAuthorize("@ss.hasPermi('system:kejian:add')")
    @Log(title = "课件管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Kejian kejian)
    {
        return toAjax(kejianService.insertKejian(kejian));
    }

    /**
     * 修改课件管理
     */
    @PreAuthorize("@ss.hasPermi('system:kejian:edit')")
    @Log(title = "课件管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Kejian kejian)
    {
        return toAjax(kejianService.updateKejian(kejian));
    }

    /**
     * 删除课件管理
     */
    @PreAuthorize("@ss.hasPermi('system:kejian:remove')")
    @Log(title = "课件管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(kejianService.deleteKejianByIds(ids));
    }
}
