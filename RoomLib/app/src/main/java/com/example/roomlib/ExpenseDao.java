package com.example.roomlib;
// In this class we store database query

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//@KEYWORDS => this is annotation

@Dao
public interface ExpenseDao {
    //select query return list of data which is store in data base that why we we used LIST< >
@Query("select * from Expense")
    List<Expense> getallexpense ();
// Insert method is not return anything that why we used void
@Insert
// we want ot fetch data from expense class which is inserted by user
    void addtx(Expense expense);

@Update
    void update (Expense expense);
// delete method is same as insert method
}
