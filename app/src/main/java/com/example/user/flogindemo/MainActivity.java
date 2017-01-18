package com.example.user.flogindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    GlobalClass mGlobalClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        mGlobalClass = (GlobalClass) getApplicationContext();



        ProjectPackageKeyHashUtility projectPackageKeyHashUtility = new ProjectPackageKeyHashUtility(MainActivity.this);
        projectPackageKeyHashUtility.getPackageInfo();



        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);


        loginButton.registerCallback(mGlobalClass.callbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                Toast.makeText(MainActivity.this,loginResult.toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancel()
            {

                Toast.makeText(MainActivity.this,"onCancel",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException error)
            {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        mGlobalClass.callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
