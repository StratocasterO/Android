package com.pablomonteserin.multimedia;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.ejercicios.R;

import java.io.IOException;
import java.net.MalformedURLException;

public class Streaming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multimedia_streaming);
    }


    public void suenaAudio(View v) {
        String stringUrl = "https://pablomonteserin.com/apuntes/web/html/html/ex/HakunaMatataItMeansNoWorries.mp3";
        try {
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(stringUrl);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });

            /*MediaPlayer mediaPlayer = MediaPlayer.create(this, Uri.parse("http://vprbbc.streamguys.net:80/vprbbc24.mp3"));
            mediaPlayer.start();*/
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
