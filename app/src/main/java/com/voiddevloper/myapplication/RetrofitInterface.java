package com.voiddevloper.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {
    @GET("posts/{UserID}")
    Call<DataClass> test_api_get(
            @Path("UserID") String userid);
}
