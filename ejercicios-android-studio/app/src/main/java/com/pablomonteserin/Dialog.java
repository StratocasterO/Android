package com.pablomonteserin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.dialogs.AlertDialogEjemplo;
import com.pablomonteserin.dialogs.HacerToast;
import com.pablomonteserin.dialogs.ProgressBarDialog;
import com.pablomonteserin.notifications.Notificaciones;
import com.pablomonteserin.notifications.notificaciones_abriendo_activity.NotificacionesAbriendoUnActivity;
import com.pablomonteserin.dialogs.PersonalDialog;
import com.pablomonteserin.notifications.notificaciones_desde_servicio_modifican_activity.NotificacionesActivityAbierto2;
import com.pablomonteserin.ejercicios.R;

public class Dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
    }

    public void irADialog1(View v){
        startActivity(new Intent(Dialog.this, AlertDialogEjemplo.class));
    }
    public void irAHorizontalDialog(View v){
        startActivity(new Intent(Dialog.this, ProgressBarDialog.class));
    }
    public void irAPersonalDialog(View v){
        startActivity(new Intent(Dialog.this, PersonalDialog.class));
    }

    public void irAToast(View v){
        startActivity(new Intent(Dialog.this, HacerToast.class));
    }


}
