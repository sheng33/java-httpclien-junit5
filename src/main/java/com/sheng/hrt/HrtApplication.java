package com.sheng.hrt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class HrtApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrtApplication.class, args);
    }

}
