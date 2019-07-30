package com.example.user.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PeticionGET extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peticion_get);

        new MiAsyncTask().execute("https://pablomonteserin.com/curso/php/res/leer-valor.php");
    }

    private class MiAsyncTask extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(urls[0]);
                URLConnection urlConnection;
                urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        //El método onPostExecute debe recibir lo que devuelve el doInBackground (en este caso, un String)
        protected void onPostExecute(String txt) {
            TextView tv = findViewById(R.id.textView);
            tv.setText(txt);
        }
    }
}
