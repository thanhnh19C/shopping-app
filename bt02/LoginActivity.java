package com.example.bt02;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private String username;
    private String password;
    private int progress;

    // SQLite Database Helper
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize SQLite Database Helper
        dbHelper = new DatabaseHelper(this);

        // Find views by ID
        Button btnDa = findViewById(R.id.btnDa);
        btnDa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to AdminHomeActivity when btnBackHome is pressed
                startActivity(new Intent(LoginActivity.this, AdminLoginActivity.class));
            }
        });


        Button btnDc = findViewById(R.id.btnDc);
        btnDc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to AdminHomeActivity when btnBackHome is pressed
                startActivity(new Intent(LoginActivity.this, CustomerLoginActivity.class));
            }
        });











    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}
