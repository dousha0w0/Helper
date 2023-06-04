package com.ruoyi.system.util;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Question {

    @NotBlank(message = "问题不能为空")
    private String q;

    /**
     * 是否接着上一次询问
     */
    private Boolean isContinue;
}
