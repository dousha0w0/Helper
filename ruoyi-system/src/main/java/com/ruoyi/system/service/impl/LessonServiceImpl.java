package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LessonMapper;
import com.ruoyi.system.domain.Lesson;
import com.ruoyi.system.service.ILessonService;

/**
 * 课程信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
@Service
public class LessonServiceImpl implements ILessonService 
{
    @Autowired
    private LessonMapper lessonMapper;

    /**
     * 查询课程信息
     * 
     * @param id 课程信息主键
     * @return 课程信息
     */
    @Override
    public Lesson selectLessonById(Long id)
    {
        return lessonMapper.selectLessonById(id);
    }

    /**
     * 查询课程信息列表
     * 
     * @param lesson 课程信息
     * @return 课程信息
     */
    @Override
    public List<Lesson> selectLessonList(Lesson lesson)
    {
        return lessonMapper.selectLessonList(lesson);
    }

    /**
     * 新增课程信息
     * 
     * @param lesson 课程信息
     * @return 结果
     */
    @Override
    public int insertLesson(Lesson lesson)
    {
        return lessonMapper.insertLesson(lesson);
    }

    /**
     * 修改课程信息
     * 
     * @param lesson 课程信息
     * @return 结果
     */
    @Override
    public int updateLesson(Lesson lesson)
    {
        return lessonMapper.updateLesson(lesson);
    }

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的课程信息主键
     * @return 结果
     */
    @Override
    public int deleteLessonByIds(Long[] ids)
    {
        return lessonMapper.deleteLessonByIds(ids);
    }

    /**
     * 删除课程信息信息
     * 
     * @param id 课程信息主键
     * @return 结果
     */
    @Override
    public int deleteLessonById(Long id)
    {
        return lessonMapper.deleteLessonById(id);
    }
}
