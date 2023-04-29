package com.example.crud01;

import static android.provider.Contacts.SettingsColumns.KEY;
import static org.xmlpull.v1.XmlPullParser.TEXT;

import static java.sql.Types.INTEGER;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME ="ContectDB";
    //If we doesn't used static Keyword this variable will initialise after sometime but if we use static keyword first this variable memory  is allocate
    // final keyword is used for the value of these variable cant be change
    private static final int  DATABASE_ID =1;
    private static final String  TABLE_NAME  ="contact";
    private static final String  KEY_ID  ="id";
    private static final String  KEY_NAME  ="name";
    private static final String  KEY_PHONE  ="phone_no";

    public dbhelper( Context context) {
        super(context, DATABASE_NAME, null,DATABASE_ID );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // this method() === db.execSQL(); is ued for insert delete update but not select
        // because this method is not for read line by line
        // we used CURSOR for reading or selecting a data form the table

        // QUERY IS
        //CREATE TABLE CONTACT (id INTEGER  PRIMARY KEY AUTOINCREMENT ,name TEXT ,phone number TEXT);
       db.execSQL("CREATE TABLE "+ TABLE_NAME + "("+ KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT  , "+ KEY_NAME + "TEXT," + KEY_PHONE +"TEXT   " +" )");
    }

    /* THIS IS FOR OPEN A DATABASE
    * if we don't have a reference of the database current application then you should try to create an reference
    * SQLiteDatabase database = this.readable/or/writeableDatabase();       //(readable === only read   OR writeable === insert update delete)
    * database.insert
    * database.update
    * database.rawQuery  (writen  type  is cursor )(this is ued for select )
    * database.delete
    *
    * NOW WE CLOSE DATABASE(USING CLOSE METHOD)
    * database.close();
    * */

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
    onCreate(db);
    }

    // NOW WE  CREATE AN INSERT METHOD FOR THE INSERTION

    public void addContact(String name , String phone_no){
        // this for to open a database

        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getReadableDatabase();

            values.put(KEY_NAME, name);
            values.put(KEY_PHONE, phone_no);

            db.insert("TABLE_NAME", null, values);



    }
}