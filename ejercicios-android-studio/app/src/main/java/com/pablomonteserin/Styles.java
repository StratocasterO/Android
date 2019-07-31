package com.pablomonteserin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.ejercicios.R;
import com.pablomonteserin.styles.BackgroundNoRepeat;
import com.pablomonteserin.styles.BackgroundRepeat;
import com.pablomonteserin.styles.CambiaBackground;
import com.pablomonteserin.styles.Color;
import com.pablomonteserin.styles.Degradado;
import com.pablomonteserin.styles.Estilos;
import com.pablomonteserin.styles.MaquetarBoton;
import com.pablomonteserin.styles.Themes;

public class Styles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.styles);
    }

    public void irAStyles(View v){
        startActivity(new Intent(Styles.this, CambiaBackground.class));
    }

    public void irADegradado(View v){
        startActivity(new Intent(Styles.this, Degradado.class));
    }

    public void irAMaquetarBoton(View v){
        startActivity(new Intent(Styles.this, MaquetarBoton.class));
    }
    public void irAColor(View v){
        startActivity(new Intent(Styles.this, Color.class));
    }
    public void irABackgroundNoRepeat(View v){
        startActivity(new Intent(Styles.this, BackgroundNoRepeat.class));
    }

    public void irABackgroundRepeat(View v){
        startActivity(new Intent(Styles.this, BackgroundRepeat.class));
    }
    public void irAEstilos(View v){
        startActivity(new Intent(Styles.this, Estilos.class));
    }
    public void irAThemes(View v){
        startActivity(new Intent(Styles.this, Themes.class));
    }
}
