package com.pablomonteserin.draws.circulo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;


public class Vista extends View{
	Paint pincel;
	int color;
	public Vista(Context context){
		super(context);
		iniciar();
	}
	public Vista(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		iniciar();
	}
	public Vista(Context context, AttributeSet attrs) {
		super(context, attrs);
		iniciar();
	}
	private void iniciar(){
		pincel = new Paint();
		//Hay varias formas de definir los colores	
		color = Color.RED;
		//color = Color.argb(127, 0, 255, 0);
		//color = 0x7F00FF00;
		pincel.setColor(color);
		pincel.setStrokeWidth(8);
		pincel.setStyle(Style.STROKE);
	}
	protected void onDraw(Canvas canvas){
		canvas.drawCircle(150, 150, 100, pincel);
	}
}