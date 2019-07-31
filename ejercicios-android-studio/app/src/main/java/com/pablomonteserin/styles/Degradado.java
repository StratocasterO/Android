package com.pablomonteserin.styles;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.ejercicios.R;


public class Degradado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.styles_degradado);
        View mlayout = findViewById(R.id.fondo);
        mlayout.setBackgroundResource(R.drawable.degradado);


    }
}
