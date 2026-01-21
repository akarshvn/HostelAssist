package com.hostelassist.roominfo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class RoomInfoServiceRunner {

    @PostConstruct
    public void init() {
        RoomInfoRegistry.start();
    }
}
