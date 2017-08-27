package com.iitr.kaishu.timetable;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.lang.reflect.Method;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Kaishu on 6/6/2017.
 */

public class content_main extends Fragment {
    Button S1;
    Button S2;
    Button cancel;
    Intent yy;
    Intent ttt;
    CheckBox chk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_main3, container, false);
yy= new Intent(getActivity(), S2.class);
        ttt=new Intent(getActivity(),S1.class);
          S1=(Button)v.findViewById(R.id.buttonS1);
        cancel=(Button)v.findViewById(R.id.cancelnotif);
          S2=(Button)v.findViewById(R.id.buttonS2);
        chk = (CheckBox) v.findViewById(R.id.checkBoxnotification);
        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        navigationView.getMenu().findItem(R.id.home).setChecked(true);

Intent automatic = new Intent (getActivity(),Weekly_Update.class);
        getActivity().startService(automatic);

        Handler bosshand  =new Handler();
        bosshand.postDelayed(new Runnable() {
            @Override
            public void run() {

try{
    Intent intent1231 = new Intent(getActivity(), TimeTable.class);
                intent1231.setAction("android.appwidget.action.APPWIDGET_UPDATE");
                int ids[] = AppWidgetManager.getInstance(getActivity()).getAppWidgetIds(new ComponentName(getActivity(), TimeTable.class));
                intent1231.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,ids);
                getActivity().sendBroadcast(intent1231);

                Intent intent12221 = new Intent(getActivity(), TimeTableS2.class);
                intent12221.setAction("android.appwidget.action.APPWIDGET_UPDATE");
                int ids1[] = AppWidgetManager.getInstance(getActivity()).getAppWidgetIds(new ComponentName(getActivity(), TimeTableS2.class));
                intent12221.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,ids1);
                getActivity().sendBroadcast(intent12221);}
catch(Exception e){}
            }
        },4000);


        SharedPreferences prcccef = getActivity().getSharedPreferences("checkboxnotif", getActivity().MODE_PRIVATE);
        int hahahah = prcccef.getInt("checkboxnotif", 1);
        if(hahahah==1){chk.setChecked(true);}
        else{chk.setChecked(false);}



        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                           @Override
                                           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                               if (!isChecked){
                                                   SharedPreferences.Editor editor = getActivity().getSharedPreferences("checkboxnotif", getActivity().MODE_PRIVATE).edit();
                                                   editor.putInt("checkboxnotif", 0);
                                                   editor.apply();
                                                   SharedPreferences pref = getActivity().getSharedPreferences("batch", getActivity().MODE_PRIVATE);
                                                   int amssn = pref.getInt("batch", 0);
                                                   if(amssn==0){
                                                       Toast.makeText(getActivity(), "First select your batch", Toast.LENGTH_SHORT).show();
                                                   }
                                                   else if(amssn==1){

                                                       Intent S1refresh = new Intent (getActivity(),S1.class);
                                                       getActivity().startService(S1refresh);
                                               }
                                               else if(amssn==2){      Intent S1refresh = new Intent (getActivity(),S2.class);
                                                       getActivity().startService(S1refresh);

                                                   }
                                               }
                                               else{

                                                   SharedPreferences.Editor editor = getActivity().getSharedPreferences("checkboxnotif", getActivity().MODE_PRIVATE).edit();
                                                   editor.putInt("checkboxnotif", 1);
                                                   editor.apply();
                                                   SharedPreferences pref = getActivity().getSharedPreferences("batch", getActivity().MODE_PRIVATE);
                                                   int amssn = pref.getInt("batch", 0);
                                                   if(amssn==0){
                                                       Toast.makeText(getActivity(), "First select your batch", Toast.LENGTH_SHORT).show();
                                                   }
                                                   else if(amssn==1){

                                                       Intent S1refresh = new Intent (getActivity(),S1.class);
                                                       getActivity().startService(S1refresh);
                                                   }
                                                   else if(amssn==2){      Intent S1refresh = new Intent (getActivity(),S2.class);
                                                       getActivity().startService(S1refresh);

                                                   }
                                               }

                                           }
                                       });

                S1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            S1.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.clicked));
                            Toast.makeText(getContext(), "Open Notifcation Panel", Toast.LENGTH_SHORT).show();
                            getActivity().startService(ttt);
                            getActivity().stopService(yy);
                            SharedPreferences.Editor editor = getActivity().getSharedPreferences("batch", getActivity().MODE_PRIVATE).edit();
                            editor.putInt("batch", 1);
                            editor.apply();
                  /*  Intent updateservice = new Intent (getContext(),Update.class);
                    getContext().startService(updateservice);*/
                            Intent updateservice = new Intent(getContext(), Weekly_Update.class);
                            getContext().startService(updateservice);
                            try {
                                Object sbservice = getActivity().getSystemService("statusbar");
                                Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
                                Method showsb;
                                if (Build.VERSION.SDK_INT >= 17) {
                                    showsb = statusbarManager.getMethod("expandNotificationsPanel");
                                } else {
                                    showsb = statusbarManager.getMethod("expand");
                                }

                                showsb.invoke(sbservice);
                            } catch (Exception e) {
                                e.printStackTrace();

                            }

                        } else if (event.getAction() == MotionEvent.ACTION_UP) {
                            S1.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.login_button));
                        }

                        return false;
                    }
                });
        S2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    S2.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.clicked));
                    Toast.makeText(getContext(), "Open Notifcation Panel", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("batch", getActivity().MODE_PRIVATE).edit();
                    editor.putInt("batch", 2);
                    editor.apply();
                    getActivity().startService(yy);
                    getActivity().stopService(ttt);
                    Intent updateservice = new Intent (getContext(),Update.class);
                    getContext().startService(updateservice);
                    try {
                        Object sbservice = getActivity().getSystemService("statusbar");
                        Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
                        Method showsb;
                        if (Build.VERSION.SDK_INT >= 17) {
                            showsb = statusbarManager.getMethod("expandNotificationsPanel");
                        } else {
                            showsb = statusbarManager.getMethod("expand");
                        }

                        showsb.invoke(sbservice);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(), "nj", Toast.LENGTH_SHORT).show();
                    }


                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    S2.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.login_button));
                }

                return false;
            }
        });
        cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    cancel.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.clicked));

                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("batch", getActivity().MODE_PRIVATE).edit();
                    editor.putInt("batch", 0);
                    editor.apply();

                    NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
                    getActivity().stopService(ttt);
                    getActivity().stopService(yy);
                    notificationManager.cancelAll();
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    cancel.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.login_button));
                }

                return false;
            }
        });







   return v; }
    }
