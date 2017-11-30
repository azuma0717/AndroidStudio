package com.gmail.yuki.table2_1123;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        init();
    }


    public void init() {

        //こいつ↓は、テーブル全体のオブジェクト。レイアウトのIDとの紐付けもする。
        TableLayout stk = (TableLayout)findViewById(R.id.table);

        ////tableの0行目を作って、そこにTextView（＝列）を作っていく

//      //まずは0行目のRowを作成する
        TableRow tableRow0 = new TableRow(this);

        TextView tv0 = new TextView(this);
        tv0.setText("Sl No.");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);

        //↑で作ったTextView(=列)をRow0(=0行目)にぶち込む。
        tableRow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText("Name");
        tv1.setTextColor(Color.WHITE);
        tv1.setGravity(Gravity.CENTER);
        tableRow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("Phone");
        tv2.setTextColor(Color.WHITE);
        tv2.setGravity(Gravity.CENTER);
        tableRow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText("City");
        tv3.setTextColor(Color.WHITE);
        tv3.setGravity(Gravity.CENTER);
        tableRow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText("Email");
        tv4.setTextColor(Color.WHITE);
        tv4.setGravity(Gravity.CENTER);
        tableRow0.addView(tv4);


        //テーブル自体に、0行目を突っ込む。
        stk.addView(tableRow0);

