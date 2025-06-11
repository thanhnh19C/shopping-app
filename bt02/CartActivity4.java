package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class CartActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart4);

// Initialize btnPay2
        Button btnPay4 = findViewById(R.id.btnPay4);

        // Set click listener for btnPay2
        btnPay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay2 is pressed
                startActivity(new Intent(CartActivity4.this, CustomerPay.class));
            }
        });

        Button btnCart4 = findViewById(R.id.btnCart4);
        // Set click listener for btnPay1
        btnCart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartActivity4.this, CartProduct4.class));
            }
        });
    }
}
