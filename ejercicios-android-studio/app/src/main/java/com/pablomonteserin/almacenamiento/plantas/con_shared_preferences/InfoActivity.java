package com.pablomonteserin.almacenamiento.plantas.con_shared_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.pablomonteserin.ejercicios.R;


public class InfoActivity extends Activity {
	int idPlanta;
    private boolean tengoPlanta;
    private SharedPreferences preferences;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.almacenamiento_plantas_con_shared_preferences_info);
        preferences = getSharedPreferences("preferencias", MODE_PRIVATE);
		TextView tv_nombre = (TextView) findViewById(R.id.nombre);
		TextView frecuencia_riego = (TextView) findViewById(R.id.frecuencia_riego);
		TextView ubicacion = (TextView) findViewById(R.id.ubicacion);
		TextView otros_cuidados = (TextView) findViewById(R.id.otros_cuidados);
		ToggleButton tb = (ToggleButton)findViewById(R.id.toggleButton1);
		Planta planta = (Planta) getIntent().getExtras().getSerializable(
				MisPlantasActivity2.PLANTA);
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

	}
}