//  ////////////こっからは、テーブルの行を作っていく。for分とかで回してもよい。/////////

        TableRow tableRow1 = new TableRow(this);

        TextView tv5 = new TextView(this);
        tv5.setText("1");
        tv5.setTextColor(Color.WHITE);
        tv5.setGravity(Gravity.CENTER);
        tableRow1.addView(tv5);

        TextView tv6 = new TextView(this);
        tv6.setText("Yuki");
        tv6.setTextColor(Color.WHITE);
        tv6.setGravity(Gravity.CENTER);
        tableRow1.addView(tv6);

        TextView tv7 = new TextView(this);
        tv7.setText("1111");
        tv7.setTextColor(Color.WHITE);
        tv7.setGravity(Gravity.CENTER);
        tableRow1.addView(tv7);

        TextView tv8 = new TextView(this);
        tv8.setText("Tokyo");
        tv8.setTextColor(Color.WHITE);
        tv8.setGravity(Gravity.CENTER);
        tableRow1.addView(tv8);

        TextView tv9 = new TextView(this);
        tv9.setText("yuki.com");
        tv9.setTextColor(Color.WHITE);
        tv9.setGravity(Gravity.CENTER);
        tableRow1.addView(tv9);

        stk.addView(tableRow1);

        //////Row2///////////////////////////////
        TableRow tableRow2 = new TableRow(this);

        TextView tv10 = new TextView(this);
        tv10.setText("2");
        tv10.setTextColor(Color.WHITE);
        tv10.setGravity(Gravity.CENTER);
        tableRow2.addView(tv10);

        TextView tv11 = new TextView(this);
        tv11.setText("Raj");
        tv11.setTextColor(Color.WHITE);
        tv11.setGravity(Gravity.CENTER);
        tableRow2.addView(tv11);

        TextView tv12 = new TextView(this);
        tv12.setText("2222");
        tv12.setTextColor(Color.WHITE);
        tv12.setGravity(Gravity.CENTER);
        tableRow2.addView(tv12);

        TextView tv13 = new TextView(this);
        tv13.setText("Gurgaon");
        tv13.setTextColor(Color.WHITE);
        tv13.setGravity(Gravity.CENTER);
        tableRow2.addView(tv13);

        TextView tv14 = new TextView(this);
        tv14.setText("raj.com");
        tv14.setTextColor(Color.WHITE);
        tv14.setGravity(Gravity.CENTER);
        tableRow2.addView(tv14);

        stk.addView(tableRow2);

        ////////Row3//////////////////////////////////
        TableRow tableRow3 = new TableRow(this);

        TextView tv15 = new TextView(this);
        tv15.setText("3");
        tv15.setTextColor(Color.WHITE);
        tv15.setGravity(Gravity.CENTER);
        tableRow3.addView(tv15);

        TextView tv16 = new TextView(this);
        tv16.setText("Toki");
        tv16.setTextColor(Color.WHITE);
        tv16.setGravity(Gravity.CENTER);
        tableRow3.addView(tv16);

        TextView tv17 = new TextView(this);
        tv17.setText("3333");
        tv17.setTextColor(Color.WHITE);
        tv17.setGravity(Gravity.CENTER);
        tableRow3.addView(tv17);

        TextView tv18 = new TextView(this);
        tv18.setText("Japan");
        tv18.setTextColor(Color.WHITE);
        tv18.setGravity(Gravity.CENTER);
        tableRow3.addView(tv18);

        TextView tv19 = new TextView(this);
        tv19.setText("toki.com");
        tv19.setTextColor(Color.WHITE);
        tv19.setGravity(Gravity.CENTER);
        tableRow3.addView(tv19);

        stk.addView(tableRow3);

        //////Row4///////////////////////////////
        TableRow tableRow4 = new TableRow(this);

        TextView tv20 = new TextView(this);
        tv20.setText("4");
        tv20.setTextColor(Color.WHITE);
        tv20.setGravity(Gravity.CENTER);
        tableRow4.addView(tv20);

        TextView tv21 = new TextView(this);
        tv21.setText("Kotaro");
        tv21.setTextColor(Color.WHITE);
        tv21.setGravity(Gravity.CENTER);
        tableRow4.addView(tv21);

        TextView tv22 = new TextView(this);
        tv22.setText("4444");
        tv22.setTextColor(Color.WHITE);
        tv22.setGravity(Gravity.CENTER);
        tableRow4.addView(tv22);

        TextView tv23 = new TextView(this);
        tv23.setText("Chiba");
        tv23.setTextColor(Color.WHITE);
        tv23.setGravity(Gravity.CENTER);
        tableRow4.addView(tv23);

        TextView tv24 = new TextView(this);
        tv24.setText("kotaro.com");
        tv24.setTextColor(Color.WHITE);
        tv24.setGravity(Gravity.CENTER);
        tableRow4.addView(tv24);

        stk.addView(tableRow4);

        ///////Row5/////////////////////////////
        TableRow tableRow5 = new TableRow(this);

        tv1 = new TextView(this);
        tv1.setText("5");
        tv1.setTextColor(Color.WHITE);
        tv1.setGravity(Gravity.CENTER);
        tableRow5.addView(tv1);

        tv2 = new TextView(this);
        tv2.setText("Shinji");
        tv2.setTextColor(Color.WHITE);
        tv2.setGravity(Gravity.CENTER);
        tableRow5.addView(tv2);

        tv3 = new TextView(this);
        tv3.setText("55555");
        tv3.setTextColor(Color.WHITE);
        tv3.setGravity(Gravity.CENTER);
        tableRow5.addView(tv3);

        tv4 = new TextView(this);
        tv4.setText("Osaka");
        tv4.setTextColor(Color.WHITE);
        tv4.setGravity(Gravity.CENTER);
        tableRow5.addView(tv4);

        tv5 = new TextView(this);
        tv5.setText("Shinji.com");
        tv5.setTextColor(Color.WHITE);
        tv5.setGravity(Gravity.CENTER);
        tableRow5.addView(tv5);

        stk.addView(tableRow5);

        ///////Row6/////////////////////////////
        TableRow tableRow6 = new TableRow(this);

        tv1 = new TextView(this);
        tv1.setText("6");
        tv1.setTextColor(Color.WHITE);
        tv1.setGravity(Gravity.CENTER);
        tableRow6.addView(tv1);

        tv2 = new TextView(this);
        tv2.setText("Kento");
        tv2.setTextColor(Color.WHITE);
        tv2.setGravity(Gravity.CENTER);
        tableRow6.addView(tv2);

        tv3 = new TextView(this);
        tv3.setText("66666");
        tv3.setTextColor(Color.WHITE);
        tv3.setGravity(Gravity.CENTER);
        tableRow6.addView(tv3);

        tv4 = new TextView(this);
        tv4.setText("Chiba");
        tv4.setTextColor(Color.WHITE);
        tv4.setGravity(Gravity.CENTER);
        tableRow6.addView(tv4);

        tv5 = new TextView(this);
        tv5.setText("kento.com");
        tv5.setTextColor(Color.WHITE);
        tv5.setGravity(Gravity.CENTER);
        tableRow6.addView(tv5);

        stk.addView(tableRow6);

        ///////Row7/////////////////////////////
        TableRow tableRow7 = new TableRow(this);

        tv1 = new TextView(this);
        tv1.setText("7");
        tv1.setTextColor(Color.WHITE);
        tv1.setGravity(Gravity.CENTER);
        tableRow7.addView(tv1);

        tv2 = new TextView(this);
        tv2.setText("Keny");
        tv2.setTextColor(Color.WHITE);
        tv2.setGravity(Gravity.CENTER);
        tableRow7.addView(tv2);

        tv3 = new TextView(this);
        tv3.setText("77777");
        tv3.setTextColor(Color.WHITE);
        tv3.setGravity(Gravity.CENTER);
        tableRow7.addView(tv3);

        tv4 = new TextView(this);
        tv4.setText("Assam");
        tv4.setTextColor(Color.WHITE);
        tv4.setGravity(Gravity.CENTER);
        tableRow7.addView(tv4);

        tv5 = new TextView(this);
        tv5.setText("Keny.com");
        tv5.setTextColor(Color.WHITE);
        tv5.setGravity(Gravity.CENTER);
        tableRow7.addView(tv5);

        stk.addView(tableRow7);

        ///////Row8/////////////////////////////
        TableRow tableRow8 = new TableRow(this);

        tv1 = new TextView(this);
        tv1.setText("8");
        tv1.setTextColor(Color.WHITE);
        tv1.setGravity(Gravity.CENTER);
        tableRow8.addView(tv1);

        tv2 = new TextView(this);
        tv2.setText("Kentaro");
        tv2.setTextColor(Color.WHITE);
        tv2.setGravity(Gravity.CENTER);
        tableRow8.addView(tv2);

        tv3 = new TextView(this);
        tv3.setText("88888");
        tv3.setTextColor(Color.WHITE);
        tv3.setGravity(Gravity.CENTER);
        tableRow8.addView(tv3);

        tv4 = new TextView(this);
        tv4.setText("Osaka");
        tv4.setTextColor(Color.WHITE);
        tv4.setGravity(Gravity.CENTER);
        tableRow8.addView(tv4);

        tv5 = new TextView(this);
        tv5.setText("kentaro.com");
        tv5.setTextColor(Color.WHITE);
        tv5.setGravity(Gravity.CENTER);
        tableRow8.addView(tv5);

        stk.addView(tableRow8);

        ///////Row9/////////////////////////////
        TableRow tableRow9 = new TableRow(this);

        tv1 = new TextView(this);
        tv1.setText("9");
        tv1.setTextColor(Color.WHITE);
        tv1.setGravity(Gravity.CENTER);
        tableRow9.addView(tv1);

        tv2 = new TextView(this);
        tv2.setText("Shun");
        tv2.setTextColor(Color.WHITE);
        tv2.setGravity(Gravity.CENTER);
        tableRow9.addView(tv2);

        tv3 = new TextView(this);
        tv3.setText("99999");
        tv3.setTextColor(Color.WHITE);
        tv3.setGravity(Gravity.CENTER);
        tableRow9.addView(tv3);

        tv4 = new TextView(this);
        tv4.setText("Kumamoto");
        tv4.setTextColor(Color.WHITE);
        tv4.setGravity(Gravity.CENTER);
        tableRow9.addView(tv4);

        tv5 = new TextView(this);
        tv5.setText("Shun.com");
        tv5.setTextColor(Color.WHITE);
        tv5.setGravity(Gravity.CENTER);
        tableRow9.addView(tv5);

        stk.addView(tableRow9);

        ///////Row10/////////////////////////////
        TableRow tableRow10 = new TableRow(this);

        tv1 = new TextView(this);
        tv1.setText("10");
        tv1.setTextColor(Color.WHITE);
        tv1.setGravity(Gravity.CENTER);
        tableRow10.addView(tv1);

        tv2 = new TextView(this);
        tv2.setText("Rei");
        tv2.setTextColor(Color.WHITE);
        tv2.setGravity(Gravity.CENTER);
        tableRow10.addView(tv2);

        tv3 = new TextView(this);
        tv3.setText("10101010");
        tv3.setTextColor(Color.WHITE);
        tv3.setGravity(Gravity.CENTER);
        tableRow10.addView(tv3);

        tv4 = new TextView(this);
        tv4.setText("Keio");
        tv4.setTextColor(Color.WHITE);
        tv4.setGravity(Gravity.CENTER);
        tableRow10.addView(tv4);

        tv5 = new TextView(this);
        tv5.setText("rei.com");
        tv5.setTextColor(Color.WHITE);
        tv5.setGravity(Gravity.CENTER);
        tableRow10.addView(tv5);

        stk.addView(tableRow10);






    }

}
