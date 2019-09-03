package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Localizacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacion);
    }

    public void toast(View v) {
        startActivity(new Intent(this, Location_Toast.class));
    }

    public void mapa(View v) {
        startActivity(new Intent(this, Mapa.class));
    }

    public void centrado(View v) {
        startActivity(new Intent(this, Mapa_centered.class));
    }
}
