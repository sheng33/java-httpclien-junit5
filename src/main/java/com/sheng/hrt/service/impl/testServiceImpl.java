package com.sheng.hrt.service.impl;

import com.sheng.hrt.dao.TestDao;
import com.sheng.hrt.service.testService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class testServiceImpl implements testService {
    @Resource
    TestDao dao;
    @Override
    public void print() {
        dao.getTest().forEach(point -> {
            System.out.printf(point.toString());
        });
    }
}
