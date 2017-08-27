package com.iitr.kaishu.timetable;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;

import static android.content.Context.MODE_PRIVATE;

public class Change extends Fragment implements View.OnClickListener{

    Button dfg;
    Button dfgf;
    Button done;
    RelativeLayout r1;
    LinearLayout r2;
    LinearLayout r3;
    FirebaseDatabase database;
    String jakalg[];
    String gotitt;
    String username;
    Button example1;
    Button example;
    String newcolord;
    String newcolors;
    String newnames;
    String newrooms;
    String newinfos;
    String newnewcol;
    EditText newname;
    EditText newroom;
    EditText newinfo;
    Spinner newcolor;
    View v;
    DatabaseReference myReff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.activity_change, container, false);

        newname= (EditText)v.findViewById(R.id.newname);
        newroom = (EditText)v.findViewById(R.id.newroom);
        newinfo = (EditText)v.findViewById(R.id.newinfo);
        newcolor = (Spinner)v.findViewById(R.id.spinner);
        done=(Button)v.findViewById(R.id.done);
        example1=(Button)v.findViewById(R.id.example1);
        example=(Button)v.findViewById(R.id.example);
        String[] name = {"name", "room", "color", "info", "boss"};
        SQLiteDatabase get = new Databasemain(getContext()).getReadableDatabase();
        Cursor getc = get.query("S1", name, null, null, null, null, null);
        CursorWraperdata dd = new CursorWraperdata(getc);
        int a = R.id.tutton11;
        try {
            dd.moveToFirst();
            while (!dd.isAfterLast()) {
                String[] data = dd.getdata();
                int id = a;int back=123;
                Button bt=(Button)v.findViewById(id);
                bt.setOnClickListener(this);
                bt.setText(data[0]);
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

                bt.setBackgroundDrawable(getActivity().getResources().getDrawable(back));


                a = a + 1;
                dd.moveToNext();
            }
        } finally {
            dd.close();
        }
        r1 = (RelativeLayout)v.findViewById(R.id.r1);
        r2 = (LinearLayout)v.findViewById(R.id.r2);
        r3 = (LinearLayout) v.findViewById(R.id.r3);



        dfg= (Button)v.findViewById(R.id.cancelclass);
        dfgf= (Button)v.findViewById(R.id.edit);


        return v; }
    public void onClick(View v) {

        int gotitit=v.getId();
        gotitt=Integer.toString(gotitit);







        r2.setVisibility(View.INVISIBLE);
        r3.setVisibility(View.INVISIBLE);
        r1.setVisibility(View.VISIBLE);
        String[] nameddd = {"name", "room", "color", "info", "boss"};
        SQLiteDatabase getghg = new Databasemain(getContext()).getReadableDatabase();
        String where[]={gotitt};
        Cursor getcsg = getghg.query("S1", nameddd, "id=?",where, null, null, null);
        CursorWraperdata ddsg = new CursorWraperdata(getcsg);
        ddsg.moveToFirst();
        jakalg=ddsg.getdata();
        example1.setText(jakalg[0]);int backk=123;
        example.setText(jakalg[0]);
        if(jakalg[2].equals("r")){backk=R.drawable.red;}
        else if(jakalg[2].equals("g")){backk=R.drawable.green;}
        else if(jakalg[2].equals("b")){backk=R.drawable.blue;}
        else if(jakalg[2].equals("y")){backk=R.drawable.yellow;}
        else if(jakalg[2].equals("drc")){backk=R.drawable.redcancel;}
        else if(jakalg[2].equals("dgc")){backk=R.drawable.greencancel;}
        else if(jakalg[2].equals("dbc")){backk=R.drawable.bluecancel;}
        else if(jakalg[2].equals("dyc")){backk=R.drawable.yellowcancel;}
        else if(jakalg[2].equals("dr")){backk=R.drawable.dred;}
        else if(jakalg[2].equals("dy")){backk=R.drawable.dyellow;}
        else if(jakalg[2].equals("dg")){backk=R.drawable.dgreen;}
        else if(jakalg[2].equals("db")){backk=R.drawable.dblue;}
        else if(jakalg[2].equals("o")){backk=R.drawable.orange;}
        else if(jakalg[2].equals("doc")){backk=R.drawable.orangecancel;}
        else if(jakalg[2].equals("do")){backk=R.drawable.dorange;}
        else if(jakalg[2].equals("dd")){backk=R.drawable.deepblue;}
        else if(jakalg[2].equals("dddc")){backk=R.drawable.deepbluecancel;}
        else if(jakalg[2].equals("ddd")){backk=R.drawable.ddeepblue;}
        else if(jakalg[2].equals("gg")){backk=R.drawable.grey;}
        else if(jakalg[2].equals("dggc")){backk=R.drawable.greycancel;}
        else if(jakalg[2].equals("dgg")){backk=R.drawable.dgrey;}
        example1.setBackgroundDrawable(getContext().getResources().getDrawable(backk));
        example.setBackgroundDrawable(getContext().getResources().getDrawable(backk));
        dfg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if(event.getAction()==MotionEvent.ACTION_DOWN){

                    dfg.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.clicked));
                    if(isOnline()){
                        database = FirebaseDatabase.getInstance();




                        if(!jakalg[3].equals("Cancelled")&&!jakalg[3].equals("")){
                            if(jakalg[4].equals("")){
                            newcolord=jakalg[2]+"c";}
                            else{
                                newcolord="d"+jakalg[2]+"c";
                            }
                            SharedPreferences pref = getActivity().getSharedPreferences("name", getActivity().MODE_PRIVATE);
                            username = pref.getString("name", "kk");
                            Dialog ss= new AlertDialog.Builder(getContext())
                                    .setTitle("Are You Sure ?")
                                    .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String [] namevv={"name","room","color","info","boss"};
                                            String[] asdvv={gotitt};
                                            SQLiteDatabase fdbvv= new Databasemain(getActivity()).getReadableDatabase();
                                            Cursor getcdvv= fdbvv.query("S2",namevv,"id=?",asdvv,null,null,null);
                                            CursorWraperdata ddvv= new CursorWraperdata(getcdvv);
                                            ddvv.moveToFirst();
                                            String[] datadbvv = ddvv.getdata();
                                            if(datadbvv[1].equals("")){dialogno();
                                               }
                                            else {
                                            same_for_other();}


                                        }
                                    })
                                    .setNegativeButton("Cancel",null)
                                    .create();
                            ss.show();

                        }
                        else {
                            Toast.makeText(getActivity(), "Impossible Task", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getActivity(), "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                    }

                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    dfg.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.login_button));
                }

                return false;
            }
        });
        dfgf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    dfgf.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.clicked));
                    r1.setVisibility(View.INVISIBLE);
                    r2.setVisibility(View.VISIBLE);


                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    dfgf.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.login_button));
                }

                return false;
            }
        });

