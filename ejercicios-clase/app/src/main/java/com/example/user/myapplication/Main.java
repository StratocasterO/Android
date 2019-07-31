package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.myapplication.PruebaAndroid.Prueba;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void Botones(View v){
        startActivity(new Intent(this, Botones.class));
    }

    public void Estilos(View v){
        startActivity(new Intent(this, Estilos.class));
    }

    public void Fragment(View v){
        startActivity(new Intent(this, Fragment.class));
    }

    public void Database(View v){
        startActivity(new Intent(this, BaseDatos.class));
    }

    public void Video(View v){
        startActivity(new Intent(this, Video.class));
    }

    public void BA(View v){startActivity(new Intent(this, BaseAdapter.class));}

    public void preferences(View v){startActivity(new Intent(this, Preferences.class));}

    public void peticiones(View v) {
        startActivity(new Intent(this, Peticiones_menu.class));
    }

    public void prueba(View v){startActivity(new Intent(this, Prueba.class));}

}

