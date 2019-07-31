package com.pablomonteserin.almacenamiento.plantas.con_alarma;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Controller {

	public static List cargaLista(Context ctx) {
		List lista = null;
		SQLiteDatabase db = ctx.openOrCreateDatabase("plantas",
				Context.MODE_PRIVATE, null);
		Cursor c = db.rawQuery("SELECT * FROM planta", null);
		lista = new ArrayList();
		while (c.moveToNext()) {
			Planta planta = new Planta();
			planta.setNombre(c.getString(c.getColumnIndex("nombre")));
			planta.setFrecuenciaRiego(c.getString(c
					.getColumnIndex("frecuencia_riego")));
			planta.setOtrosCuidados(c.getString(c
					.getColumnIndex("otros_cuidados")));
			planta.setUbicacion(c.getString(c
					.getColumnIndex("ubicacion")));
			planta.setFoto(c.getString(c.getColumnIndex("foto")));
			planta.setId(c.getInt(c.getColumnIndex("id")));
			Log.d("plantaId", ""+planta.getId());

			Log.d("plantaId", ""+planta.getId());
			lista.add(planta);
		}
		c.close();
		db.close();
		return lista;
	}
}
