package com.sheng.hrt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sheng.hrt")
//@MapperScan("com.sheng.hrt.dao")
public class HrtApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrtApplication.class, args);
    }

}
