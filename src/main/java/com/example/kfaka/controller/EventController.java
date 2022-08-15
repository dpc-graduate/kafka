package com.example.kfaka.controller;

import com.example.kfaka.event.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:daipengcheng Date:2022/8/15
 */
@RestController
@RequestMapping("test")
public class EventController {
    @Resource
    private ApplicationContext applicationContext;

    @GetMapping
    public void test() throws InterruptedException {
        //
        applicationContext.publishEvent(new MyEvent("你好"));
    }
}
