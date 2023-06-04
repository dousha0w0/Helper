package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Kejian;

/**
 * 课件管理Service接口
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
public interface IKejianService 
{
    /**
     * 查询课件管理
     * 
     * @param id 课件管理主键
     * @return 课件管理
     */
    public Kejian selectKejianById(String id);

    /**
     * 查询课件管理列表
     * 
     * @param kejian 课件管理
     * @return 课件管理集合
     */
    public List<Kejian> selectKejianList(Kejian kejian);

    /**
     * 新增课件管理
     * 
     * @param kejian 课件管理
     * @return 结果
     */
    public int insertKejian(Kejian kejian);

    /**
     * 修改课件管理
     * 
     * @param kejian 课件管理
     * @return 结果
     */
    public int updateKejian(Kejian kejian);

    /**
     * 批量删除课件管理
     * 
     * @param ids 需要删除的课件管理主键集合
     * @return 结果
     */
    public int deleteKejianByIds(String[] ids);

    /**
     * 删除课件管理信息
     * 
     * @param id 课件管理主键
     * @return 结果
     */
    public int deleteKejianById(String id);
}
