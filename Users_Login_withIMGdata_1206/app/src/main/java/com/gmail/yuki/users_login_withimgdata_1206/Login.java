package com.gmail.yuki.users_login_withimgdata_1206;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.DataFormatException;

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText ed1,ed2;
    Button bt1;

    Database_Helper database_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.pass);
        bt1 = findViewById(R.id.submit);


        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

//        Toast.makeText(getApplicationContext(),"sss",Toast.LENGTH_SHORT).show();

        database_helper = new Database_Helper(Login.this);

        String method = "login";
        String name = ed1.getText().toString();
        String pass = ed2.getText().toString();

        database_helper.execute(method,name,pass);

    }
}
