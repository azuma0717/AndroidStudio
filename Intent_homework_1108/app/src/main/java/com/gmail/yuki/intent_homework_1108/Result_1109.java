package com.gmail.yuki.intent_homework_1108;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result_1109 extends AppCompatActivity {

    TextView tv2,tv3,tv4,tv5,tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_1109);

        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);


        Intent intent = getIntent();
        String a = intent.getExtras().getString("misao1");
        String x = tv2.getText()+a;
        tv2.setText(x);

         a = intent.getExtras().getString("misao2");
         x = tv3.getText()+a;
        tv3.setText(x);

        a = intent.getExtras().getString("misao3");

         x = tv4.getText()+a;
        tv4.setText(x);

        a = intent.getExtras().getString("misao4");
         x = tv5.getText()+a;
        tv5.setText(x);

        a = intent.getExtras().getString("misao5");

         x = tv6.getText()+a;
        tv6.setText(x);

    }
}
