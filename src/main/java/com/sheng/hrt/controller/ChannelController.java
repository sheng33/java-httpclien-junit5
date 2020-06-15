package com.sheng.hrt.controller;

import com.sheng.hrt.controller.Base.BaseController;
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
        System.out.printf("1");
        System.out.printf("id:"+id);
        return super.get(id);
    }
}
