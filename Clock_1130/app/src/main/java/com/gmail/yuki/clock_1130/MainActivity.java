package com.gmail.yuki.clock_1130;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {

    Context context = null;

    private BroadcastReceiver mtimeInfoReciver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            TextView textView =(TextView)findViewById(R.id.text1);
            Calendar calendar = Calendar.getInstance();
            Toast.makeText(getApplicationContext(),"current time is ---- :" + calendar.getTime(),Toast.LENGTH_SHORT).show();
            textView.setText(""+calendar.getTime());
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter mTime = new IntentFilter(Intent.ACTION_TIME_TICK);
        registerReceiver(mtimeInfoReciver,mTime);
    }
}
