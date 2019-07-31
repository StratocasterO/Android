package com.pablomonteserin.mapas;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pablomonteserin.ejercicios.R;


public class LocationManagerConInterfaceSoloFuncionaConCambioDePosicion extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapas_locationmanagerconinterface);

        LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        //->GPS_PROVIDER actualizaciones del GPS, NETWORK_PROVIDER: actualizaciones usando la red móvil
        //damelo cada 0 milisegundos y cada 0 metros que me desplace : lo q hará realmente será darme la info con la mayor constancia posible
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,this);//Localización usando el GPS
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,this);//Localización usando la red móvil
    }

    @Override
    public void onLocationChanged(Location arg0) {
        Toast toast = Toast.makeText(this, "Latitud: "+ arg0.getLatitude()+" Longitude: "+ arg0.getLongitude(), Toast.LENGTH_LONG);
        toast.show();
    }

    //Esto ocurre cuando desactivas el gps, la red móvil, etc
    @Override
    public void onProviderDisabled(String arg0) {
        // TODO Auto-generated method stub

    }

    //Esto ocurre cuando activas el gps, la red móvil, etc.
    @Override
    public void onProviderEnabled(String arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
        // TODO Auto-generated method stub
    }
}
