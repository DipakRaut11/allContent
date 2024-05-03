package com.example.customizenotification;

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
    private static final String CHANNEL_ID = "CHannel id";
    private static final int CHANNEL = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.abc,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivities(MainActivity.this, 0, new Intent[]{intent}, PendingIntent.FLAG_UPDATE_CURRENT );

        // Big picture style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(),R.drawable.abc,null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Img set by dipak")
                .setSummaryText("Image message");

        //Inbox style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("ABC")
                .addLine("ABC")
                .addLine("ABC")
                .addLine("ABC")
                .addLine("ABC")
                .addLine("ABC")
                .addLine("ABC")
                .addLine("ABC")
                .addLine("ABC")
                .addLine("ABC")
                .setBigContentTitle("Full message")
                .setSummaryText("Message from mr dipak");



        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.abc)
                    .setContentText("Hello")
                    .setSubText("How are you")
                    .setStyle(bigPictureStyle)
                    .setContentIntent(pi)
                    .setChannelId(CHANNEL_ID)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"DATA",NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification = new Notification.Builder(MainActivity.this)
                    .setContentTitle("Hello")
                    .setSubText("How are you")
                    .setLargeIcon(largeIcon)
                    .setContentIntent(pi)
                    .setStyle(bigPictureStyle)
                    .setSmallIcon(R.drawable.abc)
                    .build();
        }

nm.notify(CHANNEL,notification);
    }
}