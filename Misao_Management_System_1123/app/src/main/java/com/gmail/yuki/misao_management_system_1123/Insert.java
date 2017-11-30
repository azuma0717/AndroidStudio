package com.gmail.yuki.misao_management_system_1123;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

public class Insert extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText ed1, ed2, ed3, ed4;
    TextView tv1, tv2, tv3, tv4;
    Button bt1, bt2, bt3, bt4, bt5, bt6;
    Spinner sp1, sp2;
    String city[] = {"Select City", "Gurgaon", "New delhi", "Old delhi", "Tokyo", "Osaka", "Fukuoka", "Jaipur", "Agra", "Haridwar", "Jodhpur", "Udaipur", "Gwalior"};
    String course[] = {"English", "Japanese", "IT", "Yoga"};

    Object city2;
    Object course2;
    String aa, bb, cc, dd;
    String x;

    Databese_Helper database_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.phone);
        ed3 = (EditText) findViewById(R.id.email);
        ed4 = (EditText) findViewById(R.id.fee);
        bt1 = (Button) findViewById(R.id.dob);
        bt2 = (Button) findViewById(R.id.doj);
        bt3 = (Button) findViewById(R.id.doe);
        bt4 = (Button) findViewById(R.id.ved);
        bt5 = (Button) findViewById(R.id.submit);
        bt6 = (Button) findViewById(R.id.back);
        sp1 = (Spinner) findViewById(R.id.city);
        sp2 = (Spinner) findViewById(R.id.course);
        tv1 = (TextView) findViewById(R.id.txt1);
        tv2 = (TextView) findViewById(R.id.txt2);
        tv3 = (TextView) findViewById(R.id.txt3);
        tv4 = (TextView) findViewById(R.id.txt4);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);


        ArrayAdapter<?> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(this);

//        city2 = sp1.getSelectedItem().toString();
        city2 =(String)sp1.getSelectedItem();

        ArrayAdapter<?> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, course);
        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(this);

        course2 = sp2.getSelectedItem().toString();

        database_helper = new Databese_Helper(Insert.this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.dob:
                aa = datePickerGetter();
                tv1.setText(aa);

                break;

            case R.id.doj:

                bb = datePickerGetter();
                tv2.setText(bb);


                break;

            case R.id.doe:
                cc = datePickerGetter();
                tv3.setText(cc);
                break;

            case R.id.ved:
                dd = datePickerGetter();
                tv4.setText(dd);
                break;

            case R.id.submit:

                String name = ed1.getText().toString();
                String phone = ed2.getText().toString();
                String email = ed3.getText().toString();
                String fee = ed4.getText().toString();
                String dob = aa;
                String doj = bb;
                String doe = cc;
                String ved = dd;
                String city = String.valueOf(city2);
                String course = String.valueOf(course2);

                database_helper.Insert(name,phone,email,city,dob,doj,doe,course,fee,ved);


                Toast.makeText(getApplicationContext(), "Insert Success", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);


                break;

            case R.id.back:

                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);

                break;

        }

    }

    ///////////////////////Method of Spinner//////////////////////////////////////

    @Override
    public void onItemSelected(AdapterView<?> a, View v, int pos, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    /////////////////////Method of Calendar//////////////////////////////////////

    public String datePickerGetter() {


        Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(Insert.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                Date date = new Date(year - 1900, month, day);

                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

                x = fmt.format(date);


            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)

        );

        datePickerDialog.show();


        return x;
    }

}