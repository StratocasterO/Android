package com.pablomonteserin.animatium;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.pablomonteserin.ejercicios.R;


public class FrameByFrame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animatium_framebyframe);

        Button b = (Button) findViewById(R.id.button1);



        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                ImageView iv = (ImageView) findViewById(R.id.imageView1);
                iv.setBackgroundResource(R.drawable.animation);
                AnimationDrawable animation = (AnimationDrawable) iv.getBackground();
                animation.start();
            }
        });

    }
}
