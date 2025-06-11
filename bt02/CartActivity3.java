package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CartActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart3);

        // Initialize btnPay3
        Button btnPay3 = findViewById(R.id.btnPay3);

        // Set click listener for btnPay3
        btnPay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to AdminPayActivity when btnPay3 is pressed
                startActivity(new Intent(CartActivity3.this, CustomerPay.class));
            }
        });

        // Initialize btnCart3
        Button btnCart3 = findViewById(R.id.btnCart3);

        // Set click listener for btnCart3
        btnCart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to CartProduct3 activity when btnCart3 is pressed
                startActivity(new Intent(CartActivity3.this, CartProduct3.class));
            }
        });
    }
}
