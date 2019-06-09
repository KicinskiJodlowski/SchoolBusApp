package com.example.SchoolBusApp.service;

import com.example.SchoolBusApp.model.EventModel;
import com.example.SchoolBusApp.model.GuestModel;
import com.example.SchoolBusApp.model.NotifyRegisterModel;
import com.example.SchoolBusApp.model.QrCodeModel;

import java.util.ArrayList;

import lombok.Getter;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserAPIClient {

    //    @Headers({
//            "Content-Type: application/x-www-form-urlencoded",
//            "accept-encoding: gzip, deflate",
//           // "access_token: mtlNzTVmXP4IBSba3z4XgcpxibboPvaF",
//            //"Authorization: Basic a2FtaWwua2ljaW5za2lAc3R1ZGVudC53YXQuZWR1LnBsOnF3ZXJ0eQ=="
//    })
    @FormUrlEncoded
    @POST("/auth")
    Call<ResponseBody> login(@Header("Authorization") String credentials, @Field("access_token") String authKey);
    //encoded(@Path("name") String name);

    @FormUrlEncoded
    @POST("/users")
    Call<ResponseBody> register(@Field("access_token") String authKey, @Field("email") String email, @Field("password") String password);

    //    tak naprawde sprawdza uprawnienia
    @GET("/passengers")
    Call<ResponseBody> user_role_check(@Query("access_token") String authKey, @Query("limit") String limit);

    @FormUrlEncoded
    @PUT("/users/{id}")
    Call<ResponseBody> updateLocation(@Path("id") String id, @Field("access_token") String authKey, @Field("latitude") String latitude, @Field("longitude") String longitude);

    @FormUrlEncoded
    @GET("/users")
    Call<ResponseBody> getAllUsers(@Query("access_token") String authKey);


    //@POST("/api/AppUser/Register")
    //Call<RegisterResponseModel> register(@Body UserJSONModel user);
    //"succeeded": true,
    //    "errors": []

    @GET("api/Event/userEvent")
    Call<ArrayList<EventModel>> getEvents(@Header("Authorization") String authKey);

    @GET("api/InvitedGuest/eventGuest/{id}")
    Call<ArrayList<GuestModel>> getGuests(
            @Path("id") int id,
            @Header("Authorization") String authKey
    );

    @GET("api/Event/{id}")
    Call<EventModel> getEvent(
            @Path("id") int id,
            @Header("Authorization") String authKey
    );

    @Headers({"Content-Type: application/json"})
    @PUT("api/Event/{id}")
    Call<ResponseBody> updateEvent(
            @Path("id") int id,
            @Header("Authorization") String authKey,
            @Body RequestBody params
    );

    @Headers({"Content-Type: application/json"})
    @POST("api/Event")
    Call<ResponseBody> addEvent(
            @Header("Authorization") String authKey,
            @Body RequestBody params
    );

    @Headers({"Content-Type: application/json"})
    @POST("api/Event/inviteQR")
    Call<String> addToEvent(
            @Header("Authorization") String authKey,
            @Body QrCodeModel qrCodeModel
    );

    //Notyfikacje
    @GET("api/notifications/register")
    Call<String> getRegisterID(
            @Header("Authorization") String authKey
    );

    @PUT("api/notifications/enable/{registerID}")
    Call<ResponseBody> notifyRegister(
            @Path("registerID") String registerID,
            @Header("Authorization") String authKey,
            @Body NotifyRegisterModel notifyRegistermodel
    );

    @DELETE("api/notifications/unregister/{registerID}")
    Call<ResponseBody> notifyUnregister(
            @Path("registerID") String registerID,
            @Header("Authorization") String authKey
    );
}
