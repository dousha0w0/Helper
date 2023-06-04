package com.ruoyi.web.model;

import lombok.Data;

@Data
public class GPTRequest {
    /**
     * 问题
     */
    private String askStr;

    /**
     * 回答
     */
    private String replyStr;
}
