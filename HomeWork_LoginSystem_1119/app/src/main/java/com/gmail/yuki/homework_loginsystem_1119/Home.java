package com.gmail.yuki.homework_loginsystem_1119;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Home extends AppCompatActivity implements Serializable {


    TextView tv0,tv1, tv2, tv3, tv4;
    ImageView iv1;
    Database_Helper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv0 = (TextView) findViewById(R.id.welcome);
        tv1 = (TextView) findViewById(R.id.name);
        tv2 = (TextView) findViewById(R.id.phone);
        tv3 = (TextView) findViewById(R.id.email);
        tv4 = (TextView) findViewById(R.id.city);
        iv1 = (ImageView) findViewById(R.id.photo);


        Intent intent = getIntent();
        String[] result = intent.getStringArrayExtra("data");


        tv0.append(result[0]);
        tv1.append(result[0]);
        tv2.append(result[1]);
        tv3.append(result[2]);
        tv4.append(result[4]);
        String  aaa = result[3];
        //iv1.setImageResource(aaa);
        //iv1.setImageResource(R.drawable.parseInt(result[3]));


    }
}
