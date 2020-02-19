package com.example.demo.eventlisteners;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class SmessageEvent extends ApplicationEvent {
    public SmessageEvent(Object source) {
        super(source);
    }
}