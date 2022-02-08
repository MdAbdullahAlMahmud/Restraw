package com.mkrlabs.restraw.ui.qr_code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.mkrlabs.customstatusbar.CustomStatusBar;
import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.ui.HomeActivity;

public class QRCodeActivity extends AppCompatActivity {

    MaterialButton exploreRestrawButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomStatusBar.transparentStatusBarWithIcon(this,false);
        setContentView(R.layout.activity_qrcode);
        inits();

        exploreRestrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRCodeActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    private void inits() {
        exploreRestrawButton= findViewById(R.id.exploreRestrawButton);
    }
}