package com.pablomonteserin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pablomonteserin.ejercicios.R;
import com.pablomonteserin.notifications.ejercicio_yoga.MainActivityYoga;
import com.pablomonteserin.notifications.notificaciones_abriendo_activity.NotificacionesAbriendoUnActivity;
import com.pablomonteserin.notifications.notificaciones_desde_servicio_modifican_activity.NotificacionesActivityAbierto2;

public class Notificaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
    }

    public void irANotificaciones(View v){
        startActivity(new Intent(this, com.pablomonteserin.notifications.Notificaciones.class));
    }
    public void irANotificacionesQueAbrenActivity(View v){
        startActivity(new Intent(this, NotificacionesAbriendoUnActivity.class));
    }

    public void irANotificacionesConServicio(View v){
        startActivity(new Intent(this, NotificacionesActivityAbierto2.class));
    }


    public void irAEjercicioYoga(View v){
        startActivity(new Intent(this, MainActivityYoga.class));
    }
}
