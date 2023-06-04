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
import com.ruoyi.system.domain.Keysentences;
import com.ruoyi.system.service.IKeysentencesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 关键句管理Controller
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/system/keysentences")
public class KeysentencesController extends BaseController
{
    @Autowired
    private IKeysentencesService keysentencesService;

    /**
     * 查询关键句管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:keysentences:list')")
    @GetMapping("/list")
    public TableDataInfo list(Keysentences keysentences)
    {
        startPage();
        List<Keysentences> list = keysentencesService.selectKeysentencesList(keysentences);
        return getDataTable(list);
    }

    /**
     * 导出关键句管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:keysentences:export')")
    @Log(title = "关键句管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Keysentences keysentences)
    {
        List<Keysentences> list = keysentencesService.selectKeysentencesList(keysentences);
        ExcelUtil<Keysentences> util = new ExcelUtil<Keysentences>(Keysentences.class);
        util.exportExcel(response, list, "关键句管理数据");
    }

    /**
     * 获取关键句管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:keysentences:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(keysentencesService.selectKeysentencesById(id));
    }

    /**
     * 新增关键句管理
     */
    @PreAuthorize("@ss.hasPermi('system:keysentences:add')")
    @Log(title = "关键句管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Keysentences keysentences)
    {
        return toAjax(keysentencesService.insertKeysentences(keysentences));
    }

    /**
     * 修改关键句管理
     */
    @PreAuthorize("@ss.hasPermi('system:keysentences:edit')")
    @Log(title = "关键句管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Keysentences keysentences)
    {
        return toAjax(keysentencesService.updateKeysentences(keysentences));
    }

    /**
     * 删除关键句管理
     */
    @PreAuthorize("@ss.hasPermi('system:keysentences:remove')")
    @Log(title = "关键句管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(keysentencesService.deleteKeysentencesByIds(ids));
    }
}
