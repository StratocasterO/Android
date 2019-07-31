package com.pablomonteserin.layouts.tabs;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.pablomonteserin.ejercicios.R;

public class TabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabs);

        Resources res = getResources();

        TabHost tabs=findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("",
                ContextCompat.getDrawable(this,android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("mi casa es tu casa",ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_email));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
    }
}
