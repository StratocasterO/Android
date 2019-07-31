package com.example.user.myapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface OmarAPI {
    @GET("people/?page=2")
        // Añadido a la URL a la que se añade la petición
    Call<ResponseBody> peticionGET();
}
