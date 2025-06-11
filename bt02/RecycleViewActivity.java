package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {
    private ArrayList<Product> productList;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        // RecyclerView setup
        recyclerView = findViewById(R.id.recyclerViewProducts);
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(this, productList, new TextView(this));

        productAdapter.setOnAddToCartClickListener(new ProductAdapter.OnAddToCartClickListener() {
            @Override
            public void onAddToCartClick(Product product) {
                // Handle add to cart click
                Intent intent = new Intent(RecycleViewActivity.this, YourNextActivity.class);
                intent.putExtra("productName", product.getName());
                intent.putExtra("quantity", product.getQuantity());
                intent.putExtra("price", product.getPrice());
                startActivity(intent);
            }
        });

        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                // Handle item click if needed
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Button to remove existing products and create new ones
        Button btnCreateNewProducts = findViewById(R.id.btnAddProduct);
        btnCreateNewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear existing products
                productList.clear();

                // Add new products with corresponding photos
                productList.add(new Product(0, "New Product 4", 4, 80, getResourceId("product_image_4", R.drawable.class)));
                productList.add(new Product(0, "New Product 5", 1, 90, getResourceId("product_image_5", R.drawable.class)));
                productList.add(new Product(0, "New Product 6", 3, 110, getResourceId("product_image_6", R.drawable.class)));

                // Notify the adapter about the data change
                productAdapter.notifyDataSetChanged();
            }
        });
    } // Add this closing brace

    private int getResourceId(String resourceName, Class<?> c) {
        try {
            Field field = c.getDeclaredField(resourceName);
            return field.getInt(null);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
