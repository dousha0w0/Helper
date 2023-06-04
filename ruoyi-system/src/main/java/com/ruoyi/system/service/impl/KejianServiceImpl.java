package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.KejianMapper;
import com.ruoyi.system.domain.Kejian;
import com.ruoyi.system.service.IKejianService;

/**
 * 课件管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@Service
public class KejianServiceImpl implements IKejianService 
{
    @Autowired
    private KejianMapper kejianMapper;

    /**
     * 查询课件管理
     * 
     * @param id 课件管理主键
     * @return 课件管理
     */
    @Override
    public Kejian selectKejianById(String id)
    {
        return kejianMapper.selectKejianById(id);
    }

    /**
     * 查询课件管理列表
     * 
     * @param kejian 课件管理
     * @return 课件管理
     */
    @Override
    public List<Kejian> selectKejianList(Kejian kejian)
    {
        return kejianMapper.selectKejianList(kejian);
    }

    /**
     * 新增课件管理
     * 
     * @param kejian 课件管理
     * @return 结果
     */
    @Override
    public int insertKejian(Kejian kejian)
    {
        return kejianMapper.insertKejian(kejian);
    }

    /**
     * 修改课件管理
     * 
     * @param kejian 课件管理
     * @return 结果
     */
    @Override
    public int updateKejian(Kejian kejian)
    {
        return kejianMapper.updateKejian(kejian);
    }

    /**
     * 批量删除课件管理
     * 
     * @param ids 需要删除的课件管理主键
     * @return 结果
     */
    @Override
    public int deleteKejianByIds(String[] ids)
    {
        return kejianMapper.deleteKejianByIds(ids);
    }

    /**
     * 删除课件管理信息
     * 
     * @param id 课件管理主键
     * @return 结果
     */
    @Override
    public int deleteKejianById(String id)
    {
        return kejianMapper.deleteKejianById(id);
    }
}
