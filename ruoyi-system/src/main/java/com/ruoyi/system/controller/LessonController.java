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
import com.ruoyi.system.domain.Lesson;
import com.ruoyi.system.service.ILessonService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
@RestController
@RequestMapping("/system/lesson")
public class LessonController extends BaseController
{
    @Autowired
    private ILessonService lessonService;

    /**
     * 查询课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:list')")
    @GetMapping("/list")
    public TableDataInfo list(Lesson lesson)
    {
        startPage();
        List<Lesson> list = lessonService.selectLessonList(lesson);
        return getDataTable(list);
    }

    /**
     * 导出课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:export')")
    @Log(title = "课程信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Lesson lesson)
    {
        List<Lesson> list = lessonService.selectLessonList(lesson);
        ExcelUtil<Lesson> util = new ExcelUtil<Lesson>(Lesson.class);
        util.exportExcel(response, list, "课程信息数据");
    }

    /**
     * 获取课程信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lessonService.selectLessonById(id));
    }

    /**
     * 新增课程信息
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:add')")
    @Log(title = "课程信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Lesson lesson)
    {
        return toAjax(lessonService.insertLesson(lesson));
    }

    /**
     * 修改课程信息
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:edit')")
    @Log(title = "课程信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Lesson lesson)
    {
        return toAjax(lessonService.updateLesson(lesson));
    }

    /**
     * 删除课程信息
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:remove')")
    @Log(title = "课程信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lessonService.deleteLessonByIds(ids));
    }
}
