package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Keysentences;

/**
 * 关键句管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
public interface KeysentencesMapper 
{
    /**
     * 查询关键句管理
     * 
     * @param id 关键句管理主键
     * @return 关键句管理
     */
    public Keysentences selectKeysentencesById(Long id);

    /**
     * 查询关键句管理列表
     * 
     * @param keysentences 关键句管理
     * @return 关键句管理集合
     */
    public List<Keysentences> selectKeysentencesList(Keysentences keysentences);

    /**
     * 新增关键句管理
     * 
     * @param keysentences 关键句管理
     * @return 结果
     */
    public int insertKeysentences(Keysentences keysentences);

    /**
     * 修改关键句管理
     * 
     * @param keysentences 关键句管理
     * @return 结果
     */
    public int updateKeysentences(Keysentences keysentences);

    /**
     * 删除关键句管理
     * 
     * @param id 关键句管理主键
     * @return 结果
     */
    public int deleteKeysentencesById(Long id);

    /**
     * 批量删除关键句管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKeysentencesByIds(Long[] ids);
}
