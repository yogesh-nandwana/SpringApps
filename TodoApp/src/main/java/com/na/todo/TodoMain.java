package com.na.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoMain implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TodoMain.class, args);
	}

  @Override
  public void run(String... arg0) throws Exception {
    System.out.println("This method gets called just after application context laoding, any initialzation can be done here.");
  }
  
}