package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_next);

        // Add any other initialization code if needed

        // Initialize btnPay1
        Button btnPay1 = findViewById(R.id.btnPay1);

        // Set click listener for btnPay1
        btnPay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartActivity.this, CustomerPay.class));
            }
        });

        Button btnCart1 = findViewById(R.id.btnCart1);

        // Set click listener for btnPay1
        btnCart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartActivity.this, CartProduct.class));
            }
        });







    }
}
