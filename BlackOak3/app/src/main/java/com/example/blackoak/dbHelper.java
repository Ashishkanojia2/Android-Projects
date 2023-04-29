package com.example.blackoak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    // this is for create a database
    private  static  final String DBname ="Table01";
    public dbHelper(@Nullable Context context) {
        super(context, DBname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String tb ="Create table Table01 (id integer Primary Key autoincrement  , name text , lastName text, Email text , Password text , mobile interger, Address text)";
        db.execSQL(tb);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists blackoak");
    }

    // create a new method for insert data

    public  boolean insert(String name, String lastname ,String email , String password, String mobile , String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name" , name );
        contentValues.put("lastname",lastname);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("mobile",mobile);
        contentValues.put("address",address);
        long r = db.insert("Table01",null,contentValues);
        if(r== -1){
            return false;
        }else
            return true;
    }


    // first we create a cursor which is used to show contain row
    // this code for fetching data from database
    public  Cursor SqlData(String email , String password){
        SQLiteDatabase db=this.getReadableDatabase();
        String query = "Select * from "+DBname+" where email= '"+email+"' and '"+password+"'";
        Cursor crs= db.rawQuery(query,null);
        return crs;
    }

}
