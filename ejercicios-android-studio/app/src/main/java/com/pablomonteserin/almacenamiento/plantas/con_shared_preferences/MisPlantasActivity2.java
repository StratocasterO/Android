package com.pablomonteserin.almacenamiento.plantas.con_shared_preferences;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;


public class MisPlantasActivity2 extends Activity implements OnItemClickListener {
	static List<Planta> plantas;
	final static public String PLANTA = "";
	private SharedPreferences sp;
	ListView lv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.almacenamiento_plantas_con_shares_preferences_main);
		lv = (ListView) findViewById(R.id.miLista);
		lv.setOnItemClickListener(this);
		lv.setAdapter(new MyAdapter());
		sp = getSharedPreferences("preferencias", MODE_PRIVATE);

	}

	private class MyAdapter extends BaseAdapter {

		public MyAdapter() {
			super();
			MisPlantasActivity2.plantas = Controller
					.cargaLista(MisPlantasActivity2.this);
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
			if (arg1 == null)
				row = View.inflate(MisPlantasActivity2.this, R.layout.row_list,
						null);
			else
				row = arg1;
			final Planta planta = plantas.get(arg0);
			Log.d("loqueviene",""+sp.getBoolean("" + planta.getId(), false));
			if (sp.getBoolean("" + planta.getId(), false)) {
				row.setBackgroundColor(Color.GREEN);
			} else {
				row.setBackgroundColor(Color.TRANSPARENT);
			}

			TextView tv = (TextView) row.findViewById(R.id.tv);
			ImageView iv = (ImageView) row.findViewById(R.id.iv);
			tv.setText(plantas.get(arg0).getNombre());
			iv.setImageResource(getResources().getIdentifier(
					plantas.get(arg0).getFoto(), "drawable", getPackageName()));
			return row;
		}

	}

	protected void onResume() {
		super.onResume();
		lv.setAdapter(new MyAdapter());

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