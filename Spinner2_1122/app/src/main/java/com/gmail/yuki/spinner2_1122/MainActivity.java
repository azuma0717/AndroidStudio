package com.gmail.yuki.spinner2_1122;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener,View.OnClickListener {


    EditText ed1,ed2;
    Spinner sp1;
    Button bt1;
    String myarray[] = {"Select City","Gurgaon","New delhi","Old delhi","Tokyo","Osaka","Fukuoka","Jaipur","Agra","Haridwar","Jodhpur","Udaipur","Gwalior"};

    String name;
    String phone;
    Object position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 =(EditText)findViewById(R.id.name);
        ed2 =(EditText)findViewById(R.id.phone);
        sp1 =(Spinner)findViewById(R.id.sp);
        bt1 =(Button)findViewById(R.id.dob);

        bt1.setOnClickListener(this);

        ArrayAdapter<?> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,myarray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> a, View v, int pos, long id) {

        this.name = ed1.getText().toString();
        this.phone = ed2.getText().toString();
        this.position = a.getItemAtPosition(pos);



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                Toast.makeText(getApplicationContext(),"My name is " +name+"\n" + "My phone No. is " +phone+ "\n"+ position+"  is selected \n"+"the date are "+String.valueOf(month)+"/"+String.valueOf(day)+"/"+String.valueOf(year),Toast.LENGTH_LONG).show();


            }
        },2017,11,22);
        datePickerDialog.show();


    }
}
