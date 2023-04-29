package com.example.roomlib;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = Expense.class ,exportSchema = false,version = 1)
public abstract class DataBaseHelper extends RoomDatabase {
    // these class is used to create a database
private static final String DB_Name="expensedb";
private static DataBaseHelper instance;
public static synchronized DataBaseHelper getdb(Context context){
    if(instance==null){
        instance= Room.databaseBuilder(context,DataBaseHelper.class,DB_Name)
        .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

    }
    return instance;
}
//public abstract  ExpenseDao();
}
