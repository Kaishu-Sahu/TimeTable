package com.iitr.kaishu.timetable;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Update extends Service {
String[] jakal;
    SQLiteDatabase getgh;
    SQLiteDatabase gfgf;
    int agghhg;
    int weeknonono;

    public Update() {
    }

    @Override
    public IBinder onBind(Intent dataSnapshot) {

        return null;
    }
@Override
public int onStartCommand(Intent intent, int flags, int startId) {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference data = database.getReference("data12");
    data.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

            String[] namedd = {"name", "room", "color", "info", "boss"};
            updateinformation kk = dataSnapshot.getValue(updateinformation.class);
            String id = kk.getId();
            String name = kk.getName();
            String room = kk.getRoom();
            String info = kk.getInfo();
            String boss = kk.getBoss();
            String color = kk.getColor();
            String batch = kk.getBatch();
            String request_id = kk.getRequest_id();



            String where[]={id};
            getgh = new Databasemain(getApplicationContext()).getReadableDatabase();
            Cursor getcs = getgh.query(batch, namedd, "id=?",where, null, null, null);
            CursorWraperdata dds = new CursorWraperdata(getcs);
            dds.moveToFirst();
            jakal=dds.getdata();

            if(!name.equals(jakal[0])||!room.equals(jakal[1])||!color.equals(jakal[2])||!info.equals(jakal[3])||!boss.equals(jakal[4])){

                SharedPreferences pref3 = getSharedPreferences("request_id", MODE_PRIVATE);
                String request_id_shared = pref3.getString("request_id", "0");

                int temp_req = Integer.parseInt(request_id_shared);
                int temp_reqnet = Integer.parseInt(request_id);

                if(temp_req<temp_reqnet){
              //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    SharedPreferences.Editor editor = getSharedPreferences("request_id", MODE_PRIVATE).edit();
                    editor.putString("request_id",request_id);
                    editor.apply();


                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




               String sqll="UPDATE "+batch+" set name='"+name+"', room='"+room+"', color='"+color+"', info='"+info+"', boss='"+boss+"' Where id='"+id+"';";
                getgh.execSQL(sqll);
                SharedPreferences pref = getApplicationContext().getSharedPreferences("batch", getApplicationContext().MODE_PRIVATE);
                int ag = pref.getInt("batch", 0);
                if(batch.equals("S1") && ag==1)
                {/*int notifid= ThreadLocalRandom.current().nextInt(1,99999);*/
                    int iid = Integer.parseInt(id);
                    Intent Sld=new Intent(Update.this,S1.class);
                startService(Sld);
                    Intent startapp= new Intent(getApplicationContext(),Main3Activity.class);
                    PendingIntent op= PendingIntent.getActivity(getApplicationContext(),0,startapp,0);
                    Drawable bb = getResources().getDrawable(R.drawable.ghgh);
                    Bitmap bjbu = ((BitmapDrawable) bb).getBitmap();
                    Notification notif = new Notification.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.ic_stat_names)
                            .setLargeIcon(bjbu)
                            .setContentIntent(op)
                            .setContentText(boss+" has updated the TimeTable.")
                            .setContentTitle("TimeTable")
                            .build();
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notif.defaults |=Notification.DEFAULT_ALL;
                    notificationManager.notify(iid, notif);}

                if(batch.equals("S2") && ag==2)
                {int iid = Integer.parseInt(id);

                    Intent Slde=new Intent(Update.this,S2.class);
                    startService(Slde);
                    Intent startapp= new Intent(getApplicationContext(),Main3Activity.class);
                    PendingIntent op= PendingIntent.getActivity(getApplicationContext(),0,startapp,0);
                    Drawable bb = getResources().getDrawable(R.drawable.ghgh);
                    Bitmap bjbu = ((BitmapDrawable) bb).getBitmap();
                    Notification notif = new Notification.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.ic_stat_names)
                            .setLargeIcon(bjbu)
                            .setContentIntent(op)
                            .setContentText(boss+" has updated the TimeTable.")
                            .setContentTitle("TimeTable")
                            .build();
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notif.defaults |=Notification.DEFAULT_ALL;
                    notificationManager.notify(iid, notif);
                 }
                    Intent intent = new Intent(Update.this, TimeTable.class);
                    intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
                    int ids[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), TimeTable.class));
                    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,ids);

                    sendBroadcast(intent);

                    Intent intent1 = new Intent(Update.this, TimeTableS2.class);
                    intent1.setAction("android.appwidget.action.APPWIDGET_UPDATE");
                    int ids1[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), TimeTableS2.class));
                    intent1.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,ids1);

                    sendBroadcast(intent1);
            }}

        }




    public void onChildRemoved(DataSnapshot dataSnapshot) {


    }


    public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {

    }

    public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {

    }

    @Override
    public void onCancelled(DatabaseError error) {


    }




    });


    final FirebaseDatabase updateid= FirebaseDatabase.getInstance();
    final DatabaseReference updateidd = updateid.getReference("update");

    updateidd.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            String gg= dataSnapshot.child("version").getValue(String.class);

            if(gg.equals(BuildConfig.VERSION_NAME)){SharedPreferences.Editor editor = getSharedPreferences("versionnet",MODE_PRIVATE).edit();
                editor.putString("versionnet", gg);
                editor.apply();}
            else{
                Drawable bb = getResources().getDrawable(R.drawable.ghgh);
                Bitmap bjbu = ((BitmapDrawable) bb).getBitmap();
                Notification notif = new Notification.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_stat_names)
                        .setLargeIcon(bjbu)
                        .setContentText("A newer version of app is available download now.")
                        .setContentTitle("TimeTable")
                        .build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notif.defaults |=Notification.DEFAULT_ALL;
                notificationManager.notify(5036, notif);
                SharedPreferences.Editor editfor = getSharedPreferences("versionnet",MODE_PRIVATE).edit();
                editfor.putString("versionnet", gg);
                editfor.apply();
                stopSelf();
                Intent forecestop = new Intent (Update.this,Weekly_Update.class);
                stopService(forecestop);
                notificationManager.cancel(1);
                notificationManager.cancel(2);

                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(Update.this);
                RemoteViews remoteViews = new RemoteViews(Update.this.getPackageName(), R.layout.custom_push);
                ComponentName thisWidget = new ComponentName(Update.this, TimeTable.class);
                ComponentName thisWidget1 = new ComponentName(Update.this, TimeTableS2.class);
                remoteViews.setTextViewText(R.id.batch, "Update Your App");
                appWidgetManager.updateAppWidget(thisWidget, remoteViews);
                appWidgetManager.updateAppWidget(thisWidget1, remoteViews);


            }

        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });

    return START_STICKY;
}}