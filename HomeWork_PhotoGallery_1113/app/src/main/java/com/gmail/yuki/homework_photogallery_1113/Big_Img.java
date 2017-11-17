package com.gmail.yuki.homework_photogallery_1113;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Big_Img extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big__img);

        iv = findViewById(R.id.SingleView);
        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");
        Image_Adaptar IM = new Image_Adaptar(this);

        iv.setImageResource(IM.mThumbIds[position]);

    }
}
