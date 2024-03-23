package com.example.zoomworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.zoomworld.Model.Contact;
import com.example.zoomworld.data.MyDataBaseHandler;

import java.util.List;

public class data_base_activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        getWindow().setStatusBarColor(Color.parseColor("#000000"));
        getWindow().setNavigationBarColor(Color.parseColor("#FADBD8"));


        MyDataBaseHandler myDataBaseHandler= new MyDataBaseHandler(data_base_activity.this);

        /****************************** Creating  a contact to the Database *************************************/

        Contact Mahta= new Contact();
        Mahta.setName("Amardeep Mahta");
        Mahta.setPhoneNumber("6201145983");

        /******************************* Adding   a contact to the Database *************************************/

        myDataBaseHandler.addContact(Mahta);

        Contact Amardeep = new Contact();
        Amardeep.setName("Akshay Kumar Prajapati");
        Amardeep.setPhoneNumber("8987918309");
        myDataBaseHandler.addContact(Amardeep);

        Amardeep.setName("Ajay Kumar Prajapati");
        Amardeep.setPhoneNumber("91232523987");
        int affectedRows=myDataBaseHandler.updateContact(Amardeep);


        Log.d("TAG", "onCreate: No of affected Rows are : "+affectedRows);


        Log.e("TAG", "onCreate: Succesfully Add the Contact in the DataBase" );
        Toast.makeText(this, "Succesfully Add the Contact in the DataBase", Toast.LENGTH_SHORT).show();

        /******************************************** Get all contacts *********************************************/
        List<Contact> allContacts= myDataBaseHandler.getAllContacts();

        /************************************** Using  for looop *************************************/


        for (Contact contact :
                allContacts) {
            Log.d("TAG", "id:"+ contact.getId()+"\n"+"Name "+ contact.getName()+"\n"+"Mobile Number "+contact.getPhoneNumber());
        }
    }
}