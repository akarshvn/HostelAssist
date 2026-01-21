package com.hostelassist.mess_feedback.socket;

import com.hostelassist.mess_feedback.model.FeedbackType;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.net.Socket;

@Component
public class FeedbackSocketClient {

    public void sendFeedback(FeedbackType feedback) {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            writer.println(feedback.name());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
