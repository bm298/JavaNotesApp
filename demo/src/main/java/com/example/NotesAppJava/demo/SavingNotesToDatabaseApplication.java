package com.example.NotesAppJava.demo;

import com.example.NotesAppJava.demo.Service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SavingNotesToDatabaseApplication implements CommandLineRunner {

	@Autowired
	private ToDoListService toDoListService;

	public static void main(String[] args) {
		SpringApplication.run(SavingNotesToDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		toDoListService.inputParser();
	}
}
