package com.gmail.yuki.listview2_1205;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] product = new String[]{"laptop","mobile","pen","bottle","cap","battery","charger","water","tea","chai","samosa","macbook","android","newspaper","cloths"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.single_item,R.id.text,product);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),product[i],Toast.LENGTH_SHORT).show();
            }
        });



    }
}
