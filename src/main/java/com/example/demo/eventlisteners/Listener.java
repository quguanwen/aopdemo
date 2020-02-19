package com.example.demo.eventlisteners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener {

    @EventListener
    public void Emailistener(EmailEvent event) {
        log.info(String.format("%s监听到事件源：%s.", Listener.class.getName(), event.getSource()));
    }

    @EventListener
    public void Smessagelistener(SmessageEvent event) {
        log.info(String.format("%s监听到事件源：%s.", Listener.class.getName(), event.getSource()));
    }

}