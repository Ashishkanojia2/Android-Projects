package com.example.androiddb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "Userdata.db",null ,1);                  // userData is name of the dataBase         // its create a dataBase
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // to Write a sql query we
        db.execSQL("create Table UserDetail(name Text primary key ,contact TEXT , dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("Drop Table if exists Userdetails");
    }

    //create a new method
    public Boolean insertuserdata(String name , String contact , String Dob){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name ",name);
        contentValues.put("contact",contact);
        contentValues.put("dob",Dob);
        long result=DB.insert("UserDetail",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }

    }


    // update method

    public Boolean updateuserdata(String name , String contact , String Dob){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("contact",contact);
        contentValues.put("dob",Dob);
        Cursor cursor = DB.rawQuery("select * from UserDetail where name =? ", new String []{name});
                if (cursor.getCount()>0) {

                    long result = DB.update("UserDetail", contentValues, "name=?", new String[]{name});
                    if (result == -1) {
                        return false;
                    } else {
                        return true;
                    }
                }
        {

            return false;
        }
    }
    // delete

    public Boolean deleteuserdata(String name ){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from UserDetail where name =? ", new String []{name});
        if (cursor.getCount()>0) {

            long result = DB.delete("UserDetail",  "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        {

            return false;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from UserDetail",null);
        {
            return cursor;
        }
    }
}
