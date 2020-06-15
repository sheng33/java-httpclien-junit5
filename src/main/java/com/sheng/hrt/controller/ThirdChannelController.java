package com.sheng.hrt.controller;

import com.sheng.hrt.controller.Base.BaseController;
import com.sheng.hrt.po.DailyStatistic;
import com.sheng.hrt.po.ThirdChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ThirdChannel")
public class ThirdChannelController extends BaseController<ThirdChannel,Long> {
}
