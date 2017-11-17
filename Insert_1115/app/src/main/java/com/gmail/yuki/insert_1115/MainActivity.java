package com.gmail.yuki.insert_1115;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase db;

    EditText ed1, ed2, ed3, ed4;
    Button bt1, bt2;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.phone);
        ed3 = (EditText) findViewById(R.id.email);
        ed4 = (EditText) findViewById(R.id.pass);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);

        tv1 = (TextView) findViewById(R.id.text);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);


        db = openOrCreateDatabase("yuki", MODE_PRIVATE, null);
        db.execSQL("create table if not exists user(name varchar,phone varchar,email varchar,pass varchar)");


    }

    @Override
    public void onClick(View v) {

//        String x ;
//
//        x = "My name is " + ed1.getText().toString() +".\n\n";
//        x = x + "My phone no is " + ed2.getText().toString() +".\n\n";
//        x = x + "My Email is "+ ed3.getText().toString() +".\n\n";
//        x = x + "My Password is "+ ed4.getText().toString() +".\n\n";
//
//        tv1.setText(x);

        switch (v.getId()) {

            case R.id.bt1:

                String name = ed1.getText().toString();
                String phone = ed2.getText().toString();
                String email = ed3.getText().toString();
                String pass = ed4.getText().toString();

                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");

                db.execSQL("insert into user values('" + name + "','" + phone + "','" + email + "','" + pass + "')");

                Toast.makeText(getApplicationContext(), "insert success", Toast.LENGTH_LONG).show();

                break;


            case R.id.bt2:

                Cursor c = db.rawQuery("select * from user",null);

                tv1.setText("");

                c.moveToFirst();

                do{
                    String name1 = c.getString(c.getColumnIndex("name"));
                    String phone1 = c.getString(c.getColumnIndex("phone"));
                    String email1 = c.getString(c.getColumnIndex("email"));
                    String pass1 = c.getString(c.getColumnIndex("pass"));
                 tv1.append("name :- "+name1+"  phone :- "+phone1+"\n email :- "+email1+"  pass :- "+pass1+"\n");

                }while(c.moveToNext());




        }

    }
}
