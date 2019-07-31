package com.pablomonteserin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.ejercicios.R;
import com.pablomonteserin.mapas.LocationManagerActivity;
import com.pablomonteserin.mapas.LocationManagerConInterfaceSoloFuncionaConCambioDePosicion;
import com.pablomonteserin.mapas.Monumentos.Main;

public class Maps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);
    }

    public void irALocationManager(View v){
        startActivity(new Intent(Maps.this, LocationManagerActivity.class));
    }

    public void irALocationManagerConInterface(View v){
        startActivity(new Intent(Maps.this, LocationManagerConInterfaceSoloFuncionaConCambioDePosicion.class));
    }

    public void irAPintarMonumentos(View v){
        startActivity(new Intent(Maps.this, Main.class));
    }



}
