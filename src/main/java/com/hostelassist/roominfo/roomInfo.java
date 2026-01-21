package com.hostelassist.roominfo;
import java.io.Serializable;
import java.util.List;

public class roomInfo implements Serializable {

    private int roomNo;
    private List<String> occupants;
    private String wardenContact;

    public roomInfo(int roomNo, List<String> occupants, String wardenContact) {
        this.roomNo = roomNo;
        this.occupants = occupants;
        this.wardenContact = wardenContact;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public List<String> getOccupants() {
        return occupants;
    }

    public String getWardenContact() {
        return wardenContact;
    }
}
