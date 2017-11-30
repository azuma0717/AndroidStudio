package com.gmail.yuki.my_firend_info_1124;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static android.graphics.drawable.Drawable.*;

public class ShowAll extends Activity implements View.OnClickListener {

    Button bt1;
    Databese_Helper databese_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_show_all);


        bt1 =findViewById(R.id.back);
        bt1.setOnClickListener(this);

        init();

    }

    public void init() {

        databese_helper = new Databese_Helper(ShowAll.this);
        ImageView iv1;
        Bitmap bmp1;
        Bitmap rebmp1;

        Cursor rslt = databese_helper.showall();

        TableLayout stk = (TableLayout) findViewById(R.id.table);
        TableRow tableRow0 = new TableRow(this);

        TextView tv0 = new TextView(this);
        tv0.setText("Sl No.");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);

        //↑で作ったTextView(=列)をRow0(=0行目)にぶち込む。
        tableRow0.addView(tv0);

        TextView photo = new TextView(this);
        photo.setText("photo");
        photo.setTextColor(Color.WHITE);
        photo.setGravity(Gravity.CENTER);
        tableRow0.addView(photo);

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

        stk.addView(tableRow0);

        rslt.moveToFirst();

        do {
            String sl = rslt.getString(rslt.getColumnIndex("_id"));
            String img = rslt.getString(rslt.getColumnIndex("photo"));
            String name = rslt.getString(rslt.getColumnIndex("name"));
            String phone = rslt.getString(rslt.getColumnIndex("phone"));
            String email = rslt.getString(rslt.getColumnIndex("email"));
            String city = rslt.getString(rslt.getColumnIndex("city"));
            String dob = rslt.getString(rslt.getColumnIndex("dob"));

            tableRow0 = new TableRow(this);

            tv0 = new TextView(this);
            tv0.setText(sl);
            tv0.setGravity(Gravity.CENTER);
            tv0.setTextColor(Color.WHITE);
            tableRow0.addView(tv0);

            ///////////////////////////////////

            iv1 = new ImageView(this);
            bmp1 = BitmapFactory.decodeFile(img);
            rebmp1 = Bitmap.createScaledBitmap(bmp1, 100, 100, false);

            iv1.setImageBitmap(rebmp1);                //ビットマップをImageViewにセット
            tableRow0.addView(iv1);

            ///////////////////////////////////

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


            //テーブル自体に、0行目を突っ込む。
            stk.addView(tableRow0);

        } while (rslt.moveToNext());


    }


    @Override
    public void onClick(View view) {

        Intent back = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(back);

    }
}
