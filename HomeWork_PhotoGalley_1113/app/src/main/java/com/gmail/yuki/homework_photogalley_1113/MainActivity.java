package com.gmail.yuki.homework_photogalley_1113;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ImageView iv;
    GridView gridView;
    Image_Adaptar im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.yukig);
         im = new Image_Adaptar(this);
        gridView.setAdapter(new Image_Adaptar(this));
        gridView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),""+im.getItem(i),Toast.LENGTH_LONG).show();
        iv.setImageResource((Integer) im.getItem(i));
    }
}

