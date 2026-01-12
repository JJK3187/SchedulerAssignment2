package com.schedule2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Schedule2Application {

    public static void main(String[] args) {
        SpringApplication.run(Schedule2Application.class, args);
    }

}
