package com.example.androidloginandlandingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView DisplayInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DisplayInfo = findViewById(R.id.DisplayInfo);
        String temp = getIntent().getStringExtra("displayUsername");

        DisplayInfo.setText("Welcome: " + temp);
    }
}
