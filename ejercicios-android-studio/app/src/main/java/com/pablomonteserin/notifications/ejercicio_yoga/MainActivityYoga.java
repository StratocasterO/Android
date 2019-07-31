package com.pablomonteserin.notifications.ejercicio_yoga;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.pablomonteserin.ejercicios.R;

public class MainActivityYoga extends AppCompatActivity {
    public static ImageView iv;
    public static Activity contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificaciones_yoga);
        contexto = this;
        iv = findViewById(R.id.imagen);

        startService(new Intent(this, CountDownTimerService.class));

        /*Intent intent = getIntent();
        if(intent!=null){
            if(intent.getExtras()!=null){

                iv.setImageResource(intent.getExtras().getInt("idDeLaFoto"));
            }
        }*/
    }

  /*
    @Override
  protected void onNewIntent(Intent intent) {
        int x = 10;
        Intent intent2 = getIntent();
        if(intent2!=null){
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
             //   iv.setImageResource(Integer.parseInt(bundle.getString("idDeLaFoto")));

            }else{
                finish();
                return;
            }
        }
    };
*/


    @Override
    protected void onStop() {
        super.onStop();
        //write your code here to start your service
    }


    public void cerrarServicio(View v){
        CountDownTimerService.timer.cancel();
        stopService(new Intent(this, CountDownTimerService.class));
        // finish();
    }

    public void onResume(){
        super.onResume();


        /*
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // Creates an explicit intent for an Activity in your app
            Intent resultIntent = new Intent(this, MainActivity.class);

            // The stack builder object will contain an artificial back stack for the
            // started Activity.
            // This ensures that navigating backward from the Activity leads out of
            // your app to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(MainActivity.class);
            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            builder.setContentIntent(resultPendingIntent);
        }

*/

        /*Intent notificationIntent = new Intent(this, SegundaActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);*/


        //builder.setLights(Color.GREEN, 500, 500);
        //builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

    }


    public void cambiarImagen(final int idImg){
        this.runOnUiThread(new Runnable(){
            @Override
            public void run() {
                iv.setImageResource(idImg);
            }});
    }
}
