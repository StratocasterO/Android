package com.pablomonteserin.listview;

import android.app.Activity;
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

public class ConBaseAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_conbaseadapter);

        ListView lv = (ListView) findViewById(R.id.miLista);
        ArrayList<Pais> paises = getPaises();

        lv.setAdapter(new MyAdapter(paises));

    }


    private class MyAdapter extends BaseAdapter {
        ArrayList<Pais> paises;

        public MyAdapter(ArrayList <Pais>paises) {
            super();
            this.paises = paises;
        }

        // MyAdapter llama automáticamente al método getView para cargar la
        // lista con información
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = View.inflate(ConBaseAdapter.this,
                    R.layout.list_item, null);
            TextView tv = (TextView) row.findViewById(R.id.textView1);
            ImageView iv = (ImageView) row.findViewById(R.id.imageView1);
            tv.setText(paises.get(position).getNombre());
            iv.setImageResource(getResources().getIdentifier(
                    paises.get(position).getImg(), "drawable", getPackageName()));
            return row;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return paises.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }
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

}
