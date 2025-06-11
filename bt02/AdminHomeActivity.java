package com.example.bt02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        // Find buttons by ID
        Button btnCus = findViewById(R.id.btnCus);

        Button btnAd = findViewById(R.id.btnAd);

        btnCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a toast message
                Toast.makeText(AdminHomeActivity.this, "Đã chuyển đến sản phẩm khách hàng", Toast.LENGTH_SHORT).show();

                // Chuyển hướng đến MainActivity khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, CustomerHomeActivity.class));
            }
        });

        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a toast message
                Toast.makeText(AdminHomeActivity.this, "Đã chuyển đến tùy chỉnh sản phẩm", Toast.LENGTH_SHORT).show();

                // Chuyển hướng đến MainActivity khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, MainActivity.class));
            }
        });







        // Add any additional logic for AdminHomeActivity if needed

        // Thêm sự kiện click cho nút btnAddToCart1
        Button btnAddToCart1 = findViewById(R.id.btnAddToCart1);
        btnAddToCart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, CartActivity.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart2
        Button btnAddToCart2 = findViewById(R.id.btnAddToCart2);
        btnAddToCart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity2 khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, CartActivity2.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart3
        Button btnAddToCart3 = findViewById(R.id.btnAddToCart3);
        btnAddToCart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity3 khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, CartActivity3.class));
            }
        });

        // Thêm sự kiện click cho nút btnAddToCart3
        Button btnAddToCart4 = findViewById(R.id.btnAddToCart4);
        btnAddToCart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity3 khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, CartActivity4.class));
            }
        });


        // Thêm sự kiện click cho nút btnAddToCart3
        Button btnAddToCart5 = findViewById(R.id.btnAddToCart5);
        btnAddToCart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity3 khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, CartActivity5.class));
            }
        });


        // Thêm sự kiện click cho nút btnAddToCart3
        Button btnAddToCart6 = findViewById(R.id.btnAddToCart6);
        btnAddToCart6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity3 khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, CartActivity6.class));
            }
        });


        // Thêm sự kiện click cho nút btnAddToCart3
        Button btnAddToCart7 = findViewById(R.id.btnAddToCart7);
        btnAddToCart7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity3 khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, CartActivity7.class));
            }
        });


        // Thêm sự kiện click cho nút btnAddToCart3
        Button btnAddToCart8 = findViewById(R.id.btnAddToCart8);
        btnAddToCart8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến CartActivity3 khi nút được nhấn
                startActivity(new Intent(AdminHomeActivity.this, CartActivity8.class));
            }
        });


    }
}
