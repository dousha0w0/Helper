package com.ruoyi.web.controller;

import cn.hutool.json.JSONUtil;
import com.plexpt.chatgpt.ChatGPT;
import com.ruoyi.web.model.BotResponse;
import com.ruoyi.web.model.GPTRequest;
import com.ruoyi.web.service.ChartGPTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * GPT-3接口
 *
 * @author zhengwen
 */

@Slf4j
@RestController
@RequestMapping("/chatGpt")
public class ChatGPTController {

    @Resource
    private ChartGPTService chartGPTService;


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * openAI GPT-3
     *
     * @param request 条件对象
     * @return 出参对象
     */
    @RequestMapping(value = "/askAi")
    public String askAi(@RequestBody String request) {
        ChatGPT chatGPT = ChatGPT.builder().apiKey("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").apiHost("https://api.openai.com/").build().init();
        return chatGPT.chat(request);
    }
}

