package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {





    // Example: Assume you have a selectedPosition
    private int selectedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);



        // Initialize RecyclerView, ProductAdapter, and product list







        // Find the button by ID
        Button gotoAdminHomeButton1 = findViewById(R.id.btnGoToAdminHome);

        // Find the button by ID
        Button gotoCustomerHomeButton2 = findViewById(R.id.btnGoToCustomerHome);

        // Find the button by ID
        Button btnOut = findViewById(R.id.btnOut);

        

        // Set a click listener for the button
        gotoAdminHomeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the AdminHomeActivity
                Intent intent = new Intent(AdminActivity.this, AdminHomeActivity.class);
                startActivity(intent);
            }
        });

        // Set a click listener for the button
        gotoCustomerHomeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the AdminHomeActivity
                Intent intent = new Intent(AdminActivity.this, CustomerHomeActivity.class);
                startActivity(intent);
            }
        });

        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity, effectively closing the application
                finish();
            }
        });


    }

    // Helper method to clear input fields

}
