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
    public void startPeerNode() {
        PeerNode peerNode = new PeerNode(
                "peer-1",
                "localhost",
                9000
        );
        peerNode.start();
    }
}
