package com.pablomonteserin.almacenamiento.plantas.con_alarma;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.pablomonteserin.ejercicios.R;


public class InfoActivity3 extends Activity {
	int idPlanta;
	Planta planta;
    private boolean tengoPlanta;
    private SharedPreferences preferences;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.almacenamiento_plantas_con_alarma_info);
        preferences = getSharedPreferences("preferencias", MODE_PRIVATE);
		TextView tv_nombre = (TextView) findViewById(R.id.nombre);
		TextView frecuencia_riego = (TextView) findViewById(R.id.frecuencia_riego);
		TextView ubicacion = (TextView) findViewById(R.id.ubicacion);
		TextView otros_cuidados = (TextView) findViewById(R.id.otros_cuidados);
		ToggleButton tb = (ToggleButton)findViewById(R.id.toggleButton1);
		planta = (Planta) getIntent().getExtras().getSerializable(
				MisPlantasActivity3.PLANTA);
		idPlanta = planta.getId();
        tengoPlanta = preferences.getBoolean("" + idPlanta, false);
        if(tengoPlanta==true){
        	tb.setChecked(true);
        }else{
        	tb.setChecked(false);
        }

		ubicacion.setText(planta.getUbicacion());
		tv_nombre.setText(planta.getNombre());
		frecuencia_riego.setText(planta.getFrecuenciaRiego());
		otros_cuidados.setText(planta.getOtrosCuidados());

	}

	public void tengoEstaPlantaPulsado(View v) {
        tengoPlanta = !tengoPlanta;
		SharedPreferences sp = getSharedPreferences("preferencias", 0);
		SharedPreferences.Editor sharedPreferencesEditor = sp.edit();
		sharedPreferencesEditor.putBoolean(""+idPlanta,tengoPlanta);
		sharedPreferencesEditor.commit();
		AlarmManager am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
		Intent i = new Intent(this, AlarmaReceiver.class);
		i.putExtra("nombrePlanta", planta.getNombre());
		i.putExtra("idPlanta", planta.getId());
		PendingIntent	pi = PendingIntent.getBroadcast(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);



		if(tengoPlanta==true){
		
			Log.d("nombre info activity",planta.getNombre());

			// El segundo parametro indica cuando lo quiero lanzar,
			// System.currentTimeMillis() es un long correspondiente al momento
			// actual
			// El primer parámetro hace que el teléfono despierte aunque esté con la
			// pantalla apagada
			am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
					1 * 1000, pi);// repite cada 10 segundos
			
		}else{
			am.cancel(pi);
		}
	}
}
