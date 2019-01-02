package com.nju.scrum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
@MapperScan(value = "com.nju.scrum.dao")
public class ScrumProjServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrumProjServerApplication.class, args);
    }

}

