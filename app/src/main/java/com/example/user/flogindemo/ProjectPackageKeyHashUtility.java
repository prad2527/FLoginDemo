package com.example.user.flogindemo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Felix-ITS012 on 21/05/16.
 */
public class ProjectPackageKeyHashUtility
{

    private Context mcontext;

    public ProjectPackageKeyHashUtility(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void getPackageInfo()
    {
        try
        {
            PackageInfo pachageInfo = mcontext.getPackageManager().getPackageInfo("com.example.user.flogindemo",
                    PackageManager.GET_SIGNATURES);

            for (Signature signature : pachageInfo.signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
        }
    }
}


