package com.iitr.kaishu.timetable;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kaishu on 5/15/2017.
 */

public class Databasemain extends SQLiteOpenHelper {
public Databasemain(Context context){

    super(context,"Main",null,1);
}

    @Override
    public void onCreate(SQLiteDatabase db){
        String ppp = "CREATE TABLE S1 (id integer PRIMARY KEY, name, room , color , info, boss);";
        String[] array= {
                "Insert into S1 Values ('2131689603','-','-','dr','-','');",
                "Insert into S1 Values ('2131689604','-','-','dg','-','');",
                "Insert into S1 Values ('2131689605','-','-','dr','-','');",
                "Insert into S1 Values ('2131689606','-','-','dg','-','');",
                "Insert into S1 Values ('2131689607','-','-','dr','-','');",
                "Insert into S1 Values ('2131689608','-','-','dg','-','');",
                "Insert into S1 Values ('2131689609','-','-','dr','-','');",
                "Insert into S1 Values ('2131689610','-','-','dg','-','');",
                "Insert into S1 Values ('2131689611','-','-','dr','-','');",
                "Insert into S1 Values ('2131689612','-','-','dg','-','');",
                "Insert into S1 Values ('2131689613','-','-','dr','-','');",
                "Insert into S1 Values ('2131689614','-','-','dg','-','');",
                "Insert into S1 Values ('2131689615','-','-','dr','-','');",
                "Insert into S1 Values ('2131689616','-','-','dg','-','');",
                "Insert into S1 Values ('2131689617','-','-','dr','-','');",
                "Insert into S1 Values ('2131689618','-','-','dg','-','');",
                "Insert into S1 Values ('2131689619','-','-','dr','-','');",
                "Insert into S1 Values ('2131689620','-','-','dg','-','');",
                "Insert into S1 Values ('2131689621','-','-','dr','-','');",
                "Insert into S1 Values ('2131689622','-','-','dg','-','');",
                "Insert into S1 Values ('2131689623','-','-','dr','-','');",
                "Insert into S1 Values ('2131689624','-','-','dg','-','');",
                "Insert into S1 Values ('2131689625','-','-','dr','-','');",
                "Insert into S1 Values ('2131689626','-','-','dg','-','');",
                "Insert into S1 Values ('2131689627','-','-','dr','-','');",
                "Insert into S1 Values ('2131689628','-','-','dg','-','');",
                "Insert into S1 Values ('2131689629','-','-','dr','-','');",
                "Insert into S1 Values ('2131689630','-','-','dg','-','');",
                "Insert into S1 Values ('2131689631','-','-','dr','-','');",
                "Insert into S1 Values ('2131689632','-','-','dg','-','');",
                "Insert into S1 Values ('2131689633','-','-','dr','-','');",
                "Insert into S1 Values ('2131689634','-','-','dg','-','');",
                "Insert into S1 Values ('2131689635','-','-','dr','-','');",
                "Insert into S1 Values ('2131689636','-','-','dg','-','');",
                "Insert into S1 Values ('2131689637','-','-','dr','-','');",
                "Insert into S1 Values ('2131689638','-','-','dg','-','');",
                "Insert into S1 Values ('2131689639','-','-','dr','-','');",
                "Insert into S1 Values ('2131689640','-','-','dg','-','');",
                "Insert into S1 Values ('2131689641','-','-','dr','-','');",
                "Insert into S1 Values ('2131689642','-','-','dg','-','');",
                "Insert into S1 Values ('2131689643','-','-','dr','-','');",
                "Insert into S1 Values ('2131689644','-','-','dg','-','');",
                "Insert into S1 Values ('2131689645','-','-','dr','-','');",
                "Insert into S1 Values ('2131689646','-','-','dg','-','');",
                "Insert into S1 Values ('2131689647','-','-','dr','-','');"

        };
        db.execSQL(ppp);

        for (String yu:array){
            db.execSQL(yu);
        }



        String ppp2 = "CREATE TABLE S2 (id integer PRIMARY KEY, name, room , color , info, boss);";
        String[] array2= {
                "Insert into S2 Values ('2131689603','-','-','dr','-','');",
                "Insert into S2 Values ('2131689604','-','-','dg','-','');",
                "Insert into S2 Values ('2131689605','-','-','dr','-','');",
                "Insert into S2 Values ('2131689606','-','-','dg','-','');",
                "Insert into S2 Values ('2131689607','-','-','dr','-','');",
                "Insert into S2 Values ('2131689608','-','-','dg','-','');",
                "Insert into S2 Values ('2131689609','-','-','dr','-','');",
                "Insert into S2 Values ('2131689610','-','-','dg','-','');",
                "Insert into S2 Values ('2131689611','-','-','dr','-','');",
                "Insert into S2 Values ('2131689612','-','-','dg','-','');",
                "Insert into S2 Values ('2131689613','-','-','dr','-','');",
                "Insert into S2 Values ('2131689614','-','-','dg','-','');",
                "Insert into S2 Values ('2131689615','-','-','dr','-','');",
                "Insert into S2 Values ('2131689616','-','-','dg','-','');",
                "Insert into S2 Values ('2131689617','-','-','dr','-','');",
                "Insert into S2 Values ('2131689618','-','-','dg','-','');",
                "Insert into S2 Values ('2131689619','-','-','dr','-','');",
                "Insert into S2 Values ('2131689620','-','-','dg','-','');",
                "Insert into S2 Values ('2131689621','-','-','dr','-','');",
                "Insert into S2 Values ('2131689622','-','-','dg','-','');",
                "Insert into S2 Values ('2131689623','-','-','dr','-','');",
                "Insert into S2 Values ('2131689624','-','-','dg','-','');",
                "Insert into S2 Values ('2131689625','-','-','dr','-','');",
                "Insert into S2 Values ('2131689626','-','-','dg','-','');",
                "Insert into S2 Values ('2131689627','-','-','dr','-','');",
                "Insert into S2 Values ('2131689628','-','-','dg','-','');",
                "Insert into S2 Values ('2131689629','-','-','dr','-','');",
                "Insert into S2 Values ('2131689630','-','-','dg','-','');",
                "Insert into S2 Values ('2131689631','-','-','dr','-','');",
                "Insert into S2 Values ('2131689632','-','-','dg','-','');",
                "Insert into S2 Values ('2131689633','-','-','dr','-','');",
                "Insert into S2 Values ('2131689634','-','-','dg','-','');",
                "Insert into S2 Values ('2131689635','-','-','dr','-','');",
                "Insert into S2 Values ('2131689636','-','-','dg','-','');",
                "Insert into S2 Values ('2131689637','-','-','dr','-','');",
                "Insert into S2 Values ('2131689638','-','-','dg','-','');",
                "Insert into S2 Values ('2131689639','-','-','dr','-','');",
                "Insert into S2 Values ('2131689640','-','-','dg','-','');",
                "Insert into S2 Values ('2131689641','-','-','dr','-','');",
                "Insert into S2 Values ('2131689642','-','-','dg','-','');",
                "Insert into S2 Values ('2131689643','-','-','dr','-','');",
                "Insert into S2 Values ('2131689644','-','-','dg','-','');",
                "Insert into S2 Values ('2131689645','-','-','dr','-','');",
                "Insert into S2 Values ('2131689646','-','-','dg','-','');",
                "Insert into S2 Values ('2131689647','-','-','dr','-','');"

        };
        db.execSQL(ppp2);

        for (String yu:array2){
            db.execSQL(yu);
        }


    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldversion ,int newversion){

    }


}
