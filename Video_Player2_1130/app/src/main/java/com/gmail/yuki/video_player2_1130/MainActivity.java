package com.gmail.yuki.video_player2_1130;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    VideoView v;
    Button bt1;
    int b = 1;

//    private static final int CAMERA_CAPTURE = 200;
    public static final int CAM_REQUEST = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt1 =(Button)findViewById(R.id.bt1);
        v = (VideoView)findViewById(R.id.video);
        bt1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video_file  = getfilepath();
        Uri video_uri = Uri.fromFile(video_file);


        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 30);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,video_uri);
        startActivityForResult(intent,CAM_REQUEST);

    }

    private File getfilepath(){

        File folder = new File("sdcard/video_app");

        if(!folder.exists()){

            folder.mkdir();

        }

        File video_file = new File(folder,b+"camera_video.mp4");

        return video_file;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultcode, Intent data){


        Toast.makeText(getApplicationContext(),"Successfully",Toast.LENGTH_SHORT).show();
//        String path = "sdcard/video_app/"+b+"camera_video.mp4";
//        Uri uri = Uri.parse(path);
//
//        v.setVisibility(View.VISIBLE);
//        v.setVideoURI(uri);
//        v.requestFocus();
//        v.start();
//        b++;

    }

}
