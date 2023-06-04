package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.KeysentencesMapper;
import com.ruoyi.system.domain.Keysentences;
import com.ruoyi.system.service.IKeysentencesService;

/**
 * 关键句管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@Service
public class KeysentencesServiceImpl implements IKeysentencesService 
{
    @Autowired
    private KeysentencesMapper keysentencesMapper;

    /**
     * 查询关键句管理
     * 
     * @param id 关键句管理主键
     * @return 关键句管理
     */
    @Override
    public Keysentences selectKeysentencesById(Long id)
    {
        return keysentencesMapper.selectKeysentencesById(id);
    }

    /**
     * 查询关键句管理列表
     * 
     * @param keysentences 关键句管理
     * @return 关键句管理
     */
    @Override
    public List<Keysentences> selectKeysentencesList(Keysentences keysentences)
    {
        return keysentencesMapper.selectKeysentencesList(keysentences);
    }

    /**
     * 新增关键句管理
     * 
     * @param keysentences 关键句管理
     * @return 结果
     */
    @Override
    public int insertKeysentences(Keysentences keysentences)
    {
        return keysentencesMapper.insertKeysentences(keysentences);
    }

    /**
     * 修改关键句管理
     * 
     * @param keysentences 关键句管理
     * @return 结果
     */
    @Override
    public int updateKeysentences(Keysentences keysentences)
    {
        return keysentencesMapper.updateKeysentences(keysentences);
    }

    /**
     * 批量删除关键句管理
     * 
     * @param ids 需要删除的关键句管理主键
     * @return 结果
     */
    @Override
    public int deleteKeysentencesByIds(Long[] ids)
    {
        return keysentencesMapper.deleteKeysentencesByIds(ids);
    }

    /**
     * 删除关键句管理信息
     * 
     * @param id 关键句管理主键
     * @return 结果
     */
    @Override
    public int deleteKeysentencesById(Long id)
    {
        return keysentencesMapper.deleteKeysentencesById(id);
    }
}
