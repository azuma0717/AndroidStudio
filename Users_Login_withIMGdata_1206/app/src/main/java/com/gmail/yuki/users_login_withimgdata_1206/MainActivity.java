package com.gmail.yuki.users_login_withimgdata_1206;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int TIME_CHANGE = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);

            }
        }, TIME_CHANGE);
    }
}
