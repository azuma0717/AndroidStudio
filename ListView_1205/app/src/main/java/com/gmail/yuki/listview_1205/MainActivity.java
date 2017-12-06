package com.gmail.yuki.listview_1205;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    Button bt1;
    ListView lv1;

    static List<String> dataList = new ArrayList<String>();
    static ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.button);
        lv1 = findViewById(R.id.list);

        bt1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
        lv1.setAdapter(adapter);
        adapter.add("Hello!");


    }
}
