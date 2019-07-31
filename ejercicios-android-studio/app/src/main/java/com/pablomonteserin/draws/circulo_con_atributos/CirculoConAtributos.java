package com.pablomonteserin.draws.circulo_con_atributos;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.pablomonteserin.ejercicios.R;


public class CirculoConAtributos extends View {
    String color;
Paint pincel;
    public CirculoConAtributos(Context context){
        super(context);
        //iniciar();
    }
    public CirculoConAtributos(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        iniciar(context, attrs);
    }
    public CirculoConAtributos(Context context, AttributeSet attrs) {
        super(context, attrs);
        iniciar(context, attrs);
    }


    private void iniciar(Context context, AttributeSet attrs){
        pincel = new Paint();
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.Monteserin_circle);
        int color = attributes.getColor(R.styleable.Monteserin_circle_monteserin_color, Color.GREEN);
        pincel.setColor(color);

    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawCircle(150, 150, 100, pincel);
    }
}
