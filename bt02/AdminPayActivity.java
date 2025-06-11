package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay); // Make sure to create the corresponding XML layout file

        // Initialize btnBackHome
        Button btnBackHome2 = findViewById(R.id.btnBackHome2);

        // Set click listener for btnBackHome
        btnBackHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to AdminHomeActivity when btnBackHome is pressed
                startActivity(new Intent(AdminPayActivity.this, AdminActivity.class));
            }
        });

        Button btnBackHome = findViewById(R.id.btnBackHome);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to AdminHomeActivity when btnBackHome is pressed
                startActivity(new Intent(AdminPayActivity.this, AdminHomeActivity.class));
            }
        });
    }
}
