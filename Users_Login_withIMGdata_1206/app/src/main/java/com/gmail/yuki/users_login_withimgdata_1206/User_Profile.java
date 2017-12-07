package com.gmail.yuki.users_login_withimgdata_1206;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class User_Profile extends AppCompatActivity implements View.OnClickListener{

    ImageView iv1;
    Button bt1;
    EditText ed1,ed2,ed3;
    private Activity activity;
    String id,name,email,pass;
    Database_Helper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);


        iv1 = findViewById(R.id.image);
        bt1 = findViewById(R.id.edit);
        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.email);
        ed3 = findViewById(R.id.pass);

        bt1.setOnClickListener(this);


        Intent intent = getIntent();
        String[] userinfo = intent.getExtras().getStringArray("userinfo");


        id = userinfo[0];

        ed1.setText(userinfo[1]);
        ed2.setText(userinfo[2]);
        ed3.setText(userinfo[3]);
        Picasso.with(activity)
                .load(userinfo[4])
                .resize(200,150)
                .into(iv1);
    }

    @Override
    public void onClick(View view) {

        database_helper = new Database_Helper(User_Profile.this);
        String method = "edit";

        name = ed1.getText().toString();
        email = ed2.getText().toString();
        pass = ed3.getText().toString();

        database_helper.execute(method,id,name,email,pass);

    }
}
