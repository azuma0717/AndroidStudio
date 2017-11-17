package com.gmail.yuki.homework_photogallery_1113;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv =(GridView)findViewById(R.id.yukig);
        gv.setAdapter(new Image_Adaptar(this));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Big_Img.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });



    }
}
