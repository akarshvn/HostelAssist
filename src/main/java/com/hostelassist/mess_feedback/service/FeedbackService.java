package com.hostelassist.mess_feedback.service;

import com.hostelassist.mess_feedback.model.FeedbackSummary;
import com.hostelassist.mess_feedback.model.FeedbackType;
import com.hostelassist.mess_feedback.socket.FeedbackSocketClient;
import com.hostelassist.mess_feedback.socket.FeedbackSocketServer;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackSocketClient client;
    private final FeedbackSocketServer server;

    public FeedbackService(FeedbackSocketClient client,
                           FeedbackSocketServer server) {
        this.client = client;
        this.server = server;
    }

    public void submitFeedback(FeedbackType feedback) {
        client.sendFeedback(feedback);
    }

    public FeedbackSummary getSummary() {
        return new FeedbackSummary(
                server.getGood(),
                server.getAverage(),
                server.getPoor()
        );
    }
}
