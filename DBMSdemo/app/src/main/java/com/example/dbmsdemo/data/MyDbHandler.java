package com.example.dbmsdemo.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import com.example.dbmsdemo.params.Params;

public class MyDbHandler extends SQLiteOpenHelper{


    public MyDbHandler( Context context) {                          //these is  a constructor
            super(context, Params.DB_NAME, null, Params.DB_VERSION);
        }


        @Override                                                   // while creating constructor we override  two methods
    public void onCreate(SQLiteDatabase db) {
      String create = "Create table " + Params.TABLE_NAME + "(" + Params.KEY_ID +"INTEGER PRIMARY KEY" +
              Params.KEY_NAME + "TEXT" + Params.KEY_PHONE + "TEXT" + ")";
      Log.d("dbashish", "query being running is " + create);   // this is for which query is showing in output
      db.execSQL(create);  // for showing output (query)
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

