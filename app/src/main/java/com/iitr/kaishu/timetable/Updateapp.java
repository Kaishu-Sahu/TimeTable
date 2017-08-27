package com.iitr.kaishu.timetable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;

/**
 * Created by Kaishu on 6/7/2017.
 */

public class Updateapp extends Fragment {
View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                        Bundle savedInstanceState) {
      v = inflater.inflate(R.layout.updateapp, container, false);

        TextView verion=(TextView)v.findViewById(R.id.version);
        verion.setText(BuildConfig.VERSION_NAME);
        Handler ghj = new Handler();
        ghj.postDelayed(new Runnable() {
            @Override
            public void run() {
                ProgressBar ubar=(ProgressBar) v.findViewById(R.id.barupdate);
                ubar.setVisibility(View.INVISIBLE);
                SharedPreferences pddref = getActivity().getSharedPreferences("versionnet", getActivity().MODE_PRIVATE);
                String posst  = pddref.getString("versionnet", "kaishu");
                if(posst.equals(BuildConfig.VERSION_NAME)||posst.equals("kaishu")){TextView yhu= (TextView) v.findViewById(R.id.check);
                yhu.setText("Your app is up to date.");}
                else {
                    TextView yhu = (TextView) v.findViewById(R.id.check);
                    yhu.setText("A newer version of app is available.");
                    final Button uhi = (Button) v.findViewById(R.id.Updateb);
                    uhi.setVisibility(View.VISIBLE);
                   uhi.setOnTouchListener(new View.OnTouchListener() {
                       @Override
                       public boolean onTouch(View v, MotionEvent event) {
                           if(event.getAction()==MotionEvent.ACTION_DOWN){


                               uhi.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.clicked));
                               String urlString=Constants.website+"dwn.php";
                               Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                               intent.setPackage(null);
                               startActivity(intent);
                           }
                           if(event.getAction()==MotionEvent.ACTION_UP){
                               uhi.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.login_button));}

                           return false;
                       }
                   });


                }      }
        },1200);

        return v;}
    }
