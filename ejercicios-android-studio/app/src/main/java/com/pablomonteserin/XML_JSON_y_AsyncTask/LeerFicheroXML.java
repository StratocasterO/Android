package com.pablomonteserin.XML_JSON_y_AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;

import java.io.InputStream;

public class LeerFicheroXML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_json_leer_fichero_xml);
        TextView tv = findViewById(R.id.texto);

            InputStream inputStream = this.getResources().openRawResource(R.raw.libros);
            tv.setText(inputStream.toString());

    }
}
