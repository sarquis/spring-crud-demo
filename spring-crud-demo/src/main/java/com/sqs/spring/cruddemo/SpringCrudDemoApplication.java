package com.sqs.spring.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCrudDemoApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringCrudDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(String[] args) {
	return runner -> {
	    System.out.println("Hello World");
	};
    }
}
