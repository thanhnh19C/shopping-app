package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerPay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_pay_activity); // Make sure to create the corresponding XML layout file

        // Initialize btnBackHome1
        Button btnBackHome1 = findViewById(R.id.btnBackHome);

        // Set click listener for btnBackHome1
        btnBackHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to CustomerHomeActivity when btnBackHome1 is pressed
                startActivity(new Intent(CustomerPay.this, CustomerHomeActivity.class));
            }
        });


    }
}
