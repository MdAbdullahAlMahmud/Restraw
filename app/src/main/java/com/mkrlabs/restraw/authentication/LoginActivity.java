package com.mkrlabs.restraw.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mkrlabs.customstatusbar.CustomStatusBar;
import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.ui.qr_code.QRCodeActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView takeATourTV;
    private AppCompatButton signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomStatusBar.transparentStatusBarWithIcon(this,false);
        setContentView(R.layout.activity_login);
        inits();

        takeATourTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, QRCodeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, QRCodeActivity.class);
                startActivity(intent);
                finish();
            }
        });





    }

    private void inits() {
        takeATourTV =findViewById(R.id.takeATourTV);
        signInButton =findViewById(R.id.signInButton);
    }
}