package com.hostelassist.roominfo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RoomInfoClient {

    public static void main(String[] args) {

        try {
            // Connect to RMI Registry running on localhost at port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup the remote service
            RoominfoService service =
                    (RoominfoService) registry.lookup("RoomService");

            // Call remote method
            roomInfo info = service.getRoomDetails(102);

            // Display output
            if (info != null) {
                System.out.println("Room Number      : " + info.getRoomNo());
                System.out.println("Occupants        : " + info.getOccupants());
                System.out.println("Warden Contact   : " + info.getWardenContact());
            } else {
                System.out.println("Room not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

