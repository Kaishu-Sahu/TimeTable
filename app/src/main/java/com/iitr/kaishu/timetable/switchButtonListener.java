
package com.iitr.kaishu.timetable;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;

public class switchButtonListener extends BroadcastReceiver {
Notification notif;
    int widgetintent;
    RemoteViews contentViews = new RemoteViews("com.iitr.kaishu.timetable", R.layout.custom_push);
    @Override
    public void onReceive(Context context, Intent intent) {

        try{
 widgetintent = Integer.parseInt(intent.getAction());}
        catch(Exception e){widgetintent = 10;}

if(intent.getAction().equals(Intent.ACTION_SHUTDOWN)){
    SharedPreferences.Editor editcoer = context.getSharedPreferences("restart", context.MODE_PRIVATE).edit();
    editcoer.putInt("restart", 1);
    editcoer.apply();}


        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            SharedPreferences.Editor editcor = context.getSharedPreferences("restart", context.MODE_PRIVATE).edit();
            editcor.putInt("restart", 1);
            editcor.apply();
            SharedPreferences pref = context.getSharedPreferences("batch", context.MODE_PRIVATE);
            int agg = pref.getInt("batch", 0);
            Intent updateser= new Intent (context,Weekly_Update.class);
            context.startService(updateser);

            if(agg==1){Intent hui= new Intent(context,S1.class);context.startService(hui);}
            if(agg==2){Intent hui= new Intent(context,S2.class);context.startService(hui);}

        }


else if (widgetintent == 98){   AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            RemoteViews remote = new RemoteViews(context.getPackageName(), R.layout.custom_push);
            ComponentName thisWidget = new ComponentName(context, TimeTable.class);
            remote.setViewVisibility(R.id.frame, View.INVISIBLE);
            appWidgetManager.updateAppWidget(thisWidget, remote);

        }
        else if (widgetintent == 97){   AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            RemoteViews remote = new RemoteViews(context.getPackageName(), R.layout.custom_push);
            ComponentName thisWidget = new ComponentName(context, TimeTableS2.class);
            remote.setViewVisibility(R.id.frame, View.INVISIBLE);
            appWidgetManager.updateAppWidget(thisWidget, remote);

        }


else if(widgetintent >2131688602 && widgetintent<2131688648){
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            RemoteViews remote = new RemoteViews(context.getPackageName(), R.layout.custom_push);
            remote.setViewVisibility(R.id.updatedby, View.INVISIBLE);
            remote.setTextViewText(R.id.frame4,"");
            ComponentName thisWidget = new ComponentName(context, TimeTable.class);
            int widgetid=widgetintent + 1000;
            String[] asd={Integer.toString(widgetid)};
            String [] name={"name","room","color","info","boss"};
            remote.setViewVisibility(R.id.frame, View.VISIBLE);


            SQLiteDatabase fdb= new Databasemain(context).getReadableDatabase();
            Cursor getcd= fdb.query("S1",name,"id=?",asd,null,null,null);
            CursorWraperdata dd= new CursorWraperdata(getcd);
            dd.moveToFirst();int tyuo=99;
            String[] datadb = dd.getdata();
            if(datadb[2].equals("r")){tyuo=R.drawable.dred;}
            else if(datadb[2].equals("g")){tyuo=R.drawable.dgreen;}
            else if(datadb[2].equals("b")){tyuo=R.drawable.dblue;}
            else if(datadb[2].equals("y")){tyuo=R.drawable.dyellow;}
            else if(datadb[2].equals("drc")){tyuo=R.drawable.dred;}
            else if(datadb[2].equals("dgc")){tyuo=R.drawable.dgreen;}
            else if(datadb[2].equals("dbc")){tyuo=R.drawable.dblue;}
            else if(datadb[2].equals("dyc")){tyuo=R.drawable.dyellow;}
            else if(datadb[2].equals("dr")){tyuo=R.drawable.dred;}
            else if(datadb[2].equals("dy")){tyuo=R.drawable.dyellow;}
            else if(datadb[2].equals("dg")){tyuo=R.drawable.dgreen;}
            else if(datadb[2].equals("db")){tyuo=R.drawable.dblue;}
            else if(datadb[2].equals("o")){tyuo=R.drawable.dorange;}
            else if(datadb[2].equals("doc")){tyuo=R.drawable.dorange;}
            else if(datadb[2].equals("do")){tyuo=R.drawable.dorange;}
            else if(datadb[2].equals("dd")){tyuo=R.drawable.ddeepblue;}
            else if(datadb[2].equals("dddc")){tyuo=R.drawable.ddeepblue;}
            else if(datadb[2].equals("ddd")){tyuo=R.drawable.ddeepblue;}
            else if(datadb[2].equals("gg")){tyuo=R.drawable.dgrey;}
            else if(datadb[2].equals("dggc")){tyuo=R.drawable.dgrey;}
            else if(datadb[2].equals("dgg")){tyuo=R.drawable.dgrey;}
            remote.setTextViewText(R.id.frame1,datadb[0]);
            remote.setTextViewText(R.id.frame2,datadb[1]);
            remote.setTextViewText(R.id.frame3,datadb[3]);

            if(!datadb[4].equals("")){
                remote.setViewVisibility(R.id.updatedby,View.VISIBLE);
                remote.setTextViewText(R.id.frame4,datadb[4]);
            }
            remote.setInt(R.id.mainframe,"setBackgroundResource",tyuo);



            remote.setTextViewText(R.id.batch, "TimeTable (Economics)" );
            appWidgetManager.updateAppWidget(thisWidget, remote);

        }






