package com.example.bt02;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class listViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        Bundle extra = getIntent().getExtras();
        String username = extra.getString("username","");
        String password = extra.getString("password","");
        List<Integer>test = extra.getIntegerArrayList("listAge");
        Uri uri = getIntent().getData();
        Log.d("TAG",username);
        Log.d("TAG1",password);
      //  Log.d("ListAge",test.get(2).toString());
        Log.d("data",uri.toString());
    }
}