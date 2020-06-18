package com.sheng.hrt.controller.api;

import com.sheng.hrt.controller.api.Base.BaseController;
import com.sheng.hrt.po.Point;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Point")
public class PointController extends BaseController<Point,Long> {
}
