package com.pablomonteserin.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;

import java.util.ArrayList;

public class Optimizacion2 extends AppCompatActivity {

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
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.d("TRAZA", "Fila Impresa");
            View row;
            //Con esta optimización conseguimos llamar sólo 10 veces al findViewById, en vez de 100. Ideal para listas largas.
            if(convertView == null){
                row = View.inflate(Optimizacion2.this, R.layout.list_item, null);
                ViewHolder vh = new ViewHolder();
                vh.iv = (ImageView) row.findViewById(R.id.imageView1);
                vh.tv = (TextView) row.findViewById(R.id.textView1);
                row.setTag(vh);
            }
            else row = convertView;
            ViewHolder vh = (ViewHolder) row.getTag();
            vh.tv.setText(paises.get(position).getNombre());
            //getPackageName() me devuelve el nombre del paquete
            vh.iv.setImageResource(getResources().getIdentifier(paises.get(position).getImg(), "drawable", getPackageName()));
            return row;
        }
        //Devuelve el número total de items que contiene la lista
        @Override
        public int getCount() {
            return paises.size();
        }
        //Los siguientes métodos apenas se usan. Por ello, en principio no haría falta modificar su código.
        //este método debería devolver que ocupa la posición indicada
        @Override
        public Object getItem(int position) {
            return null;
        }
        //este método debería devolver la id del objeto que ocupa la posición indicada
        @Override
        public long getItemId(int position) {
            return 0;
        }


    }
    private static class ViewHolder{
        TextView tv;
        ImageView iv;
    }
}
