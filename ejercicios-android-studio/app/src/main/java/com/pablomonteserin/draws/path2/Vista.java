package com.pablomonteserin.draws.path2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class Vista extends View {
	Path trazo;
	Paint pincel;

	public Vista(Context context) {
		super(context);
		trazo = new Path();
		pincel = new Paint();
	}

	public Vista(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		trazo = new Path();
		pincel = new Paint();
	}

	public Vista(Context context, AttributeSet attrs) {
		super(context, attrs);
		trazo = new Path();
		pincel = new Paint();
	}
	
	protected void onDraw(Canvas canvas){
		trazo.moveTo(50, 100);
		trazo.cubicTo(60, 70, 150, 90, 200, 110);
		trazo.lineTo(300, 200);
		canvas.drawColor(Color.YELLOW);
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
