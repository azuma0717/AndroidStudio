package com.gmail.yuki.my_firend_info_1124;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

public class ShowID extends AppCompatActivity implements View.OnClickListener {

    Button bt1,bt2;
    EditText ed1;
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    ImageView iv1;
    Databese_Helper databese_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_id);

        bt1 = findViewById(R.id.go);
        bt2 = findViewById(R.id.back);
        ed1 = findViewById(R.id.ed1);
        tv1 = findViewById(R.id.name);
        tv2 = findViewById(R.id.phone);
        tv3 = findViewById(R.id.email);
        tv4 = findViewById(R.id.city2);
        tv5 = findViewById(R.id.dob);
        tv6 = findViewById(R.id.id);
        iv1 = findViewById(R.id.image2);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        databese_helper = new Databese_Helper(ShowID.this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.go:

                String id = ed1.getText().toString();

                Cursor rslt = databese_helper.showid(id);
                rslt.moveToFirst();


                String sl2 = rslt.getString(rslt.getColumnIndex("_id"));
                String img2 = rslt.getString(rslt.getColumnIndex("photo"));
                String name2 = rslt.getString(rslt.getColumnIndex("name"));
                String phone2 = rslt.getString(rslt.getColumnIndex("phone"));
                String email2 = rslt.getString(rslt.getColumnIndex("email"));
                String city2 = rslt.getString(rslt.getColumnIndex("city"));
                String dob2 = rslt.getString(rslt.getColumnIndex("dob"));


                tv1.setText("Name:    "+name2);
                tv2.setText("phone:    "+phone2);
                tv3.setText("email:    "+email2);
                tv4.setText("city:    "+city2);
                tv5.setText("dob:    "+dob2);
                tv6.setText("ID:    "+sl2);
                iv1.setImageDrawable(Drawable.createFromPath(img2));

                break;

            case R.id.back:

                Intent back = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(back);

        }





    }
}
