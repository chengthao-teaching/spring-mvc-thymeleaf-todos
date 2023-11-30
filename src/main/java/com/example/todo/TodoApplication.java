package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Autowired
    private TodoService service;
    
    @Override
    public void run(String... args) throws Exception {
        service.add(new Todo("feed the cat", false));
        service.add(new Todo("wash the dishes", true));
    }

}
