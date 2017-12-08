package com.gmail.yuki.shop_demo_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCategory extends AppCompatActivity implements View.OnClickListener {

    EditText ed1;
    Button bt1,bt2;
    Database_Helper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        ed1 = findViewById(R.id.category);
        bt1 = findViewById(R.id.add);
        bt2 = findViewById(R.id.back);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.add:

                database_helper = new Database_Helper(AddCategory.this);
                String category = ed1.getText().toString();
                String method = "add";
                database_helper.execute(method,category);

                break;


            case R.id.back:

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                break;



        }

    }
}
