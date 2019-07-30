package com.example.user.myapplication.PruebaAndroid;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.myapplication.R;

public class Prueba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

    public void save (View v){
        startActivity(new Intent(this, SavePrefs.class));
    }

    public void load (View v){
        startActivity(new Intent(this, LoadPrefs.class));
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void notification (View v){
        NotificationUtils mNotificationUtils;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // only for Oreo(8) and newer versions
            mNotificationUtils = new NotificationUtils(this, true);
        }else{
            mNotificationUtils = new NotificationUtils(this, false);
        }
        Notification.Builder nb = mNotificationUtils.getChannelNotification("Hola", "Buenos días");
        mNotificationUtils.getManager().notify(101, nb.build());
    }

    public void list (View v){
        startActivity(new Intent(this, ListViewEmpleados.class));
    }
}
