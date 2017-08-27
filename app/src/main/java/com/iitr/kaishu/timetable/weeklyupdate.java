package com.iitr.kaishu.timetable;

/**
 * Created by Kaishu on 7/24/2017.
 */

public class weeklyupdate {
    public String id;
    public String name;
    public String room;
    public String info;
    public String boss;
    public String color;

    public weeklyupdate() {}

    public weeklyupdate(String id, String name, String room,String color ,String info, String boss ) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.info = info;
        this.boss = boss;
        this.color = color;
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
}
