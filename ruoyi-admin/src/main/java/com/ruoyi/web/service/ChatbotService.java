package com.ruoyi.web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plexpt.chatgpt.ChatGPT;
import com.ruoyi.web.model.BotResponse;

public class ChatbotService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public BotResponse generateResponse(String prompt) throws Exception {
        String res = testGpt(prompt);
        return objectMapper.readValue(res, BotResponse.class);
    }


    public String testGpt(String prompt) {
        ChatGPT chatGPT = ChatGPT.builder().
                apiKey("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")
                .apiHost("https://api.openai.com/")
                .build()
                .init();
        return chatGPT.chat(prompt);
    }
}
