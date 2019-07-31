package com.pablomonteserin.XML_JSON_y_AsyncTask.xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainParsearXML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsear_xml);
        InputStream inputStream = this.getResources().openRawResource(R.raw.libros);

XMLParser xmlParser = new XMLParser();
        try {
          List listado = xmlParser.parse(inputStream);
        ListView lv = findViewById(R.id.miLista);
            lv.setAdapter(new MyAdapter(listado));



        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class MyAdapter extends BaseAdapter {
        List<XMLParser.Entry> libros;

        public MyAdapter(List<XMLParser.Entry> libros) {
            super();
            this.libros = libros;
        }

        @Override
        public int getCount() {
            return libros.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //MyAdapter llama automáticamente al método getView para cargar la lista con información
//Dicho método se va llamar muchas veces (una cada vez que tenga que pintar una posición de la lista)
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = View.inflate(MainParsearXML.this, R.layout.xml_json_listado, null);
            TextView tv = row.findViewById(R.id.texto);
            tv.setText(libros.get(position).titulo);
            return row;
        }

    }
}
