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
        roomData.put(103, new roomInfo(
                103,
                Arrays.asList("Vijay", "Rahul"),
                "Warden: Mr. Suresh - 9001122334"
        ));

        roomData.put(104, new roomInfo(
                104,
                Arrays.asList("Anand", "Prakash"),
                "Warden: Mr. Mohan - 9011223344"
        ));

        roomData.put(105, new roomInfo(
                105,
                Arrays.asList("Deepak", "Nithin"),
                "Warden: Mr. Ramesh - 9022334455"
        ));

        roomData.put(106, new roomInfo(
                106,
                Arrays.asList("Kiran", "Santhosh"),
                "Warden: Mr. Balaji - 9033445566"
        ));

        roomData.put(107, new roomInfo(
                107,
                Arrays.asList("Ajay", "Harish"),
                "Warden: Mr. Sekar - 9044556677"
        ));

        roomData.put(108, new roomInfo(
                108,
                Arrays.asList("Sathish", "Lokesh"),
                "Warden: Mr. Vinod - 9055667788"
        ));

        roomData.put(109, new roomInfo(
                109,
                Arrays.asList("Mani", "Surya"),
                "Warden: Mr. Rajan - 9066778899"
        ));

        roomData.put(110, new roomInfo(
                110,
                Arrays.asList("Gokul", "Aravind"),
                "Warden: Mr. Prakash - 9077889900"
        ));

    }

    @Override
    public roomInfo getRoomDetails(int roomNo) {

        if (!roomData.containsKey(roomNo)) {
            return new roomInfo(
                    roomNo,
                    Arrays.asList("Room not found"),
                    "Please enter a valid room number"
            );
        }

        return roomData.get(roomNo);
    }


    @Override
    public String getWardenContact(int roomNo) {
        roomInfo info = roomData.get(roomNo);
        return (info != null)
                ? info.getWardenContact()
                : "Room not found. Please enter a valid room number.";
    }

}
