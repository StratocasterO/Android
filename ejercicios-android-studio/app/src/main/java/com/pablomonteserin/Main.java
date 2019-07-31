package com.pablomonteserin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.pablomonteserin.ejercicios.R;
import com.pablomonteserin.jobScheduler.MyJobScheduler;


public class Main extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("traza1", "valor1");
    }

    public void irALayouts(View v){
        startActivity(new Intent(this, Layouts.class));
    }
    public void irAAnimatium(View v){
        startActivity(new Intent(this, Animatium.class));
    }

    public void irAStyles(View v){
        startActivity(new Intent(this, Styles.class));
    }
    public void irADialog(View v){
        startActivity(new Intent(this, Dialog.class));
    }

    public void irAItemList(View v){
        startActivity(new Intent(this, Listados.class));
    }
    public void irAAlmacenamiento(View v){
        startActivity(new Intent(this, Almacenamiento.class));
    }
    public void irAMultimedia(View v){
        startActivity(new Intent(this, Multimedia.class));
    }
    public void irADraw(View v){
        startActivity(new Intent(this, Draw.class));
    }
    public void irAMapas(View v){
        startActivity(new Intent(this, Maps.class));
    }
    public void irAJobScheduler(View v){
        startActivity(new Intent(this, MyJobScheduler.class));
    }
    public void irANotificaciones(View v){
        startActivity(new Intent(this, Notificaciones.class));
    }
    public void irAXMLJSON(View v){
        startActivity(new Intent(this, XMLJSON.class));
    }
    public void irALogin(View v){
        startActivity(new Intent(this, Login.class));
    }

}