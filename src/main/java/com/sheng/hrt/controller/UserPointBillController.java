package com.sheng.hrt.controller;

import com.sheng.hrt.controller.Base.BaseController;
import com.sheng.hrt.po.UserPointBill;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/UserPointBill")
public class UserPointBillController extends BaseController<UserPointBill,Long> {
}
