package com.iitr.kaishu.timetable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main4Activity extends AppCompatActivity {
Button asdf;
    ProgressBar progress2;
    EditText usernamea,passworda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Create Account");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#10163A")));
        usernamea = (EditText) findViewById(R.id.suser);
        passworda = (EditText) findViewById(R.id.spass);
        progress2 = (ProgressBar) findViewById(R.id.progress2);

        asdf = (Button) findViewById(R.id.submit);
        asdf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    asdf.setBackgroundDrawable(Main4Activity.this.getResources().getDrawable(R.drawable.clicked));
                    if (isOnline()) {
                       final String usernameaa = usernamea.getText().toString().toUpperCase().trim();
                      final  String passwordaa = passworda.getText().toString().trim();

                        if (usernameaa.equals("") || passwordaa.equals("")) {
                            Toast.makeText(Main4Activity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                        } else {

                            Handler hande = new Handler();
                            progress2.setVisibility(View.VISIBLE);
                            asdf.setVisibility(View.INVISIBLE);

                            FirebaseDatabase fbfbfb = FirebaseDatabase.getInstance();
                            DatabaseReference dbdbdb = fbfbfb.getReference("users");
                           final DatabaseReference sese = dbdbdb.child("members");
                         dbdbdb.addChildEventListener(new ChildEventListener() {
                             @Override
                             public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                 if(!dataSnapshot.hasChild(usernameaa)){
                                     sese.child(usernameaa).setValue(passwordaa);
                                     Toast.makeText(Main4Activity.this, "Account Created", Toast.LENGTH_SHORT).show();
                                     SharedPreferences.Editor editor = getSharedPreferences("login", MODE_PRIVATE).edit();
                                     editor.putInt("loginsuccess", 2);
                                     editor.apply();
                                     SharedPreferences.Editor editor2=getSharedPreferences("logout", MODE_PRIVATE).edit();
                                     editor2.putInt("logout",1);
                                     editor.apply();
                                     SharedPreferences.Editor editor1 = getSharedPreferences("name", MODE_PRIVATE).edit();
                                     editor1.putString("name", usernameaa);
                                     editor1.apply();
                                     Intent heroef = new Intent(Main4Activity.this, Main3Activity.class);
                                     startActivity(heroef);
                                     finish();

                                 }
                                 else {
                                     Toast.makeText(Main4Activity.this, "Username Already Exists", Toast.LENGTH_SHORT).show();
                                     progress2.setVisibility(View.INVISIBLE);
                                     asdf.setVisibility(View.VISIBLE);
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




                        }
                    } else {
                        Toast.makeText(Main4Activity.this, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    asdf.setBackgroundDrawable(Main4Activity.this.getResources().getDrawable(R.drawable.login_button));
                }
          return false;  }
        });

    }
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();}

}
