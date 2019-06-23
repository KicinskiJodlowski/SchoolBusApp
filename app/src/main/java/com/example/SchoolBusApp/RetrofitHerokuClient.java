package com.example.SchoolBusApp;

import com.example.SchoolBusApp.service.UserAPIClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHerokuClient {

    private static final String BASE_URL = "https://school-bus-api.herokuapp.com";
    private static RetrofitHerokuClient retrofitHerokuClient;
    private Retrofit retrofit;

    public RetrofitHerokuClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitHerokuClient getInstance() {
        if (retrofitHerokuClient == null)
            retrofitHerokuClient = new RetrofitHerokuClient();

        return retrofitHerokuClient;
    }

    public UserAPIClient getApi() {
        return retrofit.create(UserAPIClient.class);
    }
}
