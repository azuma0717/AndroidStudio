package com.gmail.yuki.misao_management_system_1123;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ShowAll extends Activity {

    Databese_Helper database_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_show_all);
        init();

    }

    public void init() {

        int i = 1;


        database_helper = new Databese_Helper(ShowAll.this);

        Cursor reslut = database_helper.show();

        TableLayout stk = (TableLayout) findViewById(R.id.table);
        TableRow tableRow0 = new TableRow(this);

        TextView tv0 = new TextView(this);
        tv0.setText("Sl No.");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);

        //↑で作ったTextView(=列)をRow0(=0行目)にぶち込む。
        tableRow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText("Name");
        tv1.setTextColor(Color.WHITE);
        tv1.setGravity(Gravity.CENTER);
        tableRow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("Phone");
        tv2.setTextColor(Color.WHITE);
        tv2.setGravity(Gravity.CENTER);
        tableRow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText("Email");
        tv3.setTextColor(Color.WHITE);
        tv3.setGravity(Gravity.CENTER);
        tableRow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText("City");
        tv4.setTextColor(Color.WHITE);
        tv4.setGravity(Gravity.CENTER);
        tableRow0.addView(tv4);

        TextView tv5 = new TextView(this);
        tv5.setText("dob");
        tv5.setTextColor(Color.WHITE);
        tv5.setGravity(Gravity.CENTER);
        tableRow0.addView(tv5);

        TextView tv6 = new TextView(this);
        tv6.setText("doj");
        tv6.setTextColor(Color.WHITE);
        tv6.setGravity(Gravity.CENTER);
        tableRow0.addView(tv6);

        TextView tv7 = new TextView(this);
        tv7.setText("doe");
        tv7.setTextColor(Color.WHITE);
        tv7.setGravity(Gravity.CENTER);
        tableRow0.addView(tv7);

        TextView tv8 = new TextView(this);
        tv8.setText("course");
        tv8.setTextColor(Color.WHITE);
        tv8.setGravity(Gravity.CENTER);
        tableRow0.addView(tv8);

        TextView tv9 = new TextView(this);
        tv9.setText("fee");
        tv9.setTextColor(Color.WHITE);
        tv9.setGravity(Gravity.CENTER);
        tableRow0.addView(tv9);

        TextView tv10 = new TextView(this);
        tv10.setText("ved");
        tv10.setTextColor(Color.WHITE);
        tv10.setGravity(Gravity.CENTER);
        tableRow0.addView(tv10);

        //テーブル自体に、0行目を突っ込む。
        stk.addView(tableRow0);


        reslut.moveToFirst();



        do {
            String name = reslut.getString(reslut.getColumnIndex("name"));
            String phone = reslut.getString(reslut.getColumnIndex("phone"));
            String email = reslut.getString(reslut.getColumnIndex("email"));
            String city = reslut.getString(reslut.getColumnIndex("city"));
            String dob = reslut.getString(reslut.getColumnIndex("dob"));
            String doj = reslut.getString(reslut.getColumnIndex("doj"));
            String doe = reslut.getString(reslut.getColumnIndex("doe"));
            String course = reslut.getString(reslut.getColumnIndex("course"));
            String fee = reslut.getString(reslut.getColumnIndex("fee"));
            String ved = reslut.getString(reslut.getColumnIndex("ved"));

            tableRow0 = new TableRow(this);

            tv0 = new TextView(this);
            tv0.setText(String.valueOf(i));
            tv0.setGravity(Gravity.CENTER);
            tv0.setTextColor(Color.WHITE);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(name);
            tv0.setGravity(Gravity.CENTER);
            tv0.setTextColor(Color.WHITE);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(phone);
            tv0.setTextColor(Color.WHITE);
            tv0.setGravity(Gravity.CENTER);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(email);
            tv0.setTextColor(Color.WHITE);
            tv0.setGravity(Gravity.CENTER);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(city);
            tv0.setTextColor(Color.WHITE);
            tv0.setGravity(Gravity.CENTER);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(dob);
            tv0.setTextColor(Color.WHITE);
            tv0.setGravity(Gravity.CENTER);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(doj);
            tv0.setTextColor(Color.WHITE);
            tv0.setGravity(Gravity.CENTER);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(doe);
            tv0.setTextColor(Color.WHITE);
            tv0.setGravity(Gravity.CENTER);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(course);
            tv0.setTextColor(Color.WHITE);
            tv0.setGravity(Gravity.CENTER);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(fee);
            tv0.setTextColor(Color.WHITE);
            tv0.setGravity(Gravity.CENTER);
            tableRow0.addView(tv0);

            tv0 = new TextView(this);
            tv0.setText(ved);
            tv0.setTextColor(Color.WHITE);
            tv0.setGravity(Gravity.CENTER);
            tableRow0.addView(tv0);

            //テーブル自体に、0行目を突っ込む。
            stk.addView(tableRow0);

            i++;


        }while(reslut.moveToNext());


    }


}
