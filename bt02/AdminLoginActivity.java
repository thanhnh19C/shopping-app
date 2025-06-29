// AdminLoginActivity.java
package com.example.bt02;
import android.view.inputmethod.EditorInfo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        LinearLayout loginLayout = findViewById(R.id.loginLayout);  // Assuming login layout is a LinearLayout
        EditText editTextAdminUsername = findViewById(R.id.editTextAdminUsername);
        EditText editTextAdminPassword = findViewById(R.id.editTextAdminPassword);
        Button btnAdminLogin = findViewById(R.id.btnAdminLogin);
        Button btnDk = findViewById(R.id.btnDk);

        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Switch to CustomerRegisterActivity
                Intent intent = new Intent(AdminLoginActivity.this, CustomerRegisterActivity.class);
                startActivity(intent);
            }
        });

        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get entered username and password
                String adminUsername = editTextAdminUsername.getText().toString();
                String adminPassword = editTextAdminPassword.getText().toString();

                // Check if the username and password are correct (replace with your authentication logic)
                if (isAdminCredentialsValid(adminUsername, adminPassword)) {
                    // Admin login successful, navigate to AdminActivity
                    Intent intent = new Intent(AdminLoginActivity.this, AdminActivity.class);
                    startActivity(intent);
                    finish(); // Finish the login activity
                } else {
                    // Display an error message for invalid credentials
                    Toast.makeText(AdminLoginActivity.this, "Sai tài khoản", Toast.LENGTH_SHORT).show();
                }
            }
        });

        editTextAdminUsername.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                editTextAdminPassword.requestFocus();
                return true;
            }
            return false;
        });

        editTextAdminPassword.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // Perform your login action
                return true;
            }
            return false;
        });


    }

    // Replace this method with your actual authentication logic
    private boolean isAdminCredentialsValid(String username, String password) {
        // Add your authentication logic here (e.g., check against a predefined admin username and password)
        return username.equals("thanhnguyen") && password.equals("0312");

    }
}
