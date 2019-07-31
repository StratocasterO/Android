package com.pablomonteserin.mapas.Monumentos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pablomonteserin.ejercicios.R;


public class Main extends
		android.support.v4.app.FragmentActivity implements OnMarkerClickListener{
	private GoogleMap mapa = null;
	private LatLng myLatLng;
	private CameraPosition camPos;
	private CameraUpdate camUpd3;
	public final static String MONUMENTO ="monumento";
	public final static String ID = "";
	private HashMap<Integer, Monumento> monumentos;
	private HashMap <Marker, Integer>tabla;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapas_confragment_main);
		tabla = new HashMap<Marker, Integer>();
		
		monumentos = Controller.getMonumentos(this);

		((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMapAsync(new OnMapReadyCallback() {
			@Override
			public void onMapReady(GoogleMap googleMap) {
				mapa = googleMap;
                mapa.setOnMarkerClickListener(Main.this);

                setupMapa();
			}
		});

	}


	void setupMapa(){

		myLatLng = new LatLng(43.545260, -5.661926);
		camPos = new CameraPosition.Builder().target(myLatLng) // Centramos el
				// mapa en
				// Madrid
				.zoom(12) // Establecemos el zoom en 19
				.build();
		camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);

		mapa.animateCamera(camUpd3);
        Collection <Monumento>collection = monumentos.values();

        Iterator<Monumento> it = collection.iterator();
		while (it.hasNext()) {
            Monumento monumento = (Monumento) it.next();

			float lat = monumento.getLatitud() / 1000000f;
			float lon = monumento.getLongitud() / 1000000f;
			Marker marker = mapa.addMarker(new MarkerOptions()
					.position(new LatLng(lat, lon))
					.snippet(monumento.getDescripcion())
					.title(monumento.getNombre())
					.icon(BitmapDescriptorFactory.fromResource(R.drawable.escudo)));
            tabla.put(marker, monumento.getId());

		}
	}

	@Override
	public boolean onMarkerClick(Marker arg0) {
		int idMonumento = tabla.get(arg0);		
		
		startActivity(new Intent(this,LugarActivity.class).putExtra(MONUMENTO, monumentos.get(idMonumento)));
		return true;
	}
	
}