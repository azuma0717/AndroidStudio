package com.gmail.yuki.photo_gallery_1110;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Reslut_1110 extends AppCompatActivity {

    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reslut_1110);

        iv = findViewById(R.id.iv);
        tv = findViewById(R.id.txt);

        Intent intent = getIntent();
        String x =intent.getExtras().getString("misao");

        x = "R.drawable"+ x;


        iv.setImageResource(x);


    }
}
