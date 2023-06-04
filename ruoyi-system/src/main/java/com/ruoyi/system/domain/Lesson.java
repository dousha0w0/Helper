package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程信息对象 lesson
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
public class Lesson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 视频 */
    @Excel(name = "视频")
    private String video;

    /** 名字 */
    @Excel(name = "名字")
    private String name;

    /** 介绍 */
    @Excel(name = "介绍")
    private String description;

    /** 老师 */
    @Excel(name = "老师")
    private String teacherName;

    /** 封面 */
    @Excel(name = "封面")
    private String cover;

    /** 分类 */
    @Excel(name = "分类")
    private String classification;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVideo(String video) 
    {
        this.video = video;
    }

    public String getVideo() 
    {
        return video;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }
    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }
    public void setClassification(String classification) 
    {
        this.classification = classification;
    }

    public String getClassification() 
    {
        return classification;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("video", getVideo())
            .append("name", getName())
            .append("description", getDescription())
            .append("teacherName", getTeacherName())
            .append("cover", getCover())
            .append("classification", getClassification())
            .toString();
    }
}
