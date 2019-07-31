package com.pablomonteserin.almacenamiento.plantas.con_alarma;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.pablomonteserin.ejercicios.R;


//Broadcast: difundir a todos. Mando una señal que será escuchada por todas las aplicaciones preparadas para escuchar.
//SERÁ NECESARIO METER ESTE CÓDIGO EN EN NODO APPLICATION DEL MANIFEST:
//        <receiver android:name="com.pablomonteserin.almacenamiento.plantas.con_alarma.AlarmaReceiver" >


public  class AlarmaReceiver extends BroadcastReceiver{
	   private static int i=0;
		@Override
		public void onReceive(Context arg0, Intent arg1) {
			i++;


			NotificationManager nm = (NotificationManager)arg0.getSystemService(arg0.getApplicationContext().NOTIFICATION_SERVICE);
			//icono de la notificacion,texto, tiempo que aparecerá indicado enla notificacion
			String nombrePlanta = arg1.getStringExtra("nombrePlanta");
			int idPlanta = arg1.getIntExtra("idPlanta",0);
			Log.d("id", ""+idPlanta);
			Log.d("nombrePlanta",nombrePlanta);

			//notify.sound = Uri.parse("android.resource://com.pablomonteserin/"+ R.raw.important); 
			//El cero es la id de la notificación. Luego, la utilizaré para borrar la segunda Activity


			Notification notify = new Notification.Builder(arg0)
					.setContentTitle("Toca regar!")
					.setContentText("Hay que regar:" + nombrePlanta)
					.setSmallIcon(R.drawable.icon)
					.build();

			nm.notify(idPlanta, notify);

		}
    	
    }