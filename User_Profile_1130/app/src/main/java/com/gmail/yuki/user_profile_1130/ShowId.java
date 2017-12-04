package com.gmail.yuki.user_profile_1130;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowId extends AppCompatActivity implements View.OnClickListener {

    EditText ed1;
    Button bt1;
    TextView tv1, tv2, tv3, tv4, tv5;
    Database_Helper database_helper;
    String aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_id);

        ed1 = findViewById(R.id.id);
        bt1 = findViewById(R.id.go);
        tv1 = findViewById(R.id.name);
        tv2 = findViewById(R.id.phone);
        tv3 = findViewById(R.id.email);
        tv4 = findViewById(R.id.city);
        tv5 = findViewById(R.id.dob);

        bt1.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {

        String id = ed1.getText().toString();
        String method = "idcheck";
        database_helper = new Database_Helper(this);
        database_helper.execute(method, id);
        String ii = getIntent().getStringExtra("name");


        Toast.makeText(getApplicationContext(), ii, Toast.LENGTH_LONG).show();





    }
}
