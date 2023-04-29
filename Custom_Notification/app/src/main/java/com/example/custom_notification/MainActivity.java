package com.example.custom_notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "My channel";       // 12TH STEP
    private static final int NOTIFICATION_ID = 100;                 // 14TH STEP
    private static final int REQ_CODE = 100;

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
        Intent iNotify = new Intent(getApplicationContext(),MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.getActivities(this,REQ_CODE, new Intent[]{iNotify},PendingIntent.FLAG_UPDATE_CURRENT);

        // bigPicture style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture( ( (BitmapDrawable) (ResourcesCompat.getDrawable(getResources(),R.drawable.nature,null))).getBitmap())
                .bigLargeIcon(LargeIcon)
                .setBigContentTitle("this is big content title ")
                .setSummaryText("this is summery text in big content  ");

        // there is two mainly used style which is setStyle and Inbox Style

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("D")
                .addLine("E")
                .addLine("F")
                .addLine("G")
                .addLine("H")
                .addLine("I")
                .addLine("J")
                .addLine("K")
                .addLine("L")
                .addLine("M")
                .addLine("N")
                .addLine("O")
                .addLine("P")
                .addLine("Q")
                .addLine("R")
                .setBigContentTitle("full message ")
                .setSummaryText("this is big summery text ");



        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {                     // 9th STEP
            notification = new Notification.Builder(this)                                      // 2ND STEP
                    .setLargeIcon(LargeIcon)                                                            // 3RD STEP
                    .setSmallIcon(R.drawable.db)                                                        // 4TH STEP
                    .setContentText("Hello Ashish kanojia I am android studio. ")                       // 5TH STEP
                    .setSubText("New message from ashish")                                                  // 6TH STEP
                   // .setAutoCancel(false)                   // swipe to cant delete msg
                    .setOngoing(true)         // ongoing is same as AutoCancel but AutoCancel is not work properly
                    .setStyle(inboxStyle)
                   // .setStyle(bigPictureStyle)
// In this channel_id there is a one condition which declared by android that is if android version or sdk version is less than 8 so there is no required of any channel_id otherwise  vice-versa
                    .setChannelId(CHANNEL_ID)                                                                   // 8TH STEP    +  (Alt+enter) to set condition
                    .setContentIntent(pi)
                    .build();                                                                          // 7TH STEP

            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID , "New Channel",NotificationManager.IMPORTANCE_HIGH));    // 11TH STEP

        }else{                                                                                       // 10TH STEP ELSE CONDITION (COPY PASTE)
            notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(LargeIcon)
                    .setSmallIcon(R.drawable.db)
                    .setContentText("New Message")
                    .setSubText("New message from ashish")
                    .setContentIntent(pi)
                   // .setAutoCancel(false)
                    .setOngoing(true)
                    .setStyle(inboxStyle)
                  //  .setStyle(bigPictureStyle)
                    .build();
        }
        nm.notify(NOTIFICATION_ID, notification);                                             // 13TH STEP   // NOW LAST 15TH STEP TO SET NOTIFICATION_ID
    }
}