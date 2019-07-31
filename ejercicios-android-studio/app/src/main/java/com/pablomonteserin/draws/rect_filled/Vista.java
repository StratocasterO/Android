package com.pablomonteserin.draws.rect_filled;

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
		pincel = new Paint();
	}

	public Vista(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		pincel = new Paint();
	}

	public Vista(Context context, AttributeSet attrs) {
		super(context, attrs);
		pincel = new Paint();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		pincel.setColor(Color.BLUE);
		pincel.setStrokeWidth(8);
		pincel.setStyle(Style.STROKE);
		canvas.drawRect(10, 10, 200, 50, pincel);
		pincel.setColor(Color.RED);
		pincel.setStyle(Style.FILL);
		canvas.drawRect(12,12,198,48, pincel);
	}

}
