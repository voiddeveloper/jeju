package com.voiddevloper.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private static RetrofitApi retrofitApi;
    private static final String BASE_URL = "https://api.odcloud.kr/api/15049999/v1/";

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitApi = retrofit.create(RetrofitApi.class);
    }

    public static RetrofitClient getInstance() {
        if(instance==null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static RetrofitApi getRetrofitApi() {
        return retrofitApi;
    }
}
