package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ChatGPT管理对象 chat
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
public class Chat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 对话id */
    private String chatId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 用户api-key */
    @Excel(name = "用户api-key")
    private String userKey;

    /** 使用的model类型 */
    @Excel(name = "使用的model类型")
    private String model;

    /** 问题 */
    @Excel(name = "问题")
    private String prompt;

    /** 答案 */
    @Excel(name = "答案")
    private String answer;

    /** 是否结束 */
    @Excel(name = "是否结束")
    private Boolean isEnd;

    /** 用户ip地址 */
    @Excel(name = "用户ip地址")
    private String requestIpAddress;

    /** 返回的responseJSON串 */
    @Excel(name = "返回的responseJSON串")
    private String responseJson;

    /** 问题ID */
    @Excel(name = "问题ID")
    private String promptId;

    /** 问答结束的原因 */
    @Excel(name = "问答结束的原因")
    private String finishReason;

    /** 请求的url */
    @Excel(name = "请求的url")
    private String requestUrl;

    /** 请求完成的时间 */
    @Excel(name = "请求完成的时间")
    private Long requestTime;

    /** 要生成的最大字符数 */
    @Excel(name = "要生成的最大字符数")
    private Long maxTokens;

    /** 采样温度 */
    @Excel(name = "采样温度")
    private Double temperature;

    /** 运行的线程名称 */
    @Excel(name = "运行的线程名称")
    private String threadName;

    public void setChatId(String chatId) 
    {
        this.chatId = chatId;
    }

    public String getChatId() 
    {
        return chatId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setUserKey(String userKey) 
    {
        this.userKey = userKey;
    }

    public String getUserKey() 
    {
        return userKey;
    }
    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }
    public void setPrompt(String prompt) 
    {
        this.prompt = prompt;
    }

    public String getPrompt() 
    {
        return prompt;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setIsEnd(Boolean isEnd) 
    {
        this.isEnd = isEnd;
    }

    public Boolean getIsEnd() 
    {
        return isEnd;
    }
    public void setRequestIpAddress(String requestIpAddress) 
    {
        this.requestIpAddress = requestIpAddress;
    }

    public String getRequestIpAddress() 
    {
        return requestIpAddress;
    }
    public void setResponseJson(String responseJson) 
    {
        this.responseJson = responseJson;
    }

    public String getResponseJson() 
    {
        return responseJson;
    }
    public void setPromptId(String promptId) 
    {
        this.promptId = promptId;
    }

    public String getPromptId() 
    {
        return promptId;
    }
    public void setFinishReason(String finishReason) 
    {
        this.finishReason = finishReason;
    }

    public String getFinishReason() 
    {
        return finishReason;
    }
    public void setRequestUrl(String requestUrl) 
    {
        this.requestUrl = requestUrl;
    }

    public String getRequestUrl() 
    {
        return requestUrl;
    }
    public void setRequestTime(Long requestTime) 
    {
        this.requestTime = requestTime;
    }

    public Long getRequestTime() 
    {
        return requestTime;
    }
    public void setMaxTokens(Long maxTokens) 
    {
        this.maxTokens = maxTokens;
    }

    public Long getMaxTokens() 
    {
        return maxTokens;
    }
    public void setTemperature(Double temperature) 
    {
        this.temperature = temperature;
    }

    public Double getTemperature() 
    {
        return temperature;
    }
    public void setThreadName(String threadName) 
    {
        this.threadName = threadName;
    }

    public String getThreadName() 
    {
        return threadName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chatId", getChatId())
            .append("username", getUsername())
            .append("userKey", getUserKey())
            .append("model", getModel())
            .append("prompt", getPrompt())
            .append("answer", getAnswer())
            .append("isEnd", getIsEnd())
            .append("requestIpAddress", getRequestIpAddress())
            .append("responseJson", getResponseJson())
            .append("promptId", getPromptId())
            .append("finishReason", getFinishReason())
            .append("requestUrl", getRequestUrl())
            .append("createTime", getCreateTime())
            .append("requestTime", getRequestTime())
            .append("maxTokens", getMaxTokens())
            .append("temperature", getTemperature())
            .append("threadName", getThreadName())
            .toString();
    }
}
