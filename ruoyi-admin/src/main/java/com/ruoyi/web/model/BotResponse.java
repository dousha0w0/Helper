package com.ruoyi.web.model;

public class BotResponse {
    private String text;
    private String conversationId;
    private String[] choices;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }
}
