package com.example.crud02;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class dataBase extends SQLiteOpenHelper {
    private static final String  DBname ="signup.db";
    public dataBase(@Nullable Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = "Create table user (id integer Primary key autoincrement , name text , username text ,password text)";
        db.execSQL(q);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists user ");
    onCreate(db);
    }

    public boolean insert_data(String name ,String username ,String password ){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name ", name );
        contentValues.put("username",username);
        contentValues.put("password",password);
        long r = db.insert("user",null,contentValues);
        if(r==-1){
            return false;
        }else{
            return true;
        }
    }

}
