package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private static final String CHANNEL_ID = "My channel";       // 12TH STEP
    private static final int NOTIFICATION_ID = 100;                 // 14TH STEP


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // tis is a process to convert png img to bitmap  img
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.db,null);
        // now convert drawable to bitmap drawable
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        // now convert bitmap drawable to bitmap
        Bitmap LargeIcon = bitmapDrawable.getBitmap();




        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);         // 1ST STEP
        Notification notification;     // variable globally declare
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {                     // 9th STEP
             notification = new Notification.Builder(this)                                      // 2ND STEP
                    .setLargeIcon(LargeIcon)                                                            // 3RD STEP
                    .setSmallIcon(R.drawable.db)                                                        // 4TH STEP
                    .setContentText("Hello Ashish kanojia I am android studio. ")                       // 5TH STEP
                    .setSubText("New message from ashish")                                                  // 6TH STEP
// In this channel_id there is a one condition which declared by android that is if android version or sdk version is less than 8 so there is no required of any channel_id otherwise  vice-versa
                    .setChannelId(CHANNEL_ID)                                                                   // 8TH STEP    +  (Alt+enter) to set condition
                     .build();                                                                          // 7TH STEP

                     nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID , "New Channel",NotificationManager.IMPORTANCE_HIGH));    // 11TH STEP

        }else{                                                                                       // 10TH STEP ELSE CONDITION (COPY PASTE)
            notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(LargeIcon)
                    .setSmallIcon(R.drawable.db)
                    .setContentText("New Message")
                    .setSubText("New message from ashish")
                    .build();
        }
  nm.notify(NOTIFICATION_ID, notification);                                             // 13TH STEP   // NOW LAST 15TH STEP TO SET NOTIFICATION_ID
    }
}