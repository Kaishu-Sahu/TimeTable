package com.iitr.kaishu.timetable;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by Kaishu on 6/7/2017.
 */

public class logout {
    public  logout (final Context context){


        Dialog ss= new AlertDialog.Builder(context)
                .setTitle("Are You Sure ?")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences.Editor editor = context.getSharedPreferences("login", MODE_PRIVATE).edit();
                        editor.putInt("loginsuccess", 1);
                        editor.apply();
                        Intent logout=new Intent(context,MainActivity.class);
                        context.startActivity(logout);
                        SharedPreferences.Editor editorggg = context.getSharedPreferences("logout", MODE_PRIVATE).edit();
                        editorggg.putInt("logout", 2);
                        editorggg.apply();

                    }
                })
                .setNegativeButton("Cancel",null)
                .create();
        ss.show();
    }
}
