package com.ruoyi.web.config;

import lombok.Data;

@Data
public class ChatGPTConfig {

    private String model;
    private Double temperature;
    private Integer maxTokens;
    private Double topP;
    private Boolean echo;
}
