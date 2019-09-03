package com.example.user.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa);

		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
	}

	@SuppressLint("MissingPermission")
	@Override

	public void onMapReady(final GoogleMap googleMap) {
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
		LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

		LocationListener listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location location) {
				LatLng aqui = new LatLng(location.getLatitude(), location.getLongitude());
				centrarCamara(googleMap, aqui);
			}

			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
			}

			@Override
			public void onProviderEnabled(String provider) {
			}

			@Override
			public void onProviderDisabled(String provider) {
			}
		};


		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);

		lm.requestSingleUpdate(criteria, listener, null);

		googleMap.setMyLocationEnabled(true);

		googleMap.addMarker(new MarkerOptions()
				.position(new LatLng(41.431725, 2.192188))
				.snippet("Centre de formació")
				.title("Tadel Formació"));

		googleMap.addMarker(new MarkerOptions()
				.position(new LatLng(41.447619, 2.199991))
				.title("Baró de Viver"));

		googleMap.addMarker(new MarkerOptions()
				.position(new LatLng(41.326509, 2.093870))
				.title("Escola d'Arts en Viu")
				.snippet("Escola de Música del Prat"));
	}

	public void centrarCamara(GoogleMap map, LatLng loc) {
		CameraPosition camPos = new CameraPosition.Builder()
				.target(loc)
				.zoom(12)
				.build();

		CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(camPos);

		map.animateCamera(camUpd);
	}
}