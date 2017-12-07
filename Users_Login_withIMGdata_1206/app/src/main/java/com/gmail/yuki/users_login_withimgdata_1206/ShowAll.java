package com.gmail.yuki.users_login_withimgdata_1206;

import android.content.Intent;
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

public class ShowAll extends AppCompatActivity {

    ListView listView;
    ArrayList<ImageData> list = new ArrayList<>();
    ImgAdapter imgAdapter;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String arr[] = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);


        listView = findViewById(R.id.listview);
        json_string = getIntent().getStringExtra("showall");

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("data");
            int count = 0;
            String id,name,email,pass,path;

            while (count<jsonArray.length()){
                JSONObject jo = jsonArray.getJSONObject(count);

                id = jo.getString("id");
                name = jo.getString("name");
                email = jo.getString("email");
                pass = jo.getString("pass");
                path = jo.getString("path");
//                path = "http://192.168.0.100:8888/Androidims/"+path;
                path = "http://10.0.1.42:8888/Androidims/"+path;
                ImageData imageData = new ImageData();
                imageData.setId(id);
                imageData.setImg_name(name);
                imageData.setEmail(email);
                imageData.setPass(pass);
                imageData.setImg_path(path);
                list.add(imageData);
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        imgAdapter = new ImgAdapter(ShowAll.this,R.layout.show_all_data,list);
        listView.setAdapter(imgAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageData imageData = (ImageData) listView.getItemAtPosition(i);


                String id = imageData.getId();
                String name = imageData.getImg_name();
                String email = imageData.getEmail();
                String pass = imageData.getPass();
                String path = imageData.getImg_path();


                arr = new String[]{id,name, email, pass, path};

//                Toast.makeText(getApplicationContext(),imageData.getImg_name(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),User_Profile.class);
                intent.putExtra("userinfo", arr);
                startActivity(intent);

            }
        });


    }
}
