package com.pablomonteserin.XML_JSON_y_AsyncTask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pablomonteserin.ejercicios.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class AsynTaskPorGET extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asyntask_peticion_basica);
    }

public void hacerPeticion(View v){
    new MiAsyncTask().execute("https://pablomonteserin.com/apuntes/java/rec/login.php");
}

    private class MiAsyncTask extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            StringBuilder content = new StringBuilder();

            try
            {
                URL url = new URL(urls[0]);

                URLConnection urlConnection = url.openConnection();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                String line;

                while ((line = bufferedReader.readLine()) != null)
                {
                    content.append(line + "\n");
                }
                bufferedReader.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return content.toString();
        }
        protected void onPostExecute(String txt) {
//El método onPostExecute debe recibir lo que devuelve el doInBackground (en este caso, un String)
            Toast.makeText(AsynTaskPorGET.this, txt,Toast.LENGTH_SHORT).show();
        }
        }
    }
