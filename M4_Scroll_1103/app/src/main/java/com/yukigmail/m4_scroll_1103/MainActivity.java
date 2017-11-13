package com.yukigmail.m4_scroll_1103;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.txt1);

        String num = "";
        for (int i = 1; i <= 100; i++) {
            num = num + String.valueOf(i) + "\n";
        }

        tv.setText(num);

    }
}
