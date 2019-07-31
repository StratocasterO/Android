package com.pablomonteserin.almacenamiento.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pablomonteserin.ejercicios.R;


public class Preferencias extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.almacenamiento_preferencias_preferencias);
    }
    public void irAVerResultados(View v){
        startActivity(new Intent(this, VerResultados.class));
    }
    public void irPreferencias(View v){
        startActivity(new Intent(this, PreferencesActivity.class));
    }
}
