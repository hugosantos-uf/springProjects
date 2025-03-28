package com.spring.firstapp;

import com.spring.firstapp.Controller.ChatController;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstappApplication implements CommandLineRunner {

	@Autowired
	private ChatController chatController;

	public static void main(String[] args) {
		SpringApplication.run(FirstappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		chatController.startChat();
	}
}
