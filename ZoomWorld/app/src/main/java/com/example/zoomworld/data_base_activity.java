package com.example.zoomworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class data_base_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        getWindow().setStatusBarColor(Color.parseColor("#000000"));
        getWindow().setNavigationBarColor(Color.parseColor("#FADBD8"));
    }
}