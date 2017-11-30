package com.gmail.yuki.mysql_insert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1,bt2;
    EditText ed1, ed2, ed3;
    Database_Helper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.email);
        ed3 = findViewById(R.id.phone);
        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        database_helper = new Database_Helper(this);


    }

    @Override
    public void onClick(View v) {

        String name = ed1.getText().toString();
        String email = ed2.getText().toString();
        String phone = ed3.getText().toString();
        String method = "Register";


        switch (v.getId()) {

            case R.id.bt1:

                //execute is predefined method//////////////
                database_helper.execute(method, name, email, phone);

                break;

            case R.id.bt2:

                Intent select = new Intent(getApplicationContext(),Select_Id.class);
                startActivity(select);


                break;


        }


    }
}
