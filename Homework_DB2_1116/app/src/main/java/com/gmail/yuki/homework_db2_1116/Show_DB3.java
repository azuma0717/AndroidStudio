package com.gmail.yuki.homework_db2_1116;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Show_DB3 extends AppCompatActivity  {

    TextView tv1;
    Database_Helper database_helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__db3);

        tv1 =(TextView)findViewById(R.id.txt1);
        database_helper = new Database_Helper(Show_DB3.this);

        Cursor reslut = database_helper.show();

        reslut.moveToFirst();

        do{
            String name = reslut.getString(reslut.getColumnIndex("name"));
            String phone = reslut.getString(reslut.getColumnIndex("phone"));
            String salary = reslut.getString(reslut.getColumnIndex("salary"));
            String city = reslut.getString(reslut.getColumnIndex("city"));
            String dob = reslut.getString(reslut.getColumnIndex("dob"));
            String email = reslut.getString(reslut.getColumnIndex("email"));

            tv1.append(name +"  "+phone+"  \n"+salary+"  "+city+"  \n"+dob+"  "+email+"  \n\n\n");

        }while (reslut.moveToNext());


    }





}
