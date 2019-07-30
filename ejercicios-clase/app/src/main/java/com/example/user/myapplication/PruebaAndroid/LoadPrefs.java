package com.example.user.myapplication.PruebaAndroid;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.R;

public class LoadPrefs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_load_prefs);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String txt = sp.getString("texto", "Texto predeterminado");
        TextView tv = findViewById(R.id.textView);
        tv.setText(txt);
    }
}
