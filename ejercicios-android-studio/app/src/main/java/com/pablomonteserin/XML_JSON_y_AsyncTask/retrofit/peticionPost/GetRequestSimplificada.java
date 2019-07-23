package com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.peticionPost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.PabloAPI;
import com.pablomonteserin.ejercicios.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRequestSimplificada extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_request);

    }

    public void hacerPeticion(View v){


        Retrofit builder = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PabloAPI api = builder.create(PabloAPI.class);
        //api.peticionPost("Pablo", "Monteserrín").enqueue(new Callback<ResponseBody>() {
        api.peticionGET().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String respuesta = response.body().string();
                   Log.d("RESPUESTA", respuesta);
                    Toast.makeText(getBaseContext(), respuesta, Toast.LENGTH_LONG).show();

                    JSONObject jObject = null;
                    try {
                        jObject = new JSONObject(respuesta);
                        JSONArray jArray = jObject.getJSONArray("results");
                        List <String> lista = fromArrayToList(jArray);
                        ListView lv = findViewById(R.id.personas);
                        lv.setAdapter(new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,lista));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(GetRequestSimplificada.this, "Error", Toast.LENGTH_SHORT).show();
            }


            private List<String>fromArrayToList(JSONArray jArray){
                List<String>lista = new ArrayList<String>();
                for (int i=0; i < jArray.length(); i++)
                {
                    try {
                        JSONObject oneObject = jArray.getJSONObject(i);
                        // Pulling items from the array
                        String name = oneObject.getString("name");
                        lista.add(name);

                    } catch (JSONException e) {
                        // Oops
                    }
                }
                return  lista;
            }
        });


}
}
