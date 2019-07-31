package com.pablomonteserin.almacenamiento.plantas.basico;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;


public class MisPlantasActivity extends Activity implements OnItemClickListener {
	static List<Planta> plantas;
	final static public String PLANTA = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.almacenamiento_plantas_basico_main);
		ListView lv = (ListView) findViewById(R.id.miLista);
		lv.setOnItemClickListener(this);
		lv.setAdapter(new MyAdapter());

	}

	private class MyAdapter extends BaseAdapter {

		public MyAdapter() {
			super();
			MisPlantasActivity.plantas = Controller
					.cargaLista(MisPlantasActivity.this);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return plantas.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			View row;
			if(arg1 == null)row = View.inflate(MisPlantasActivity.this, R.layout.row_list, null);
			else row = arg1;
			
			TextView tv = (TextView) row.findViewById(R.id.tv);
			ImageView iv = (ImageView) row.findViewById(R.id.iv);
			tv.setText(plantas.get(arg0).getNombre());
			iv.setImageResource(getResources().getIdentifier(
					plantas.get(arg0).getFoto(), "drawable", getPackageName()));
			return row;
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// arg0: sobre quien hice el click
		// onItemClick(AdapterView<?> parent, View view, int position, long id)

		// Log.d("traza", "" + v.getId());

		startActivity(new Intent(this, InfoActivity.class).putExtra(PLANTA,
				plantas.get(position)));

	}
}