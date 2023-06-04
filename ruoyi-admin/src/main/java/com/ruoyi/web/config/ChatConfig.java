package com.ruoyi.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件 读取 open-ai 配置
 */
@ConfigurationProperties(prefix = "open-ai",ignoreUnknownFields = true)
@Component
@Data
public class ChatConfig {

    private String token;
    private Long timeOut;
    private Long writeTimeOut;
    private Long readTimeOut;
    private Integer proxyPort;
    private Long size;
    private ChatGPTConfig chatGPT;

}
