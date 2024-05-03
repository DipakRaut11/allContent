package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.Manifest;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "My channel";
    private static final int NOTIFICATION_ID = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.abc,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeICon = bitmapDrawable.getBitmap();

        Notification notification;
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
           notification = new Notification.Builder(MainActivity.this).setLargeIcon(largeICon)
                    .setSmallIcon(R.drawable.abc).setContentText("New Message").setSubText("New message for Dipak")
                    .setChannelId(CHANNEL_ID)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New channel", NotificationManager.IMPORTANCE_HIGH));
        }
        else {
            notification = new Notification.Builder(MainActivity.this).setLargeIcon(largeICon)
                    .setSmallIcon(R.drawable.abc).setContentText("New Message").setSubText("New message for Dipak")
                    .build();
        }

        nm.notify(NOTIFICATION_ID, notification);

    }
}