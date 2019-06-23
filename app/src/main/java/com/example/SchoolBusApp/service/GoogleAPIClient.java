package com.example.SchoolBusApp.service;

import com.example.SchoolBusApp.model.DirectionResults;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleAPIClient {

    @GET("/maps/api/directions/json")
    Call<ResponseBody> getDirection (@Query("origin") String origin, @Query("destination") String destination, @Query("key")String key);
}

