package com.example.kfaka.listener;

import com.example.kfaka.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author:daipengcheng Date:2022/8/15
 */
@Component
public class MyListenerEvent implements ApplicationListener<MyEvent> {
    @Override
    @Async
    public void onApplicationEvent(MyEvent event) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(event.getSource());
        System.out.println("检测到事件");
    }
}
