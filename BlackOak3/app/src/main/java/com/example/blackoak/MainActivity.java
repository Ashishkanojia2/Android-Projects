package com.example.blackoak;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity {

    Button btn;

    BottomNavigationView btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnView = findViewById(R.id.bnView);

        btnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_Home) {
                    loadFrag(new HomeFragment(), false);
                } else if (id == R.id.nav_Notify) {
                    loadFrag(new notifyFragment(), false);
                } else if (id == R.id.nav_cat) {
                    loadFrag(new CategoryFragment(), false);
                } else if (id == R.id.nav_profile) {
                    loadFrag(new Cart_Product(), false);
                } else {
                    //cart
                    loadFrag(new ProfileFragment(), false);                                   // check it
                }

                return true;
            }
        });
        btnView.setSelectedItemId(R.id.nav_Home);
    }

    // to create a method for fragments for don't repeat same lines
    public void loadFrag(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag)
            ft.add(R.id.container, fragment);
        else
            ft.replace(R.id.container, fragment);
        ft.commit();

        //***********************************************************

    }

}