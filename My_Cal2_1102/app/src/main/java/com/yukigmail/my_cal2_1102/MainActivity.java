package com.yukigmail.my_cal2_1102;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button bt;
    EditText tv, tv1, tv2;
    TextView tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.add);
        tv = (EditText) findViewById(R.id.editText);
        tv1 = (EditText) findViewById(R.id.editText3);
        tv2 = (EditText) findViewById(R.id.editText4);
        tv3 = (TextView) findViewById(R.id.textView5);

        Editable a = tv.getText();
    }


    public void clicks(View t) {

        String a = tv.getText().toString();
        int i = Integer.parseInt(a);
        String b = tv1.getText().toString();
        int x = Integer.parseInt(b);

        String c = tv2.getText().toString();

        if(c.equals("add")) {
            int y = i + x;
//            String z = String.valueOf(y);
            tv3.setText(y  +"");
        }
        else if(c.equals("sub")){
            int y = i - x;
//            String z = String.valueOf(y);
            tv3.setText(y  +"");
        }
        else if(c.equals("mul")){
            int y = i * x;
//            String z = String.valueOf(y);
            tv3.setText(y  +"");
        }
        else if(c.equals("div")){
            int y = i / x;
//            String z = String.valueOf(y);
            tv3.setText(y  +"");
        }
        else if(c.equals("rem")){
            int y = i % x;
//            String z = String.valueOf(y);
            tv3.setText(y  +"");
        }
    }
}
