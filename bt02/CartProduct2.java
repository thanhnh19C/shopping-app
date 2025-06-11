package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CartProduct2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cartp2);

        // You can add additional initialization code for your CartProduct activity here
        Button btnPay1 = findViewById(R.id.btnPay1);

        // Set click listener for btnPay1
        btnPay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartProduct2.this, CustomerPay.class));
            }
        });

        Button btnBackHome = findViewById(R.id.btnBackHome);

        // Set click listener for btnPay1
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartProduct2.this, CustomerHomeActivity.class));
            }
        });


        // Add any other initialization code or methods as needed
    }
}
