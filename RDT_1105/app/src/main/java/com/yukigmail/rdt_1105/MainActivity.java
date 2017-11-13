package com.yukigmail.rdt_1105;

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

        for(int a = 5; a>0; a--){

            for(int c = 0; c<(5-a); c++){

                num = num + "  ";

            }

            for(int b = a; b>0; b--){

                num = num + "*";

            }

            num = num + "\n";
        }
        tv.setText(num);
    }
}
