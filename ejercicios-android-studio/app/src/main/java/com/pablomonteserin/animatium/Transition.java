package com.pablomonteserin.animatium;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.pablomonteserin.ejercicios.R;


public class Transition extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animatium_transition);
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(this);
    }



    public void onClick(View arg0) {
        Log.d("TRAZA", "Ha habido un click");
        if(arg0.getId()==R.id.button1){
            Log.d("TRAZA","Del boton 1");
            ImageView iv = (ImageView) findViewById(R.id.imageView1);
            TransitionDrawable td = (TransitionDrawable) iv.getDrawable();
            td.startTransition(1000);
        }
    }
}
