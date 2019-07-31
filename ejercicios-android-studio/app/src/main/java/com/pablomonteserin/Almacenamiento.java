package com.pablomonteserin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.almacenamiento.plantas.basico.MisPlantasActivity;
import com.pablomonteserin.almacenamiento.Ejercicio;
import com.pablomonteserin.almacenamiento.plantas.con_alarma.MisPlantasActivity3;
import com.pablomonteserin.almacenamiento.plantas.con_shared_preferences.MisPlantasActivity2;
import com.pablomonteserin.almacenamiento.preferencias.Preferencias;
import com.pablomonteserin.almacenamiento.Sqlite;
import com.pablomonteserin.ejercicios.R;

public class Almacenamiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.almacenamiento);
    }

    public void irAPreferencias(View v){
        startActivity(new Intent(Almacenamiento.this, Preferencias.class));
    }

    public void irASqlite(View v){
        startActivity(new Intent(Almacenamiento.this, Sqlite.class));
    }

    public void irEjercicio(View v){
        startActivity(new Intent(Almacenamiento.this, Ejercicio.class));
    }
    public void irAPlantas(View v){
        startActivity(new Intent(Almacenamiento.this, MisPlantasActivity.class));
    }
    public void irAPlantasConSharedPreferences(View v){
        startActivity(new Intent(Almacenamiento.this, MisPlantasActivity2.class));
    }
    public void irAPlantasConAlarma(View v){
        startActivity(new Intent(Almacenamiento.this, MisPlantasActivity3.class));
    }
}
