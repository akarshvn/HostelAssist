package com.hostelassist.complaints;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComplaintServer implements Runnable {

    private static final int PORT = 6000;

    public static List<Complaint> getComplaints() {
        return complaints;
    }

    // 🔹 STORAGE (ARRAY)
    private static  final List<Complaint> complaints = new ArrayList<>();
    private static int idCounter = 1;

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("🏠 Hostel Complaint Server Running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }

    // 🔹 CLIENT HANDLER
    class ClientHandler extends Thread {

        private Socket clientSocket;

        ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer =
                        new PrintWriter(clientSocket.getOutputStream(), true);

                StringBuilder data = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null && !line.isEmpty()) {
                    data.append(line).append("\n");
                }

                // 🔹 PARSE DATA
                String[] parts = data.toString().split("\n");

                String name = parts[1].split(": ")[1];
                String room = parts[2].split(": ")[1];
                String type = parts[3].split(": ")[1];
                String desc = parts[4].split(": ")[1];

                // 🔹 CREATE OBJECT
                Complaint complaint = new Complaint(
                        idCounter++,
                        name,
                        room,
                        type,
                        desc
                );

                // 🔹 STORE IN ARRAY
                complaints.add(complaint);

                // 🔹 SEND ACK
                int ackNumber = 10000 + new Random().nextInt(90000);

                writer.println("Your problem has been noted successfully.");
                writer.println("Acknowledgement Number: " + ackNumber);
                writer.println("Hostel administration will take action soon.");

                clientSocket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
