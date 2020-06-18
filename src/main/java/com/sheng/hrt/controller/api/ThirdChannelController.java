package com.sheng.hrt.controller.api;

import com.sheng.hrt.controller.api.Base.BaseController;
import com.sheng.hrt.po.ThirdChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ThirdChannel")
public class ThirdChannelController extends BaseController<ThirdChannel,Long> {
}
