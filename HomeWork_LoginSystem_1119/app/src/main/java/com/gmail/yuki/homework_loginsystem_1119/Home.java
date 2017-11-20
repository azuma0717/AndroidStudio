package com.gmail.yuki.homework_loginsystem_1119;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Home extends AppCompatActivity implements View.OnClickListener {


    TextView tv0, tv1, tv2, tv3, tv4;
    ImageView iv1;
    Button bt1;


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
        bt1 = (Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(this);


        Intent intent = getIntent();
        String[] result = intent.getStringArrayExtra("data");


        tv0.append(result[0]);
        tv1.append(result[0]);
        tv2.append(result[1]);
        tv3.append(result[2]);
        tv4.append(result[4]);

        switch (result[3]) {

            case "a1":

                iv1.setImageResource(R.drawable.a1);

                break;

            case "a2":

                iv1.setImageResource(R.drawable.a2);

                break;

            case "a3":

                iv1.setImageResource(R.drawable.a3);

                break;

            case "a4":

                iv1.setImageResource(R.drawable.a4);

                break;

            case "a5":

                iv1.setImageResource(R.drawable.a5);

                break;

            case "a6":

                iv1.setImageResource(R.drawable.a6);

                break;

            case "a7":

                iv1.setImageResource(R.drawable.a7);

                break;

            case "a8":

                iv1.setImageResource(R.drawable.a8);

                break;

            case "a9":

                iv1.setImageResource(R.drawable.a9);

                break;

            case "a10":

                iv1.setImageResource(R.drawable.a10);

                break;

            case "a11":

                iv1.setImageResource(R.drawable.a11);

                break;

            case "a12":

                iv1.setImageResource(R.drawable.a12);

                break;

            case "a13":

                iv1.setImageResource(R.drawable.a13);

                break;

            case "a14":

                iv1.setImageResource(R.drawable.a14);

                break;

        }


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);

    }
}
