package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class CartActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart6);

// Initialize btnPay2
        Button btnPay6 = findViewById(R.id.btnPay6);

        // Set click listener for btnPay2
        btnPay6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay2 is pressed
                startActivity(new Intent(CartActivity6.this, CustomerPay.class));
            }
        });
        Button btnCart6 = findViewById(R.id.btnCart6);
        // Set click listener for btnPay1
        btnCart6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartActivity6.this, CartProduct6.class));
            }
        });

    }
}
