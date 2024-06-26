package com.example.stitchingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stitchingapp.LoginActivity.SignIn_Activity;

public class Splash_Activity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_DURATION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkVerificationStatus();
            }
        }, SPLASH_SCREEN_DURATION);
    }
    private void checkVerificationStatus() {
        SharedPreferences preferences = getSharedPreferences("LoanAppPrefs", MODE_PRIVATE);
        boolean isVerified = preferences.getBoolean("isVerified", false);

        if (isVerified) {
            Intent intent = new Intent(Splash_Activity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(Splash_Activity.this, SignIn_Activity.class);
            startActivity(intent);
        }
        finish();
    }
}