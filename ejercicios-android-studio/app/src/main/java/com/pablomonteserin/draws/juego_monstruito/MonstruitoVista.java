package com.pablomonteserin.draws.juego_monstruito;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pablomonteserin.ejercicios.R;

import org.w3c.dom.Text;

/**
 * Created by monty on 20/09/17.
 */

public class MonstruitoVista extends AppCompatImageView {
    int i =0;
    public MonstruitoVista(Context context){
        super(context);
        iniciar();
    }
    public MonstruitoVista(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        iniciar();
    }
    public MonstruitoVista(Context context, AttributeSet attrs) {
        super(context, attrs);
        iniciar();
    }

    private void iniciar(){
        this.setImageResource(R.drawable.rosa);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        com.pablomonteserin.draws.juego_monstruito.MainActivity.aumentarMarcador(i);
        //Fuerzo el repintado
        this.invalidate();
        return super.onTouchEvent(event);
    }
}
