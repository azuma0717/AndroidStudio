package com.gmail.yuki.db2_1116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1, bt2;
    EditText ed1,ed2,ed3,ed4;
    Database_Helper database_helper;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed1 = (EditText)findViewById(R.id.name);
        ed2 = (EditText)findViewById(R.id.phone);
        ed3 = (EditText)findViewById(R.id.email);
        ed4 = (EditText)findViewById(R.id.dob);

        tv1 = (TextView)findViewById(R.id.text);


        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

        database_helper = new Database_Helper(MainActivity.this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt1:

                String name = ed1.getText().toString();
                String phone = ed2.getText().toString();
                String email = ed3.getText().toString();
                String dob = ed4.getText().toString();

                database_helper.Insertss(name,phone,email,dob);
                Toast.makeText(getApplicationContext(),"inssssert",Toast.LENGTH_SHORT).show();



                break;


            case R.id.bt2:

                Intent intent = new Intent(getApplicationContext(),Show_DB2.class);
                startActivity(intent);
                break;
        }

    }
}
