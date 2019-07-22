package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Botones extends BaseDatos {
    public final static String text = "texto";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.botones_onclick);
    }
    public void btnPulsado(View v){
        TextView tv = (TextView) findViewById(R.id.boton);
        tv.setText("Botón pulsado");
    }

    public void cambioActivity(View v){
        startActivity(new Intent(this, PasarContenido.class));
    }

    public void pasarInfo(View view) {
        final EditText et = findViewById(R.id.texto);
        Intent intent = new Intent(this, PasarContenido.class);
        intent.putExtra(text, et.getText().toString());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}