package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class BaseAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayList<Planta> plantas = getPlantas();

        MyAdapter adapter = new MyAdapter(plantas);

        ListView lv = (ListView) findViewById(R.id.cosa);
        lv.setAdapter(new MyAdapter(getPlantas()));
    }

    public ArrayList<Planta> getPlantas() {
        ArrayList<Planta> plantas = new ArrayList<Planta>();

        plantas.add(new Planta(0, "Geranio", 5.5f));
        plantas.add(new Planta(1, "Cactus", 2.8f));
        plantas.add(new Planta(2, "Petunia", 16.9f));
        plantas.add(new Planta(3, "Hortensia", 14.9f));
        plantas.add(new Planta(4, "Palmera", 25f));

        return plantas;
    }


    private class MyAdapter extends android.widget.BaseAdapter {
        ArrayList<Planta> Plantas;

        public MyAdapter(ArrayList<Planta> Plantas) {
            super();
            this.Plantas = Plantas;
        }

        @Override
        public int getCount() {
            return Plantas.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //MyAdapter llama automáticamente al método getView para cargar la lista con información
        //Dicho método se va llamar muchas veces (una cada vez que tenga que pintar una posición de la lista)
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = View.inflate(BaseAdapter.this, R.layout.layout_fila_baseadapter, null);
            TextView tv = (TextView) row.findViewById(R.id.planta);
            tv.setText(Plantas.get(position).getName());
            TextView tv2 = (TextView) row.findViewById(R.id.precio);
            tv2.setText(Plantas.get(position).getPrice().toString()+" €");
            //getPackageName() me devuelve el nombre del paquete que identifica a nuestra aplicación
            return row;
        }
    }
}

