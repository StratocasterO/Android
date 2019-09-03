package com.example.user.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Location_Toast extends AppCompatActivity {

	@SuppressLint("MissingPermission")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location__toast);

		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
		LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		LocationListener listener = new LocationListener() {
			public void onLocationChanged(Location location) {
				Toast toast = Toast.makeText(Location_Toast.this, "Latitud: " + location.getLatitude() + "\n Longitud: " + location.getLongitude(), Toast.LENGTH_LONG);
				toast.show();
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

		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
	}
}
