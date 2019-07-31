package com.pablomonteserin.draws.rect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class Vista extends View {
	Paint pincel;  
	public Vista(Context context) {
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
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		pincel.setColor(Color.BLUE);
		pincel.setStrokeWidth(8);
		pincel.setStyle(Style.STROKE);
		canvas.drawRect(10, 10, 200, 50, pincel);
	}
	

}
