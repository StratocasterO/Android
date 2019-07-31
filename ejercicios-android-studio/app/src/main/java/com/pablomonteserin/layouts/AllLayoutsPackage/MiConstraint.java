package com.pablomonteserin.layouts.AllLayoutsPackage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pablomonteserin.ejercicios.R;


public class MiConstraint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("llega", "llega");
        setContentView(R.layout.alllayouts_constraint);
    }
}
