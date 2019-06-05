package com.example.SchoolBussApp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import okhttp3.Credentials;

public class CredentialsModel {

    @SerializedName("credentials")
    @Expose
    private String credentials;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    public CredentialsModel(String email, String password) {
        //this.email = email;
        //this.password = password;
        this.credentials = Credentials.basic(email, password);
    }
}
