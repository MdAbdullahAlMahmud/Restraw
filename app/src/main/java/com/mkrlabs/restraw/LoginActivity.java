package com.mkrlabs.restraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mkrlabs.customstatusbar.CustomStatusBar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomStatusBar.transparentStatusBarWithIcon(this,false);
        setContentView(R.layout.activity_login);
    }
}