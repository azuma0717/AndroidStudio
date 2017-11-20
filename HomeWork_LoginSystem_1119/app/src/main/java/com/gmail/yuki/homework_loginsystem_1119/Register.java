package com.gmail.yuki.homework_loginsystem_1119;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bt1, bt2;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Database_Helper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        ed1 = (EditText)findViewById(R.id.name);
        ed2 = (EditText)findViewById(R.id.phone);
        ed3 = (EditText)findViewById(R.id.email);
        ed4 = (EditText)findViewById(R.id.photo);
        ed5 = (EditText)findViewById(R.id.pass);
        ed6 = (EditText)findViewById(R.id.city);

        database_helper = new Database_Helper(Register.this);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt1:


                String name = ed1.getText().toString();
                String phone = ed2.getText().toString();
                String email = ed3.getText().toString();
                String photo = ed4.getText().toString();
                String pass = ed5.getText().toString();
                String city = ed6.getText().toString();


                database_helper.Insert(name, phone, email, photo, pass, city);

                Toast.makeText(getApplicationContext(), "Successfull", Toast.LENGTH_SHORT).show();

                break;


            case R.id.bt2:


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);


                break;


        }

    }
}
