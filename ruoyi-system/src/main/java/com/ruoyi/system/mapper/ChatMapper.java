package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Chat;

/**
 * ChatGPT管理Mapper接口
 *
 * @author ruoyi
 * @date 2023-06-04
 */
public interface ChatMapper
{
    /**
     * 查询ChatGPT管理
     *
     * @param chatId ChatGPT管理主键
     * @return ChatGPT管理
     */
    public Chat selectChatByChatId(String chatId);

    /**
     * 查询ChatGPT管理列表
     *
     * @param chat ChatGPT管理
     * @return ChatGPT管理集合
     */
    public List<Chat> selectChatList(Chat chat);

    /**
     * 新增ChatGPT管理
     *
     * @param chat ChatGPT管理
     * @return 结果
     */
    public int insertChat(Chat chat);

    /**
     * 修改ChatGPT管理
     *
     * @param chat ChatGPT管理
     * @return 结果
     */
    public int updateChat(Chat chat);

    /**
     * 删除ChatGPT管理
     *
     * @param chatId ChatGPT管理主键
     * @return 结果
     */
    public int deleteChatByChatId(String chatId);

    /**
     * 批量删除ChatGPT管理
     *
     * @param chatIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatByChatIds(String[] chatIds);


    int deleteByPrimaryKey(Integer chatId);

    int insert(Chat record);

    int insertSelective(Chat record);

    Chat selectByPrimaryKey(Integer chatId);

    int updateByPrimaryKeySelective(Chat record);

    int updateByPrimaryKey(Chat record);

    List<Chat> selectByUsername(String username);

    List<Chat> selectPage(String username, Integer start, Integer pageSize);
}
