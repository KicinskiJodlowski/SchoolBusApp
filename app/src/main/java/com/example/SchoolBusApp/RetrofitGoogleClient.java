package com.example.SchoolBusApp;

import com.example.SchoolBusApp.service.GoogleAPIClient;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitGoogleClient {

    private static final String BASE_URL = "https://maps.googleapis.com/";
    private static RetrofitGoogleClient retrofitGoogleClient;
    private Retrofit retrofit;

    public RetrofitGoogleClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(base_url)
//                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .build();
    }

    public static synchronized RetrofitGoogleClient getInstance() {
        if (retrofitGoogleClient == null)
            retrofitGoogleClient = new RetrofitGoogleClient();

        return retrofitGoogleClient;
    }

    public GoogleAPIClient getApi() {
        return retrofit.create(GoogleAPIClient.class);
    }
}
