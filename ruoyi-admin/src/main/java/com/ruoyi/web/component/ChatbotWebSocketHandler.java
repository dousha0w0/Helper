package com.ruoyi.web.component;

import com.ruoyi.web.model.BotResponse;
import com.ruoyi.web.service.ChatbotService;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.CloseStatus;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ChatbotWebSocketHandler extends AbstractWebSocketHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ChatbotService chatbotService = new ChatbotService();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocket connection established: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Received message: " + message.getPayload());

        BotResponse response = chatbotService.generateResponse(message.getPayload());
        if (response != null) {
            String jsonResponse = objectMapper.writeValueAsString(response);
            session.sendMessage(new TextMessage(jsonResponse));
        } else {
            session.close(CloseStatus.BAD_DATA);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("WebSocket connection closed: " + session.getId() + " (" + status.getCode() + ")");
    }
}
