package com.hostelassist.complaints;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {

    @PostConstruct
    public void startServer() {
        Thread serverThread = new Thread(new ComplaintServer());
        serverThread.start();
    }
}
