package com.example.videoplay;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;

        Uri videoUri = Uri.parse(videoPath);
        videoView.setVideoURI(videoUri);
        videoView.start();



//        //online Video
//        String onlineVideo = "https://www.youtube.com/watch?v=aLe9QAVvHY4";
//        Uri onlineV = Uri.parse(onlineVideo);
//        videoView.setVideoURI(onlineV);
//        videoView.start();



        MediaController mediaController = new MediaController(MainActivity.this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }
}