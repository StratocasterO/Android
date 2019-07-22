package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PasarContenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        TextView tv = (TextView)findViewById(R.id.textView1);
        if(getIntent().getExtras() != null) {
            tv.setText(getIntent().getExtras().getString(Botones.text));
        }
    }
}
