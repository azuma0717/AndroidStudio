package com.gmail.yuki.user_profile_1130;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener{

    Button bt1,bt2;
    Database_Helper database_helper;
    String dd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bt1 = findViewById(R.id.insert);
        bt2 = findViewById(R.id.showid);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

        database_helper = new Database_Helper(Home.this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.insert:

                String method = "yukicheck";
                database_helper.execute(method);

//                dd = getIntent().getStringExtra("idnumber");
//                Toast.makeText(getApplicationContext(),dd,Toast.LENGTH_SHORT).show();

//                Intent insertintent  = new Intent (getApplicationContext(),MainActivity.class);
//                insertintent.putExtra("id",dd);
//                startActivity(insertintent);

                break;



            case R.id.showid:

                Intent intent = new Intent(getApplicationContext(),ShowId.class);
                startActivity(intent);


                break;


        }

    }
}
