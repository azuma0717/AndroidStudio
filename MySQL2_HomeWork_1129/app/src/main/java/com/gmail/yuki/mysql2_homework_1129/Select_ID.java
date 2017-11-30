package com.gmail.yuki.mysql2_homework_1129;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Select_ID extends AppCompatActivity implements View.OnClickListener {

    EditText ed1;
    Button bt1, bt2;
    Database_Helper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__id);

        ed1 = findViewById(R.id.id);
        bt1 = findViewById(R.id.go);
        bt2 = findViewById(R.id.back);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

        database_helper = new Database_Helper(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.go:

                String method = "yukicheck";
                String id = ed1.getText().toString();

                database_helper.execute(method,id);

                break;


            case R.id.back:

                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);

                break;

        }

    }
}
