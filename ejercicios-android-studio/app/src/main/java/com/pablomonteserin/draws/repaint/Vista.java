package com.pablomonteserin.draws.repaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Vista extends View {
	Paint pincel;
	private float x;
	private float y;

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

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		pincel.setColor(Color.BLUE);
		pincel.setStrokeWidth(8);
		pincel.setStyle(Style.STROKE);
		canvas.drawRect(x + 10, y + 10, x + 200, y + 50, pincel);
		
		
	}

	private void iniciar() {
		pincel = new Paint();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		x = event.getX();
		y = event.getY();
		// Fuerzo el repintado
		this.invalidate();
		return super.onTouchEvent(event);
	}

}
