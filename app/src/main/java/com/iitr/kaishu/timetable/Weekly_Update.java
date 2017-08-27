package com.iitr.kaishu.timetable;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.net.ssl.HandshakeCompletedEvent;

public class Weekly_Update extends Service {
    public Weekly_Update() {
    }
int weeknonono;
    int agghhg;
    SQLiteDatabase gfgf;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference week__no = database.getReference("week_no");
        SharedPreferences pref = getApplicationContext().getSharedPreferences("batch", getApplicationContext().MODE_PRIVATE);
        agghhg = pref.getInt("batch", 0);
        SharedPreferences weeknono = getApplicationContext().getSharedPreferences("weekno", getApplicationContext().MODE_PRIVATE);
        weeknonono = weeknono.getInt("weekno", 0);
        week__no.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String hh = dataSnapshot.child("qwerty").getValue(String.class);
                int hhhh=Integer.parseInt(hh);
                if(hhhh!=weeknonono) {

                    DatabaseReference s1 = database.getReference("S1");
                    s1.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                            weeklyupdate kkj = dataSnapshot.getValue(weeklyupdate.class);
                            String id = kkj.getId();
                            String name = kkj.getName();
                            String room = kkj.getRoom();
                            String color = kkj.getColor();
                            String info = kkj.getInfo();
                            String boss = kkj.getBoss();
                            String llsqll="UPDATE "+"S1"+" set name='"+name+"', room='"+room+"', color='"+color+"', info='"+info+"', boss='"+boss+"' Where id='"+id+"';";
                            gfgf = new Databasemain(getBaseContext()).getWritableDatabase();
                            gfgf.execSQL(llsqll);
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
                    DatabaseReference s12 = database.getReference("S2");
                    s12.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                            weeklyupdate kkj = dataSnapshot.getValue(weeklyupdate.class);
                            String id = kkj.getId();
                            String name = kkj.getName();
                            String room = kkj.getRoom();
                            String color = kkj.getColor();
                            String info = kkj.getInfo();
                            String boss = kkj.getBoss();

                            String llsqll2="UPDATE "+"S2"+" set name='"+name+"', room='"+room+"', color='"+color+"', info='"+info+"', boss='"+boss+"' Where id='"+id+"';";
                            gfgf = new Databasemain(getBaseContext()).getWritableDatabase();
                            gfgf.execSQL(llsqll2);
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
                    if(agghhg==1){

                      final  Intent ss1= new Intent (Weekly_Update.this,S1.class);
                        NotificationManager notificationManager1 = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
notificationManager1.cancel(1);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    startService(ss1);

                                                }},4000);

                    }
                    else if(agghhg==2){
                        final Intent ss1= new Intent (Weekly_Update.this,S2.class);
                        NotificationManager notificationManager1 = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
                        notificationManager1.cancel(1);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startService(ss1);

                            }},4000);
                    }

                    SharedPreferences.Editor editorj = getSharedPreferences("request_id", MODE_PRIVATE).edit();
                    editorj.putString("request_id","0");
                    editorj.apply();

                    SharedPreferences.Editor editor = getSharedPreferences("weekno", MODE_PRIVATE).edit();
                    editor.putInt("weekno",hhhh);
                    editor.apply();
                    Intent startapp= new Intent(getApplicationContext(),Main3Activity.class);
                    PendingIntent op= PendingIntent.getActivity(getApplicationContext(),0,startapp,0);
                    Drawable bb = getResources().getDrawable(R.drawable.ghgh);
                    Bitmap bjbu = ((BitmapDrawable) bb).getBitmap();
                    Notification notidf = new Notification.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.ic_stat_names)
                            .setLargeIcon(bjbu)
                            .setContentIntent(op)
                            .setContentText("TimeTable refreshed")
                            .setContentTitle("TimeTable")
                            .build();
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notidf.defaults |=Notification.DEFAULT_ALL;
                    notificationManager.notify(153247, notidf);
                    weeknonono=hhhh;


                    Handler bughand = new Handler();
                    bughand.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Weekly_Update.this, TimeTable.class);
                            intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
                            int ids[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), TimeTable.class));
                            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,ids);

                            sendBroadcast(intent);
                            Intent intent1 = new Intent(Weekly_Update.this, TimeTableS2.class);
                            intent1.setAction("android.appwidget.action.APPWIDGET_UPDATE");
                            int ids1[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), TimeTableS2.class));
                            intent1.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,ids1);

                            sendBroadcast(intent1);
                        }
                    },4000);




                }
                Intent firstuser = new Intent (Weekly_Update.this,Update.class);
                startService(firstuser);

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

    }
}
