package com.iitr.kaishu.timetable;




import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

Notification notif;
    ProgressBar progress1;
    TextView signin;
    Button login;
    EditText username,password;
  TextView mmmm;
    Button nn;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Log In");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#10163A")));
        SQLiteDatabase get = new Databasemain(getApplicationContext()).getReadableDatabase();




username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        progress1= (ProgressBar)findViewById(R.id.progress1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);






mmmm= (TextView) findViewById(R.id.go);
        login =(Button)findViewById(R.id.login);

        login.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    login.setBackgroundDrawable(MainActivity.this.getResources().getDrawable(R.drawable.clicked));
                    if (isOnline()){
                        final String usernames = username.getText().toString().toUpperCase().trim();
                        final String passwords = password.getText().toString().trim();


                        if(usernames.equals("")||passwords.equals("")){
                              Toast.makeText(MainActivity.this,"Fill all fileds" , Toast.LENGTH_SHORT).show();
                        }
                        else {

                            login.setVisibility(View.INVISIBLE);
                            progress1.setVisibility(View.VISIBLE);
                            signin.setClickable(false);
                            mmmm.setClickable(false);

                                    final FirebaseDatabase logind= FirebaseDatabase.getInstance();
                                    final DatabaseReference logggin = logind.getReference("users");

                                    logggin.addChildEventListener(new ChildEventListener() {
                                        @Override
                                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                            if(dataSnapshot.hasChild(usernames)){
                                                 String gg= dataSnapshot.child(usernames).getValue(String.class);
                                               if(gg.equals(passwords)){
                                                   Toast.makeText(MainActivity.this, "WELCOME", Toast.LENGTH_LONG).show();
                                                   SharedPreferences.Editor editor = getSharedPreferences("login", MODE_PRIVATE).edit();
                                                   editor.putInt("loginsuccess", 2);
                                                   editor.apply();
                                                   SharedPreferences.Editor editor2=getSharedPreferences("logout", MODE_PRIVATE).edit();
                                                   editor2.putInt("logout",1);
                                                   editor.apply();
                                                   SharedPreferences.Editor editor1 = getSharedPreferences("name", MODE_PRIVATE).edit();
                                                   editor1.putString("name", usernames);
                                                   editor1.apply();
                                                   Intent heroe = new Intent(MainActivity.this, Main3Activity.class);
                                                   startActivity(heroe);
                                                   finish();
                                               }
                                               else{
                                                   Toast.makeText(MainActivity.this, "Incorrect Credentials", Toast.LENGTH_LONG).show();
                                                   progress1.setVisibility(View.INVISIBLE);
                                                   login.setVisibility(View.VISIBLE);
                                                   signin.setClickable(true);
                                                   mmmm.setClickable(true);
                                               }

                                            }
                                            else {
                                                Toast.makeText(MainActivity.this, "Username does not exist", Toast.LENGTH_SHORT).show();
                                                progress1.setVisibility(View.INVISIBLE);
                                                login.setVisibility(View.VISIBLE);
                                                signin.setClickable(true);
                                                mmmm.setClickable(true); }
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












                        }}
                    else{
                        Toast.makeText(MainActivity.this, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                    }

                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    login.setBackgroundDrawable(MainActivity.this.getResources().getDrawable(R.drawable.login_button));
                }

                return false;
            }
        });


imageView2.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {

        return false;
    }
});


    signin=(TextView)findViewById(R.id.textView14);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent sign = new Intent (MainActivity.this,Main4Activity.class);
                startActivity(sign);

            }
        });

mmmm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent tttt= new Intent (MainActivity.this,Main3Activity.class);
        tttt.putExtra("Account",false);
        startActivity(tttt);


    }
});


    }
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferences kjh= MainActivity.this.getSharedPreferences("logout",this.MODE_PRIVATE);
        int uip=kjh.getInt("logout",1);
        if(uip==2){
            this.finish();
            finishAffinity();
        }
    }
}
