package com.pablomonteserin.notifications;


import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pablomonteserin.ejercicios.R;

/**
 * Created by monty on 4/09/17.
 */

public class Notificaciones extends AppCompatActivity {
    private NotificationUtils mNotificationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificaciones);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // only for Oreo(8) and newer versions
            mNotificationUtils = new NotificationUtils(this, true);
        }
        else{
            mNotificationUtils = new NotificationUtils(this, false);
        }

        Notification.Builder nb = mNotificationUtils.getChannelNotification("Titulo", "Mensaje", R.raw.hakunamatata);
        mNotificationUtils.getManager().notify(101, nb.build());



    }
}