done.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
       if(event.getAction()==MotionEvent.ACTION_DOWN){
           done.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.clicked));

                   newnames=newname.getText().toString().toUpperCase().trim();
                   newrooms=newroom.getText().toString().toUpperCase().trim();
                   newinfos=newinfo.getText().toString().trim(); newnewcol="r";
                   newcolors=newcolor.getSelectedItem().toString();
                   if(newcolors.equals("GREEN")){ newnewcol = "g";}
                   else if(newcolors.equals("RED")){ newnewcol = "r";}
                   else if(newcolors.equals("YELLOW")){newnewcol = "y";}
                   else if(newcolors.equals("BLUE")){ newnewcol = "b";}
                   else if(newcolors.equals("ORANGE")){ newnewcol = "o";}
                   else if(newcolors.equals("VIOLET")){ newnewcol = "dd";}
                   else if(newcolors.equals("GREY")){ newnewcol = "gg";}
                   if(isOnline()) {if(!newnames.equals("")&&!newrooms.equals("")&&!newinfos.equals("")){
                                if (!newnames.equals(jakalg[0]) || !newrooms.equals(jakalg[1]) || !newnewcol.equals(jakalg[2]) || !newinfos.equals(jakalg[3])){

                                 Dialog sffs= new AlertDialog.Builder(getContext())
                                            .setTitle("Do you want the same change for Sociology ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    SharedPreferences pref1 = getActivity().getSharedPreferences("request_id", MODE_PRIVATE);
                                                    String request_id_shared = pref1.getString("request_id", "0");

                                                    int temp_req = Integer.parseInt(request_id_shared)+1;
                                                    int temp_req_1=temp_req+1;
                                                    String request_id_shared_1 = Integer.toString(temp_req);
                                                    String request_id_shared_11 = Integer.toString(temp_req_1);


                                                    database = FirebaseDatabase.getInstance();
                                                 DatabaseReference myRefrrf = database.getReference("data12");
                                                    DatabaseReference childRefrrf = myRefrrf.push();
                                                    SharedPreferences pref = getActivity().getSharedPreferences("name", getContext().MODE_PRIVATE);
                                                    String usernamesd = pref.getString("name", "kk");
                                                    childRefrrf.setValue( new updateinformation(gotitt,newnames,newrooms,newnewcol,newinfos,usernamesd,"S2",request_id_shared_1));
                                                    DatabaseReference childRefrrfoo = myRefrrf.push();
                                                 childRefrrfoo.setValue( new updateinformation(gotitt,newnames,newrooms,newnewcol,newinfos,usernamesd,"S1",request_id_shared_11));
                                                    Toast.makeText(getContext(), "Successfully updated", Toast.LENGTH_SHORT).show();
                                                    Intent jhjh= new Intent(getContext(),Main3Activity.class);
                                                    getContext().startActivity(jhjh);



                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    SharedPreferences pref = getActivity().getSharedPreferences("name", getContext().MODE_PRIVATE);
                                                    String usernamesds= pref.getString("name", "kk");
                                                    database = FirebaseDatabase.getInstance();
                                                   myReff = database.getReference("data12");
                                                    DatabaseReference childReff = myReff.push();
                                                    SharedPreferences pref1 = getActivity().getSharedPreferences("request_id", MODE_PRIVATE);
                                                    String request_id_shared = pref1.getString("request_id", "0");

                                                    int temp_req = Integer.parseInt(request_id_shared)+1;
                                                    String request_id_shared_1 = Integer.toString(temp_req);


                                                    childReff.setValue( new updateinformation(gotitt,newnames,newrooms,newnewcol,newinfos,usernamesds,"S1",request_id_shared_1));
                                                    Toast.makeText(getContext(), "Successfully updated", Toast.LENGTH_SHORT).show();
                                                    Intent jhjh= new Intent(getContext(),Main3Activity.class);
                                                    getContext().startActivity(jhjh);
                                                }
                                            })
                                            .create();
                                    sffs.show();


                                }
                                else{
                                    Toast.makeText(getContext(), "Impossible Task", Toast.LENGTH_SHORT).show();
                                }}else{Toast.makeText(getActivity(), "Fill all fields", Toast.LENGTH_SHORT).show();}}
                   else{
                       Toast.makeText(getActivity(), "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                   }


       }
        else if (event.getAction()==MotionEvent.ACTION_UP){
           done.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.login_button));
       }
        return false;
    }
});







    }
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();}


    public void same_for_other (){
   Dialog Dialogss = new AlertDialog.Builder(getContext())
            .setTitle("Do you want the same change for Sociology ?")
            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences pref1 = getActivity().getSharedPreferences("request_id", MODE_PRIVATE);
                    String request_id_shared = pref1.getString("request_id", "0");

                    int temp_req = Integer.parseInt(request_id_shared)+1;
                    int temp_req_1=temp_req+1;
                    String request_id_shared_1 = Integer.toString(temp_req);
                    String request_id_shared_11 = Integer.toString(temp_req_1);


                   myReff = database.getReference("data12");
                    DatabaseReference childReff = myReff.push();
                    childReff.setValue( new updateinformation(gotitt,jakalg[0],"",newcolord,"Cancelled",username,"S1",request_id_shared_1));
                    DatabaseReference childReiff = myReff.push();
                    childReiff.setValue( new updateinformation(gotitt,jakalg[0],"",newcolord,"Cancelled",username,"S2",request_id_shared_11));

                    Toast.makeText(getContext(), "Successfully updated", Toast.LENGTH_SHORT).show();
                    Intent jhjh= new Intent(getContext(),Main3Activity.class);
                    getContext().startActivity(jhjh);

                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialogno();
                }
            })
            .create();
    Dialogss.show();
}
    @Override
    public void onResume() {

        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    LinearLayout r3=(LinearLayout)v.findViewById(R.id.r3);
                    RelativeLayout r1=(RelativeLayout)v.findViewById(R.id.r1);
                    LinearLayout r2=(LinearLayout)v.findViewById(R.id.r2);
                    FragmentManager fm = getActivity().getSupportFragmentManager();


                    FragmentManager juiop=getActivity().getSupportFragmentManager();
                    Fragment jj=juiop.findFragmentById(R.id.fragmentrr);

                    if(jj instanceof content_main){
                        getActivity().finish();
                        getActivity().finishAffinity();
                    }






                    if(r3.getVisibility()==View.VISIBLE){fm.beginTransaction().add(R.id.fragmentrr,new content_main()).commit();
                        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
                        toolbar.setTitle("TimeTable");
                        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
                        fab.setVisibility(View.VISIBLE);



                    }
                    if(r1.getVisibility()==View.VISIBLE){
                        r1.setVisibility(View.INVISIBLE);
                        r3.setVisibility(View.VISIBLE);

                    }
                    if(r2.getVisibility()==View.VISIBLE){
                        r2.setVisibility(View.INVISIBLE);
                        r1.setVisibility(View.VISIBLE);

                    }

                    return true;

                }

                return false;
            }
        });
    }
    public void dialogno(){
        myReff = database.getReference("data12");


        DatabaseReference childReff = myReff.push();
        SharedPreferences pref1 = getActivity().getSharedPreferences("request_id", MODE_PRIVATE);
        String request_id_shared = pref1.getString("request_id", "0");

        int temp_req = Integer.parseInt(request_id_shared)+1;
        String request_id_shared_1 = Integer.toString(temp_req);



        childReff.setValue( new updateinformation(gotitt,  jakalg[0],  "", newcolord, "Cancelled",username,"S1",request_id_shared_1));
        Toast.makeText(getContext(), "Successfully updated", Toast.LENGTH_SHORT).show();
        Intent jhjh= new Intent(getContext(),Main3Activity.class);
        getContext().startActivity(jhjh);
    }
}
