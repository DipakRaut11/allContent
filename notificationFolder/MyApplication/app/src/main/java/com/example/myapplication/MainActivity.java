package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager
                    .PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                        Manifest.permission.POST_NOTIFICATIONS
                }, 101);

            }

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeNotification();
            }
        });
    }
        public void makeNotification(){
            String CHANNEL_ID = "CHANNEL_ID_NOTIFIXCATION";
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
            builder.setSmallIcon(R.drawable.notification)
           .setContentTitle("Notification Title")
           .setContentText("Some text for notification")
                    .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_HIGH);

            Intent intent = new Intent(getApplicationContext(), Notification.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("Data", "Some values to be passed here");

//            PendingIntent pendingIntent = PendingIntent.getActivities(getApplicationContext(), 0, intent , PendingIntent.FLAG_MUTABLE);
//            builder.setContentIntent(pendingIntent);

            PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[]{intent}, PendingIntent.FLAG_MUTABLE);
            builder.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);




            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel(CHANNEL_ID);
                if (notificationChannel == null){
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    notificationChannel = new NotificationChannel(CHANNEL_ID, "Some description", importance);
                    notificationChannel.setLightColor(Color.GRAY);
                    notificationChannel.enableVibration(true);

                    notificationManager.createNotificationChannel(notificationChannel);
                }

            }
            notificationManager.notify(0, builder.build());



        }


    }
