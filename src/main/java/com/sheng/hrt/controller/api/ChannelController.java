package com.sheng.hrt.controller.api;

import com.sheng.hrt.controller.api.Base.BaseController;
import com.sheng.hrt.po.Channel;
import com.sheng.hrt.until.RtnData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/channel")
public class ChannelController  extends BaseController<Channel,Long> {
    @GetMapping("/get")
    @Override
    public RtnData get(Long id) {
        return super.get(id);
    }
}
