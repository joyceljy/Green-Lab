package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.util.Objects;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        String selectedVideo = getIntent().getStringExtra("selectedVideo");

        final VideoView video = findViewById(R.id.videoView_vv);
        if (Objects.equals(selectedVideo, "video1")){
            video.setVideoURI(Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20210217101214/Screenrecorder-2021-02-17-10-10-20-513.mp4?_=1"));
            video.requestFocus();
            video.start();
        }else if(Objects.equals(selectedVideo, "video2")){
            video.setVideoURI(Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"));
            video.requestFocus();
            video.start();
        }else{
            video.setVideoURI(Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201028015557/MVVMOutputRecording.mp4?_=1"));
            video.requestFocus();
            video.start();
        }

        Button videoButton = findViewById(R.id.bt_videolist);

        videoButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), VideoSelectionActivity.class);
            // start the Intent
            startActivity(intent);
        });
    }
}