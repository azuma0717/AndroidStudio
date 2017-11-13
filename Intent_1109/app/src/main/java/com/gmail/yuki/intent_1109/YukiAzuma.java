package com.gmail.yuki.intent_1109;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class YukiAzuma extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuki_azuma);
        tv =(TextView)findViewById(R.id.txt1);

        Intent intent = getIntent();
        String aa = intent.getExtras().getString("misao");
        tv.setText(aa);
    }
}
