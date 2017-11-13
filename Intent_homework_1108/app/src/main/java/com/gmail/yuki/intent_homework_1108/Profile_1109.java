package com.gmail.yuki.intent_homework_1108;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profile_1109 extends AppCompatActivity implements View.OnClickListener {

    EditText ed1,ed2,ed3,ed4,ed5;
    Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_1109);

        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);
        ed3 = (EditText)findViewById(R.id.ed3);
        ed4 = (EditText)findViewById(R.id.ed4);
        ed5 = (EditText)findViewById(R.id.ed5);
        bt1 = (Button)findViewById(R.id.bt1);

        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent yuki = new Intent(getApplicationContext(),Result_1109.class);
        String a1 = ed1.getText().toString();
        yuki.putExtra("misao1",a1);

        String a2 = ed2.getText().toString();
        yuki.putExtra("misao2",a2);

        String a3 = ed3.getText().toString();
        yuki.putExtra("misao3",a3);

        String a4 = ed4.getText().toString();
        yuki.putExtra("misao4",a4);

        String a5 = ed5.getText().toString();
        yuki.putExtra("misao5",a5);

        startActivity(yuki);

    }
}
