package com.hostelassist.resources;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeerRegistryService {

    private final List<PeerInfo> peers = new ArrayList<>();

    public PeerRegistryService() {
        // Static peer list (temporarily)
        peers.add(new PeerInfo("peer-A", "localhost", 9000));
        peers.add(new PeerInfo("peer-B", "localhost", 9001));
    }

    public List<PeerInfo> getAllPeers() {
        return peers;
    }
}
