package com.gmail.yuki.homework_photogalley_1113;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {


    ImageView iv;
    GridView gv;
    Image_Adaptar IM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.ImageView);
        gv = (GridView) findViewById(R.id.yukig);

/////////////////// Use Image_Adaptar class//////////

        ////// make a IM object/////////////////////

        IM = new Image_Adaptar(this);


        gv.setAdapter(IM);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position,long id ) {
                iv.setImageResource(IM.mThumbIds[position]);
            }

        });


    }

}

