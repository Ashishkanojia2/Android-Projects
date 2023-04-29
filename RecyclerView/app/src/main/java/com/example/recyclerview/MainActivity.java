package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrayContact = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.Recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // first way to initialised object
//        ContactModel model = new ContactModel (R.drawable.boy1,"abc","1234567890");   // this is dataset
//        arrayContact.add(model)
        // Second way to initialised object

       arrayContact.add(new ContactModel (R.drawable.boy1,"a","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.student,"b","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.deliveryboy,"c","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.boy,"d","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.siblings,"e","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.student1,"f","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.woman,"g","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.deliveryboy,"h","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.student,"i","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.boy,"j","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.siblings,"k","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.boy1,"l","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.deliveryboy,"m","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.boy,"n","1234567890"));
       arrayContact.add(new ContactModel (R.drawable.deliveryboy,"o","1234567890"));

    RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrayContact);
    recyclerView.setAdapter(adapter);

    }
}