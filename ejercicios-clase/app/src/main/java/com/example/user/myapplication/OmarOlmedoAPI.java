package com.example.user.myapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OmarOlmedoAPI {
    // Las cabeceras deben estar en consonancia con el tipo de dato que vamos a recuperar u obtendremos un error 406
    // @Headers({"Accept: application/json"})
    @Headers({"Accept: text/html"})
    @FormUrlEncoded
    @POST("curso/php/res/peticion-post-android-2.php/")
    Call<ResponseBody> peticionPOST(@Field("nombre") String nombre, @Field("apellidos") String apellidos);
}
