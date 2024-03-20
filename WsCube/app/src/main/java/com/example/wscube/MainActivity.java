package com.example.wscube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<ContactMoodel> arrContact= new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyleContactPooja);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));





        ContactMoodel contactMoodel = new ContactMoodel(R.drawable.er,"Akshay","8987948652");

        arrContact.add(new ContactMoodel(R.drawable.neha,"Neha Kumari Pandey","8520659863"));
        arrContact.add(new ContactMoodel(R.drawable.pooja,"Pooja Kumari ","6985463259"));
        arrContact.add(new ContactMoodel(R.drawable.tsdsg,"Komal Kumari Pandey","8549632525"));


        RecylerAdapterContact adapterContact= new RecylerAdapterContact(this,arrContact);
        recyclerView.setAdapter(adapterContact);
    }
}
