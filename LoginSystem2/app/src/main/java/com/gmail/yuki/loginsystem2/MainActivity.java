package com.gmail.yuki.loginsystem2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.login);
        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);


    }
}
