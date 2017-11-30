package com.gmail.yuki.loginsystem2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText ed1, ed2;
    Button bt1, bt2;
    Database_Helper database_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.pass);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        database_helper = new Database_Helper(Login.this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.bt1:

                String name = ed1.getText().toString();
                String pass = ed2.getText().toString();

                Cursor result = database_helper.login(name, pass);

                if (result == null) {


                    Toast.makeText(getApplicationContext(), "Name or Pass is wrong", Toast.LENGTH_SHORT).show();

                } else {

                    if (result.getCount() > 0) {

                        String[] array = new String[7];

                        if (result != null) {

                            while (result.moveToNext()) {

                                array[0] = result.getString(0);
                                array[1] = result.getString(1);
                                array[2] = result.getString(2);
                                array[3] = result.getString(3);
                                array[4] = result.getString(4);
                                array[5] = result.getString(5);
                                array[6] = result.getString(6);

                            }
                        }

                        Intent intent = new Intent(getApplication(), Home.class);
                        intent.putExtra("data", array);
                        startActivity(intent);


                    } else {

                        Toast.makeText(getApplicationContext(), "Name or Pass is wrong", Toast.LENGTH_SHORT).show();
                    }

                }


                break;

            case R.id.bt2:

                Intent intent2 = new Intent(getApplication(), Register.class);
                startActivity(intent2);


                break;


        }

    }
}
