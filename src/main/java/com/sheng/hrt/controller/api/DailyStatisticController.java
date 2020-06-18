package com.sheng.hrt.controller.api;

import com.sheng.hrt.controller.api.Base.BaseController;
import com.sheng.hrt.po.DailyStatistic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/DailyStatistic")
public class DailyStatisticController extends BaseController<DailyStatistic,Long> {

}
