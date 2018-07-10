package com.example.dijonkariz.washme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.dijonkariz.washme.Model.User;

public class SharedPrefManager {

    private static SharedPrefManager sharedPrefManager;
    private static Context mcontext;

    private static final String SHARED_PREF_NAME = "sharedprefalpha";
    private static final String USER_ID = "kuserid";
    private static final String USER_NAME = "kusername";
    private static final String USER_TYPE = "kusertype";



    public SharedPrefManager(Context context) {

        mcontext = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (sharedPrefManager == null) {
            sharedPrefManager = new SharedPrefManager(context);
        }
        return sharedPrefManager;
    }

    public void Login(User user){
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(USER_ID, user.getId());
        editor.putString(USER_NAME, user.getName());
        editor.putString(USER_TYPE, user.getUser_type());
        editor.apply();
    }

    public boolean areLoggedIn(){

        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_NAME, null) != null;

    }

    public User getUser(){
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(

                sharedPreferences.getInt(USER_ID, -1),
                sharedPreferences.getString(USER_NAME, null),
                sharedPreferences.getString(USER_TYPE, null)
        );
    }

    public void logout(){
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mcontext.startActivity(new Intent(mcontext, LogIn.class));
    }
}
