package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class CartActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart5);

// Initialize btnPay2
        Button btnPay5 = findViewById(R.id.btnPay5);

        // Set click listener for btnPay2
        btnPay5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay2 is pressed
                startActivity(new Intent(CartActivity5.this, CustomerPay.class));
            }
        });
        Button btnCart5 = findViewById(R.id.btnCart5);
        // Set click listener for btnPay1
        btnCart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartActivity5.this, CartProduct5.class));
            }
        });

    }
}
