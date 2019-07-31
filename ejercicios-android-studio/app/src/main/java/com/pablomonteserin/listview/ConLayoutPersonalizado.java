package com.pablomonteserin.listview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;


public class ConLayoutPersonalizado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_conbaseadapter);

        ListView lv = (ListView) findViewById(R.id.miLista);
        lv.setAdapter(new MyAdapter(this, R.layout.list_item_2, R.id.miLista, getResources().getStringArray(R.array.countries2)));
    }
    private class MyAdapter extends ArrayAdapter<String> {
        String []items;
        String []itemsImg;
        public MyAdapter(Context context, int resource, int textViewResourceId, String[] strings) {
            super(context, resource, textViewResourceId, strings);
            items = getResources().getStringArray(R.array.countries2);
            itemsImg =getResources().getStringArray(R.array.countriesImg);
        }
        //MyAdapter llama automáticamente al método getView para cargar la lista con información
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = View.inflate(ConLayoutPersonalizado.this, R.layout.list_item_2, null);
            TextView tv = (TextView) row.findViewById(R.id.textView1);
            ImageView iv = (ImageView) row.findViewById(R.id.imageView1);
            tv.setText(items[position]);
            iv.setImageResource(getResources().getIdentifier(itemsImg[position],
                    "drawable", getPackageName()));
            return row;
        }
    }

}
