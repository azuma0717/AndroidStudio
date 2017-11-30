package com.gmail.yuki.misao_management_system_1123;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    Button bt1,bt2,bt3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        bt1 =(Button)findViewById(R.id.bt1);
        bt2 =(Button)findViewById(R.id.bt2);
        bt3 =(Button)findViewById(R.id.bt3);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bt1:

                Intent intent1 = new Intent(getApplicationContext(),Insert.class);
                startActivity(intent1);

                break;

            case R.id.bt2:

                Intent intent2 = new Intent(getApplicationContext(),ShowAll.class);
                startActivity(intent2);

                break;

            case R.id.bt3:

                Intent intent3 = new Intent(getApplicationContext(),ShowId.class);
                startActivity(intent3);

                break;


        }



    }
}
