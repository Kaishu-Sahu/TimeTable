package com.iitr.kaishu.timetable;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.icu.util.TimeUnit;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;


public class TimeTable extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.custom_push);
        views.setViewVisibility(R.id.updatedby, View.INVISIBLE);
        views.setTextViewText(R.id.frame4,"");

        String bclass="S1";

        String[] name = {"name", "room", "color", "info", "boss"};
        SQLiteDatabase get = new Databasemain(context).getReadableDatabase();
        Cursor getc = get.query(bclass, name, null, null, null, null, null);
        CursorWraperdata dd = new CursorWraperdata(getc);
        int a = R.id.tutton11;
        try {
            dd.moveToFirst();
            while (!dd.isAfterLast()) {
                String[] data = dd.getdata();
                int id = a;int back=123;int tyuo=99;
                views.setTextViewText(id, data[0]);
                if(data[2].equals("r")){back=R.drawable.red;}
                else if(data[2].equals("g")){back=R.drawable.green;}
                else if(data[2].equals("b")){back=R.drawable.blue;}
                else if(data[2].equals("y")){back=R.drawable.yellow;}
                else if(data[2].equals("drc")){back=R.drawable.redcancel;}
                else if(data[2].equals("dgc")){back=R.drawable.greencancel;}
                else if(data[2].equals("dbc")){back=R.drawable.bluecancel;}
                else if(data[2].equals("dyc")){back=R.drawable.yellowcancel;}
                else if(data[2].equals("dr")){back=R.drawable.dred;}
                else if(data[2].equals("dy")){back=R.drawable.dyellow;}
                else if(data[2].equals("dg")){back=R.drawable.dgreen;}
                else if(data[2].equals("db")){back=R.drawable.dblue;}
                else if(data[2].equals("o")){back=R.drawable.orange;}
                else if(data[2].equals("doc")){back=R.drawable.orangecancel;}
                else if(data[2].equals("do")){back=R.drawable.dorange;}
                else if(data[2].equals("dd")){back=R.drawable.deepblue;}
                else if(data[2].equals("dddc")){back=R.drawable.deepbluecancel;}
                else if(data[2].equals("ddd")){back=R.drawable.ddeepblue;}
                else if(data[2].equals("gg")){back=R.drawable.grey;}
                else if(data[2].equals("dggc")){back=R.drawable.greycancel;}
                else if(data[2].equals("dgg")){back=R.drawable.dgrey;}

               views.setInt(id,"setBackgroundResource",back);

               views.setTextColor(id, Color.BLACK);

                a = a + 1;
                dd.moveToNext();
            }
        } finally {
            dd.close();
        }

        views.setTextViewText(R.id.batch, "TimeTable (Economics)");
        views.setInt(R.id.batch,"setBackgroundResource",R.drawable.widgettextbatch);
        views.setTextColor(R.id.batch, Color.BLACK);
        hhjhhh (context,views);
        appWidgetManager.updateAppWidget(appWidgetId, views);


    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {

            SharedPreferences pref = context.getSharedPreferences("restart", context.MODE_PRIVATE);
            int a = pref.getInt("restart", 0);
            if(a==0){
            updateAppWidget(context, appWidgetManager, appWidgetId);
                Toast.makeText(context, "Restart Your Phone", Toast.LENGTH_SHORT).show();}
            else {updateAppWidget(context, appWidgetManager, appWidgetId);}



        }
    }

    @Override
    public void onEnabled(Context context) {

        SharedPreferences pref = context.getSharedPreferences("restart", context.MODE_PRIVATE);
        int a = pref.getInt("restart", 0);
        if (a==0){Toast.makeText(context, "Restart Your Phone", Toast.LENGTH_SHORT).show();}
else{
        Intent weeklyupup= new Intent(context ,Weekly_Update.class);
        context.startService(weeklyupup);}
    }

    @Override
    public void onDisabled(Context context) {

    }


    public static void hhjhhh(Context cc,RemoteViews vv) {

        Intent v2131689603= new Intent("2131688603");PendingIntent g2131689603= PendingIntent.getBroadcast(cc, 0, v2131689603, 0);vv.setOnClickPendingIntent(2131689603, g2131689603);
        Intent v2131689604= new Intent("2131688604");PendingIntent g2131689604= PendingIntent.getBroadcast(cc, 0, v2131689604, 0);vv.setOnClickPendingIntent(2131689604, g2131689604);
        Intent v2131689605= new Intent("2131688605");PendingIntent g2131689605= PendingIntent.getBroadcast(cc, 0, v2131689605, 0);vv.setOnClickPendingIntent(2131689605, g2131689605);
        Intent v2131689606= new Intent("2131688606");PendingIntent g2131689606= PendingIntent.getBroadcast(cc, 0, v2131689606, 0);vv.setOnClickPendingIntent(2131689606, g2131689606);
        Intent v2131689607= new Intent("2131688607");PendingIntent g2131689607= PendingIntent.getBroadcast(cc, 0, v2131689607, 0);vv.setOnClickPendingIntent(2131689607, g2131689607);
        Intent v2131689608= new Intent("2131688608");PendingIntent g2131689608= PendingIntent.getBroadcast(cc, 0, v2131689608, 0);vv.setOnClickPendingIntent(2131689608, g2131689608);
        Intent v2131689609= new Intent("2131688609");PendingIntent g2131689609= PendingIntent.getBroadcast(cc, 0, v2131689609, 0);vv.setOnClickPendingIntent(2131689609, g2131689609);
        Intent v2131689610= new Intent("2131688610");PendingIntent g2131689610= PendingIntent.getBroadcast(cc, 0, v2131689610, 0);vv.setOnClickPendingIntent(2131689610, g2131689610);
        Intent v2131689611= new Intent("2131688611");PendingIntent g2131689611= PendingIntent.getBroadcast(cc, 0, v2131689611, 0);vv.setOnClickPendingIntent(2131689611, g2131689611);
        Intent v2131689612= new Intent("2131688612");PendingIntent g2131689612= PendingIntent.getBroadcast(cc, 0, v2131689612, 0);vv.setOnClickPendingIntent(2131689612, g2131689612);
        Intent v2131689613= new Intent("2131688613");PendingIntent g2131689613= PendingIntent.getBroadcast(cc, 0, v2131689613, 0);vv.setOnClickPendingIntent(2131689613, g2131689613);
        Intent v2131689614= new Intent("2131688614");PendingIntent g2131689614= PendingIntent.getBroadcast(cc, 0, v2131689614, 0);vv.setOnClickPendingIntent(2131689614, g2131689614);
        Intent v2131689615= new Intent("2131688615");PendingIntent g2131689615= PendingIntent.getBroadcast(cc, 0, v2131689615, 0);vv.setOnClickPendingIntent(2131689615, g2131689615);
        Intent v2131689616= new Intent("2131688616");PendingIntent g2131689616= PendingIntent.getBroadcast(cc, 0, v2131689616, 0);vv.setOnClickPendingIntent(2131689616, g2131689616);
        Intent v2131689617= new Intent("2131688617");PendingIntent g2131689617= PendingIntent.getBroadcast(cc, 0, v2131689617, 0);vv.setOnClickPendingIntent(2131689617, g2131689617);
        Intent v2131689618= new Intent("2131688618");PendingIntent g2131689618= PendingIntent.getBroadcast(cc, 0, v2131689618, 0);vv.setOnClickPendingIntent(2131689618, g2131689618);
        Intent v2131689619= new Intent("2131688619");PendingIntent g2131689619= PendingIntent.getBroadcast(cc, 0, v2131689619, 0);vv.setOnClickPendingIntent(2131689619, g2131689619);
        Intent v2131689620= new Intent("2131688620");PendingIntent g2131689620= PendingIntent.getBroadcast(cc, 0, v2131689620, 0);vv.setOnClickPendingIntent(2131689620, g2131689620);
        Intent v2131689621= new Intent("2131688621");PendingIntent g2131689621= PendingIntent.getBroadcast(cc, 0, v2131689621, 0);vv.setOnClickPendingIntent(2131689621, g2131689621);
        Intent v2131689622= new Intent("2131688622");PendingIntent g2131689622= PendingIntent.getBroadcast(cc, 0, v2131689622, 0);vv.setOnClickPendingIntent(2131689622, g2131689622);
        Intent v2131689623= new Intent("2131688623");PendingIntent g2131689623= PendingIntent.getBroadcast(cc, 0, v2131689623, 0);vv.setOnClickPendingIntent(2131689623, g2131689623);
        Intent v2131689624= new Intent("2131688624");PendingIntent g2131689624= PendingIntent.getBroadcast(cc, 0, v2131689624, 0);vv.setOnClickPendingIntent(2131689624, g2131689624);
        Intent v2131689625= new Intent("2131688625");PendingIntent g2131689625= PendingIntent.getBroadcast(cc, 0, v2131689625, 0);vv.setOnClickPendingIntent(2131689625, g2131689625);
        Intent v2131689626= new Intent("2131688626");PendingIntent g2131689626= PendingIntent.getBroadcast(cc, 0, v2131689626, 0);vv.setOnClickPendingIntent(2131689626, g2131689626);
        Intent v2131689627= new Intent("2131688627");PendingIntent g2131689627= PendingIntent.getBroadcast(cc, 0, v2131689627, 0);vv.setOnClickPendingIntent(2131689627, g2131689627);
        Intent v2131689628= new Intent("2131688628");PendingIntent g2131689628= PendingIntent.getBroadcast(cc, 0, v2131689628, 0);vv.setOnClickPendingIntent(2131689628, g2131689628);
        Intent v2131689629= new Intent("2131688629");PendingIntent g2131689629= PendingIntent.getBroadcast(cc, 0, v2131689629, 0);vv.setOnClickPendingIntent(2131689629, g2131689629);
        Intent v2131689630= new Intent("2131688630");PendingIntent g2131689630= PendingIntent.getBroadcast(cc, 0, v2131689630, 0);vv.setOnClickPendingIntent(2131689630, g2131689630);
        Intent v2131689631= new Intent("2131688631");PendingIntent g2131689631= PendingIntent.getBroadcast(cc, 0, v2131689631, 0);vv.setOnClickPendingIntent(2131689631, g2131689631);
        Intent v2131689632= new Intent("2131688632");PendingIntent g2131689632= PendingIntent.getBroadcast(cc, 0, v2131689632, 0);vv.setOnClickPendingIntent(2131689632, g2131689632);
        Intent v2131689633= new Intent("2131688633");PendingIntent g2131689633= PendingIntent.getBroadcast(cc, 0, v2131689633, 0);vv.setOnClickPendingIntent(2131689633, g2131689633);
        Intent v2131689634= new Intent("2131688634");PendingIntent g2131689634= PendingIntent.getBroadcast(cc, 0, v2131689634, 0);vv.setOnClickPendingIntent(2131689634, g2131689634);
        Intent v2131689635= new Intent("2131688635");PendingIntent g2131689635= PendingIntent.getBroadcast(cc, 0, v2131689635, 0);vv.setOnClickPendingIntent(2131689635, g2131689635);
        Intent v2131689636= new Intent("2131688636");PendingIntent g2131689636= PendingIntent.getBroadcast(cc, 0, v2131689636, 0);vv.setOnClickPendingIntent(2131689636, g2131689636);
        Intent v2131689637= new Intent("2131688637");PendingIntent g2131689637= PendingIntent.getBroadcast(cc, 0, v2131689637, 0);vv.setOnClickPendingIntent(2131689637, g2131689637);
        Intent v2131689638= new Intent("2131688638");PendingIntent g2131689638= PendingIntent.getBroadcast(cc, 0, v2131689638, 0);vv.setOnClickPendingIntent(2131689638, g2131689638);
        Intent v2131689639= new Intent("2131688639");PendingIntent g2131689639= PendingIntent.getBroadcast(cc, 0, v2131689639, 0);vv.setOnClickPendingIntent(2131689639, g2131689639);
        Intent v2131689640= new Intent("2131688640");PendingIntent g2131689640= PendingIntent.getBroadcast(cc, 0, v2131689640, 0);vv.setOnClickPendingIntent(2131689640, g2131689640);
        Intent v2131689641= new Intent("2131688641");PendingIntent g2131689641= PendingIntent.getBroadcast(cc, 0, v2131689641, 0);vv.setOnClickPendingIntent(2131689641, g2131689641);
        Intent v2131689642= new Intent("2131688642");PendingIntent g2131689642= PendingIntent.getBroadcast(cc, 0, v2131689642, 0);vv.setOnClickPendingIntent(2131689642, g2131689642);
        Intent v2131689643= new Intent("2131688643");PendingIntent g2131689643= PendingIntent.getBroadcast(cc, 0, v2131689643, 0);vv.setOnClickPendingIntent(2131689643, g2131689643);
        Intent v2131689644= new Intent("2131688644");PendingIntent g2131689644= PendingIntent.getBroadcast(cc, 0, v2131689644, 0);vv.setOnClickPendingIntent(2131689644, g2131689644);
        Intent v2131689645= new Intent("2131688645");PendingIntent g2131689645= PendingIntent.getBroadcast(cc, 0, v2131689645, 0);vv.setOnClickPendingIntent(2131689645, g2131689645);
        Intent v2131689646= new Intent("2131688646");PendingIntent g2131689646= PendingIntent.getBroadcast(cc, 0, v2131689646, 0);vv.setOnClickPendingIntent(2131689646, g2131689646);
        Intent v2131689647= new Intent("2131688647");PendingIntent g2131689647= PendingIntent.getBroadcast(cc, 0, v2131689647, 0);vv.setOnClickPendingIntent(2131689647, g2131689647);

        Intent v99 = new Intent("98");PendingIntent g99 = PendingIntent.getBroadcast(cc, 0, v99, 0);vv.setOnClickPendingIntent(R.id.imageButton, g99);


    }

}

