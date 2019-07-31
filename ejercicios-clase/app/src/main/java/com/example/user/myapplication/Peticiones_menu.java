package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Peticiones_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peticiones_menu);
    }

    public void get(View v) {
        startActivity(new Intent(this, PeticionGET.class));
    }

    public void post(View v) {
        startActivity(new Intent(this, PeticionPOST.class));
    }

    public void getR(View v) {
        startActivity(new Intent(this, PeticionGETretrofit.class));
    }

    public void postR(View v) {
        startActivity(new Intent(this, PeticionPOSTretrofit.class));
    }

    public void foto(View v) {
        startActivity(new Intent(this, SubirImagen.class));
    }
}
