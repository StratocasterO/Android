package com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.peticionPost;

import com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.PabloAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by monty on 12/11/17.
 */

public class SingletonRetrofitPHP {


    private static SingletonRetrofitPHP INSTANCE = null;
    private static final String BASE_URL = "https://swapi.co/api/"; //https://swapi.co/api/
    private PabloAPI apiService;

    // Private constructor suppresses
    private SingletonRetrofitPHP(){
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
            INSTANCE = new SingletonRetrofitPHP();
        }
    }

    public static SingletonRetrofitPHP getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }


    public PabloAPI getApiProxyServer()
    {
        return apiService;
    }

}