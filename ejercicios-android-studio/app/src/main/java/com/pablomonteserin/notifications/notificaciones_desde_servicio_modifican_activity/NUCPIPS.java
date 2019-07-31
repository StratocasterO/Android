package com.pablomonteserin.notifications.notificaciones_desde_servicio_modifican_activity;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;

import com.pablomonteserin.notifications.notificaciones_desde_servicio_modifican_activity.NotificacionesActivityAbierto2;

/**
 * Created by monty on 30/09/17. NUCPIPS
 */

public class NUCPIPS extends ContextWrapper {


    private NotificationManager mManager;
    private boolean isAndroid8;
    public static final String ANDROID_CHANNEL_ID = "com.pablomonteserin.ANDROID";
    public static final String ANDROID_CHANNEL_NAME = "ANDROID CHANNEL";

    public NUCPIPS(Context base, boolean isAndroid8) {
        super(base);
        this.isAndroid8 = isAndroid8;

        if(isAndroid8){
            createChannels();
        }
    }

    @TargetApi(26)
    public void createChannels() {
        // create android channel
        NotificationChannel androidChannel = new NotificationChannel(ANDROID_CHANNEL_ID,
                ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        // Sets whether notifications posted to this channel should display notification lights
        androidChannel.enableLights(true);
        // Sets whether notification posted to this channel should vibrate.
        androidChannel.enableVibration(true);
        // Sets the notification light color for notifications posted to this channel
        androidChannel.setLightColor(Color.GREEN);
        // Sets whether notifications posted to this channel appear on the lockscreen or not
//        androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

        getManager().createNotificationChannel(androidChannel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public Notification.Builder getChannelNotification(String title, String body,int sound) {
        Notification.Builder builder;
        Intent notificationIntent = new Intent(this, NotificacionesActivityAbierto2.class) .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        notificationIntent.putExtra("saludo", "adios");
        PendingIntent pendingIntent  = PendingIntent.getActivity(this, 0,
                notificationIntent,  PendingIntent.FLAG_ONE_SHOT);
        if(isAndroid8){
            builder  = new Notification.Builder(getApplicationContext(), ANDROID_CHANNEL_ID);
        }else{
            builder = new Notification.Builder(getApplicationContext());
        }
        builder .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
        return builder;
    }
}

