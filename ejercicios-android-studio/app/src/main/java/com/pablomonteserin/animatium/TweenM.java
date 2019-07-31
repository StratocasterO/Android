package com.pablomonteserin.animatium;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.pablomonteserin.ejercicios.R;


public class TweenM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animatium_tween);
    }

    public void animar(View view){
        Animation anim = AnimationUtils.loadAnimation(TweenM.this, R.anim.animation);
        Button b = (Button)findViewById(R.id.button1);
        b.startAnimation(anim);
    }
}
