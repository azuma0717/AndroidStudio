package com.yukigmail.ldt_1105;

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

        for(int a = 0; a<5; a++){

            for(int b = 5; b>a; b--){

                num = num + "*";
            }

            for(int c = 0; c<a; c++){

                num = num + "  ";

            }
            num = num + "\n";

        }
        tv.setText(num);

    }
}
