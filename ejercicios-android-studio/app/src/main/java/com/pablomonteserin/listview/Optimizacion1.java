package com.pablomonteserin.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;

import java.util.ArrayList;


public class Optimizacion1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_conbaseadapter);

        ListView lv = (ListView) findViewById(R.id.miLista);
        lv.setAdapter(new MyAdapter(getPaises()));

    }
    public ArrayList<Pais> getPaises() {
        ArrayList<Pais> paises = new ArrayList<Pais>();
        paises.add(new Pais("United States", "flag_usa"));
        paises.add(new Pais("Brazil", "flag_brasil"));
        paises.add(new Pais("Russia", "flag_russia"));
        paises.add(new Pais("Egypt", "flag_egypt"));
        paises.add(new Pais("Japan", "flag_japan"));
        return paises;
    }
    private class MyAdapter extends BaseAdapter {
        ArrayList<Pais> paises;
        public MyAdapter( ArrayList<Pais> paises) {
            this.paises = paises;

        }

        @Override
        public int getCount() {
            return paises.size();
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
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row;
            if(convertView == null){
                row = View.inflate(Optimizacion1.this, R.layout.list_item, null);
            }
            else row = convertView;
            ImageView iv =  row.findViewById(R.id.imageView1);
            TextView tv = row.findViewById(R.id.textView1);
            tv.setText(paises.get(position).getNombre());
            iv.setImageResource(getResources().getIdentifier(paises.get(position).getImg(),
                    "drawable", getPackageName()));
            return row;
        }
    }
}
