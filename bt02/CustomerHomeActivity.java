// CustomerHomeActivity.java
package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerHomeActivity extends AppCompatActivity {


    private EditText editTextProductName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        // Initialize EditText
        editTextProductName = findViewById(R.id.editTextProductName);

        // Set up TextWatcher to detect changes in the product name input
        editTextProductName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // Not needed for this example
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Filter products based on the entered product name
                filterProducts(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Not needed for this example
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart1
        Button btnAddToCart1 = findViewById(R.id.btnAddToCart1);
        btnAddToCart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity khi nút được nhấn
                startActivity(new Intent(CustomerHomeActivity.this, CartActivity.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart2
        Button btnAddToCart2 = findViewById(R.id.btnAddToCart2);
        btnAddToCart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity2 khi nút được nhấn
                startActivity(new Intent(CustomerHomeActivity.this, CartActivity2.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart3
        Button btnAddToCart3 = findViewById(R.id.btnAddToCart3);
        btnAddToCart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity3 khi nút được nhấn
                startActivity(new Intent(CustomerHomeActivity.this, CartActivity3.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart4
        Button btnAddToCart4 = findViewById(R.id.btnAddToCart4);
        btnAddToCart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity4 khi nút được nhấn
                startActivity(new Intent(CustomerHomeActivity.this, CartActivity4.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart5
        Button btnAddToCart5 = findViewById(R.id.btnAddToCart5);
        btnAddToCart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity5 khi nút được nhấn
                startActivity(new Intent(CustomerHomeActivity.this, CartActivity5.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart6
        Button btnAddToCart6 = findViewById(R.id.btnAddToCart6);
        btnAddToCart6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity6 khi nút được nhấn
                startActivity(new Intent(CustomerHomeActivity.this, CartActivity6.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart7
        Button btnAddToCart7 = findViewById(R.id.btnAddToCart7);
        btnAddToCart7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity7 khi nút được nhấn
                startActivity(new Intent(CustomerHomeActivity.this, CartActivity7.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart8
        Button btnAddToCart8 = findViewById(R.id.btnAddToCart8);
        btnAddToCart8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity8 khi nút được nhấn
                startActivity(new Intent(CustomerHomeActivity.this, CartActivity8.class));
            }
        });

        // Thêm sự kiện click cho nút Search
        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered product name
                String productName = editTextProductName.getText().toString();
                // Call the method to filter products based on the entered product name
                filterProducts(productName);
            }
        });
    }

    // Method to filter products based on the entered product name
    private void filterProducts(String productName) {
        // Implement logic to filter products based on the entered product name
        // For example, you can filter your product list and update the UI accordingly
        // You may want to have a method that fetches the products from the database
        // and displays them in the UI based on the filter.

        // For demonstration purposes, let's assume you have a method getFilteredProducts
        // which returns a list of products based on the entered name.
        // Update the list view or perform any UI update as needed.

        // ArrayList<Product> filteredProducts = getFilteredProducts(productName);
        // updateProductListView(filteredProducts);
    }

    // Add any additional methods you need for fetching and updating products in the UI

    // ... (rest of your existing code)
}
