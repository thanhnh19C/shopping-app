package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class YourCurrentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home); // Replace with your actual layout file name

        Button btnAddToCart2 = findViewById(R.id.btnAddToCart2);

        // Set an OnClickListener for the button
        btnAddToCart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start CartActivity when the button is clicked
                startActivity(new Intent(YourCurrentActivity.this, CartActivity.class));
            }
        });
    }
}
