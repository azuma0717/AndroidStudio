package com.gmail.yuki.shop_demo_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1,bt2;
    ListView listView;
    ArrayList<ProductData> list = new ArrayList<>();
    ArrayList products2 = new ArrayList();
    ProductAdapter productAdapter;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String arr[] = new String[5];
    Database_Helper database_helper;

    String[] products = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.category);
        bt2 = findViewById(R.id.product);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

        database_helper = new Database_Helper(MainActivity.this);
        String method = "category";

        try {
            json_string = database_helper.execute(method).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        listView = findViewById(R.id.listview);
//        json_string = getIntent().getStringExtra("category");


        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("data");
            int count = 0;
            String cid,cname;


            while (count<jsonArray.length()){
                JSONObject jo = jsonArray.getJSONObject(count);

                cid = jo.getString("cid");
                cname = jo.getString("cname");
                ProductData productData = new ProductData();
                productData.setCid(cid);
                productData.setCname(cname);
                list.add(productData);
                products2.add(cname);
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



        productAdapter = new ProductAdapter(MainActivity.this,R.layout.home_layout,list);
        listView.setAdapter(productAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ProductData productData = (ProductData) listView.getItemAtPosition(i);


//                Toast.makeText(getApplicationContext(),""+i, Toast.LENGTH_SHORT).show();

                database_helper = new Database_Helper(MainActivity.this);

                String productId = String.valueOf(i+1);
                String method = "productshow";

                database_helper.execute(method,productId);



//                Intent intent = new Intent(getApplicationContext(),ProductShow.class);
//                intent.putExtra("productid", pid);
//                startActivity(intent);

            }
        });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.category:

                Intent intent = new Intent(getApplicationContext(),AddCategory.class);
                startActivity(intent);

                break;


            case R.id.product:

                products = new String[ products2.size() ];
                products2.toArray(products);

                intent = new Intent(getApplicationContext(),CreateProducts.class);
                intent.putExtra("categorydata",products);
                startActivity(intent);



                break;


        }



    }
}
