package com.pablomonteserin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pablomonteserin.ejercicios.R;
import com.pablomonteserin.layouts.A_HelloWorldActivity;
import com.pablomonteserin.layouts.B_HelloWorldEjercicioActivity;
import com.pablomonteserin.layouts.C_AllLayoutsActivity;
import com.pablomonteserin.layouts.D_EjercicioLinearLayout;
import com.pablomonteserin.layouts.E_ContenidoScrollable;
import com.pablomonteserin.layouts.F_CargaImagenActivity;
import com.pablomonteserin.layouts.I_Menu;
import com.pablomonteserin.layouts.tinderlike.TinderLike;
import com.pablomonteserin.layouts.fragments.RecipienteFragment;
import com.pablomonteserin.layouts.navigationDrawer.MyNavigationDrawer;
import com.pablomonteserin.layouts.tabs.TabsActivity;

public class Layouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layouts);
    }

    public void irAHelloWorld(View v){
        startActivity(new Intent(this, A_HelloWorldActivity.class));
    }
    public void irAHelloWorldEjercicio(View v){
        startActivity(new Intent(this, B_HelloWorldEjercicioActivity.class));
    }
    public void irAAllLayouts(View v){
        startActivity(new Intent(this, C_AllLayoutsActivity.class));
    }

    public void irAContenidoScrollable(View v){
        startActivity(new Intent(this, E_ContenidoScrollable.class));
    }

    public void irAEjercicioLinearLayout(View v){
        startActivity(new Intent(this, D_EjercicioLinearLayout.class));
    }
    public void irACargaImagen(View v){
        startActivity(new Intent(this, F_CargaImagenActivity.class));
    }


    public void irAMenu(View v){
        startActivity(new Intent(this, I_Menu.class));
    }
    public void irATinderLike(View v){
        startActivity(new Intent(this, TinderLike.class));
    }


    public void irAFragments(View v){
        startActivity(new Intent(this, RecipienteFragment.class));
    }
    public void irATabs(View v){
        startActivity(new Intent(this, TabsActivity.class));
    }
    public void irANavigationDrawer(View v){
        startActivity(new Intent(Layouts.this, MyNavigationDrawer.class));
    }
}
