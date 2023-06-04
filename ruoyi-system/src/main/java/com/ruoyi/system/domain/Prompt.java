package com.ruoyi.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 封装的工具类对象 用于存储问题，ip，时间等信息
 */
@Data
@AllArgsConstructor
public class Prompt {

    private String question;
    private String ip;
    private String data;
    private Integer requestTime;
}
