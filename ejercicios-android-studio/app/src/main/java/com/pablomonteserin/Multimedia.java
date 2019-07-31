package com.pablomonteserin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.ejercicios.R;
import com.pablomonteserin.multimedia.Audio;
import com.pablomonteserin.multimedia.Camera;
import com.pablomonteserin.multimedia.Streaming;
import com.pablomonteserin.multimedia.Video;

public class Multimedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multimedia);
    }

    public void irAAudio(View v){
        startActivity(new Intent(Multimedia.this, Audio.class));
    }
    public void irACamera(View v){
        startActivity(new Intent(Multimedia.this, Camera.class));
    }

    public void irStreaming(View v){
        startActivity(new Intent(Multimedia.this, Streaming.class));
    }

    public void irAVideo(View v){
        startActivity(new Intent(Multimedia.this, Video.class));
    }

}
