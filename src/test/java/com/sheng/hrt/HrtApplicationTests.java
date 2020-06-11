package com.sheng.hrt;

import com.sheng.hrt.service.testService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HrtApplicationTests {

    @Autowired
    testService testService;

    @Test
    void test(){
        testService.print();
    }

}
