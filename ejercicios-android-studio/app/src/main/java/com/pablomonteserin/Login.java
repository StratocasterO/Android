package com.pablomonteserin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pablomonteserin.ejercicios.R;
import com.pablomonteserin.login.facebook.LoginActivityFacebook;
import com.pablomonteserin.login.google.LoginActivityGoogle;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void irALoginConGoogle(View v){
        startActivity(new Intent(this, LoginActivityGoogle.class));
    }

    public void irALoginConFacebook(View v){
        startActivity(new Intent(this, LoginActivityFacebook.class));
    }
}
