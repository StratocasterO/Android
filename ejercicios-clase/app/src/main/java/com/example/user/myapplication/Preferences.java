package com.example.user.myapplication;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Preferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String txt = sp.getString("texto", "valor por defecto");
        Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_LONG).show();
    }

    //El siguiente código se ejecuta cuando la aplicación está a punto de terminar
    @Override
    protected void onPause() {
        super.onPause();
        EditText et = findViewById(R.id.editText);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor sharedPreferencesEditor = sp.edit();
        sharedPreferencesEditor.putString("texto", et.getText().toString());
        sharedPreferencesEditor.commit();

    }
}
