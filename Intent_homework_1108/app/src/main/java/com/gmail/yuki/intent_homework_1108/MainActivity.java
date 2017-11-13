package com.gmail.yuki.intent_homework_1108;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bt1 :{

                Intent yuki = new Intent(getApplicationContext(),YukiCal.class);
                startActivity(yuki);
                break;
            }

            case R.id.bt2 :{

                Intent yuki = new Intent(getApplicationContext(),Profile_1109.class);
                startActivity(yuki);
                break;
            }
        }

    }
}
