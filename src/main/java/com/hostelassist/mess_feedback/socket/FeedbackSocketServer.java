package com.hostelassist.mess_feedback.socket;

import com.hostelassist.mess_feedback.model.FeedbackType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.*;
import java.util.concurrent.Semaphore;

@Component
public class FeedbackSocketServer {

    private int good = 0;
    private int average = 0;
    private int poor = 0;

    private final Semaphore sem = new Semaphore(1);

    @PostConstruct
    public void startServer() {
        new Thread(this::runServer).start();
    }

    private void runServer() {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Feedback Socket Server started on port 5000");

            while (true) {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler extends Thread {
        private final Socket student;

        ClientHandler(Socket socket) {
            this.student = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in =
                         new BufferedReader(new InputStreamReader(student.getInputStream()))) {

                FeedbackType feedback = FeedbackType.valueOf(in.readLine().toUpperCase());

                sem.acquire();
                try {
                    switch (feedback) {
                        case GOOD -> good++;
                        case AVERAGE -> average++;
                        case POOR -> poor++;
                    }
                } finally {
                    sem.release();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getGood() { return good; }
    public int getAverage() { return average; }
    public int getPoor() { return poor; }
}
