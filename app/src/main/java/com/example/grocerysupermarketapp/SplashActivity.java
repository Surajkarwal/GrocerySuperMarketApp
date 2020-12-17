package com.example.grocerysupermarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SPLASH_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Thread thread = new Thread(){
            public void run(){
                try{
                    // threat will sleep for 5 seconds
                    sleep(5*1000);

                    // after sleep redirect to another activity
                    startActivity(new Intent(getBaseContext(), MainActivity.class));

                    // remove activity
                    finish();
                }catch(Exception e){
                    Log.d(TAG, "Exception for run : " +e);
                }
            }
        };

        // start thread
        thread.start();
    }
}

/*
References:
Logo: https://www.logodesign.net/logo/grocery-in-cart-included-with-stars-6045ld.png
 */