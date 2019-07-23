package com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.peticionPost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.PabloAPI;
import com.pablomonteserin.ejercicios.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRequest extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);

    }

    public void hacerPeticion(View v){


        SingletonRetrofitPHP retrofitService = SingletonRetrofitPHP.getInstance();
        PabloAPI api = retrofitService.getApiProxyServer();
        //api.peticionPost("Pablo", "Monteserrín").enqueue(new Callback<ResponseBody>() {
        api.peticionGET().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String respuesta = response.body().string();
                   Log.d("RESPUESTA", respuesta);
                    Toast.makeText(PostRequest.this, "Aqui vendria la respuesta", Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(PostRequest.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


}
}
