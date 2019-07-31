package com.pablomonteserin.notifications.ejercicio_yoga;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;



public class NotificationUtils2 extends ContextWrapper {

    private NotificationManager mManager;
    private boolean isAndroid8;
    private Activity contexto;

    public NotificationUtils2(Context base, boolean isAndroid8) {
        super(base);
        this.isAndroid8 = isAndroid8;
        this.contexto = MainActivityYoga.contexto;

    }

    @TargetApi(26)
    public void createChannels(String channelName, String channelId, int sound) {
        // create android channel
        NotificationChannel androidChannel = new NotificationChannel(channelId,
                channelName, NotificationManager.IMPORTANCE_DEFAULT);
        // Sets whether notifications posted to this channel should display notification lights
        androidChannel.enableLights(true);
        // Sets whether notification posted to this channel should vibrate.
        androidChannel.enableVibration(true);
        // Sets the notification light color for notifications posted to this channel
        androidChannel.setLightColor(Color.GREEN);
        // Sets whether notifications posted to this channel appear on the lockscreen or not
//        androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

        AudioAttributes att = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        androidChannel.setSound(Uri.parse("android.resource://"
                + getPackageName() + "/" + sound),att);

        getManager().createNotificationChannel(androidChannel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public Notification.Builder getChannelNotification(String title, int img, int sound, String channelName, String channelId) {
        Notification.Builder builder;
        Intent notificationIntent = contexto.getIntent();;

        //Intent notificationIntent = new Intent(this, MainActivity.class) .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        //notificationIntent.putExtra("idDeLaFoto", img);

        MainActivityYoga.iv.setImageResource(img);
        PendingIntent pendingIntent  = PendingIntent.getActivity(this, 0,
                notificationIntent,  PendingIntent.FLAG_UPDATE_CURRENT);

        if(isAndroid8){
            createChannels(channelName, channelId, sound);

            builder  = new Notification.Builder(getApplicationContext(), channelId);


        }else{
            builder = new Notification.Builder(getApplicationContext())
                    .setSound( Uri.parse("android.resource://"
                            + getPackageName() + "/" + sound));
        }

        builder .setContentTitle(title)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setStyle(new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), img)));

        return builder;
    }



}

