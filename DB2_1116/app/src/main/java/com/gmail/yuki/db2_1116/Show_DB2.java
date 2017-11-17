package com.gmail.yuki.db2_1116;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Show_DB2 extends AppCompatActivity implements View.OnClickListener {

    Button bt3;
    TextView tv1;
    Database_Helper database_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__db2);

        tv1 = (TextView) findViewById(R.id.txt2);
        database_helper = new Database_Helper(Show_DB2.this);

        Cursor reslut = database_helper.show();

        reslut.moveToFirst();

        do {
            String name = reslut.getString(reslut.getColumnIndex("name"));
            String phone = reslut.getString(reslut.getColumnIndex("phone"));
            String email = reslut.getString(reslut.getColumnIndex("email"));
            String dob = reslut.getString(reslut.getColumnIndex("dob"));

            tv1.append(name +"  "+ phone+"  \n"+email+"  "+dob+"\n");


        }while(reslut.moveToNext());


        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);


    }
}
