package com.pablomonteserin.almacenamiento;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.pablomonteserin.ejercicios.R;


public class Sqlite extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.almacenamiento_sqlite);
        
        //La siguiente línea busca la base de datos. Si la encuentra la abre. si no, la crea
        SQLiteDatabase db = openOrCreateDatabase("nombre_base_datos", MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM mi_tabla", null);
        c.moveToFirst();
        String valor = c.getString(c.getColumnIndex("campo1"));
        Toast.makeText(this,valor, Toast.LENGTH_LONG).show();
        Log.d("LEE",valor);
        db.close(); 
    }
}