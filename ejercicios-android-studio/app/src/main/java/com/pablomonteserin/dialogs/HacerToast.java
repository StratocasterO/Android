package com.pablomonteserin.dialogs;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pablomonteserin.ejercicios.R;

public class HacerToast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacer_toast);


        Button b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){

                Toast toast = Toast.makeText(HacerToast.this, "El texto emergente",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }

        });

    }
}