        else if(widgetintent >2131687602 && widgetintent<2131687648){

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            RemoteViews remotee = new RemoteViews(context.getPackageName(), R.layout.custom_push);
            remotee.setViewVisibility(R.id.updatedby, View.INVISIBLE);
            remotee.setTextViewText(R.id.frame4,"");
            ComponentName thisWidget = new ComponentName(context, TimeTableS2.class);
            int widgetid=widgetintent + 2000;
            String[] asd={Integer.toString(widgetid)};
            String [] name={"name","room","color","info","boss"};
            remotee.setViewVisibility(R.id.frame, View.VISIBLE);


            SQLiteDatabase fdb= new Databasemain(context).getReadableDatabase();
            Cursor getcd= fdb.query("S2",name,"id=?",asd,null,null,null);
            CursorWraperdata dd= new CursorWraperdata(getcd);
            dd.moveToFirst();int tyuo=99;
            String[] datadb = dd.getdata();
            if(datadb[2].equals("r")){tyuo=R.drawable.dred;}
            else if(datadb[2].equals("g")){tyuo=R.drawable.dgreen;}
            else if(datadb[2].equals("b")){tyuo=R.drawable.dblue;}
            else if(datadb[2].equals("y")){tyuo=R.drawable.dyellow;}
            else if(datadb[2].equals("drc")){tyuo=R.drawable.dred;}
            else if(datadb[2].equals("dgc")){tyuo=R.drawable.dgreen;}
            else if(datadb[2].equals("dbc")){tyuo=R.drawable.dblue;}
            else if(datadb[2].equals("dyc")){tyuo=R.drawable.dyellow;}
            else if(datadb[2].equals("dr")){tyuo=R.drawable.dred;}
            else if(datadb[2].equals("dy")){tyuo=R.drawable.dyellow;}
            else if(datadb[2].equals("dg")){tyuo=R.drawable.dgreen;}
            else if(datadb[2].equals("db")){tyuo=R.drawable.dblue;}
            else if(datadb[2].equals("o")){tyuo=R.drawable.dorange;}
            else if(datadb[2].equals("doc")){tyuo=R.drawable.dorange;}
            else if(datadb[2].equals("do")){tyuo=R.drawable.dorange;}
            else if(datadb[2].equals("dd")){tyuo=R.drawable.ddeepblue;}
            else if(datadb[2].equals("dddc")){tyuo=R.drawable.ddeepblue;}
            else if(datadb[2].equals("ddd")){tyuo=R.drawable.ddeepblue;}
            else if(datadb[2].equals("gg")){tyuo=R.drawable.dgrey;}
            else if(datadb[2].equals("dggc")){tyuo=R.drawable.dgrey;}
            else if(datadb[2].equals("dgg")){tyuo=R.drawable.dgrey;}
            remotee.setTextViewText(R.id.frame1,datadb[0]);
            remotee.setTextViewText(R.id.frame2,datadb[1]);
            remotee.setTextViewText(R.id.frame3,datadb[3]);

            if(!datadb[4].equals("")){
                remotee.setViewVisibility(R.id.updatedby,View.VISIBLE);
                remotee.setTextViewText(R.id.frame4,datadb[4]);
            }
            remotee.setInt(R.id.mainframe,"setBackgroundResource",tyuo);



            remotee.setTextViewText(R.id.batch, "TimeTable (Sociology)" );
            appWidgetManager.updateAppWidget(thisWidget, remotee);

        }





