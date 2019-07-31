package com.pablomonteserin.styles;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.ejercicios.R;


public class CambiaBackground extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.styles_cambiabackground);
        View mlayout = findViewById(R.id.miLayout);
        mlayout.setBackgroundColor(Color.rgb(151, 19, 19));
    }
}
