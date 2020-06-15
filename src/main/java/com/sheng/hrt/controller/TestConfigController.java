package com.sheng.hrt.controller;

import com.sheng.hrt.controller.Base.BaseController;
import com.sheng.hrt.po.DailyStatistic;
import com.sheng.hrt.po.TestConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/TestConfig")
public class TestConfigController extends BaseController<TestConfig,Long> {
}
