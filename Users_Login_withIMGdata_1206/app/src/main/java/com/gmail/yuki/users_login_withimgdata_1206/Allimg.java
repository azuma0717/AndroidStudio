package com.gmail.yuki.users_login_withimgdata_1206;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Allimg extends AppCompatActivity {

    ListView listView;
    ArrayList<ImageData> list = new ArrayList<>();
    ImgAdapter imgAdapter;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allimg);


        listView = findViewById(R.id.listview);
        json_string = getIntent().getStringExtra("allimg");

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("data");
            int count = 0;
            String id,name,path;

            while (count<jsonArray.length()){
                JSONObject jo = jsonArray.getJSONObject(count);
                id = jo.getString("id");
                name = jo.getString("img_name");
                path = jo.getString("img_path");
//                path = "http://192.168.0.100:8888/Androidims/"+path;
                path = "http://10.0.1.42:8888/Androidims/"+path;
                ImageData imageData = new ImageData();
                imageData.setId(id);
                imageData.setImg_name(name);
                imageData.setImg_path(path);
                list.add(imageData);
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        imgAdapter = new ImgAdapter(Allimg.this,R.layout.single_img_data,list);
        listView.setAdapter(imgAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageData imageData = (ImageData) listView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(),imageData.getImg_name(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
