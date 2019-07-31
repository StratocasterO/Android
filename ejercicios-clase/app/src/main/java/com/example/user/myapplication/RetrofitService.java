package com.example.user.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static RetrofitService INSTANCE = null;
    private static final String BASE_URL = "http://10.0.2.2:3000/";
    // Se pone la ID del server porque localhost es la de la máquina virtual
    private ImagenAPI apiService;

    // Private constructor suppresses
    private RetrofitService() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = builder.create(ImagenAPI.class);
    }

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitService();
        }
    }

    public static RetrofitService getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    public ImagenAPI getApiProxyServer() {
        return apiService;
    }
}