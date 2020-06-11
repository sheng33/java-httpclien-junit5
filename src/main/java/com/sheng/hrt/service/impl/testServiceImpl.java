package com.sheng.hrt.service.impl;

import com.sheng.hrt.dao.TestDao;
import com.sheng.hrt.service.testService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class testServiceImpl implements testService {
    @Autowired
    TestDao dao;
    @Override
    public void print() {
        log.info("读取测试");
        log.error("error");
        log.debug("debug");
        dao.getTest().forEach(System.out::printf);
    }
}
