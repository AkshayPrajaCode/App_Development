package com.example.zoomworld.data;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.zoomworld.Parameters.parameter;

public class MyDataBaseHandler extends SQLiteOpenHelper {


    public MyDataBaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create = "Create Table "+ parameter.DATA_BASE_TABLE +"("+
                parameter.KEY_ID + "Integer Primary Key , " + parameter.KEY_name + "Text , " + parameter.KEY_phone_number + " Text , "
                +")";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
