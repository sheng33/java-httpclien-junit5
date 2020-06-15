package com.sheng.hrt.controller;

import com.sheng.hrt.controller.Base.BaseController;
import com.sheng.hrt.po.Application;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application")
public class ApplicationController extends BaseController<Application,Long> {

}
