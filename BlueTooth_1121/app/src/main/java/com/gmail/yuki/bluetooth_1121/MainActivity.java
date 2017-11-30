package com.gmail.yuki.bluetooth_1121;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    BluetoothAdapter bt = null;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = BluetoothAdapter.getDefaultAdapter();
        button = (Button) findViewById(R.id.BT);

        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (bt == null) {

            Toast.makeText(getApplicationContext(),"No.Bluetooth found",Toast.LENGTH_SHORT).show();



        } else {

            if(!bt.isEnabled()){


                bt.enable();
                Toast.makeText(getApplicationContext(),"bluetooth is on",Toast.LENGTH_SHORT).show();

            }else {

                bt.disable();
                Toast.makeText(getApplicationContext(),"bluetooth turn off",Toast.LENGTH_SHORT).show();
            }


        }


    }
}
