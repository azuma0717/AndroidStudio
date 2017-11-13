package com.gmail.yuki.intent_1109;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button home,aboutus,contactus,signin,go;
    EditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        home =(Button)findViewById(R.id.home);
        aboutus =(Button)findViewById(R.id.aboutus);
        contactus =(Button)findViewById(R.id.contactus);
        signin =(Button)findViewById(R.id.signin);
        go =(Button)findViewById(R.id.go);
        et =(EditText)findViewById(R.id.et);

        home.setOnClickListener(this);
        aboutus.setOnClickListener(this);
        contactus.setOnClickListener(this);
        signin.setOnClickListener(this);
        go.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.home :{
                Intent yuki = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(yuki);
                break;
            }

            case R.id.aboutus :{
                Intent yuki = new Intent(getApplicationContext(),YukiAzuma.class);
                startActivity(yuki);
                break;
            }

            case R.id.contactus :{
                Intent yuki = new Intent(getApplicationContext(),ContactUs.class);
                startActivity(yuki);
                break;
            }

            case R.id.signin :{
                Intent yuki = new Intent(getApplicationContext(),SiginIn.class);
                startActivity(yuki);

                break;
            }

            case R.id.go :{
                Intent yuki = new Intent(getApplicationContext(),YukiAzuma.class);
                String a = et.getText().toString();
                yuki.putExtra("misao",a);
                startActivity(yuki);

                break;
            }



        }






    }
}
