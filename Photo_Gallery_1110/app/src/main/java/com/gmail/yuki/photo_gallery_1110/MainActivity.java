package com.gmail.yuki.photo_gallery_1110;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12,iv13,iv14,iv15,iv16;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 =findViewById(R.id.iv1);
        iv2 =findViewById(R.id.iv2);
        iv3 =findViewById(R.id.iv3);
        iv4 =findViewById(R.id.iv4);
        iv5 =findViewById(R.id.iv5);
        iv6 =findViewById(R.id.iv6);
        iv7 =findViewById(R.id.iv7);
        iv8 =findViewById(R.id.iv8);
        iv9 =findViewById(R.id.iv9);
        iv10 =findViewById(R.id.iv10);
        iv11 =findViewById(R.id.iv11);
        iv12 =findViewById(R.id.iv12);
        iv13 =findViewById(R.id.iv13);
        iv14 =findViewById(R.id.iv14);
        iv15 =findViewById(R.id.iv15);
        iv16 =findViewById(R.id.iv16);

        txt1 =findViewById(R.id.txt1);

        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
        iv5.setOnClickListener(this);
        iv6.setOnClickListener(this);
        iv7.setOnClickListener(this);
        iv8.setOnClickListener(this);
        iv9.setOnClickListener(this);
        iv10.setOnClickListener(this);
        iv11.setOnClickListener(this);
        iv12.setOnClickListener(this);
        iv13.setOnClickListener(this);
        iv14.setOnClickListener(this);
        iv15.setOnClickListener(this);
        iv16.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.iv1:

                Intent yuki = new Intent(getApplicationContext(),Reslut_1110.class);
                String a = "aa";
                yuki.putExtra("misao",a);
                startActivity(yuki);
                break;

            case R.id.iv2:

                txt1.setText("Hi");
                break;

            case R.id.iv3:

                txt1.setText("Hi");
                break;

            case R.id.iv4:

                txt1.setText("Hi");
                break;

            case R.id.iv5:

                txt1.setText("Hi");
                break;

            case R.id.iv6:

                txt1.setText("Hi");
                break;

            case R.id.iv7:

                txt1.setText("Hi");
                break;

            case R.id.iv8:

                txt1.setText("Hi");
                break;

            case R.id.iv9:

                txt1.setText("Hi");
                break;

            case R.id.iv10:

                txt1.setText("Hi");
                break;

            case R.id.iv11:

                txt1.setText("Hi");
                break;

            case R.id.iv12:

                txt1.setText("Hi");
                break;

            case R.id.iv13:

                txt1.setText("Hi");
                break;

            case R.id.iv14:

                txt1.setText("Hi");
                break;

            case R.id.iv15:

                txt1.setText("Hi");
                break;

            case R.id.iv16:

                txt1.setText("Hi");
                break;
        }

    }
}
