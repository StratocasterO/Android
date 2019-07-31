package com.pablomonteserin.notifications.notificaciones_abriendo_activity;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

import com.pablomonteserin.ejercicios.R;

/**
 * Created by monty on 4/09/17.
 */

public class NotificacionesAbriendoUnActivity extends AppCompatActivity {
    private NotificationUtilsConPendingIntent mNotificationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificaciones);

        Intent notificationIntent = new Intent(this, NotificacionesActivityAbierto.class);


        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Titulo")
                .setContentIntent(pendingIntent);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // only for Oreo(8) and newer versions
            mNotificationUtils = new NotificationUtilsConPendingIntent(this, true);
        }
        else{
            mNotificationUtils = new NotificationUtilsConPendingIntent(this, false);
        }

        Notification.Builder nb = mNotificationUtils.getChannelNotification("Titulo", "Mensaje", R.raw.hakunamatata);
        mNotificationUtils.getManager().notify(101, nb.build());
    }
    }
