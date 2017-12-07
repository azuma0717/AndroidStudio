package com.gmail.yuki.sessions_1207;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.send);
        bt1.setOnClickListener(this);

        ////sessionは、putextraをしなくても、変数を送ることができる。
        ///今回の場合は、setter,getterを織り交ぜながらやっている。

        //Sessionクラスを作って、setter,getterにセット
        Session session = new Session(this,"users");
        session.setName("name","yuki");

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,GetActivity.class));

    }
}
