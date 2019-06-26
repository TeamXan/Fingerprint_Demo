package com.xan.fingerprint_demo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

    private Context context;

    public FingerprintHandler(Context context){

        this.context = context;

    }

    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject){

        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, this, null);

    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {

       // this.update("There was an Auth Error. " + errString, false);
        Toast.makeText(context,"There was an Auth Error.",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAuthenticationFailed() {

       // this.update("Auth Failed. ", false);
        Toast.makeText(context,"Auth Failed..",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {

        //this.update("Error: " + helpString, false);
        Toast.makeText(context,"Error: " + helpString,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {

        //this.update("You can now access the app.", true);
        context.startActivity(new Intent(context,
                LoginActivity.class));

    }


}
