package com.example.roomlib;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.jar.Attributes;

// Table name****************************************
@Entity(tableName = "Expense")
public class Expense {
    // creating table columns**************************
 @PrimaryKey(autoGenerate = true)
    private int id;   // first column

@ColumnInfo(name="title")
    private String Title;  // second column0 02

@ColumnInfo(name="price")
    private String price; // third column
// now we creating DAO interface class which is used for data base entry in abstract method

// this is constructor (same name as class name no return type)
    public Expense(int id, String title, String price) {
        this.id = id;
        Title = title;
        this.price = price;
    }
// getter setter is used for get or set only /one value
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
