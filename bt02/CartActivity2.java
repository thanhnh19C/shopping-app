package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CartActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart2);


        // Initialize btnPay2
        Button btnPay2 = findViewById(R.id.btnPay2);

        // Set click listener for btnPay2
        btnPay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay2 is pressed
                startActivity(new Intent(CartActivity2.this, CustomerPay.class));
            }
        });
        Button btnCart2 = findViewById(R.id.btnCart2);
        // Set click listener for btnPay1
        btnCart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to PayActivity when btnPay1 is pressed
                startActivity(new Intent(CartActivity2.this, CartProduct2.class));
            }
        });
    }
}
