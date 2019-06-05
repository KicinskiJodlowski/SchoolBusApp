package com.example.SchoolBussApp.model;


public class TokenJSONModel {

    private String token;
    private String id;
    private UserJSONModel user;

//    public TokenJSONModel(String token, String id) {
//        this.token = token;
//        this.id = id;
//    }

    public TokenJSONModel(String token, UserJSONModel user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(UserJSONModel user) {
        this.user = user;
    }

    public UserJSONModel getUser() {
        return user;

    }
}
