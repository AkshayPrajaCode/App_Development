package com.example.cardviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView= findViewById(R.id.cardviewidd1);


        cardView.setRadius(45.0f);
        cardView.setCardElevation(11.0f);
    }
}