package com.example.bt02;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerLoginActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper; // Assuming you have a DatabaseHelper class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_customer);

        dbHelper = new DatabaseHelper(this); // Initialize your DatabaseHelper

        EditText editTextCustomerUsername = findViewById(R.id.editTextCustomerUsername);
        EditText editTextCustomerPassword = findViewById(R.id.editTextCustomerPassword);
        Button btnCustomerLogin = findViewById(R.id.btnCustomerLogin);
        Button btnCustomerRegister = findViewById(R.id.btnCustomerRegister);

        btnCustomerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customerUsername = editTextCustomerUsername.getText().toString();
                String customerPassword = editTextCustomerPassword.getText().toString();

                if (isCustomerCredentialsValid(customerUsername, customerPassword)) {
                    // Save customer data to SQLite
                    saveCustomerData(customerUsername, customerPassword);

                    // Customer login successful, navigate to CustomerHomeActivity
                    // Replace CustomerHomeActivity.class with your actual activity name
                    Intent intent = new Intent(CustomerLoginActivity.this, CustomerHomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(CustomerLoginActivity.this, "Thông tin không hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCustomerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Switch to CustomerRegisterActivity
                Intent intent = new Intent(CustomerLoginActivity.this, CustomerRegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isCustomerCredentialsValid(String username, String password) {
        // Implement your authentication logic here
        // For simplicity, this example always returns true, replace with your actual logic
        return true;
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
            showToast("Đăng nhập thành công!");
        } else {
            showToast("Lỗi chèn dữ liệu khách hàng");
        }
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // Close the database helper when the activity is destroyed
        dbHelper.close();
        super.onDestroy();
    }


    }
