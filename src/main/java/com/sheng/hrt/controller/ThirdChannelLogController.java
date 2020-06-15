package com.sheng.hrt.controller;

import com.sheng.hrt.controller.Base.BaseController;
import com.sheng.hrt.po.ThirdChannelLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ThirdChannelLog")
public class ThirdChannelLogController extends BaseController<ThirdChannelLog,Long> {
}
