package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi =  getMenuInflater();
        mi.inflate(R.menu.menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "New Clicked item 1", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "New Clicked item 2", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "New Clicked item 3", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item4:
                Toast.makeText(this, "New Clicked item 4", Toast.LENGTH_SHORT).show();
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }


    }

}