package com.gmail.yuki.vedeo_player_1130;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    VideoView v;
    Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v = (VideoView) findViewById(R.id.vedio1);

        bt1 = (Button)findViewById(R.id.button);

        bt1.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
//        String uriPath ="http://rmcdn.2mdn.net/MotifFiles/html/1248596/android_1330378998288.mp4";
        String uriPath = "sdcard/Movies/Instagram/test2.mp4";
        Uri uri = Uri.parse(uriPath);
        v.setVideoURI(uri);
        v.requestFocus();
        v.start();

    }
}
