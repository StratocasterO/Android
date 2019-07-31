package com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.subirimagen;

import com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.PabloAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by monty on 12/11/17.
 */

public class SingletonRetrofit {


    private static SingletonRetrofit INSTANCE = null;
    private static final String BASE_URL = "http://pablomonteserin.com:19139";
    private PabloAPI apiService;

    // Private constructor suppresses
    private SingletonRetrofit(){
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        apiService = builder.create(PabloAPI.class);
    }

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonRetrofit();
        }
    }

    public static SingletonRetrofit getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }


    public PabloAPI getApiProxyServer()
    {
        return apiService;
    }

}