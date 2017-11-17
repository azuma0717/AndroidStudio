package com.gmail.yuki.homework_db2_1116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1,bt2;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Database_Helper database_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.name);
        ed2 = (EditText)findViewById(R.id.phone);
        ed3 = (EditText)findViewById(R.id.salary);
        ed4 = (EditText)findViewById(R.id.city);
        ed5 = (EditText)findViewById(R.id.dob);
        ed6 = (EditText)findViewById(R.id.email);
        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

        database_helper = new Database_Helper(MainActivity.this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bt1:

                String name = ed1.getText().toString();
                String phone = ed2.getText().toString();
                String salary = ed3.getText().toString();
                String city = ed4.getText().toString();
                String dob = ed5.getText().toString();
                String email = ed6.getText().toString();

                database_helper.Insert(name,phone,salary,city,dob,email);




                Toast.makeText(getApplicationContext(),"insert successfully",Toast.LENGTH_SHORT).show();

                break;

            case R.id.bt2:

                Intent intent = new Intent(getApplicationContext(),Show_DB3.class);
                startActivity(intent);



//                Toast.makeText(getApplicationContext(),"show",Toast.LENGTH_SHORT).show();

                break;



        }

    }
}
