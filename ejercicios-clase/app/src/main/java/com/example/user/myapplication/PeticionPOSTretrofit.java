package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

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

public class PeticionPOSTretrofit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peticion_postretrofit);

        hacerPeticion();
    }

    public void hacerPeticion() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("https://www.pablomonteserin.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OmarOlmedoAPI api = builder.create(OmarOlmedoAPI.class);
        //api.peticionPost("Pablo", "Monteserín").enqueue(new Callback<ResponseBody>() {
        api.peticionPOST("Omar", "Olmedo").enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String respuesta = response.body().string();
                    Log.d("RESPUESTA", respuesta);
                    Toast.makeText(getBaseContext(), respuesta, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(PeticionPOSTretrofit.this, "Error", Toast.LENGTH_SHORT).show();
            }

            private List<String> fromArrayToList(JSONArray jArray) {
                List<String> lista = new ArrayList<String>();
                for (int i = 0; i < jArray.length(); i++) {
                    try {
                        JSONObject oneObject = jArray.getJSONObject(i);
                        // Pulling items from the array
                        String name = oneObject.getString("name");
                        lista.add(name);
                    } catch (JSONException e) {
                        // Oops
                    }
                }
                return lista;
            }
        });
    }
}