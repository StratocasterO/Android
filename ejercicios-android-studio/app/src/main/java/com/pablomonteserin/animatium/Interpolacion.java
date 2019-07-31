package com.pablomonteserin.animatium;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.pablomonteserin.ejercicios.R;


public class Interpolacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animatium_interpolacion);

        final Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Animation anim = AnimationUtils.loadAnimation(Interpolacion.this, R.anim.animation);
                b.startAnimation(anim);
            }
        });
    }


}
