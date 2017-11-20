package com.gmail.yuki.sensor_imagechange_1120;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity implements SensorEventListener {


    SensorManager sm;
    ImageView iv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv1 = (ImageView) findViewById(R.id.image1);
        sm = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
//       sm.registerListener(this.sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        Sensor accel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accel, SensorManager.SENSOR_DELAY_NORMAL);

    }

    int i = 1;

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {


            float value[] = event.values;
            float x = value[0];
            float y = value[1];
            float z = value[2];

            float asr = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

            if (asr >= 2) {

                switch (i) {

                    case 1:

                        iv1.setImageResource(R.drawable.a1);
                        break;

                    case 2:

                        iv1.setImageResource(R.drawable.a2);
                        break;

                    case 3:

                        iv1.setImageResource(R.drawable.a3);
                        break;

                    case 4:

                        iv1.setImageResource(R.drawable.a4);
                        break;

                    case 5:

                        iv1.setImageResource(R.drawable.a5);
                        break;

                    case 6:

                        iv1.setImageResource(R.drawable.a6);
                        break;

                    case 7:

                        iv1.setImageResource(R.drawable.a7);
                        break;

                    case 8:

                        iv1.setImageResource(R.drawable.a8);
                        break;

                    case 9:

                        iv1.setImageResource(R.drawable.a9);
                        break;

                    case 10:

                        iv1.setImageResource(R.drawable.a10);
                        break;

                    case 11:

                        iv1.setImageResource(R.drawable.a11);
                        break;

                    case 12:

                        iv1.setImageResource(R.drawable.a12);
                        break;

                    case 13:

                        iv1.setImageResource(R.drawable.a13);
                        break;

                    case 14:

                        iv1.setImageResource(R.drawable.a14);
                        break;


                }

                i++;

                if(i == 14){

                    i=1;
                }
            }


        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
