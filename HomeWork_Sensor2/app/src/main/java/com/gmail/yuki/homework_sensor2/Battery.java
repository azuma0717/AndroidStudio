package com.gmail.yuki.homework_sensor2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;


public class Battery extends Activity {


    private BroadcastReceiver mbcr = new BroadcastReceiver() {


        @Override
        public void onReceive(Context c, Intent i) {

            int level = i.getIntExtra("level",0);

            ProgressBar pb =  (ProgressBar)findViewById(R.id.bt1);
            TextView tv     =   (TextView)findViewById(R.id.txt1);

            pb.setProgress(level);
            tv.setText("BatteryLevel: " +Integer.toString(level)+"%");

            if(level == 100){

                try{

                    AssetFileDescriptor afd = getAssets().openFd("Doorbell-Melody01-mp3.mp3");
                    MediaPlayer mp = new MediaPlayer();

                    mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    mp.prepare();
                    mp.start();

                }

                catch (IOException e){}


            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        registerReceiver(mbcr,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));





    }
}
