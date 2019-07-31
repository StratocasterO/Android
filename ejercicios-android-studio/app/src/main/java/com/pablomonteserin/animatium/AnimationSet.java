package com.pablomonteserin.animatium;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.pablomonteserin.ejercicios.R;


public class AnimationSet extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animatium_animationset);

        final Button b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View arg0){
                Animation anim = AnimationUtils.loadAnimation(AnimationSet.this, R.anim.animation);
                b.startAnimation(anim);
            }
        });

    }



    public void onAnimationEnd(Animation arg0) {
        Log.d("traza", "Termina");
    }

    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }
}