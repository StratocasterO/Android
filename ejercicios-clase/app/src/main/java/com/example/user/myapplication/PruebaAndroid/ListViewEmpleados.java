package com.example.user.myapplication.PruebaAndroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.myapplication.R;

import java.util.ArrayList;

public class ListViewEmpleados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_list_view2);

        ArrayList<Empleado> empleados = leer();
        ListView lv = (ListView) findViewById(R.id.lista);
        lv.setAdapter(new MyAdapter(empleados));
    }

    public ArrayList<Empleado> leer(){
        ArrayList<Empleado> empleados = new ArrayList<>();

        SQLiteDatabase db = openOrCreateDatabase("empleados", MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM empleados", null);
        while (c.moveToNext()) {
            Log.d("LEE", c.getString(c.getColumnIndex("nombre")));
            empleados.add(new Empleado( c.getString(c.getColumnIndex("nombre")),
                    c.getString(c.getColumnIndex("edad")),
                    c.getString(c.getColumnIndex("empleado"))));
        }
        c.close();
        db.close();

        return empleados;
    }

    private class MyAdapter extends BaseAdapter {
        ArrayList<Empleado> Empleados;

        public MyAdapter(ArrayList<Empleado> Empleados) {
            super();
            this.Empleados = Empleados;
        }

        @Override
        public int getCount() {
            return Empleados.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row = View.inflate(ListViewEmpleados.this, R.layout.base_adapter, null);
            TextView tv = row.findViewById(R.id.nombre);
            tv.setText(Empleados.get(position).getNombre());
            TextView tv2 = row.findViewById(R.id.edad);
            String edad = Empleados.get(position).getEdad();
            tv2.setText(edad);
            TextView tv3 = row.findViewById(R.id.empleado);
            if(Empleados.get(position).getEmpleado().equals("Y")){
                tv3.setText("Es empleado");
            } else {
                tv3.setText("No es empleado");
            }

            return row;
        }
    }
}
