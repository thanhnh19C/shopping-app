package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class CartActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart8);

// Initialize btnPay2
        Button btnPay8 = findViewById(R.id.btnPay8);

        // Set click listener for btnPay2
        btnPay8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay2 is pressed
                startActivity(new Intent(CartActivity8.this, CustomerPay.class));
            }
        });

        Button btnCart8 = findViewById(R.id.btnCart8);
        // Set click listener for btnPay1
        btnCart8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartActivity8.this, CartProduct8.class));
            }
        });

    }
}
