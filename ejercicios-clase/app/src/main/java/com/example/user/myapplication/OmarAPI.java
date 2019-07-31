package com.example.user.myapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface OmarAPI {
    @GET("people/")
    Call<ResponseBody> peticionGET();
}
