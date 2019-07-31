package com.pablomonteserin.almacenamiento;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;


import com.pablomonteserin.ejercicios.R;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio extends AppCompatActivity {
    SQLiteDatabase db;
    ListView v;
    String txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.almacenamiento_ejercicio_con_precarga);
        //La siguiente línea busca la base de datos. Si la encuentra la abre. si no, la crea
        v = (ListView) findViewById(R.id.listView1);
        consultar();
    }

    public void insertar(View view){
        txt =  ((EditText)findViewById(R.id.editText1)).getText().toString();
        db = openOrCreateDatabase("invitado_db", MODE_PRIVATE, null);
        db.execSQL("INSERT INTO invitado VALUES ('"+txt+"')");
        consultar();
        db.close();

    }
    public void borrar(View view){
        txt =  ((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
        db = openOrCreateDatabase("invitado_db", MODE_PRIVATE, null);
        db.execSQL("DELETE FROM invitado WHERE nombre='"+txt+"'");
        consultar();
        db.close();

    }
    public void consultar(){
        db = openOrCreateDatabase("invitado_db", MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM invitado", null);
        List<String> lista = new ArrayList<String>();
        while(c.moveToNext()){
            lista.add(c.getString(0));
        }
        v.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista));
        Spinner sp = (Spinner) findViewById(R.id.spinner1);
        sp.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista));
        c.close();
        db.close();
    }
}
