package com.example.demo.eventlisteners;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class EmailEvent extends ApplicationEvent {
    public EmailEvent(Object source) {
        super(source);
    }
}
