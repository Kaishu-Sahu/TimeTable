package com.iitr.kaishu.timetable;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.View;
import android.widget.RemoteViews;


public class S2 extends Service {
    RemoteViews contentView;
    Notification notif;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String [] name={"name","room","color","info","boss"};
        contentView = new RemoteViews(getPackageName(), R.layout.custom_push);
        SQLiteDatabase get = new Databasemain(getApplicationContext()).getReadableDatabase();
        Cursor getc= get.query("S2",name,null,null,null,null,null);
        CursorWraperdata dd= new CursorWraperdata(getc);
        int a=R.id.tutton11;
        try {
            dd.moveToFirst();
            while (!dd.isAfterLast()) {
                String[] data= dd.getdata();
                int id=a;int back=123;
                contentView.setTextViewText(id,data[0]);
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

                contentView.setInt(id,"setBackgroundResource",back);

                contentView.setTextColor(id, Color.BLACK);
                a=a+1;
                dd.moveToNext();}
        } finally {
            dd.close();
        }


        contentView.setViewVisibility(R.id.frame, View.INVISIBLE);

        contentView.setTextViewText(R.id.batch,"TimeTable (Sociology)");

        hhhhh();


        Boolean yes = true ;
        SharedPreferences pref = this.getSharedPreferences("checkboxnotif", this.MODE_PRIVATE);
        int chchch = pref.getInt("checkboxnotif", 1);
        if(chchch==0){yes=false;}



