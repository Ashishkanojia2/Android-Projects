package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper  extends SQLiteOpenHelper {
    public static final String DBNAME="login.db";
    public DBHelper( Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }
    // this is method
    public Boolean insertData(String username ,String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();            // ContentValue is used to store values

        values.put("username",username);
        values.put("password",password);
        long result = db.insert("users", null, values);
        if(result==-1) return false;
        else
            return true;
    }
// check username function      // this is method
    public Boolean checkusername(String username ){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[] {username});
        if(cursor.getCount()>0)        // If user is present return true otherwise false
            return true;
        else
            return false;
    }
// check username password  function
    public Boolean checkusernamepassword(String username ,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password =? ", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
