package com.spring.firstapp.Controller;

import com.spring.firstapp.Model.Message;
import com.spring.firstapp.Model.User;
import com.spring.firstapp.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    public void startChat(){
       Scanner scanner = new Scanner(System.in);

       User user1 = new User("Alice");
       User user2 = new User("Bob");

       while (true){
           System.out.println("Who is sending the message? (Alice/Bob): ");
           String senderName = scanner.nextLine();

           System.out.println("Enter your message");
           String content = scanner.nextLine();

           User sender = senderName.equalsIgnoreCase("Alice") ? user1:user2;
           User receiver = senderName.equalsIgnoreCase("Bob") ? user1:user2;

           Message message = new Message(content, sender, receiver);

           chatService.sendMessage(message);

           System.out.println("Type 'history' to view chat history, 'continue' to send next message or 'exit' to end the chat.");
           String command = scanner.nextLine();

           if (command.equalsIgnoreCase("history")) {
               chatService.displayChatHistory();
           }
           else if (command.equalsIgnoreCase("exit")) {
               break;
           }
           else if(!command.equalsIgnoreCase("continue")){
               System.out.println("Invalid command... continuing");
           }

       }
    }
}
