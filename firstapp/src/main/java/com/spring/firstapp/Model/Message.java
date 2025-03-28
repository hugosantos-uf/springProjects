package com.spring.firstapp.Model;

public class Message {

    private String content;
    private User sender;
    private User receiver;

    public Message(String content, User sender, User receiver) {
        this.receiver = receiver;
        this.content = content;
        this.sender = sender;
    }

    public User getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public User getReceiver() {
        return receiver;
    }
}
