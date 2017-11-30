package com.gmail.yuki.homework_sensor2;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button bt1, bt2, bt3, bt4;
    WifiManager wm;
    BluetoothAdapter bt = null;
    int value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt1 = (Button) findViewById(R.id.wifi);
        bt2 = (Button) findViewById(R.id.airplane);
        bt3 = (Button) findViewById(R.id.bluetooth);
        bt4 = (Button) findViewById(R.id.battery);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.wifi:

                wm = (WifiManager) getSystemService(WIFI_SERVICE);

                if (wm.isWifiEnabled()) {

                    wm.setWifiEnabled(false);
                    Toast.makeText(getApplicationContext(), "WiFi off", Toast.LENGTH_SHORT).show();

                } else {

                    wm.setWifiEnabled(true);
                    Toast.makeText(getApplicationContext(), "WiFi on", Toast.LENGTH_SHORT).show();

                }

                break;

            case R.id.bluetooth:

                bt = BluetoothAdapter.getDefaultAdapter();

//                まずブルートゥース機能の有無を確認して、そっからOnかOFFをする。

                if (bt == null) {

                    bt.enable();
                    Toast.makeText(getApplicationContext(), "No.Bluetooth found", Toast.LENGTH_SHORT).show();

                } else {

                    if (!bt.isEnabled()) {


                        bt.enable();
                        Toast.makeText(getApplicationContext(), "bluetooth is on", Toast.LENGTH_SHORT).show();

                    } else {


                        bt.disable();
                        Toast.makeText(getApplicationContext(), "bluetooth turn off", Toast.LENGTH_SHORT).show();


                    }


                }

                break;


            case R.id.airplane:
                boolean airplaneMode = isAirplaneMode();

                Toast.makeText(getApplicationContext(), ""+airplaneMode, Toast.LENGTH_SHORT).show();


                setAirplaneMode(!airplaneMode);
                break;


            case R.id.battery:

                Intent intent = new Intent(getApplicationContext(),Battery.class);
                startActivity(intent);


                break;

        }


    }

    /**
     * 機内モードかどうか判定する
     * @return
     */
    private boolean isAirplaneMode() {
        int status = Settings.System.getInt(getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0);
        return status != 0;
    }

    /**
     * 機内モードを変更する
     * @param enable
     */
    private void setAirplaneMode(boolean enable) {
        // putInt()には[android.permission.WRITE_SETTINGS]が必要

        if(enable == false){
             value = 0;

        }else {
             value = 1;
        }



        Settings.System.putInt(getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, value);

        Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intent.putExtra("state", value);
//        sendBroadcast(intent);
    }


}
