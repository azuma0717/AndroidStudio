package com.gmail.yuki.yuki_cal_1108;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btRem, btAdd, btSub, btMul, btDiv, btEqu, btCle;
    TextView tv;
    int a, b;
    String cal = "";
    String x;
    String y = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        btRem = (Button) findViewById(R.id.btRem);
        btAdd = (Button) findViewById(R.id.btAdd);
        btSub = (Button) findViewById(R.id.btSub);
        btMul = (Button) findViewById(R.id.btMul);
        btDiv = (Button) findViewById(R.id.btDiv);
        btEqu = (Button) findViewById(R.id.btEqu);
        btCle = (Button) findViewById(R.id.btCle);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        btRem.setOnClickListener(this);
        btAdd.setOnClickListener(this);
        btSub.setOnClickListener(this);
        btMul.setOnClickListener(this);
        btDiv.setOnClickListener(this);
        btEqu.setOnClickListener(this);
        btCle.setOnClickListener(this);

        tv = (TextView) findViewById(R.id.txt1);

        a = 0;
        b = 0;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt1: {

                y = y + bt1.getText().toString();
                tv.setText(y);

                break;
            }
            case R.id.bt2: {

                y = y + bt2.getText().toString();
                tv.setText(y);

                break;
            }
            case R.id.bt3: {

                y = y + bt3.getText().toString();
                tv.setText(y);

                break;
            }
            case R.id.bt4: {

                y = y + bt4.getText().toString();
                tv.setText(y);

                break;
            }
            case R.id.bt5: {

                y = y + bt5.getText().toString();
                tv.setText(y);

                break;
            }
            case R.id.bt6: {

                y = y + bt6.getText().toString();
                tv.setText(y);

                break;
            }
            case R.id.bt7: {

                y = y + bt7.getText().toString();
                tv.setText(y);

                break;
            }
            case R.id.bt8: {

                y = y + bt8.getText().toString();
                tv.setText(y);

                break;
            }
            case R.id.bt9: {

                y = y + bt9.getText().toString();
                tv.setText(y);

                break;
            }
            case R.id.btRem: {

                a = Integer.parseInt(y);
                y = y + btRem.getText().toString();
                tv.setText(y);
                y = "";
                cal = "rem";

                break;
            }
            case R.id.btAdd: {

                a = Integer.parseInt(y);
                y = y + btAdd.getText().toString();
                tv.setText(y);
                y = "";
                cal = "add";

                break;
            }
            case R.id.btSub: {

                a = Integer.parseInt(y);
                y = y + btSub.getText().toString();
                tv.setText(y);
                y = "";
                cal = "sub";

                break;
            }
            case R.id.btMul: {

                a = Integer.parseInt(y);
                y = y + btMul.getText().toString();
                tv.setText(y);
                y = "";
                cal = "mul";

                break;
            }
            case R.id.btDiv: {

                a = Integer.parseInt(y);
                y = y + btDiv.getText().toString();
                tv.setText(y);
                y = "";
                cal = "div";

                break;
            }
            case R.id.btEqu: {

                if (cal.equals("add")) {

                    b = Integer.parseInt(y);
                    a = a + b;

                } else if (cal.equals("sub")) {

                    b = Integer.parseInt(y);
                    a = a - b;

                } else if (cal.equals("mul")) {

                    b = Integer.parseInt(y);
                    a = a * b;

                } else if (cal.equals("div")) {

                    b = Integer.parseInt(y);
                    a = a / b;

                } else if (cal.equals("rem")) {

                    b = Integer.parseInt(y);
                    a = a % b;

                } else {

                    a = 0;
                    b = 0;
                    x = String.valueOf(a);
                    y = "";
                    tv.setText(x);
                }

                y = String.valueOf(a);
                tv.setText(y);
                break;
            }
            case R.id.btCle: {

                a = 0;
                b = 0;
                y = "";
                x = String.valueOf(a);
                tv.setText(x);
                break;
            }

        }

    }
}
