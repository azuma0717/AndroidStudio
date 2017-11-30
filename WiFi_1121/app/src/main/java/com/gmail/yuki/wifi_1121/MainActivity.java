package com.gmail.yuki.wifi_1121;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button button;
    WifiManager wm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.BT);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        wm = (WifiManager) getSystemService(WIFI_SERVICE);

        if (wm.isWifiEnabled()) {

            wm.setWifiEnabled(false);
            Toast.makeText(getApplicationContext(), "WiFi off", Toast.LENGTH_SHORT).show();


        } else {

            wm.setWifiEnabled(true);
            Toast.makeText(getApplicationContext(), "WiFi on", Toast.LENGTH_SHORT).show();


        }

    }
}
