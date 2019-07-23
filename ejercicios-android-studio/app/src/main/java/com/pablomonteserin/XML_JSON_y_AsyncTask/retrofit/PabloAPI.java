package com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by monty on 12/11/17.
 */

public interface PabloAPI {


    @Multipart
    @POST("subida/upload")
    Call<ResponseBody> uploadFile(@Part("description") RequestBody description, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("curso/php/res/peticion-post.php")
    Call<ResponseBody> peticionPost(@Field("nombre") String nombre, @Field("apellidos") String apellidos);

    @GET("people/")
    Call<ResponseBody> peticionGET();

}
