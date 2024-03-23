package com.example.zoomworld.data;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zoomworld.Model.Contact;
import com.example.zoomworld.Parameters.parameter;

import java.util.ArrayList;
import java.util.List;

public class MyDataBaseHandler extends SQLiteOpenHelper {


    public MyDataBaseHandler(Context context) {
        super(context, parameter.DATA_BASE_NAME, null, parameter.DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create = "Create Table " + parameter.DATA_BASE_TABLE + "(" +
                parameter.KEY_ID + "Integer Primary Key , " + parameter.KEY_name + "Text , " + parameter.KEY_phone_number + " Text "
                + ")";
        Log.d("TAG", "onCreate: Query is runing " + Create);
        db.execSQL(Create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(Contact contact) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(parameter.KEY_name, contact.getName());
        values.put(parameter.KEY_phone_number, contact.getPhoneNumber());


        /********************* Insert ***************************/
        DB.insert(parameter.DATA_BASE_TABLE, null, values);
        Log.e("TAG", "addContact: Successfylly inserted");
        Log.d("TAG", "addContact: Successfylly inserted ");
        DB.close();

    }

    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        /************************************ Generate the query to read from the database *****************************/
        String select = "SELECT * FROM " + parameter.DATA_BASE_TABLE;
        Cursor cursor = db.rawQuery(select, null);


        /********************************** loop throught now **********************************************************/
        if (cursor.moveToFirst()){
            do {
                Contact contact= new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact) ;
            }while (cursor.moveToFirst());
        }
        return contactList;
    }

    public int updateContact(Contact contact){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(parameter.KEY_name,contact.getName());
        values.put(parameter.KEY_phone_number,contact.getPhoneNumber());


        //Lets update now

        return database.update(parameter.DATA_BASE_TABLE,values,parameter.KEY_ID+"?",
                new String []{String.valueOf(contact.getId())});
    }
}
