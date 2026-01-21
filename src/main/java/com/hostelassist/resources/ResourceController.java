package com.hostelassist.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final FileTransferService fileTransferService;
    private final PeerRegistryService peerRegistryService;

    public ResourceController(FileTransferService fileTransferService,
                              PeerRegistryService peerRegistryService) {
        this.fileTransferService = fileTransferService;
        this.peerRegistryService = peerRegistryService;
    }

    /**
     * POST /api/resources/download
     * Trigger file download from another peer
     */
    @PostMapping("/download")
    public ResponseEntity<String> downloadFile(@RequestBody DownloadRequest request) {

        PeerNode remotePeer = new PeerNode(
                request.getPeerId(),
                request.getHost(),
                request.getPort()
        );

        fileTransferService.receiveFile(remotePeer, request.getFileName());

        return ResponseEntity.ok("File download triggered");
    }

    @GetMapping("/peers")
    public List<PeerInfo> getPeers() {
        return peerRegistryService.getAllPeers();
    }

}
