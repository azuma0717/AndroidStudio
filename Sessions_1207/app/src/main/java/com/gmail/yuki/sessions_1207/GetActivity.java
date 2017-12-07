package com.gmail.yuki.sessions_1207;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class GetActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        Session session = new Session(this,"user");
        String name = session.getName("name");
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();

    }
}
