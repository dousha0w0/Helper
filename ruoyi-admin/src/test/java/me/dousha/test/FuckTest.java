package me.dousha.test;

import com.plexpt.chatgpt.ChatGPT;
import com.ruoyi.web.component.ChatbotWebSocketHandler;
import com.ruoyi.web.model.BotResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FuckTest {
    @Test
    public void testGpt() {
        ChatGPT chatGPT = ChatGPT.builder().
                apiKey("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")
                .apiHost("https://api.openai.com/")
                .build()
                .init();
        String res = chatGPT.chat("写一段七言绝句诗，题目是：火锅！");
        System.out.println(res);
        BotResponse botResponse = new BotResponse();
        botResponse.setText(res);
        System.out.println(res);
    }

    @Autowired
    private ChatbotWebSocketHandler chatbotWebSocketHandler;

    @Test
    public void testRegisterWebSocketHandlers() throws InterruptedException, ExecutionException, TimeoutException, IOException {
        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        WebSocketClient webSocketClient = new SockJsClient(transports);

        TextWebSocketHandler testHandler = new TextWebSocketHandler() {
            @Override
            protected void handleTextMessage(org.springframework.web.socket.WebSocketSession session, org.springframework.web.socket.TextMessage message) {
                assertEquals("Hello, Chatbot!", message.getPayload());
            }
        };

        org.springframework.web.socket.WebSocketSession session = webSocketClient.doHandshake(testHandler, "ws://localhost:8082/chatbot").get(10, TimeUnit.SECONDS);
        assertNotNull(session);

        session.sendMessage(new org.springframework.web.socket.TextMessage("Hello, Chatbot!"));
        Thread.sleep(1000);
        session.close();
    }
}
