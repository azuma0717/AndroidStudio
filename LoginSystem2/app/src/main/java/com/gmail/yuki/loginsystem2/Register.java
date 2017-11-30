package com.gmail.yuki.loginsystem2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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

public class Register extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    TextView tv1;
    EditText ed1, ed2, ed3, ed4, ed5;
    Button bt1, bt2, bt3;
    Spinner sp1;
    String myarray[] = {"Select City", "Gurgaon", "New delhi", "Old delhi", "Tokyo", "Osaka", "Fukuoka", "Jaipur", "Agra", "Haridwar", "Jodhpur", "Udaipur", "Gwalior"};
    Object position;
    Database_Helper database_helper;
    String aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tv1 = (TextView) findViewById(R.id.txt2);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.phone);
        ed3 = (EditText) findViewById(R.id.email);
        ed4 = (EditText) findViewById(R.id.pass);
        ed5 = (EditText) findViewById(R.id.photo);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.dob);
        sp1 = (Spinner) findViewById(R.id.city);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        database_helper = new Database_Helper(Register.this);





        ArrayAdapter<?> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myarray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt1:

                String name = ed1.getText().toString();
                String phone = ed2.getText().toString();
                String email = ed3.getText().toString();
                String pass = ed4.getText().toString();
                String photo = ed5.getText().toString();
                String dob = aa;
                String city = String.valueOf(position);



                database_helper.Insert(name, phone, email, pass, photo, dob, city);



                Toast.makeText(getApplicationContext(), "Registration Successfull", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getApplicationContext(),Login.class);
                startActivity(intent3);

                break;

            case R.id.bt2:

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

                break;


            case R.id.dob:

                Calendar calendar = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        Date date = new Date(year - 1900,month,day);

                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                        tv1.setText(fmt.format(date));
                        aa = fmt.format(date);


                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)

                );

                datePickerDialog.show();

                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> a, View v, int pos, long id) {

        this.position = a.getItemAtPosition(pos);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
