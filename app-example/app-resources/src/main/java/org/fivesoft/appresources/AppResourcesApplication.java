package org.fivesoft.appresources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.fivesoft"})
public class AppResourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppResourcesApplication.class, args);
    }

}
