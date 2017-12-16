package com.gmail.yuki.shop_demo_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ProductShow extends AppCompatActivity {

    ListView listView;
    Database_Helper database_helper;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ArrayList<ProductData> list = new ArrayList<>();
    ProductShowAdapter productShowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_show);

        listView = findViewById(R.id.List_product);

        Intent intent = getIntent();
        String productshow = intent.getExtras().getString("productshow");



        try {
            jsonObject = new JSONObject(productshow);
            jsonArray = jsonObject.getJSONArray("data");
            int count = 0;
            String name,price,img;


            while (count<jsonArray.length()){
                JSONObject jo = jsonArray.getJSONObject(count);

                name = jo.getString("name");
                price = jo.getString("price");
                img = jo.getString("img");
                img = "http://10.0.1.42:8888/Androidims/"+img;
//                img = "http://192.171.144.40:8888/Androidims/"+img;
                ProductData productData = new ProductData();
                productData.setName(name);
                productData.setPrice(price);
                productData.setImg(img);

                list.add(productData);
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        productShowAdapter = new ProductShowAdapter(this,R.layout.product_layout,list);
        listView.setAdapter(productShowAdapter);

        //////// アダプター周りでこんなエラーがあるよ。///////
       /// invoke virtual method 'void android.widget.ListView.setAdapter(android.widget.ListAdapter)' on a null object reference
       //////これは、listviewのidがfindできていない可能性が高い。見直しが必要。


    }
}
