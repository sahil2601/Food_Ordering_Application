package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    final static String DBNAME="mydatabase.db";
    final  static int DBVERSION=2;

    public DataBaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "create table orders"+
                        "(id integer primary key autoincrement,"+
                        "name text," +
                        "phone text," +
                        "price int," +
                        "image int," +
                        "quantity int," +
                        "description text," +
                        "foodname text)"


        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);

    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String foodName, int quantity){

        SQLiteDatabase database =getReadableDatabase();
        ContentValues values = new ContentValues();
           values.put("name",name);
           values.put("phone",phone);
           values.put("price",price);
           values.put("image",image);
           values.put("description",desc);
           values.put("foodname",foodName);
           values.put("quantity",quantity);

           long id =database.insert("orders",null,values);
           if (id<=0){

               return false;
           }
           else {

               return true;
           }

    }

}
