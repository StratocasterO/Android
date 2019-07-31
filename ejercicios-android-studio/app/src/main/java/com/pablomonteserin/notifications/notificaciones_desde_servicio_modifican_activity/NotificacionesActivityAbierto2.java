package com.pablomonteserin.notifications.notificaciones_desde_servicio_modifican_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;


public class NotificacionesActivityAbierto2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificaciones_desde_servicio);

        startService(new Intent(this, NotificacionesServicio.class));

        Intent intent = getIntent();
        if(intent!=null) {
            Bundle bundle = intent.getExtras();
            if (intent.getExtras() != null) {

                String dato = bundle.getString("saludo");
                TextView tv = (TextView) findViewById(R.id.texto);
                tv.setText(dato);
            }


        }

    }


    @Override
    protected void onNewIntent(Intent intent) {

        if(intent!=null){
        Bundle bundle = intent.getExtras();
        if(intent.getExtras()!=null){

            String dato = bundle.getString("saludo");
            TextView tv = (TextView) findViewById(R.id.texto);
            tv.setText(dato);
        }

    }
    }


    public void cerrarApp(View v){
        stopService(new Intent(this,  NotificacionesServicio.class));
        //Las aplicaciones Android no tienen botón de cerrar APP, lo único que puedo hacer es detener el servicio
        finish();

    }
}
