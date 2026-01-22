package com.hostelassist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hostelassist.resources.PeerNode;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class HostelAssistApplication {

    public static void main(String[] args) {
        SpringApplication.run(HostelAssistApplication.class, args);
    }
    @PostConstruct
    public void startPeerNode() {src/main/java/com/hostelassist/HostelAssistApplication.java
        PeerNode peerNode = new PeerNode(
                "username",
                "192.168.0.1",
                9002
        );
        peerNode.start();
    }
}
