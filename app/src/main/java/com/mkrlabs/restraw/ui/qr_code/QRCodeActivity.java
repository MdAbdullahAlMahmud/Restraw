package com.mkrlabs.restraw.ui.qr_code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.mkrlabs.customstatusbar.CustomStatusBar;
import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.ui.HomeActivity;
import com.mkrlabs.restraw.utils.QRScanner;

public class QRCodeActivity extends AppCompatActivity {

    public static  TextView qrTextTV;

    MaterialButton exploreRestrawButton,scanQrCode;
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
        scanQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRCodeActivity.this, QRScanner.class);
                startActivity(intent);
               // finish();

            }
        });

    }

    private void inits() {
        scanQrCode= findViewById(R.id.scanQrCode);
        qrTextTV= findViewById(R.id.qrText);
        exploreRestrawButton= findViewById(R.id.exploreRestrawButton);
    }
}