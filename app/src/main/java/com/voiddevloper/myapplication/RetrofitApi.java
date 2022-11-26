package com.voiddevloper.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitApi {
    @Headers("Authorization:C4%2BBhRfsgoTTfNNCazCNuSn5UsGIAt7R97wQCdN2vD4LIoSqFhM8J9eIZFG9WM797KTf35zlKLPVp2Yq6kFz9g%3D%3D")
    @GET("uddi:b18230d3-a3a8-49c3-9e22-fddebf8338c1")
    Call<DataClass> getData(@Query("serviceKey") String serviceKey, @Query("page") int page, @Query("perPage") int perPage);
}
