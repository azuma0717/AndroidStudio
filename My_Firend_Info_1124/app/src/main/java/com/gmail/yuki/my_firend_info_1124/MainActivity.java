package com.gmail.yuki.my_firend_info_1124;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1,bt2,bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt1 =(Button)findViewById(R.id.insert);
        bt2 =(Button)findViewById(R.id.showall);
        bt3 =(Button)findViewById(R.id.showid);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.insert:

                Intent intent1 = new Intent(getApplicationContext(),Insert.class);
                startActivity(intent1);

                break;


            case R.id.showall:

                Intent intent2 = new Intent(getApplicationContext(),ShowAll.class);
                startActivity(intent2);

                break;

            case R.id.showid:

                Intent intent3 = new Intent(getApplicationContext(),ShowID.class);
                startActivity(intent3);

                break;




        }

    }
}
