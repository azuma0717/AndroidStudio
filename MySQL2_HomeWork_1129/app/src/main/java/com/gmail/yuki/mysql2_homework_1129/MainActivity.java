package com.gmail.yuki.mysql2_homework_1129;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText ed1, ed2, ed3;
    Button bt1, bt2, bt3;
    TextView tv1;
    Spinner sp1;
    String city[] = {"Select City", "Gurgaon", "New delhi", "Old delhi", "Tokyo", "Osaka", "Fukuoka", "Jaipur", "Agra", "Haridwar", "Jodhpur", "Udaipur", "Gwalior"};
    Object city2;
    String x;
    Database_Helper databese_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.phone);
        ed3 = findViewById(R.id.email);
        bt1 = findViewById(R.id.dob);
        bt2 = findViewById(R.id.insert);
        bt3 = findViewById(R.id.selectid);
        tv1 = findViewById(R.id.txt1);
        sp1 = findViewById(R.id.city);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        ArrayAdapter<?> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(this);

//        city2 = (String) sp1.getSelectedItem();
        city2 = sp1.getSelectedItem().toString();

        databese_helper = new Database_Helper(MainActivity.this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.dob:

                Calendar calendar = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        Date date = new Date(year - 1900, month, day);

                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

                        x = fmt.format(date);
                        tv1.setText(x);


                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)

                );

                datePickerDialog.show();


                break;

            case R.id.insert:

                String name = ed1.getText().toString();
                String phone = ed2.getText().toString();
                String email = ed3.getText().toString();
                String city = String.valueOf(city2);
                String dob = x;
                String method = "Register";

                databese_helper.execute(method, name, phone, email, city, dob);

//                Toast.makeText(getApplicationContext(), name + phone + email + city + dob, Toast.LENGTH_LONG).show();

                break;

            case R.id.selectid:

                Intent selectid = new Intent(getApplicationContext(), Select_ID.class);
                startActivity(selectid);

                break;

        }


    }


    ///////////////////////Method of Spinner//////////////////////////////////////

    @Override
    public void onItemSelected(AdapterView<?> a, View v, int pos, long id) {

        this.city2 = a.getItemAtPosition(pos);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
