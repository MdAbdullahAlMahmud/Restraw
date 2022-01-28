package com.mkrlabs.restraw.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mkrlabs.customstatusbar.CustomStatusBar;
import com.mkrlabs.restraw.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomStatusBar.transparentStatusBarWithIcon(this,false);
        setContentView(R.layout.activity_login);
    }
}