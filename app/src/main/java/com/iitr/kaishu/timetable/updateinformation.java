package com.iitr.kaishu.timetable;

/**
 * Created by Kaishu on 6/7/2017.
 */

public class updateinformation {
    public String id;
    public String name;
    public String room;
    public String info;
    public String boss;
    public String color;
    public String batch;
    public String request_id;



public updateinformation(){}
    public updateinformation(String id, String name, String room,String color ,  String info,String boss,String batch,String request_id) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.info = info;
        this.boss = boss;
        this.color = color;
        this.batch=batch;
        this.request_id=request_id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public String getInfo() {
        return info;
    }

    public String getBoss() {
        return boss;
    }
    public String getColor() {
        return color;
    }

    public String getBatch() {
        return batch;
    }

    public String getRequest_id() {return request_id;}
}
