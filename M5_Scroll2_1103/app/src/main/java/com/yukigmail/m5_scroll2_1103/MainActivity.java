package com.yukigmail.m5_scroll2_1103;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.txt1);

        String num = "";
        for (int j = 1; j <=5 ; j++) {
            for (int i = 1; i <= 5; i++) {

                for (int l = 0; l < i; l++) {

                    num = num + "*";
                }
                num = num + "\n";
            }
            num = num + "\n\n\n";
        }

        tv.setText(num);

    }
}

//num = num + String.valueOf(i) + "\n";
