package com.sheng.hrt.controller.api;

import com.sheng.hrt.controller.api.Base.BaseController;
import com.sheng.hrt.po.ChannelLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/channelLog")
public class ChannelLogController extends BaseController<ChannelLog,Long> {
}
