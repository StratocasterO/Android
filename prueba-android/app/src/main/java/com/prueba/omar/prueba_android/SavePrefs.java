package com.prueba.omar.prueba_android;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SavePrefs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_save_prefs);
    }

    public void save_prefs(View v) {
        EditText et = findViewById(R.id.editText);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor sharedPreferencesEditor = sp.edit();
        sharedPreferencesEditor.putString("texto", et.getText().toString());
        sharedPreferencesEditor.commit();
    }

}
