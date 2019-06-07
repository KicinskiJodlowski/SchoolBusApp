package com.example.SchoolBusApp.service;

public class Token {
    public static String userTOKEN() {
        return TOKEN;
    }

    public static void setTOKEN(String TOKEN) {
        Token.TOKEN = "Bearer " + TOKEN;
    }

    //TODO: Prawdopodobnie do usuniecie
    private static String TOKEN;
}
