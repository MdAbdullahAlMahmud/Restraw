package com.mkrlabs.restraw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.mkrlabs.customstatusbar.CustomStatusBar;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomStatusBar.transparentStatusBarWithIcon(this,false);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                finish();
            }
        },3000);
    }
}