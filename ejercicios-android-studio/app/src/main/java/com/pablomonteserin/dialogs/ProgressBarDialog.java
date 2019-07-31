package com.pablomonteserin.dialogs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.pablomonteserin.ejercicios.R;


public class ProgressBarDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogs_progressbar);


        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setIndeterminate(false);
        pb.setProgress(50);
    }
}
