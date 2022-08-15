package com.example.kfaka.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author:daipengcheng Date:2022/8/15
 */
public class MyEvent extends ApplicationEvent {

    public MyEvent(Object event) {
        super(event);
    }
}
