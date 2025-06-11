package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class CartActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart7);

// Initialize btnPay2
        Button btnPay7 = findViewById(R.id.btnPay7);

        // Set click listener for btnPay2
        btnPay7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay2 is pressed
                startActivity(new Intent(CartActivity7.this, CustomerPay.class));
            }
        });

        Button btnCart7 = findViewById(R.id.btnCart7);
        // Set click listener for btnPay1
        btnCart7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartActivity7.this, CartProduct7.class));
            }
        });

    }
}
