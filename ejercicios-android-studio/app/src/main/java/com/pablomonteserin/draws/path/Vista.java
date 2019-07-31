package com.pablomonteserin.draws.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.util.AttributeSet;
import android.view.View;

public class Vista extends View{
	Path trazo;
	Paint pincel;
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
		trazo = new Path();
		pincel = new Paint();
	}
	protected void onDraw(Canvas canvas){
		trazo.addCircle(150, 150, 100, Direction.CCW);
		canvas.drawColor(Color.WHITE);
		pincel.setColor(Color.BLUE);
		pincel.setStrokeWidth(8);
		pincel.setStyle(Style.STROKE);
		canvas.drawPath(trazo, pincel);
		pincel.setStrokeWidth(1);
		pincel.setStyle(Style.FILL);
		pincel.setTextSize(20);
		pincel.setTypeface(Typeface.SANS_SERIF);
		canvas.drawTextOnPath("Pablo Monteserín", trazo, 10, 40, pincel);
	}
}