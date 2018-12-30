package com.nju.scrum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ScrumProjServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrumProjServerApplication.class, args);
    }

}

