package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class Mapa_centered extends AppCompatActivity implements OnMapReadyCallback {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa_centered);

		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
	}

	@Override
	public void onMapReady(GoogleMap googleMap) {

		LatLng madrid = new LatLng(40.417325, -3.683081);
		CameraPosition camPos = new CameraPosition.Builder()
				.target(madrid)    // Centramos el mapa en Madrid
				.zoom(19)          // Establecemos el zoom en 19
				.bearing(45)       // Establecemos la orientación con el noreste arriba
				.tilt(70)          // Bajamos el punto de vista de la cámara 70 grados
				.build();

		CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(camPos);

		googleMap.animateCamera(camUpd);
	}
}
