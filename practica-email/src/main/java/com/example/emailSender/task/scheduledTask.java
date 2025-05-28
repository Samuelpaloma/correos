package com.example.emailSender.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.emailSender.services.emailService;

@Component
public class scheduledTask {
    @Autowired

    private emailService email;

    @Scheduled(cron = "* * * * * *")
    public void taskMinute() {
        email.newAccountEmail("usuario@correo.com");
        System.out.println("Tomarse la pasta");
    }
}
