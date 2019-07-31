package com.pablomonteserin.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pablomonteserin.ejercicios.R;


public class PersonalDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_personal);


        final Dialog d = new Dialog(PersonalDialog.this);
        d.setContentView(R.layout.dialog_personal_dialog);
        d.setTitle("Amor");

        Button b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                d.show();

            }


        });
    }
}
