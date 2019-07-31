package com.pablomonteserin.layouts;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.pablomonteserin.ejercicios.R;


public class F_CargaImagenActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carga_imagen);
        
        
        ImageView iv = (ImageView) findViewById(R.id.imageView1);
        iv.setImageResource(R.drawable.android2);
    }
}