package com.yukigmail.uh_1105;

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
        for(int a = 5; a>0; a--) {

            for(int c =a; c>1; c--){

                num = num + "  ";

            }

            for (int b = 0; b < (6-a); b++){

                num = num + "*";

            }

            for(int d =1; d<(6-a); d++){

                num = num + "*";
            }



            num = num + "\n";
        }
        tv.setText(num);
    }
}
