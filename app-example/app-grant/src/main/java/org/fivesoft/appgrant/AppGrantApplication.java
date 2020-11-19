package org.fivesoft.appgrant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.fivesoft")
public class AppGrantApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppGrantApplication.class, args);
    }

}
