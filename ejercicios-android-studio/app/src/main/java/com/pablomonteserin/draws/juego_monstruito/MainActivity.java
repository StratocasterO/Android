package com.pablomonteserin.draws.juego_monstruito;

import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    int width;
    int height;
    Random random;
    static TextView tv;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_monstruito);
        handler = new Handler();
        iv = findViewById(R.id.monstruito);
        tv = findViewById(R.id.textomonstruito);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        random = new Random();


        handler.postDelayed(runnable, 1000);
    }

    public static void aumentarMarcador(int i) {
        tv.setText("" + i);
    }

    public void setRandomPosition(ImageView a1) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        a1.setX(x);
        a1.setY(y);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
      /* do what you need to do */
            setRandomPosition(iv);
            handler.postDelayed(this, 1000);
        }
    };
}
