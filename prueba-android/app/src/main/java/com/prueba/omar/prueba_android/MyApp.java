package com.prueba.omar.prueba_android;

import android.app.Application;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        File file = this.getDatabasePath("empleados");
        if (!file.exists()) {
            file.getParentFile().mkdirs(); // Esto crea todas las carpetas para que la ruta a la bd exista.
            OutputStream os = null;
            InputStream is = null;
            try {
                is = this.getResources().openRawResource(R.raw.empleados);
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