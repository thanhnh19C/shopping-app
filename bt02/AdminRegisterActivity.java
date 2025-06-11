// CustomerRegisterActivity.java
package com.example.bt02;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminRegisterActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper; // Assuming you have a DatabaseHelper class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        dbHelper = new DatabaseHelper(this); // Initialize your DatabaseHelper

        EditText editTextCustomerUsername = findViewById(R.id.editTextCustomerUsername);
        EditText editTextCustomerPassword = findViewById(R.id.editTextCustomerPassword);
        Button btnRegisterCustomer = findViewById(R.id.btnRegisterCustomer);


        btnRegisterCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customerUsername = editTextCustomerUsername.getText().toString();
                String customerPassword = editTextCustomerPassword.getText().toString();

                // Validate the input data if needed

                // Save customer data to SQLite
                saveCustomerData(customerUsername, customerPassword);
            }
        });
    }

    private void saveCustomerData(String username, String password) {
        // Get a writable database
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a ContentValues object to store the data
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_USERNAME, username);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);

        // Insert the data into the table
        long newRowId = db.insert(DatabaseHelper.TABLE_PRODUCTS, null, values);


        // Close the database connection
        db.close();

        // Check if data is inserted successfully
        if (newRowId != -1) {
            showToast("Đăng ký tài khoản thành công !" );
        } else {
            showToast("Error inserting user data");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // Close the database helper when the activity is destroyed
        super.onDestroy();
    }
}
