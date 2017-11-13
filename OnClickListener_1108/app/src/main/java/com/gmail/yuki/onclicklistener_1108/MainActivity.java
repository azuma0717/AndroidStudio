package com.gmail.yuki.onclicklistener_1108;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button bt1,bt2,bt3,bt4;
    EditText no1,no2;
    TextView tv;
    int a,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);
        bt3 = (Button)findViewById(R.id.bt3);
        bt4 = (Button)findViewById(R.id.bt4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

        no1 = (EditText)findViewById(R.id.no1);
        no2 = (EditText)findViewById(R.id.no2);

//        String x = no1.getText().toString();
//         a = Integer.parseInt(x);
//        String y = no2.getText().toString();
//         b = Integer.parseInt(y);

        tv = (TextView)findViewById(R.id.text1);

    }

    @Override
    public void onClick(View v) {

        a = Integer.valueOf(no1.getText().toString());
        b = Integer.valueOf(no2.getText().toString());
        String x ;
        switch(v.getId())
        {
            case R.id.bt1 : {
                //int a = Integer.valueOf(no1.getText().toString());
                int num3 = a+b;
                 x = String.valueOf(num3);
                tv.setText(x);

//                tv.setText(bt1.getText().toString());


                break;}

            case R.id.bt2 : {

                int num3 = a-b;
                 x = String.valueOf(num3);
                tv.setText(x);

                break;}

            case R.id.bt3 : {

                int num3 = a*b;
                 x = String.valueOf(num3);
                tv.setText(x);

                break;}

            case R.id.bt4 : {

                int num3 = a/b;
                 x = String.valueOf(num3);
                tv.setText(x);

                break;}

        }
    }
}
