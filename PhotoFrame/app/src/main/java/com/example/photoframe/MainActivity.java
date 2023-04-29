package com.example.photoframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ImageButton prev , next;
    ImageView pic;
    TextView text ;
    int currentImage = 0;

    // showing image by used in number  means 0-1-2-3-4-5-0-1-2-3-4-5


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // this is onclick function which means if anyone click on previous button then what they do..
    public void prev(View v){
     // to change and show   previous picture
        String idX = "pic" + currentImage;
        int x = this.getResources().getIdentifier( idX, "id", getPackageName());
        pic = findViewById(x);
        pic.setAlpha(1f);

        currentImage = (5 + currentImage -1) %5;
        String idY = "pic" + currentImage;
        int y = this.getResources().getIdentifier( idY, "id", getPackageName());
        pic = findViewById(y);
        pic.setAlpha(1f);

                                            // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly// application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly// application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly// application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly// application is not running properly
        // application is not running properly
        // application is not running properly
        // application is not running properly




    }
    public void next(View v){
        String idX = "pic" + currentImage;
        int x = this.getResources().getIdentifier( idX, "id", getPackageName());
        pic = findViewById(x);
        pic.setAlpha(1f);

        currentImage = ( currentImage -1) %5;
        String idY = "pic" + currentImage;
        int y = this.getResources().getIdentifier( idY, "id", getPackageName());
        pic = findViewById(y);
        pic.setAlpha(1f);
    }
}
