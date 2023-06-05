package com.ruoyi.system.domain.vo;

import com.ruoyi.system.domain.Chat;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 封装返回前端的问答实体对象，只展示问题，结果，时间等。
 */
@Data
public class ChatVo implements Serializable {

    /**
     * 问题
     */
    private String prompt;

    /**
     * 答案
     */
    private String answer;

    private String promptId;
    /**
     * 是否结束
     */
    private Boolean isEnd;

    /**
     * 请求创建的时间
     */
    private Date createTime;

    /**
     * 采样温度
     */
    private Double temperature;

    public ChatVo(@NotNull Chat chat) {
        this.prompt = chat.getPrompt();
        this.answer = chat.getAnswer();
        this.promptId = chat.getPromptId();
        this.isEnd = chat.getIsEnd();
        this.createTime = chat.getCreateTime();
        this.temperature = chat.getTemperature();
    }

    public static List<ChatVo> toChatVo(List<Chat> chatList) {
        List<ChatVo> chatVoList = new java.util.ArrayList<>();
        for (Chat chat : chatList) {
            chatVoList.add(new ChatVo(chat));
        }
        return chatVoList;
    }

    private static final long serialVersionUID = 1L;
}
