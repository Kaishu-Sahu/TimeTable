package com.iitr.kaishu.timetable;

import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade);
        ImageView image1 = (ImageView)findViewById(R.id.imageView3);
        image1.startAnimation(animation);



        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.move);
        TextView text =(TextView)findViewById(R.id.textView2);
        text.startAnimation(animation1);
        TextView devel=(TextView)findViewById(R.id.Devel);
        TextView kaishu = (TextView)findViewById(R.id.Kaishu);
        Animation sahu = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.movenega);
        devel.startAnimation(sahu);
        kaishu.startAnimation(sahu);



        SharedPreferences pddref = this.getSharedPreferences("versionnet", this.MODE_PRIVATE);
        String post  = pddref.getString("versionnet", "kaishu");
     if(post.equals(BuildConfig.VERSION_NAME)||post.equals("kaishu")){


        SharedPreferences pref = this.getSharedPreferences("login", this.MODE_PRIVATE);
        int a = pref.getInt("loginsuccess", 1);
        Handler handler = new Handler();

         SharedPreferences prefrestart = this.getSharedPreferences("restart", this.MODE_PRIVATE);
         int arestart = prefrestart.getInt("restart", 0);
         if(arestart==0){  handler.postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent zero = new Intent(Main2Activity.this,IntroActivity.class);
                 startActivity(zero);
                 finish();}
         },1750);}
              else {

             if (a == 1) {
                 handler.postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         Intent zero = new Intent(Main2Activity.this, MainActivity.class);
                         startActivity(zero);
                         finish();
                     }
                 }, 1750);


             } else if (a == 2) {
                 handler.postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         Intent hero = new Intent(Main2Activity.this, Main3Activity.class);
                         startActivity(hero);
                         finish();
                     }
                 }, 1750);

             }
         } }else {
         Toast.makeText(this, "Update Your App", Toast.LENGTH_LONG).show();
         String urlString=Constants.website+"dwn.php";
         Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

         intent.setPackage(null);
         startActivity(intent);
     }}


    }

