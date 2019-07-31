package com.pablomonteserin.mapas.Monumentos;

import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Controller {

	public static HashMap<Integer,Monumento> getMonumentos(Context ctx){
		
		SQLiteDatabase db = ctx.openOrCreateDatabase("lugares", Context.MODE_PRIVATE,
				null);
		Cursor c = db.rawQuery("SELECT * FROM lugar", null);
		HashMap<Integer, Monumento> monumentos = new HashMap<Integer, Monumento>();
		while (c.moveToNext()) {

			Monumento monumento = new Monumento(c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("nombre")),c.getString(c.getColumnIndex("descripcion")),c.getInt(c.getColumnIndex("latitud")),c.getInt(c.getColumnIndex("longitud")));
			monumentos.put(monumento.getId(), monumento);
		}
		c.close();
		db.close();
		return monumentos;
	}
}
