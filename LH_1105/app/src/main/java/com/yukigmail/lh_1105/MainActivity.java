package com.yukigmail.lh_1105;

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

        for (int a = 1; a <= 10; a++) {

            if(a<=5) {

                for (int b = 0; b < a; b++) {

                    num = num + "*";
                }
                num = num + "\n";

            }else {
                
                for (int b = (10-a); b > 0; b--) {

                    num = num + "*";

                }

                num = num + "\n";
            }
        }
        tv.setText(num);
    }
}