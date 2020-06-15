package com.sheng.hrt.controller;

import com.sheng.hrt.controller.Base.BaseController;
import com.sheng.hrt.po.DailyStatistic;
import com.sheng.hrt.po.TestPlan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/TestPlan")
public class TestPlanController extends BaseController<TestPlan,Long> {
}
