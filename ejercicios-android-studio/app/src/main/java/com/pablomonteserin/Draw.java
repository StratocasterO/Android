package com.pablomonteserin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.draws.circulo.Main;
import com.pablomonteserin.draws.circulo_con_atributos.CirculoConAtributos;
import com.pablomonteserin.draws.path.PathActivity;
import com.pablomonteserin.draws.path2.PathIIActivity;
import com.pablomonteserin.draws.rect.PaintRectActivity;
import com.pablomonteserin.draws.rect_filled.PaintFilledRect;
import com.pablomonteserin.draws.repaint.Repaint;
import com.pablomonteserin.ejercicios.R;

public class Draw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw);
    }


    public void irACirculo(View v){
        startActivity(new Intent(Draw.this, Main.class));
    }

    public void irAPath(View v){
        startActivity(new Intent(Draw.this, PathActivity.class));
    }

    public void irAPath2(View v){
        startActivity(new Intent(Draw.this, PathIIActivity.class));
    }
    public void irARect(View v){
        startActivity(new Intent(Draw.this, PaintRectActivity.class));
    }
    public void irAFilledRect(View v){
        startActivity(new Intent(Draw.this, PaintFilledRect.class));
    }

    public void irARepaint(View v){
        startActivity(new Intent(Draw.this, Repaint.class));
    }
    public void irAMonstruito(View v){
        startActivity(new Intent(Draw.this, com.pablomonteserin.draws.juego_monstruito.MainActivity.class));
    }
    public void irACirculoConAtributos(View v){
        startActivity(new Intent(this, com.pablomonteserin.draws.circulo_con_atributos.Main.class));
    }

}
