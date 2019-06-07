package com.example.SchoolBusApp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.SchoolBusApp.R;

public class SharedPreferenceManager {

    private static SharedPreferences mSharedPref;
    public static final String TOKEN = "token";
    public static final String ID = "id";
    public static final String Login = "login";
    public static final String MASTER_KEY = "master_token";
    public static final String AUTH = "auth";
    public static final String USER_TYPE = "user_type";


    private SharedPreferenceManager()
    {

    }

    public static void init(Context context)
    {
        if(mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        write(MASTER_KEY, context.getString(R.string.master_token));
    }

    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public static void remove(String key){
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.remove(key);
        prefsEditor.apply();
    }

    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public static Integer read(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public static void write(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value).apply();
    }

}
