package com.iitr.kaishu.timetable;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.zip.Inflater;

public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Context vv=this;
    int goty;

    Cursor cr;
Boolean  go;

    DrawerLayout drawer;
    FloatingActionButton fab;
    Toolbar toolbar;
    FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        fm.beginTransaction().add(R.id.fragmentrr,new content_main()).commit();
goty=0;
go= getIntent().getBooleanExtra("Account",true);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        if(go==false){fab.setVisibility(View.INVISIBLE);}
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().add(R.id.fragmentrr,new changefragment()).commit();
                toolbar.setTitle("Change Schedule");
                fab.setVisibility(View.INVISIBLE);
                goty=2;}
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
   if(go==false){navigationView.getMenu().findItem(R.id.logout).setVisible(false);}


    }


    @Override
    public void onBackPressed() {
        FragmentManager juiop=getSupportFragmentManager();
        Fragment jj=juiop.findFragmentById(R.id.fragmentrr);
        View uuuu=jj.getView();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(jj instanceof changefragment){

            LinearLayout r3=(LinearLayout)uuuu.findViewById(R.id.r3);
            RelativeLayout r1=(RelativeLayout)uuuu.findViewById(R.id.r1);
            LinearLayout r2=(LinearLayout)uuuu.findViewById(R.id.r2);
            if(r3.getVisibility()==View.VISIBLE){fm.beginTransaction().add(R.id.fragmentrr,new content_main()).commit();
                toolbar.setTitle("TimeTable");
                fab.setVisibility(View.VISIBLE);
                goty=0;


            }
            if(r1.getVisibility()==View.VISIBLE){
                r1.setVisibility(View.INVISIBLE);
                r3.setVisibility(View.VISIBLE);

            }
            if(r2.getVisibility()==View.VISIBLE){
                r2.setVisibility(View.INVISIBLE);
                r1.setVisibility(View.VISIBLE);

            }
        }
        else if(goty!=0){fm.beginTransaction().add(R.id.fragmentrr,new content_main()).commit();
            toolbar.setTitle("TimeTable");
            if(go==false){fab.setVisibility(View.INVISIBLE);}
            else{fab.setVisibility(View.VISIBLE);}
            goty=0;}

        else {
            super.onBackPressed();

        SharedPreferences uiop= this.getSharedPreferences("login",MODE_PRIVATE);
       int er= uiop.getInt("loginsuccess",1);
        if(er==2) {
            this.finish();
            finishAffinity();
        }

        }
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

         if (id == R.id.home) { fm.beginTransaction().add(R.id.fragmentrr,new content_main()).commit();
             toolbar.setTitle("TimeTable");
             if(go==false){fab.setVisibility(View.INVISIBLE);}
             else{fab.setVisibility(View.VISIBLE);}
             goty=0;


        } else if (id == R.id.share) { fm.beginTransaction().add(R.id.fragmentrr,new Main5Activity()).commit();
           toolbar.setTitle("Share");
             fab.setVisibility(View.INVISIBLE);
             goty=1;

        }

        else if (id==R.id.edit){if(go==true){
             fm.beginTransaction().add(R.id.fragmentrr,new changefragment()).commit();
             toolbar.setTitle("Change Schedule");
             fab.setVisibility(View.INVISIBLE);
        goty=2;}
         else { item.setCheckable(false);
             Dialog ss= new AlertDialog.Builder(this)
                 .setTitle("This feature is unavailable for anonymous users.")
                 .setPositiveButton("Create Account", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Intent jhg= new Intent(Main3Activity.this,Main4Activity.class);
startActivity(jhg);
                     }
                 })
                 .setNegativeButton("Cancel",null)
                 .create();
             ss.show();}}

        else if(id==R.id.logout){new logout(this);}



         else if (id==R.id.update){fm.beginTransaction().add(R.id.fragmentrr,new Updateapp()).commit();
         toolbar.setTitle("Update");
         fab.setVisibility(View.INVISIBLE);
         goty=3;}




        else if(id==R.id.feedback){fm.beginTransaction().add(R.id.fragmentrr,new Feedback()).commit();
             toolbar.setTitle("Feedback");
             fab.setVisibility(View.INVISIBLE);
        goty=4;}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
