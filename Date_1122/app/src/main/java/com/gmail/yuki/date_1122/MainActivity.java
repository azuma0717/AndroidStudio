package com.gmail.yuki.date_1122;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 =(Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthofyaer, int dayofmonth) {

                Toast.makeText(getApplicationContext(),"the date are "+String.valueOf(dayofmonth)+"/"+String.valueOf(monthofyaer)+"/"+String.valueOf(year),Toast.LENGTH_LONG).show();

            }
        },2017,11,22);
        datePickerDialog.show();

    }
}
