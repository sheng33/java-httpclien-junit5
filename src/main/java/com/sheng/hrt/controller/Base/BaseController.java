package com.sheng.hrt.controller.Base;

import com.sheng.hrt.service.IService;
import com.sheng.hrt.until.RtnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

public class BaseController<T, K> extends AbstractController<T, K> {

    @Autowired
    private IService<T, K> service;

    @PostMapping("/insert")
    @Override
    public RtnData insert(@RequestBody T t) {
        return RtnData.ok(service.insert(t));
    }

    @PostMapping("/update")
    @Override
    public RtnData update(@RequestBody T t) {
        return RtnData.ok(service.update(t));
    }

    @GetMapping("/delete")
    @Override
    public RtnData delete(K id) {
        return RtnData.ok(service.delete(id));
    }

    @GetMapping("/get")
    @Override
    public RtnData get(K id) {
        return RtnData.ok(service.get(id));
    }

    @GetMapping("/page-list")
    @Override
    public RtnData queryPageList(@RequestParam(required = false, defaultValue = "20") int pageSize,
                                 @RequestParam(required = false, defaultValue = "1") int pageIndex,
                                 @RequestParam Map<String,Object> params) {
        return RtnData.ok(service.queryPageList(pageSize, pageIndex, params));
    }

    @GetMapping("/list")
    @Override
    public RtnData queryList(@RequestParam Map<String, Object> params) {
        return RtnData.ok(service.queryList(params));
    }
}