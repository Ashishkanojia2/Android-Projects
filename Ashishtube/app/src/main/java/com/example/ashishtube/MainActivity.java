package com.example.ashishtube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView family11 = findViewById(R.id.family11);
        family11.setVideoPath("android.resource://" + getPackageName() + "/" +  R.raw.family);
        MediaController mediaController = new MediaController(this);
        family11.setMediaController(mediaController);
        mediaController.setAnchorView(family11);
        family11.start();
    }
}