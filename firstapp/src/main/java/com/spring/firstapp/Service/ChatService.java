package com.spring.firstapp.Service;

import com.spring.firstapp.Model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private List<Message> messageHistory = new ArrayList<>();

    public void sendMessage(Message message){
        messageHistory.add(message);
        System.out.println(message.getSender().getName() + " to "
                + message.getReceiver().getName() + ": " +
                message.getContent());
    }

    public void displayChatHistory(){
        System.out.println("Chat history: ");
        for (Message message: messageHistory){
            System.out.println(message.getSender().getName() + "to "
                    + message.getReceiver().getName() + ": " +
                    message.getContent());
        }
    }
}
