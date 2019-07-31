package com.pablomonteserin.multimedia;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pablomonteserin.ejercicios.R;

public class Audio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multimedia_audio);

        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(Audio.this, R.raw.hakunamatata);
                mp.start();
            }
        });
    }
}
