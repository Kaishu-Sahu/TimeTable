package com.iitr.kaishu.timetable;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by Kaishu on 6/4/2017.
 */

public class CursorWraperdata extends CursorWrapper {
        public CursorWraperdata(Cursor cursor) {
            super(cursor);
        }

        public String[]  getdata(){
            String name = getString(getColumnIndex("name"));
            String room = getString(getColumnIndex("room"));
            String color = getString(getColumnIndex("color"));
            String info = getString(getColumnIndex("info"));
            String boss = getString(getColumnIndex("boss"));
        String[] data={name,room,color,info,boss};
        return data;
        }



}
