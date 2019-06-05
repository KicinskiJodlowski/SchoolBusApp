package com.example.SchoolBussApp.service;

public class Token {
    public static String userTOKEN() {
        return TOKEN;
    }

    public static void setTOKEN(String TOKEN) {
        Token.TOKEN = "Bearer " + TOKEN;
    }

    private static String TOKEN;
}
