package com.pablomonteserin.notifications.ejercicio_yoga;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.pablomonteserin.ejercicios.R;

/**
 * Created by monty on 3/09/17.
 */


public class CountDownTimerService extends Service {
    NotificationManager mNotificationManager;
    String CHANNEL_ID = "MY_CHANNEL_ID";

    public static CountDownTimer timer;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        final Service service = this;

        timer = new CountDownTimer(30000, 10000) {//90000

            private int counter;

            public void onTick(long millisUntilFinished) {


                NotificationUtils2 mNotificationUtils = null;
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    mNotificationUtils = new NotificationUtils2(service, true);
                }
                else{
                    mNotificationUtils = new NotificationUtils2(service, false);
                }
                if (counter == 0){
                    Notification.Builder nb = mNotificationUtils.getChannelNotification("Apertura Abductores", R.drawable.aperturaabductores, R.raw.aperturaabductores, "Apertura Abductores","Apertura Abductores");
                    mNotificationUtils.getManager().notify(101, nb.build());
                    counter++;
                }else if(counter ==1){
                    Notification.Builder nb = mNotificationUtils.getChannelNotification("Torsión Izquierda", R.drawable.torsion, R.raw.torsionizquierda, "Torsion izquierda","Torsion izquierda");
                    mNotificationUtils.getManager().notify(101, nb.build());
                    counter++;
                }else if(counter ==2){
                    Notification.Builder nb = mNotificationUtils.getChannelNotification("Torsión derecha", R.drawable.torsion, R.raw.torsionderecha, "Torsión derecha","Torsión derecha");
                    mNotificationUtils.getManager().notify(101, nb.build());
                    counter++;
                }
            }
            public void onFinish() {
            }
        }.start();

    }
}