        else  if(intent.getAction().equals("99")){

            SharedPreferences pref = context.getSharedPreferences("batch", context.MODE_PRIVATE);
            int agfg = pref.getInt("batch", 0);

if(agfg==1){Intent zxzx = new Intent (context,S1.class);
context.startService(zxzx);}
            if(agfg==2){Intent zxzx = new Intent (context,S2.class);
                context.startService(zxzx);}


        }





        else {


            contentViews.setViewVisibility(R.id.updatedby,View.INVISIBLE);
            contentViews.setTextViewText(R.id.frame4,"");
            String yui=intent.getAction();
            int intentaction=Integer.parseInt(yui);


            SharedPreferences pref = context.getSharedPreferences("batch", context.MODE_PRIVATE);
            int amn = pref.getInt("batch", 1);
            String bclass;
            if(amn==1){bclass="S1";}
            else{bclass="S2";}



            contentViews.setViewVisibility(R.id.frame, View.VISIBLE);

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
                    contentViews.setTextViewText(id, data[0]);
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

                    contentViews.setInt(id,"setBackgroundResource",back);

                    contentViews.setTextColor(id, Color.BLACK);
                   if(id==intentaction){
                       contentViews.setTextViewText(R.id.frame1,data[0]);
                       contentViews.setTextViewText(R.id.frame2,data[1]);
                       contentViews.setTextViewText(R.id.frame3,data[3]);

                       if(!data[4].equals("")){
                           contentViews.setViewVisibility(R.id.updatedby,View.VISIBLE);
                           contentViews.setTextViewText(R.id.frame4,data[4]);
                       }
                    if(back==R.drawable.red||back==R.drawable.redcancel||back==R.drawable.dred){tyuo=R.drawable.dred;}
                    else if(back==R.drawable.green||back==R.drawable.greencancel||back==R.drawable.dgreen){tyuo=R.drawable.dgreen;}
                    else if(back==R.drawable.blue||back==R.drawable.bluecancel||back==R.drawable.dblue){tyuo=R.drawable.dblue;}
                    else if(back==R.drawable.yellow||back==R.drawable.yellowcancel||back==R.drawable.dyellow){tyuo=R.drawable.dyellow;}
                    else if(back==R.drawable.orange||back==R.drawable.orangecancel||back==R.drawable.dorange){tyuo=R.drawable.dorange;}
                    else if(back==R.drawable.deepblue||back==R.drawable.deepbluecancel||back==R.drawable.ddeepblue){tyuo=R.drawable.ddeepblue;}
                    else if(back==R.drawable.grey||back==R.drawable.greycancel||back==R.drawable.dgrey){tyuo=R.drawable.dgrey;}



                       contentViews.setInt(R.id.mainframe,"setBackgroundResource",tyuo);
                   }
                    a = a + 1;
                    dd.moveToNext();
                }
            } finally {
                dd.close();
            }


            if(bclass.equals("S1")){contentViews.setTextViewText(R.id.batch, "TimeTable (Economics)");}
            if(bclass.equals("S2")){contentViews.setTextViewText(R.id.batch, "TimeTable (Sociology)");}


            Intent v99 = new Intent("99");PendingIntent g99 = PendingIntent.getBroadcast(context, 0, v99, 0);contentViews.setOnClickPendingIntent(R.id.imageButton, g99);


       Boolean yes ;
        SharedPreferences pdddref = context.getSharedPreferences("checkboxnotif", context.MODE_PRIVATE);
        int chchch = pdddref.getInt("checkboxnotif", 1);
        if(chchch==0){yes=false;}
        else {yes=true;}



            Drawable bb = context.getResources().getDrawable(R.drawable.ghgh);
            Bitmap bjbu = ((BitmapDrawable) bb).getBitmap();
            notif = new Notification.Builder(context)
                    .setSmallIcon(R.drawable.ic_stat_names)
                    .setLargeIcon(bjbu)
                    .setOngoing(yes)
                    .setContentText("Drag Down To Open TimeTable")
                    .setContentTitle("TimeTable")
                    .setShowWhen(false)
                    .build();
            notif.bigContentView = contentViews;
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(1, notif);


        }






    }
}
