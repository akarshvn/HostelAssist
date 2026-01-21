package com.hostelassist.roominfo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RoomInfoRegistry {

    public static void start() {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            RoominfoService service = new RoominfoServiceImpl();
            registry.rebind("RoomService", service);

            System.out.println("RoomInfo RMI Server started...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
