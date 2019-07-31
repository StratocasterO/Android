package com.pablomonteserin.mapas.Monumentos;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;


public class LugarActivity extends AppCompatActivity {

	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mapas_confragment_lugar);
	        Monumento monumento = (Monumento) getIntent().getExtras().getSerializable(Main.MONUMENTO);
	 
	        TextView tv = (TextView)findViewById(R.id.textView1);
	        tv.setText(monumento.getDescripcion());
	        setTitle(monumento.getNombre());
 
	  }
}
