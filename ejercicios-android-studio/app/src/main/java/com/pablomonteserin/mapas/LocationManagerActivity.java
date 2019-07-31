package com.pablomonteserin.mapas;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;

import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;


public class LocationManagerActivity extends AppCompatActivity {
    TextView textView;
    LocationManager lm;
    LocationListener listener;
final private int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 99;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapas_locationmanager);

        textView = (TextView)findViewById(R.id.coordenadas);

        //->GPS_PROVIDER actualizaciones del GPS, NETWORK_PROVIDER: actualizaciones usando la red móvil
        //damelo cada 0 milisegundos y cada 0 metros que me desplace : lo q hará realmente será darme la info con la mayor constancia posible

         lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
         listener = new LocationListener(){

            @Override
            public void onProviderDisabled(String arg0) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onProviderEnabled(String arg0) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onLocationChanged(Location location) {
                textView.setText("Latitud: " + location.getLatitude() + "Longitud: " + location.getLongitude());
            }
        };
        //->GPS_PROVIDER actualizaciones del GPS, NETWORK_PROVIDER: actualizaciones usando la red móvil
        //damelo cada 0 milisegundos y cada 0 metros que me desplace : lo q hará realmente será darme la info con la mayor constancia posible


        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            // Do something for lollipop and above versions
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_FINE_LOCATION);
            }
            else{
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
            }
        }
        else{
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
