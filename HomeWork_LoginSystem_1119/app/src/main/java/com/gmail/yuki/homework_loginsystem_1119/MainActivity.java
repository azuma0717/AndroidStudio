package com.gmail.yuki.homework_loginsystem_1119;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Serializable {

    EditText ed1, ed2;
    Button bt1, bt2;

    Database_Helper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.pass);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

        database_helper = new Database_Helper(MainActivity.this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.bt1:

                String name = ed1.getText().toString();
                String pass = ed2.getText().toString();

                Cursor reslut = database_helper.login(name, pass);

                if (reslut.getCount() > 0) {

                    String[] array = new String[5];
                    if (reslut != null) {
                        while (reslut.moveToNext()) {

                            array[0] = reslut.getString(0);
                            array[1] = reslut.getString(1);
                            array[2] = reslut.getString(2);
                            array[3] = reslut.getString(3);
                            array[4] = reslut.getString(5);

                        }
                    }


                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    intent.putExtra("data",array);
                    startActivity(intent);

                } else {

                    Toast.makeText(getApplicationContext(), "Wrong name or password", Toast.LENGTH_LONG).show();


                }


                break;

            case R.id.bt2:

                Intent intent = new Intent(getApplicationContext(), Register.class);

                startActivity(intent);

                break;

        }


    }
}
