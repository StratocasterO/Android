package com.pablomonteserin.almacenamiento;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.util.Log;

import com.pablomonteserin.ejercicios.R;


public class Precarga extends Application {
	private boolean hayActualizacion;
	@Override
	public void onCreate() {
		super.onCreate();
		//AppEventLogger.activateApp(this);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		int version = prefs.getInt("version", -1);

		try {
			PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
			int posible_nueva_version = pInfo.versionCode;
			if(version<posible_nueva_version){
				hayActualizacion = true;
				SharedPreferences.Editor editor = prefs.edit();
				editor.putInt("version", posible_nueva_version);
				editor.commit();
			}else{
				hayActualizacion = false;
			}
		} catch (PackageManager.NameNotFoundException e1) {
			e1.printStackTrace();
		}


		if( hayActualizacion) {

			OutputStream os = null;
			InputStream is = null;
			File file = this.getDatabasePath("nombre_base_datos");
			if (!file.exists()) {
				file.getParentFile().mkdirs();// Esto crea todas las carpetas para que esta ruta exista. Esta es la ruta de la base de datos.
			}
					Log.d("paso1", "copiamos la base de datos si no existía antes");

				try {
					is = this.getResources().openRawResource(
							R.raw.nombre_base_datos);
					os = new FileOutputStream(file);
					byte[] buffer = new byte[1024];
					int length;
					while ((length = is.read(buffer)) > 0) {
						os.write(buffer, 0, length);
					}
					os.flush();
				} catch (Throwable t) {//e.printStackTrace();
				} finally {
					try {
						if (os != null)
							os.close();
					} catch (IOException e) {//e.printStackTrace();
					}
					if (is != null) {
						try {
							is.close();
						} catch (IOException e) {//e.printStackTrace();
						}
					}
				}


			//////////////////////////////////////////
			file = this.getDatabasePath("invitado_db");
			if (!file.exists()) {
				file.getParentFile().mkdirs();// Esto crea todas las carpetas para que esta ruta exista. Esta es la ruta de la base de datos.
			}
				Log.d("paso1", "copiamos la base de datos si no existía antes");
				 os = null;
				 is = null;
				try {
					is = this.getResources().openRawResource(
							R.raw.invitado_db);
					os = new FileOutputStream(file);
					byte[] buffer = new byte[1024];
					int length;
					while ((length = is.read(buffer)) > 0) {
						os.write(buffer, 0, length);
					}
					os.flush();
				} catch (Throwable t) {//e.printStackTrace();
				} finally {
					try {
						if (os != null)
							os.close();
					} catch (IOException e) {//e.printStackTrace();
					}
					if (is != null) {
						try {
							is.close();
						} catch (IOException e) {//e.printStackTrace();
						}
					}
				}
				////////////////////////////////////////////////
				file = this.getDatabasePath("plantas");
				if (!file.exists()) {
					file.getParentFile().mkdirs();// Esto crea todas las carpetas para
				}
					// que la ruta a la bd exista.
					os = null;
					is = null;
					try {
						is = this.getResources().openRawResource(R.raw.plantas);
						os = new FileOutputStream(file);
						byte[] buffer = new byte[1024];
						int length;
						while ((length = is.read(buffer)) > 0) {
							os.write(buffer, 0, length);
						}
						os.flush();
					} catch (Throwable t) {// e.printStackTrace();
					} finally {
						try {
							if (os != null)
								os.close();
						} catch (IOException e) {// e.printStackTrace();
						}
						if (is != null) {
							try {
								is.close();
							} catch (IOException e) {// e.printStackTrace();
							}
						}
					}


				///////////////////////

				file = this.getDatabasePath("lugares");
				if (!file.exists()) {
					file.getParentFile().mkdirs();// Esto crea todas las carpetas para que esta ruta exista. Esta es la ruta de la base de datos.
				}
					os = null;
					is = null;
					try {
						is = this.getResources().openRawResource(
								R.raw.lugares);
						os = new FileOutputStream(file);
						byte[] buffer = new byte[1024];
						int length;
						while ((length = is.read(buffer)) > 0) {
							os.write(buffer, 0, length);
						}
						os.flush();
					} catch (Throwable t) {//e.printStackTrace();
					} finally {
						try {
							if (os != null)
								os.close();
						} catch (IOException e) {//e.printStackTrace();
						}
						if (is != null) {
							try {
								is.close();
							} catch (IOException e) {//e.printStackTrace();
							}
						}
					}
				}
			}
		}