        Intent intenttr = new Intent(S2.this, TimeTable.class);
        intenttr.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        int idskk[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), TimeTableS2.class));
        intenttr.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,idskk);

        sendBroadcast(intenttr);




        //    register();
        Drawable bb=getResources().getDrawable(R.drawable.ghgh);
        Bitmap bjbu= ((BitmapDrawable)bb).getBitmap();
        notif = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_names)
                .setLargeIcon(bjbu)
                .setOngoing(yes)
                .setContentText("Drag Down To Open TimeTable")
                .setContentTitle("TimeTable")
                .setShowWhen(false)
                .build();
        notif.bigContentView=contentView;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(1, notif);
        return START_STICKY;
    }

    public void hhhhh() {

        Intent v2131689603= new Intent("2131689603");PendingIntent g2131689603= PendingIntent.getBroadcast(this, 0, v2131689603, 0);contentView.setOnClickPendingIntent(2131689603, g2131689603);
        Intent v2131689604= new Intent("2131689604");PendingIntent g2131689604= PendingIntent.getBroadcast(this, 0, v2131689604, 0);contentView.setOnClickPendingIntent(2131689604, g2131689604);
        Intent v2131689605= new Intent("2131689605");PendingIntent g2131689605= PendingIntent.getBroadcast(this, 0, v2131689605, 0);contentView.setOnClickPendingIntent(2131689605, g2131689605);
        Intent v2131689606= new Intent("2131689606");PendingIntent g2131689606= PendingIntent.getBroadcast(this, 0, v2131689606, 0);contentView.setOnClickPendingIntent(2131689606, g2131689606);
        Intent v2131689607= new Intent("2131689607");PendingIntent g2131689607= PendingIntent.getBroadcast(this, 0, v2131689607, 0);contentView.setOnClickPendingIntent(2131689607, g2131689607);
        Intent v2131689608= new Intent("2131689608");PendingIntent g2131689608= PendingIntent.getBroadcast(this, 0, v2131689608, 0);contentView.setOnClickPendingIntent(2131689608, g2131689608);
        Intent v2131689609= new Intent("2131689609");PendingIntent g2131689609= PendingIntent.getBroadcast(this, 0, v2131689609, 0);contentView.setOnClickPendingIntent(2131689609, g2131689609);
        Intent v2131689610= new Intent("2131689610");PendingIntent g2131689610= PendingIntent.getBroadcast(this, 0, v2131689610, 0);contentView.setOnClickPendingIntent(2131689610, g2131689610);
        Intent v2131689611= new Intent("2131689611");PendingIntent g2131689611= PendingIntent.getBroadcast(this, 0, v2131689611, 0);contentView.setOnClickPendingIntent(2131689611, g2131689611);
        Intent v2131689612= new Intent("2131689612");PendingIntent g2131689612= PendingIntent.getBroadcast(this, 0, v2131689612, 0);contentView.setOnClickPendingIntent(2131689612, g2131689612);
        Intent v2131689613= new Intent("2131689613");PendingIntent g2131689613= PendingIntent.getBroadcast(this, 0, v2131689613, 0);contentView.setOnClickPendingIntent(2131689613, g2131689613);
        Intent v2131689614= new Intent("2131689614");PendingIntent g2131689614= PendingIntent.getBroadcast(this, 0, v2131689614, 0);contentView.setOnClickPendingIntent(2131689614, g2131689614);
        Intent v2131689615= new Intent("2131689615");PendingIntent g2131689615= PendingIntent.getBroadcast(this, 0, v2131689615, 0);contentView.setOnClickPendingIntent(2131689615, g2131689615);
        Intent v2131689616= new Intent("2131689616");PendingIntent g2131689616= PendingIntent.getBroadcast(this, 0, v2131689616, 0);contentView.setOnClickPendingIntent(2131689616, g2131689616);
        Intent v2131689617= new Intent("2131689617");PendingIntent g2131689617= PendingIntent.getBroadcast(this, 0, v2131689617, 0);contentView.setOnClickPendingIntent(2131689617, g2131689617);
        Intent v2131689618= new Intent("2131689618");PendingIntent g2131689618= PendingIntent.getBroadcast(this, 0, v2131689618, 0);contentView.setOnClickPendingIntent(2131689618, g2131689618);
        Intent v2131689619= new Intent("2131689619");PendingIntent g2131689619= PendingIntent.getBroadcast(this, 0, v2131689619, 0);contentView.setOnClickPendingIntent(2131689619, g2131689619);
        Intent v2131689620= new Intent("2131689620");PendingIntent g2131689620= PendingIntent.getBroadcast(this, 0, v2131689620, 0);contentView.setOnClickPendingIntent(2131689620, g2131689620);
        Intent v2131689621= new Intent("2131689621");PendingIntent g2131689621= PendingIntent.getBroadcast(this, 0, v2131689621, 0);contentView.setOnClickPendingIntent(2131689621, g2131689621);
        Intent v2131689622= new Intent("2131689622");PendingIntent g2131689622= PendingIntent.getBroadcast(this, 0, v2131689622, 0);contentView.setOnClickPendingIntent(2131689622, g2131689622);
        Intent v2131689623= new Intent("2131689623");PendingIntent g2131689623= PendingIntent.getBroadcast(this, 0, v2131689623, 0);contentView.setOnClickPendingIntent(2131689623, g2131689623);
        Intent v2131689624= new Intent("2131689624");PendingIntent g2131689624= PendingIntent.getBroadcast(this, 0, v2131689624, 0);contentView.setOnClickPendingIntent(2131689624, g2131689624);
        Intent v2131689625= new Intent("2131689625");PendingIntent g2131689625= PendingIntent.getBroadcast(this, 0, v2131689625, 0);contentView.setOnClickPendingIntent(2131689625, g2131689625);
        Intent v2131689626= new Intent("2131689626");PendingIntent g2131689626= PendingIntent.getBroadcast(this, 0, v2131689626, 0);contentView.setOnClickPendingIntent(2131689626, g2131689626);
        Intent v2131689627= new Intent("2131689627");PendingIntent g2131689627= PendingIntent.getBroadcast(this, 0, v2131689627, 0);contentView.setOnClickPendingIntent(2131689627, g2131689627);
        Intent v2131689628= new Intent("2131689628");PendingIntent g2131689628= PendingIntent.getBroadcast(this, 0, v2131689628, 0);contentView.setOnClickPendingIntent(2131689628, g2131689628);
        Intent v2131689629= new Intent("2131689629");PendingIntent g2131689629= PendingIntent.getBroadcast(this, 0, v2131689629, 0);contentView.setOnClickPendingIntent(2131689629, g2131689629);
        Intent v2131689630= new Intent("2131689630");PendingIntent g2131689630= PendingIntent.getBroadcast(this, 0, v2131689630, 0);contentView.setOnClickPendingIntent(2131689630, g2131689630);
        Intent v2131689631= new Intent("2131689631");PendingIntent g2131689631= PendingIntent.getBroadcast(this, 0, v2131689631, 0);contentView.setOnClickPendingIntent(2131689631, g2131689631);
        Intent v2131689632= new Intent("2131689632");PendingIntent g2131689632= PendingIntent.getBroadcast(this, 0, v2131689632, 0);contentView.setOnClickPendingIntent(2131689632, g2131689632);
        Intent v2131689633= new Intent("2131689633");PendingIntent g2131689633= PendingIntent.getBroadcast(this, 0, v2131689633, 0);contentView.setOnClickPendingIntent(2131689633, g2131689633);
        Intent v2131689634= new Intent("2131689634");PendingIntent g2131689634= PendingIntent.getBroadcast(this, 0, v2131689634, 0);contentView.setOnClickPendingIntent(2131689634, g2131689634);
        Intent v2131689635= new Intent("2131689635");PendingIntent g2131689635= PendingIntent.getBroadcast(this, 0, v2131689635, 0);contentView.setOnClickPendingIntent(2131689635, g2131689635);
        Intent v2131689636= new Intent("2131689636");PendingIntent g2131689636= PendingIntent.getBroadcast(this, 0, v2131689636, 0);contentView.setOnClickPendingIntent(2131689636, g2131689636);
        Intent v2131689637= new Intent("2131689637");PendingIntent g2131689637= PendingIntent.getBroadcast(this, 0, v2131689637, 0);contentView.setOnClickPendingIntent(2131689637, g2131689637);
        Intent v2131689638= new Intent("2131689638");PendingIntent g2131689638= PendingIntent.getBroadcast(this, 0, v2131689638, 0);contentView.setOnClickPendingIntent(2131689638, g2131689638);
        Intent v2131689639= new Intent("2131689639");PendingIntent g2131689639= PendingIntent.getBroadcast(this, 0, v2131689639, 0);contentView.setOnClickPendingIntent(2131689639, g2131689639);
        Intent v2131689640= new Intent("2131689640");PendingIntent g2131689640= PendingIntent.getBroadcast(this, 0, v2131689640, 0);contentView.setOnClickPendingIntent(2131689640, g2131689640);
        Intent v2131689641= new Intent("2131689641");PendingIntent g2131689641= PendingIntent.getBroadcast(this, 0, v2131689641, 0);contentView.setOnClickPendingIntent(2131689641, g2131689641);
        Intent v2131689642= new Intent("2131689642");PendingIntent g2131689642= PendingIntent.getBroadcast(this, 0, v2131689642, 0);contentView.setOnClickPendingIntent(2131689642, g2131689642);
        Intent v2131689643= new Intent("2131689643");PendingIntent g2131689643= PendingIntent.getBroadcast(this, 0, v2131689643, 0);contentView.setOnClickPendingIntent(2131689643, g2131689643);
        Intent v2131689644= new Intent("2131689644");PendingIntent g2131689644= PendingIntent.getBroadcast(this, 0, v2131689644, 0);contentView.setOnClickPendingIntent(2131689644, g2131689644);
        Intent v2131689645= new Intent("2131689645");PendingIntent g2131689645= PendingIntent.getBroadcast(this, 0, v2131689645, 0);contentView.setOnClickPendingIntent(2131689645, g2131689645);
        Intent v2131689646= new Intent("2131689646");PendingIntent g2131689646= PendingIntent.getBroadcast(this, 0, v2131689646, 0);contentView.setOnClickPendingIntent(2131689646, g2131689646);
        Intent v2131689647= new Intent("2131689647");PendingIntent g2131689647= PendingIntent.getBroadcast(this, 0, v2131689647, 0);contentView.setOnClickPendingIntent(2131689647, g2131689647);



        Intent v99 = new Intent("99");
        PendingIntent g99 = PendingIntent.getBroadcast(this, 0, v99, 0);
        contentView.setOnClickPendingIntent(R.id.imageButton, g99);


    }


}