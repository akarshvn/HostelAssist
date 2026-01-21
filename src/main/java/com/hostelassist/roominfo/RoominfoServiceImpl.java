package com.hostelassist.roominfo;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

public class RoominfoServiceImpl extends UnicastRemoteObject
        implements RoominfoService {

    private Map<Integer, roomInfo> roomData = new HashMap<>();

    protected RoominfoServiceImpl() throws RemoteException {
        super();

        // In-memory data (NO DB)
        roomData.put(101, new roomInfo(
                101,
                Arrays.asList("Arun", "Karthik"),
                "Warden: Mr. Ravi - 9876543210"
        ));

        roomData.put(102, new roomInfo(
                102,
                Arrays.asList("Suresh", "Manoj"),
                "Warden: Mr. Kumar - 9123456780"
        ));
    }

    @Override
    public roomInfo getRoomDetails(int roomNo) {
        return roomData.get(roomNo);
    }

    @Override
    public String getWardenContact(int roomNo) {
        roomInfo info = roomData.get(roomNo);
        return (info != null) ? info.getWardenContact() : "Room not found";
    }
}
