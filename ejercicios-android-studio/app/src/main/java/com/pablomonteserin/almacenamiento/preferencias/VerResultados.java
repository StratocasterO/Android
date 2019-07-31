package com.pablomonteserin.almacenamiento.preferencias;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;


public class VerResultados extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.almacenamiento_preferencias_verresultados);
		TextView tv = findViewById(R.id.textview1);
		TextView tv2 = findViewById(R.id.textview2);
		
SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

			tv.setText(""+sp.getBoolean("primero", false));
		tv2.setText(""+sp.getBoolean("segundo", false));		

	}	
	
}
