package com.example.SchoolBusApp.model;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Data;

@Data
public class UserJSONModel {

    private String id;
    private String name;
    private String picture;
    private String email;
    private String createdAt;


    public UserJSONModel(String id, String name, String picture, String email, String createdAt) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.email = email;
        this.createdAt = createdAt;
    }

    public UserJSONModel(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString("id");
        this.name = jsonObject.getString("name");
        this.picture = jsonObject.getString("picture");
        this.email = jsonObject.getString("email");
        this.createdAt = jsonObject.getString("createdAt");
    }

}
//        "id": "5cf59bbcc43c5b00171b2542",
//        "name": "kamil.kicinski",
//        "picture": "https://gravatar.com/avatar/3a96665d49bb533032279f1f076397d5?d=identicon",
//        "email": "kamil.kicinski@student.wat.edu.pl",
//        "createdAt": "2019-06-03T22:14:20.906Z"