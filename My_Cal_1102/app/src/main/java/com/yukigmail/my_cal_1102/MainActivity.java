package com.yukigmail.my_cal_1102;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    Button bt,bt1,bt2,bt3,bt4;
    TextView tv,tv1,tv2,tv3,tv4;
    int a = 9;
    int b = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt =(Button)findViewById(R.id.add);
        bt1 =(Button)findViewById(R.id.sub);
        bt2 =(Button)findViewById(R.id.mul);
        bt3 =(Button)findViewById(R.id.div);
        bt4 =(Button)findViewById(R.id.rem);
        tv =(TextView)findViewById(R.id.textView14);
        tv1 =(TextView)findViewById(R.id.textView15);
        tv2 =(TextView)findViewById(R.id.textView16);
        tv3 =(TextView)findViewById(R.id.textView17);
        tv4 =(TextView)findViewById(R.id.textView18);

    }

    public void clicks1(View t){
        tv.setText("add is "+ (a+b));
    }

    public void clicks2(View t){
        tv1.setText("sub is "+ (a-b));
    }

    public void clicks3(View t){
        tv2.setText("mul is "+ (a*b));
    }

    public void clicks4(View t){
        tv3.setText("div is "+ (a/b));
    }

    public void clicks5(View t){
        tv4.setText("rem is "+ (a%b));
    }
}
