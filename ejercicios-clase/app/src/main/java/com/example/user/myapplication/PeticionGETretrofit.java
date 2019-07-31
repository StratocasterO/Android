package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
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

public class PeticionGETretrofit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peticion_getretrofit);

        hacerPeticion();
    }

    public void hacerPeticion() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OmarAPI api = builder.create(OmarAPI.class);
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
                        List<String> lista = fromArrayToList(jArray);
                        ListView lv = findViewById(R.id.personas);
                        lv.setAdapter(new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, lista));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ListView lv = findViewById(R.id.personas);
                setListViewHeightBasedOnChildren(lv);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(PeticionGETretrofit.this, "Error", Toast.LENGTH_SHORT).show();
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

    // Método para adaptar la altura del ListView al contenido
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}