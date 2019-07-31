package com.pablomonteserin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.ejercicios.R;
import com.pablomonteserin.listview.ConBaseAdapter;
import com.pablomonteserin.listview.ConLayoutPersonalizado;
import com.pablomonteserin.listview.A_ExtendiendoListActivity;
import com.pablomonteserin.listview.Contactos;
import com.pablomonteserin.listview.Optimizacion1;
import com.pablomonteserin.listview.Optimizacion2;
import com.pablomonteserin.listview.B_SinExtenderListActivity;

public class Listados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
    }

    public void irAExtendiendoListActivity(View v){
        startActivity(new Intent(Listados.this, A_ExtendiendoListActivity.class));
    }
    public void irASinExtenderListActivity(View v){
        startActivity(new Intent(Listados.this, B_SinExtenderListActivity.class));
    }

    public void irAConLayoutPersonalizado(View v){
        startActivity(new Intent(Listados.this, ConLayoutPersonalizado.class));
    }

    public void irABaseAdapter(View v){
        startActivity(new Intent(Listados.this, ConBaseAdapter.class));
    }

    public void irAOptimizacion1(View v){
        startActivity(new Intent(Listados.this, Optimizacion1.class));
    }

    public void irAOptimizacion2(View v){
        startActivity(new Intent(Listados.this, Optimizacion2.class));
    }

    public void irAContactos(View v){
        startActivity(new Intent(this, Contactos.class));
    }

}
