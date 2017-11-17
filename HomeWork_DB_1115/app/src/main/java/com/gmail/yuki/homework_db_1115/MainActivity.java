package com.gmail.yuki.homework_db_1115;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    SQLiteDatabase db;
    EditText ed1, ed2, ed3, ed4;
    Button bt1, bt2, bt3, bt4;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.phone);
        ed3 = findViewById(R.id.email);
        ed4 = findViewById(R.id.pass);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        tv1 = findViewById(R.id.text);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

        db = openOrCreateDatabase("yuki", MODE_PRIVATE, null);
        db.execSQL("create table if not exists user2(name varchar,phone varchar,email varchar,pass varchar)");


    }

    @Override
    public void onClick(View v) {

        String gname = ed1.getText().toString();
        String gphone = ed2.getText().toString();
        String gemail = ed3.getText().toString();
        String gpass = ed4.getText().toString();

        switch (v.getId()) {

            case R.id.bt1:


                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");

                db.execSQL("insert into user2 values('" + gname + "','" + gphone + "','" + gemail + "','" + gpass + "')");

                Toast.makeText(getApplicationContext(), "insert succsess", Toast.LENGTH_LONG).show();

                break;

            case R.id.bt2:

                Cursor c = db.rawQuery("select * from user2", null);

                tv1.setText("");

                c.moveToFirst();

                do {

                    String name1 = c.getString(c.getColumnIndex("name"));
                    String phone1 = c.getString(c.getColumnIndex("phone"));
                    String email1 = c.getString(c.getColumnIndex("email"));
                    String pass1 = c.getString(c.getColumnIndex("pass"));
                    tv1.append("name :- " + name1 + "  phone :- " + phone1 + "\n email :- " + email1 + "  pass :- " + pass1 + "\n");

                }
                while (c.moveToNext());


                break;

            case R.id.bt3:

                Cursor c1 = db.rawQuery("select * from user2 WHERE name = '" + gname + "' or phone = '" + gphone + "' or email = '" + gemail + "' or pass = '" + gpass + "'", null);


                tv1.setText("");
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");

                c1.moveToFirst();


                do {

                    String name1 = c1.getString(c1.getColumnIndex("name"));
                    String phone1 = c1.getString(c1.getColumnIndex("phone"));
                    String email1 = c1.getString(c1.getColumnIndex("email"));
                    String pass1 = c1.getString(c1.getColumnIndex("pass"));
                    tv1.append("name :- " + name1 + "  phone :- " + phone1 + "\n email :- " + email1 + "  pass :- " + pass1 + "\n");

                }
                while (c1.moveToNext());

                break;

            case R.id.bt4:

//                db.rawQuery("DELETE from user2 WHERE name = '"+ gname +"' or phone = '"+ gphone +"' or email = '"+ gemail +"' or pass = '"+ gpass +"'", null);

                db.delete("user2", "name = '" + gname + "'", null);


                tv1.setText("");
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");


                Toast.makeText(getApplicationContext(), "Delete Success", Toast.LENGTH_LONG).show();


                break;


        }

    }
}
