package com.pablomonteserin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.animatium.AnimationSet;
import com.pablomonteserin.animatium.FrameByFrame;
import com.pablomonteserin.animatium.Interpolacion;
import com.pablomonteserin.animatium.Transition;
import com.pablomonteserin.animatium.TweenM;
import com.pablomonteserin.ejercicios.R;

public class Animatium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layouts_styles_animatium);
    }

    public void irATransition(View v){
        startActivity(new Intent(Animatium.this, Transition.class));
    }

    public void irATween(View v){
        startActivity(new Intent(Animatium.this, TweenM.class));
    }
    public void irAAnimationSet(View v){
        startActivity(new Intent(Animatium.this, AnimationSet.class));
    }
    public void irAFrameByFrame(View v){
        startActivity(new Intent(Animatium.this, FrameByFrame.class));
    }

    public void irAInterpolacion(View v){
        startActivity(new Intent(Animatium.this, Interpolacion.class));
    }


}
