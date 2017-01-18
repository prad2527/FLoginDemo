package com.example.user.flogindemo;

import android.app.Application;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

/**
 * Created by jaysingh on 26/7/16.
 */
public class GlobalClass extends Application
{

    CallbackManager callbackManager;

    @Override
    public void onCreate()
    {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();


    }
}
