package com.gmail.yuki.alarm_1201;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TimePicker timePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        timePicker = (TimePicker) findViewById(R.id.timepick);

        toggleButton = (ToggleButton) findViewById(R.id.toggle);
        toggleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        long time;

        if (((ToggleButton) v).isChecked()) {

            Toast.makeText(getApplicationContext(), "ALARM ON", Toast.LENGTH_SHORT).show();
            Calendar calendar = Calendar.getInstance();
            calendar.set(java.util.Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
            calendar.set(java.util.Calendar.MINUTE, timePicker.getCurrentMinute());

            Intent intent = new Intent(this, AlarmReciver.class);
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));

            if (System.currentTimeMillis() > time) {

                if (calendar.AM_PM == 0) {

                    time = time + (1000 * 60 * 60 * 12);

                } else {

                    time = time + (1000 * 60 * 60 * 24);

                }

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);

            } else {

                alarmManager.cancel(pendingIntent);
                Toast.makeText(getApplicationContext(), "Alarm Off", Toast.LENGTH_SHORT).show();

            }

        }

    }
}
