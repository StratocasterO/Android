package com.example.user.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BaseDatos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantas);

        actualiza();
    }

    public void alta(View v){
        SQLiteDatabase db = openOrCreateDatabase("plantas", MODE_PRIVATE, null);

        ContentValues nuevoRegistro = new ContentValues();
        TextView tv1 = findViewById(R.id.nombre);
        TextView tv2 = findViewById(R.id.precio);
        String nombre = tv1.getText().toString();
        String precio = tv2.getText().toString();
        nuevoRegistro.put("nombre", nombre);
        nuevoRegistro.put("precio", precio);
        db.insert("plantas", null, nuevoRegistro);

        db.close();

        actualiza();
    }

    public void baja(View v){
        SQLiteDatabase db = openOrCreateDatabase("plantas", MODE_PRIVATE, null);

        EditText tv = findViewById(R.id.nombre);
        String name = new String(tv.getText().toString());
        db.execSQL("DELETE FROM plantas WHERE nombre='" + name + "'");

        db.close();

        actualiza();
    }

    public void modificacion(View v){
        SQLiteDatabase db = openOrCreateDatabase("plantas", MODE_PRIVATE, null);
        EditText et = findViewById(R.id.nombre);
        String name = et.getText().toString();
        Cursor c = db.rawQuery("SELECT * FROM plantas WHERE nombre='" + name + "'", null);

        ContentValues valores = new ContentValues();
        EditText vt = findViewById(R.id.precio);
        valores.put("precio",vt.getText().toString());
        db.update("plantas", valores, "nombre='"+name+"'", null);

        c.close();
        db.close();

        actualiza();
    }

    public void actualiza(){
        ArrayList plantas = new ArrayList();

        SQLiteDatabase db = openOrCreateDatabase("plantas", MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM plantas", null);

        //Para recorrer un cursor:
        while (c.moveToNext()) {
            //No debemos hacer el c.moveToFirst(); o nos saltaremos el primer registro.
            Log.d("LEE", c.getString(c.getColumnIndex("nombre")));
            plantas.add(c.getString(c.getColumnIndex("nombre"))+ " " +c.getString(c.getColumnIndex("precio")) + "€");
        }
        c.close();
        db.close();

        ListView listView = findViewById(R.id.plantas);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, plantas));
    }
}
