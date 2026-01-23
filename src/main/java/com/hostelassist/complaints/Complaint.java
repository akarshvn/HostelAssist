package com.hostelassist.complaints;

public class Complaint {

    public Integer id;
    public String name;
    public String room;
    public String type;
    public String description;

    // REQUIRED for JSON -> Object
    public Complaint(Integer id, String name, String room, String type, String description) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.type = type;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
}
