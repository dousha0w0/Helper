package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Lesson;

/**
 * 课程信息Service接口
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
public interface ILessonService 
{
    /**
     * 查询课程信息
     * 
     * @param id 课程信息主键
     * @return 课程信息
     */
    public Lesson selectLessonById(Long id);

    /**
     * 查询课程信息列表
     * 
     * @param lesson 课程信息
     * @return 课程信息集合
     */
    public List<Lesson> selectLessonList(Lesson lesson);

    /**
     * 新增课程信息
     * 
     * @param lesson 课程信息
     * @return 结果
     */
    public int insertLesson(Lesson lesson);

    /**
     * 修改课程信息
     * 
     * @param lesson 课程信息
     * @return 结果
     */
    public int updateLesson(Lesson lesson);

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的课程信息主键集合
     * @return 结果
     */
    public int deleteLessonByIds(Long[] ids);

    /**
     * 删除课程信息信息
     * 
     * @param id 课程信息主键
     * @return 结果
     */
    public int deleteLessonById(Long id);
}
