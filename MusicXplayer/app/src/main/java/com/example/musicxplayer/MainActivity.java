 package com.example.musicxplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

 public class MainActivity extends AppCompatActivity {
    MediaPlayer player ;                 // this all are methods or function
     AudioManager audioManager;
    // for playing the music
    public void play (View view){
        player.start();
    }
     // for pause the music
     public void pause (View view){
         player.pause();
     }
     // for stop the music
     public void stop(View view){
         player.stop();
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this,R.raw.music3);    // for connecting music from raw file

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVol = audioManager.getStreamMaxVolume(audioManager.STREAM_MUSIC);
        int curVol = audioManager.getStreamVolume(audioManager.STREAM_MUSIC);


        SeekBar seekvol = findViewById(R.id.seekVol);    // this statement for grabbing seekbar from xml file using id
        seekvol.setMax(maxVol);       // setmax or setprogress both are the function
        seekvol.setProgress(curVol);

        seekvol .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
             audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekprog = findViewById(R.id.seekprog);
        seekprog.setMax(player.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekprog.setProgress(player.getCurrentPosition());
            }
        }, 0 , 50000);


        seekprog.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                player.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}