package com.pablomonteserin.almacenamiento.plantas.basico;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;


public class InfoActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.almacenamientos_plantas_basico_info);

		TextView tv_nombre = (TextView) findViewById(R.id.nombre);
		TextView frecuencia_riego = (TextView) findViewById(R.id.frecuencia_riego);
		TextView ubicacion = (TextView)findViewById(R.id.ubicacion);
		TextView otros_cuidados = (TextView) findViewById(R.id.otros_cuidados);
		
		Planta planta = (Planta) getIntent().getExtras().getSerializable(
				MisPlantasActivity.PLANTA);
		ubicacion.setText(planta.getUbicacion());
		tv_nombre.setText(planta.getNombre());
		frecuencia_riego.setText(planta.getFrecuenciaRiego());
		otros_cuidados.setText(planta.getOtrosCuidados());

	}
}
