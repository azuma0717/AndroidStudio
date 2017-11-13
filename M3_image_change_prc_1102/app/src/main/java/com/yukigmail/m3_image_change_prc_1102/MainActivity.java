package com.yukigmail.m3_image_change_prc_1102;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button bt;
    ImageView iv;
    TextView tv,tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button)findViewById(R.id.yuki);
        iv = (ImageView)findViewById(R.id.yukiimag);
        tv = (TextView)findViewById(R.id.yukitext);
        tv2 = (TextView)findViewById(R.id.yukitext2);
    }

    int a = 1;
    public void clicks(View v)
    {

        if(a % 2 == 0){
            iv.setImageResource(R.drawable.misao);
            tv2.setText("misao"+ String.valueOf(a));


            a++;
        }
        else
        {
            iv.setImageResource(R.drawable.rei);
            tv2.setText("Rei"+ String.valueOf(a));
            a++;
        }

    }

}
